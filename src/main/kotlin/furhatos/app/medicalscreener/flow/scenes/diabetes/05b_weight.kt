package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.Goodbye
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.records.User
import furhatos.util.CommonUtils
import kotlin.math.pow
import kotlin.math.roundToInt

const val maxPossibleWeight = 650 // kilos
const val maxAllowedWeight = 200 // kilos
const val minPossibleWeight = 30 // kilos
private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!

val WeightQuestion: State = state(EPDSQuestionBase) {
    onEntry {
        furhat.askAndDo(i18n.phrases.DIABETES_WEIGHT_QUESTION) {
            send(ShowOptionsEvent(
                weightOptions.map { "${it.key}:${it.value}" },
                i18n.phrases.DIABETES_WEIGHT_QUESTION_PROMT
            ))
        }
    }
    onResponse<DontKnow> {
        furhat.ask(i18n.phrases.GENERAL_ESTIMATE)
    }
    onResponse<WeightExactlyIntent> {

        handleWeightResponse(weight = it.intent.weight?.value, weightUnit = it.intent.weightUnit?.value)
    }
    onResponse<WeightBetweenIntent> {
        handleWeightResponse(weightAbove = it.intent.weightAbove?.value, weightBelow = it.intent.weightBelow?.value)
    }
    onResponse<WeightBelowIntent> {
        handleWeightResponse(weightBelow = it.intent.weightBelow?.value)
    }
    onResponse<WeightAboveIntent> {
        handleWeightResponse(weightAbove = it.intent.weightAbove?.value)
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        users.current.weight = (it.get("response") as String).toInt()
        log.debug("User weight ${users.current.weight}")
        addBmiScore(users.current)
        ackAndGoto(WaistCircumferenceQuestion)
    }
}

private fun TriggerRunner<*>.handleWeightResponse(weight: Int? = null, weightBelow: Int? = null, weightAbove: Int? = null, weightUnit: String? = null) {
    println("weightParam: $weight")
    println("weightBelow: $weightBelow")
    println("weightAbove: $weightAbove")
    println("weightUnit: $weightUnit")

    val adjustedWeight = when {
        weight != null -> weight
        (weightBelow != null && weightAbove != null) -> weightBelow
        weightBelow != null  -> weightBelow - 1
        weightAbove != null  -> weightAbove + 1
        else -> throw Error()
    }

    val userWeight = normalizeWeight(adjustedWeight, weightUnit)

    println("weight in kilos: $userWeight")

    when {
            userWeight in maxAllowedWeight..maxPossibleWeight -> {
                furhat.say(i18n.phrases.DIABETES_WEIGHT_EXCEEDED)
                goto(ContinueAnyway)
            }
            userWeight < minPossibleWeight -> {
                furhat.ask(i18n.phrases.GENERAL_ANSWER_NOT_ACCEPTED_REPEAT)
            }
            userWeight > maxPossibleWeight -> {
                furhat.ask(i18n.phrases.GENERAL_ANSWER_NOT_ACCEPTED_REPEAT)
            }
            else -> {
                val selectedOption = getSelectedWeightOption(userWeight)
                send(OptionSelectedEvent(selectedOption))
                users.current.weight = userWeight

                addBmiScore(users.current)
                ackAndGoto(WaistCircumferenceQuestion)
            }
        }
}

fun normalizeWeight(weightParam: Int, weightUnit: String?): Int {

    return when(weightUnit) {
        "pounds" -> (0.453592*weightParam).roundToInt()
        /*  info on jin–kg conversation:
            it varies slightly in different countries or contexts, but this is probably a close conversion: 1 jin =~ 600 gramme.
            when people convert for weight, however, they use: 1 jin = 500 gramme (because it is easier to convert in the head).
            then again, this conversion is flexible: men and women round the value off differently, and so do heavier or thinner people.
            so, there's no fixed value for this conversion, and no easy way to tackle this challenge.
         */
        "jin" -> (0.5*weightParam).roundToInt() // "0.5", because, in this project, people will use jin to describe their weights.
        else -> weightParam
    }
}

fun getSelectedWeightOption(selected : Int) : String {
    val weightKeys = weightOptions.keys.toList().sorted()
    return when {
        selected < weightKeys[0] -> { weightKeys[0] }
        selected in weightKeys[0] .. weightKeys[1] -> { weightKeys[1] }
        selected in weightKeys[1] .. weightKeys[2] -> { weightKeys[2] }
        selected in weightKeys[2] .. weightKeys[3] -> { weightKeys[3] }
        else -> weightKeys[3]
    }.toString()
}

val weightOptions : Map<Int, String> = mapOf(
    60 to i18n.phrases.DIABETES_WEIGHT_ALTERNATIVE_1,
    80 to i18n.phrases.DIABETES_WEIGHT_ALTERNATIVE_2,
    100 to i18n.phrases.DIABETES_WEIGHT_ALTERNATIVE_3,
    110 to i18n.phrases.DIABETES_WEIGHT_ALTERNATIVE_4
)


private fun addBmiScore(user: User) {
    if (user.height > 0 && user.weight > 0) {
        val bmi = (user.weight.toDouble() / user.height.toDouble().pow(2.0)).toInt()
        when {
            bmi in 25..30 -> user.EPDSData.addToScore(1, "Bmi")
            bmi > 30 -> user.EPDSData.addToScore(3, "Bmi")
        }
    }
}

val ContinueAnyway = state(EPDSQuestionBase) {
    onEntry {
        furhat.ask(i18n.phrases.GENERAL_CONTINUE_ANYWAY)
    }

    onResponse<Yes> {
        log.debug("User weight ${users.current.weight}")
        users.current.weight = maxAllowedWeight
        addBmiScore(users.current)
        ackAndGoto(WaistCircumferenceQuestion)
    }

    onResponse<No> {
        furhat.say(i18n.phrases.GENERAL_OK_NO_PROBLEM)
        goto(Goodbye)
    }
}

package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.DiabetesQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils

const val minHeight = 40 //cm
const val maxHeight = 300 // cm
private val log = CommonUtils.getLogger(DiabetesQuestionBase::class.java)!!

val HeightQuestion: State = state(DiabetesQuestionBase) {
    onEntry {
        furhat.askAndDo(i18n.phrases.DIABETES_HEIGHT_QUESTION) {
            send(ShowOptionsEvent(
                    heightOptions.map { "${it.key}:${it.value}" },
                    i18n.phrases.DIABETES_HEIGHT_QUESTION_PROMT
            ))
        }
    }
    onResponse<DontKnow> {
        furhat.ask(i18n.phrases.GENERAL_ESTIMATE)
    }
    onResponse<HeightExactlyIntent> {
        handleHeightResponse(height = it.intent.height?.value)
    }
    onResponse<HeightBetweenIntent> {
        handleHeightResponse(heightBelow = it.intent.heightBelow?.value, heightAbove = it.intent.heightAbove?.value)
    }
    onResponse<HeightBelowIntent> {
        handleHeightResponse(heightBelow = it.intent.heightBelow?.value)
    }
    onResponse<HeightAboveIntent> {
        handleHeightResponse(heightAbove = it.intent.heightAbove?.value)
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        users.current.height = (it.get("response") as String).toInt()
        log.debug("User height ${users.current.height}")
        ackAndGoto(WeightQuestion)
    }
}

private fun TriggerRunner<*>.handleHeightResponse(height: Int? = null, heightBelow: Int? = null, heightAbove: Int? = null) {
    println("height: $height")
    println("heightBelow: $heightBelow")
    println("heightAbove: $heightAbove")

    val userHeight = when {
        height != null -> height
        (heightBelow != null && heightAbove != null) -> heightAbove - 1
        heightBelow != null  -> heightBelow - 1
        heightAbove != null  -> heightAbove + 1
        else -> throw Error()
    }

    when {
            userHeight < minHeight || userHeight > maxHeight -> {
                furhat.ask(i18n.phrases.GENERAL_ANSWER_NOT_ACCEPTED_REPEAT)
            }
            else -> {
                users.current.height = userHeight
                val selectedOption = getSelectedHeightOption(userHeight)
                println(selectedOption)
                send(OptionSelectedEvent(selectedOption))
                log.debug("Users height is $userHeight")
                ackAndGoto(WeightQuestion)
            }
        }
}

fun getSelectedHeightOption(selected : Int) : String {
    val heightKeys = heightOptions.keys.toList().sorted()
    return when {
        selected < heightKeys[0] -> { heightKeys[0] }
        selected in heightKeys[0] until heightKeys[1] -> { heightKeys[0] }
        selected in heightKeys[1] until heightKeys[2] -> { heightKeys[1] }
        selected in heightKeys[2] until heightKeys[3] -> { heightKeys[2] }
        else -> heightKeys[3]
    }.toString()
}

val heightOptions : Map<Int, String> = mapOf(
    140 to i18n.phrases.DIABETES_HEIGHT_ALTERNATIVE_1,
    160 to i18n.phrases.DIABETES_HEIGHT_ALTERNATIVE_2,
    180 to i18n.phrases.DIABETES_HEIGHT_ALTERNATIVE_3,
    200 to i18n.phrases.DIABETES_HEIGHT_ALTERNATIVE_4
)

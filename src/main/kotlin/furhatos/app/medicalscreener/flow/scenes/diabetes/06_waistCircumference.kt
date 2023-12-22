package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.Goodbye
import furhatos.app.medicalscreener.flow.scenes.DiabetesQuestionBase
import furhatos.app.medicalscreener.i18n.No
import furhatos.app.medicalscreener.i18n.Yes
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.*
import furhatos.flow.kotlin.*
import java.lang.Integer.parseInt

const val lowestAllowedMeasurement = 25 // cm
const val highestAllowedMeasurement = 200 // cm

private fun getWaistCircumferenceOptionsList(sex : String? = "male") : List<String> {
    return if (sex == "male") {
        listOf(
                "normal:${i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION1}",
                "elevated:${i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION2}",
                "high:${i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION3}"
        )
    } else {
        listOf(
                "normal:${i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION1}",
                "elevated:${i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION2}",
                "high:${i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION3}"
        )
    }
}
private fun getWaistCircumferenceAskPhrase(sex : String? = "male") : String {
    return if (sex == "male") i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_MALE_QUESTION else i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_FEMALE_QUESTION
}

val WaistCircumferenceQuestion = state(DiabetesQuestionBase) {
    var timeOfEntry : Long = System.currentTimeMillis()
    val listenTimeMS = 30000
    onEntry {
        println("Entering WaistCircumferenceQuestion state")
        send(ClearScreen())
        val guiOptions = getWaistCircumferenceOptionsList(this.users.current.diabetesData.biologicalSex)
        val askPhrase = getWaistCircumferenceAskPhrase(this.users.current.diabetesData.biologicalSex)
        furhat.askAndDo(askPhrase, timeout = listenTimeMS, endSil = 3500) {
            send(ShowOptionsEvent(
                    guiOptions,
                    prompt = i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_PROMPT))
            timeOfEntry = System.currentTimeMillis()
        }
    }
    onNoResponse(instant = false) {
        gotoOrListen(WaistCircumferenceTimeout, timeOfEntry, listenTimeMS)
    }
    include(waistCircumferenceShared(listenTimeMS))}

val WaistCircumferenceTimeout = state(DiabetesQuestionBase) {
    var timeOfEntry : Long = System.currentTimeMillis()
    val listenTimeMS = 20000
    onEntry {
        timeOfEntry = System.currentTimeMillis()
        if (users.current.isVisible) {
            furhat.ask(i18n.phrases.GENERAL_ASK_IF_DONE)
        } else {
            val isUserStillHere = call(UserMightBeGone) as Boolean
            if (isUserStillHere) {
                furhat.ask(i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_2, timeout=listenTimeMS)
            } else {
                goto(Goodbye)
            }
        }
    }

    onNoResponse {
        gotoOrListen(Goodbye, timeOfEntry, listenTimeMS)
    }
    onResponse<Yes> {
        furhat.ask(i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_2)
    }
    onResponse<No> {
        furhat.say(i18n.phrases.GENERAL_OK_WAITING)
        furhat.listen(LONG_TIMEOUT_MS)
    }
    include(waistCircumferenceShared(listenTimeMS))
}


fun waistCircumferenceShared(listenTimeMS: Int) = partialState {
    onEvent("UserResponse") {
        println("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "normal" -> this.users.current.diabetesData.addToScore(0, "WaistCircumferenceQuestion")
            "elevated" -> this.users.current.diabetesData.addToScore(3, "WaistCircumferenceQuestion")
            "high" -> this.users.current.diabetesData.addToScore(4, "WaistCircumferenceQuestion")
        }

        AcknowledgeAndGoToNext()
    }

    onUserLeave {
        furhat.listen(listenTimeMS)
    }
    onUserEnter(instant = true) {
        furhatos.app.medicalscreener.log.debug("User ${it.id} entereded in WaistCircumferenceTimeout")
        furhatos.app.medicalscreener.log.debug("currentUser ${users.current}")

        val furhatIsBusy = (furhat.isSpeaking() || furhat.isListening)

        when {
            it == users.current -> {
                furhatos.app.medicalscreener.log.debug("same user returned")
                furhat.attend(it)

                if (!furhatIsBusy) {
                    furhat.listen(listenTimeMS)
                }
            }
            users.count == 1 -> {
                // The platform's doesn't always get user identification right.
                // To work around this in this state, we let any returning user continue the interaction
                furhatos.app.medicalscreener.log.debug("overwriting user ${users.current} with $it")
                users.current = it
                furhat.attend(it)
                if (!furhatIsBusy) {
                    furhat.listen(listenTimeMS)
                }
            }
            else -> {
                furhatos.app.medicalscreener.log.debug("else just glance")
                furhat.glance(it)
            }
        }
    }

    onResponse<WaistCircumferenceIntent> {
        val centimeters: Int = parseInt(it.intent.cm?.value.toString())

        val lowerWaistBoundary: Int
        val higherWaistBoundary: Int
        if(this.users.current.diabetesData.biologicalSex == "male") {
            lowerWaistBoundary = 94
            higherWaistBoundary = 102
        } else {
            lowerWaistBoundary = 80
            higherWaistBoundary = 88
        }

        println("User answered ${centimeters} (\"${it.text}\")")
        when {
            centimeters < lowestAllowedMeasurement -> {
                furhat.ask(i18n.phrases.GENERAL_ANSWER_NOT_ACCEPTED_REPEAT)
            }
            centimeters > highestAllowedMeasurement -> {
                furhat.ask(i18n.phrases.GENERAL_ANSWER_NOT_ACCEPTED_REPEAT)
            }
            centimeters <= lowerWaistBoundary -> {
                this.users.current.diabetesData.addToScore(0, "WaistCircumferenceQuestion")
                send(OptionSelectedEvent("normal"))
                AcknowledgeAndGoToNext()
            }
            centimeters in (lowerWaistBoundary + 1)..(higherWaistBoundary - 1) ->{
                this.users.current.diabetesData.addToScore(3, "WaistCircumferenceQuestion")
                send(OptionSelectedEvent("elevated"))
                AcknowledgeAndGoToNext()
            }
            else -> {
                this.users.current.diabetesData.addToScore(4, "WaistCircumferenceQuestion")
                send(OptionSelectedEvent("high"))
                AcknowledgeAndGoToNext()
            }
        }
    }
    onResponse(listOf(
        ImReady(),
        ImDone()
    )) {
        furhat.ask(i18n.phrases.DIABETES_WAIST_CIRCUMFERENCE_2)
    }
}

private fun TriggerRunner<*>.AcknowledgeAndGoToNext() {
    furhat.say(i18n.phrases.GENERAL_ACKNOWLEDGE_THANK_YOU)
    goto(PhysicalActivityQuestion)
}


private fun TriggerRunner<*>.gotoOrListen(nextState : State, timestamp : Long, listenTimeMS : Int) {
    val currentTime = System.currentTimeMillis()
    if (timestamp + listenTimeMS < currentTime) {
        goto(nextState)
    } else {
        val timeLeft = timestamp + listenTimeMS - currentTime
        furhat.listen(timeout = timeLeft.toInt(), endSil = 3500)
    }
}
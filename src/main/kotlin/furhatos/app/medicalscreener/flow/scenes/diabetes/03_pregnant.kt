package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.Goodbye
import furhatos.app.medicalscreener.flow.scenes.EPDSStartQuestion
import furhatos.app.medicalscreener.i18n.No
import furhatos.app.medicalscreener.i18n.Yes
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils

private val log = CommonUtils.getLogger(EPDSStartQuestion::class.java)!!

val Pregnant : State = state(EPDSStartQuestion) {
    onEntry {
        furhat.askAndDo(i18n.phrases.DIABETES_PREGNANT_QUESTION_1) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}","no:${i18n.phrases.GENERAL_NO}"),
                i18n.phrases.DIABETES_PREGNANT_QUESTION_1_PROMPT
            ))
        }
    }
    onResponse<Yes> {
        send(OptionSelectedEvent("yes"))
        goto(Pregnant2)
    }
    onResponse(listOf(i18n.phrases.DIABETES_PREGNANT_EXTRA_YES_1)) {
        send(OptionSelectedEvent("yes"))
        goto(Pregnant2)
    }
    onResponse<No> {
        send(OptionSelectedEvent("no"))
        ackAndGoto(AgeQuestion)
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> {
                goto(Pregnant2)
            }
            "no" -> {
                ackAndGoto(AgeQuestion)
            }
        }
    }
}

val Pregnant2 : State = state(EPDSStartQuestion) {
    onEntry {
        furhat.askAndDo(i18n.phrases.DIABETES_PREGNANT_QUESTION_2) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}","no:${i18n.phrases.GENERAL_NO}"),
                i18n.phrases.DIABETES_PREGNANT_QUESTION_2_PROMPT
            ))
        }
    }
    onResponse<Yes> {
        send(OptionSelectedEvent("yes"))
        ackAndGoto(AgeQuestion)
    }
    onResponse<No> {
        send(OptionSelectedEvent("no"))
        furhat.say(i18n.phrases.GENERAL_OK_NO_PROBLEM)
        goto(Goodbye)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> {
                ackAndGoto(AgeQuestion)
            }
            "no" -> {
                furhat.say(i18n.phrases.GENERAL_OK_NO_PROBLEM)
                goto(Goodbye)
            }
        }
    }
}


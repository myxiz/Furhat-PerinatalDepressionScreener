package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.ScreeningSelection
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.flow.scenes.SexQuestion
import furhatos.app.medicalscreener.i18n.No
import furhatos.app.medicalscreener.i18n.Yes
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils

private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!

val AlreadyDiagnosed1 : State = state(EPDSQuestionBase) {
    onEntry {
        send(ClearScreen())
        furhat.askAndDo(i18n.phrases.DIABETES_ALREADY_DIAGNOSED_QUESTION_1) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}","no:${i18n.phrases.GENERAL_NO}"),
                i18n.phrases.DIABETES_ALREADY_DIAGNOSED_QUESTION_1_PROMPT
            ))
        }
    }
    onResponse<Yes> {
        send(OptionSelectedEvent("yes"))
        goto(AlreadyDiagnosed2)
    }
    onResponse(listOf(
            i18n.phrases.DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_1,
            i18n.phrases.DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_2
    )) {
        send(OptionSelectedEvent("yes"))
        goto(AlreadyDiagnosed2)
    }
    onResponse<No> {
        send(OptionSelectedEvent("no"))
        ackAndGoto(SexQuestion)
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> {
                goto(AlreadyDiagnosed2)
            }
            "no" -> {
                ackAndGoto(SexQuestion)
            }
        }
    }
}

val AlreadyDiagnosed2 : State = state(EPDSQuestionBase) {
    onEntry {
        send(ShowOptionsEvent(
            listOf("yes:${i18n.phrases.GENERAL_YES}","no:${i18n.phrases.GENERAL_NO}"),
            i18n.phrases.DIABETES_ALREADY_DIAGNOSED_QUESTION_2_PROMPT)
        )
        furhat.ask(i18n.phrases.DIABETES_ALREADY_DIAGNOSED_QUESTION_2)
    }
    onResponse<Yes> {
        send(OptionSelectedEvent("yes"))
        ackAndGoto(SexQuestion)
    }
    onResponse(listOf(
            i18n.phrases.DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_3,
            i18n.phrases.DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_4
    )) {
        send(OptionSelectedEvent("yes"))
        ackAndGoto(SexQuestion)
    }
    onResponse<No> {
        send(OptionSelectedEvent("no"))
        furhat.say(i18n.phrases.GENERAL_OK_NO_PROBLEM)
        goto(ScreeningSelection)
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> {
                ackAndGoto(SexQuestion)
            }
            "no" -> {
                furhat.say(i18n.phrases.GENERAL_OK_NO_PROBLEM)
                goto(ScreeningSelection)
            }
        }
    }
}
package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.i18n.No
import furhatos.app.medicalscreener.i18n.Yes
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.app.medicalscreener.i18n.DontKnow
import furhatos.app.medicalscreener.i18n.Maybe

val BloodGlucoseQuestion1: State = state(EPDSQuestionBase) {
    onEntry {
        furhat.askAndDo(i18n.phrases.DIABETES_BLOOD_GLUCOSE_QUESTION_1) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"),
                i18n.phrases.DIABETES_BLOOD_GLUCOSE_QUESTION_PROMT
            ))
        }
    }
    
    onResponse<Yes> {
        send(OptionSelectedEvent("yes"))
        goto(BloodGlucoseQuestion2)
    }

    onResponse(i18n.phrases.GENERAL_ONCE, i18n.phrases.GENERAL_SEVERAL_TIMES) {
        send(OptionSelectedEvent("yes"))
        goto(BloodGlucoseQuestion2)
    }
    onResponse<No> {
        send(OptionSelectedEvent("no"))
        ackAndGoto(FamilyQuestion1)
    }

    onResponse(listOf(Maybe(), DontKnow())) {
        ackAndGoto(FamilyQuestion1)
    }

    onEvent("UserResponse") {
        if ((it.get("response") as String?)?.toLowerCase() == "yes") {
            ackAndGoto(BloodGlucoseQuestion2)
        }
        ackAndGoto(FamilyQuestion1)
    }
}

val BloodGlucoseQuestion2: State = state(EPDSQuestionBase) {
    include(
        yesNoQuestion(
            i18n.phrases.DIABETES_BLOOD_GLUCOSE_QUESTION_2,
            nextState = FamilyQuestion1,
            onYes = { it.addToScore(5, "BloodGlucoseQuestion") },
            onNo = { Unit },
            onMaybe = { Unit },
            dataGetter = { user -> user.epdsData },
            extraYesPhrases = listOf(
                "高" // "high", which is a common chinese answer to a question that asks "was it high"
            ),
            extraNoPhrases = listOf(
                "不高" // "not high" or "low"
            )
        )
    )
}

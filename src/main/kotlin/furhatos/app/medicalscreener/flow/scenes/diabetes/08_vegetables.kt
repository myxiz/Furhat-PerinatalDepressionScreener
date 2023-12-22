package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.DiabetesQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.i18n.DontKnow
import furhatos.app.medicalscreener.i18n.Maybe
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.users

val VegetablesQuestion = state(DiabetesQuestionBase) {
    onEntry {
        send(ClearScreen())
        furhat.askAndDo(i18n.phrases.DIABETES_VEGETABLES_QUESTION) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"),
                i18n.phrases.DIABETES_VEGETABLES_QUESTION_PROMPT
            ))
        }
    }

    onResponse(listOf(Yes(), IEatEveryDay())) {
        send(OptionSelectedEvent("yes"))
        ackAndGoto(BloodPressureMedicationQuestion)
    }

    onResponse(listOf(No(), IDontEatEveryDay())) {
        send(OptionSelectedEvent("no"))
        users.current.diabetesData.addToScore(1, "VegetablesQuestion")
        ackAndGoto(BloodPressureMedicationQuestion)
    }

    onResponse(listOf(Maybe(), DontKnow(), Sometimes())) {
        users.current.diabetesData.addToScore(1, "VegetablesQuestion")
        ackAndGoto(BloodPressureMedicationQuestion)
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "yes" -> ackAndGoto(BloodPressureMedicationQuestion)
            "no" -> {
                users.current.diabetesData.addToScore(1)
                ackAndGoto(BloodPressureMedicationQuestion)
            }
        }
    }

}

package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.DiabetesQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.i18n.DontKnow
import furhatos.app.medicalscreener.i18n.Maybe
import furhatos.app.medicalscreener.nlu.PsysicalActivityExplain
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.users

val PhysicalActivityQuestion = state(DiabetesQuestionBase) {
    onEntry {
        send(ClearScreen())
        furhat.askAndDo(i18n.phrases.DIABETES_PHYSICAL_ACTIVITY_QUESTION) {
            send(ShowOptionsEvent(
                    listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"),
                    i18n.phrases.DIABETES_PHYSICAL_ACTIVITY_QUESTION_PROMPT
            ))
        }
    }
    onResponse<Yes> {
        send(OptionSelectedEvent("yes"))
        ackAndGoto(VegetablesQuestion)
    }
    onResponse<EveryDay> {
        send(OptionSelectedEvent("yes"))
        ackAndGoto(VegetablesQuestion)
    }
    onResponse<No> {
        send(OptionSelectedEvent("no"))
        users.current.diabetesData.addToScore(2, "PhysicalActivityQuestion")
        ackAndGoto(VegetablesQuestion)
    }
    onResponse<Maybe> {
        users.current.diabetesData.addToScore(2, "PhysicalActivityQuestion")
        ackAndGoto(VegetablesQuestion)
    }
    onResponse<DontKnow> {
        users.current.diabetesData.addToScore(2, "PhysicalActivityQuestion")
        ackAndGoto(VegetablesQuestion)
    }
    onResponse<Sometimes> {
        users.current.diabetesData.addToScore(2, "PhysicalActivityQuestion")
        ackAndGoto(VegetablesQuestion)
    }
    onResponse<NotEveryDay> {
        send(OptionSelectedEvent("no"))
        users.current.diabetesData.addToScore(2, "PhysicalActivityQuestion")
        ackAndGoto(VegetablesQuestion)
    }
    onResponse<PsysicalActivityExplain> {
        furhat.ask(i18n.phrases.DIABETES_PHYSICAL_ACTIVITY_EXPLAIN)
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "yes" -> ackAndGoto(VegetablesQuestion)
            "no" -> {
                users.current.diabetesData.addToScore(2)
                ackAndGoto(VegetablesQuestion)
            }
        }
    }
}

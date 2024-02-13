package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.i18n.i18n

val EPDSQuestion09: State = state(EPDSQuestionBase) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion9 state")
        furhat.askAndDo(i18n.phrases.EPDS_NINE) {
            send(ShowOptionsEvent(
                listOf(
                    "3:${i18n.phrases.EPDS_NINE_RESPONSES_3}", // For "ja, nästan jämt"
                    "2:${i18n.phrases.EPDS_NINE_RESPONSES_2}", // For "ja, ganska ofta"
                    "1:${i18n.phrases.EPDS_NINE_RESPONSES_1}", // For "bara någon gång"
                    "0:${i18n.phrases.EPDS_NINE_RESPONSES_0}"), // For "nej, aldrig"
                i18n.phrases.EPDS_NINE_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<YesAlmostAlways> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e9 = 3
        users.current.epdsData.addToScore(3, "EPDS09")
        goto(EPDSQuestion10) // Assuming there's an EPDSQuestion10 state to go to next
    }
    onResponse<YesQuiteOftenGanska> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e9 = 2
        users.current.epdsData.addToScore(2, "EPDS09")
        goto(EPDSQuestion10)
    }
    onResponse<JustOccasionally> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e9 = 1
        users.current.epdsData.addToScore(1, "EPDS09")
        goto(EPDSQuestion10)
    }
    onResponse<NoNever> { // Assuming NoNever intent is already defined and suitable here
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e9 = 0
        goto(EPDSQuestion10) // Proceed to the next question
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e9 = 0
                goto(EPDSQuestion10)
            }
            "1" -> {
                users.current.epdsData.e9 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDSQuestion10)
            }
            "2" -> {
                users.current.epdsData.e9 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDSQuestion10)
            }
            "3" -> {
                users.current.epdsData.e9 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDSQuestion10)
            }
        }
    }
}

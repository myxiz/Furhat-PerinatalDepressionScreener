package furhatos.app.medicalscreener.flow.scenes.MINI
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.i18n.i18n

val EPDSQuestion08: State = state(EPDSQuestionBase) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion8 state")
        furhat.askAndDo(i18n.phrases.EPDS_EIGHT) {
            send(ShowOptionsEvent(
                listOf(
                    "3:${i18n.phrases.EPDS_EIGHT_RESPONSES_3}", // Assuming this matches "ja, mycket ofta"
                    "2:${i18n.phrases.EPDS_EIGHT_RESPONSES_2}", // Assuming this is for "ja, rätt ofta"
                    "1:${i18n.phrases.EPDS_EIGHT_RESPONSES_1}",
                    "0:${i18n.phrases.EPDS_EIGHT_RESPONSES_0}"),
                i18n.phrases.EPDS_EIGHT_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<YesMostOfTheTime> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e8 = 3
        users.current.epdsData.addToScore(3, "EPDS08")
        ackAndGoto(EPDSQuestion09) // Assuming there's an EPDSQuestion09 state to go to next
    }
    onResponse<YesQuiteOften> { // Adjust this if you have a specific intent for "ja, rätt ofta"
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e8 = 2
        users.current.epdsData.addToScore(2, "EPDS08")
        ackAndGoto(EPDSQuestion09)
    }
    onResponse<NoRarely> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e8 = 1
        users.current.epdsData.addToScore(1, "EPDS08")
        ackAndGoto(EPDSQuestion09)
    }
    onResponse<NoNever> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e8 = 0
        ackAndGoto(EPDSQuestion09) // Proceed to the next question
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e8 = 0
                goto(EPDSQuestion09) // Assuming there's an EPDSQuestion09 to transition to next
            }
            "1" -> {
                users.current.epdsData.e8 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDSQuestion09) // Adjust if transitioning directly to a results state or another question
            }
            "2" -> {
                users.current.epdsData.e8 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDSQuestion09) // Ensure this transitions to the correct next step in your flow
            }
            "3" -> {
                users.current.epdsData.e8 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDSQuestion09) // Update the transition target as per your questionnaire flow
            }
        }
    }
}
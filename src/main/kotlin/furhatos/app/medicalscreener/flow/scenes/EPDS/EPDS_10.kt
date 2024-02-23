package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.OptionSelectedEvent
import furhatos.app.medicalscreener.flow.ShowOptionsEvent
import furhatos.app.medicalscreener.flow.askAndDo
import furhatos.app.medicalscreener.flow.epdsData
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestions
import furhatos.app.medicalscreener.flow.scenes.log
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*




val EPDSQuestion10: State = state(EPDSQuestions) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion10 state")
        furhat.askAndDo(i18n.phrases.EPDS_TEN) {
            send(ShowOptionsEvent(
                listOf(
                    "3:${i18n.phrases.EPDS_TEN_RESPONSES_3}", // For "ja, rätt så ofta"
                    "2:${i18n.phrases.EPDS_TEN_RESPONSES_2}", // For "ibland"
                    "1:${i18n.phrases.EPDS_TEN_RESPONSES_1}", // For "nästan aldrig"
                    "0:${i18n.phrases.EPDS_TEN_RESPONSES_0}"), // For "aldrig"
                i18n.phrases.EPDS_TEN_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<Q10_0_Never> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e10 = 0
        goto(EPDS_Results) // Assuming this is the last question and the assessment concludes here.
    }
    onResponse<Q10_1_HardlyEver> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e10 = 1
        users.current.epdsData.addToScore(1, "EPDS10")
        goto(EPDS_Results)
    }
    onResponse<Q10_2_Sometimes> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e10 = 2
        users.current.epdsData.addToScore(2, "EPDS10")
        goto(EPDS_Results)
    }
    onResponse<Q10_3_YesQuiteOften> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e10 = 3
        users.current.epdsData.addToScore(3, "EPDS10")
        goto(EPDS_Results)
    }


    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e10 = 0
                goto(EPDS_Results)
            }
            "1" -> {
                users.current.epdsData.e10 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDS_Results)
            }
            "2" -> {
                users.current.epdsData.e10 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDS_Results)
            }
            "3" -> {
                users.current.epdsData.e10 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDS_Results)
            }
        }
    }
}

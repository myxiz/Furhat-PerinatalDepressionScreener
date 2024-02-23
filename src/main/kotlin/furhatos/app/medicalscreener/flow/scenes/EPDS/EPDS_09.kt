package furhatos.app.medicalscreener.flow.scenes.EPDS

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestions
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.log
import furhatos.util.CommonUtils


val EPDSQuestion09: State = state(EPDSQuestions) {
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

    onResponse<Q9_0_NoNever> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e9 = 0
        ackAndGoto(EPDSQuestion10)
    }
    onResponse<Q9_1_OnlyOccasionally> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e9 = 1
        users.current.epdsData.addToScore(1, "EPDS09")
        ackAndGoto(EPDSQuestion10)
    }
    onResponse<Q9_2_YesQuiteOften> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e9 = 2
        users.current.epdsData.addToScore(2, "EPDS09")
        ackAndGoto(EPDSQuestion10)
    }
    onResponse<Q9_3_YesMostOfTheTime> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e9 = 3
        users.current.epdsData.addToScore(3, "EPDS09")
        ackAndGoto(EPDSQuestion10)
    }


    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
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

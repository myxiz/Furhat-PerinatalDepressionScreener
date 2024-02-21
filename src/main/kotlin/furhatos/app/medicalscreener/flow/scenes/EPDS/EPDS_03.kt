package furhatos.app.medicalscreener.flow.scenes.EPDS

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*

val EPDSQuestion03: State = state(EPDSQuestionBase) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion3 state")
        furhat.askAndDo(i18n.phrases.EPDS_THREE) {
            send(ShowOptionsEvent(
                //reversed order
                listOf(
                    "3:${i18n.phrases.EPDS_THREE_RESPONSES_3}",
                    "2:${i18n.phrases.EPDS_THREE_RESPONSES_2}",
                    "1:${i18n.phrases.EPDS_THREE_RESPONSES_1}",
                    "0:${i18n.phrases.EPDS_THREE_RESPONSES_0}"),
                i18n.phrases.EPDS_THREE_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<Q3_3_YesMostOfTheTime> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e3 = 3
        users.current.epdsData.addToScore(3, "EPDS03")
        ackAndGoto(EPDSQuestion04)
    }
    onResponse<Q3_2_YesSomeOfTheTime> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e3 = 2
        users.current.epdsData.addToScore(2, "EPDS03")
        ackAndGoto(EPDSQuestion04)
    }

    onResponse<Q3_1_NotVeryOften> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e3 = 1
        users.current.epdsData.addToScore(1, "EPDS03")
        ackAndGoto(EPDSQuestion04)
    }
    onResponse<Q3_0_NoNever> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e3 = 0
        ackAndGoto(EPDSQuestion04) // Assuming there's an EPDSQuestion04 state to go to next
    }


    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e3 = 0
                goto(EPDSQuestion04)
            }
            "1" -> {
                users.current.epdsData.e3 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDSQuestion04)
            }
            "2" -> {
                users.current.epdsData.e3 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDSQuestion04)
            }
            "3" -> {
                users.current.epdsData.e3 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDSQuestion04)
            }
        }
    }
}

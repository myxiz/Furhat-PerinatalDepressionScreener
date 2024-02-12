package furhatos.app.medicalscreener.flow.scenes.EPDS

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.i18n.DontKnow
import furhatos.app.medicalscreener.i18n.Maybe
import furhatos.app.medicalscreener.nlu.PsysicalActivityExplain
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.users

val EPDSQuestion02: State = state(EPDSQuestionBase) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion2 state")
        furhat.askAndDo(i18n.phrases.EPDS_TWO) {
            send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.EPDS_TWO_RESPONSES_0}",
                    "1:${i18n.phrases.EPDS_TWO_RESPONSES_1}",
                    "2:${i18n.phrases.EPDS_TWO_RESPONSES_2}",
                    "3:${i18n.phrases.EPDS_TWO_RESPONSES_3}"),
                i18n.phrases.EPDS_TWO_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<AsWellAsUsual> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e2 = 0
        ackAndGoto(EPDSQuestion03)
    }
    onResponse<AlmostAsWellAsUsual> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e2 = 1
        users.current.epdsData.addToScore(1, "EPDS02")
        ackAndGoto(EPDSQuestion03)
    }
    onResponse<MuchLessThanUsual> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e2 = 2
        users.current.epdsData.addToScore(2, "EPDS02")
        ackAndGoto(EPDSQuestion03)
    }
    onResponse<NotAtAll> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e2 = 3
        users.current.epdsData.addToScore(3, "EPDS02")
        ackAndGoto(EPDSQuestion03)
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> ackAndGoto(EPDSQuestion03)
            "1" -> {
                users.current.epdsData.addToScore(1)
                ackAndGoto(EPDSQuestion03)
            }
            "2" -> {
                users.current.epdsData.addToScore(2)
                ackAndGoto(EPDSQuestion03)
            }
            "3" -> {
                users.current.epdsData.addToScore(3)
                ackAndGoto(EPDSQuestion03)
            }
        }
    }
}


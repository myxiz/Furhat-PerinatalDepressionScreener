package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.i18n.AsMuchAsUsual
import furhatos.app.medicalscreener.i18n.SomewhatLessThanUsual
import furhatos.app.medicalscreener.i18n.MuchLessThanUsual
import furhatos.app.medicalscreener.i18n.NotAtAll
import furhatos.flow.kotlin.state


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

    onResponse<AsMuchAsUsual> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e2 = 0
        ackAndGoto(EPDSQuestion03)
    }
    onResponse<SomewhatLessThanUsual> {
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
            "0" -> {
                users.current.epdsData.e2 = 0 // Replace X with the question number
                goto(EPDSQuestion03) // Replace EPDSQuestion03 with the actual next question's state
            }
            "1" -> {
                users.current.epdsData.e2 = 1 // Replace X
                users.current.epdsData.addToScore(1) // Keep if scoring applies
                goto(EPDSQuestion03)
            }
            "2" -> {
                users.current.epdsData.e2 = 2 // Replace X
                users.current.epdsData.addToScore(2) // Keep if scoring applies
                goto(EPDSQuestion03)
            }
            "3" -> {
                users.current.epdsData.e2 = 3 // Replace X
                users.current.epdsData.addToScore(3) // Keep if scoring applies
                goto(EPDSQuestion03)
            }
        }
    }
}


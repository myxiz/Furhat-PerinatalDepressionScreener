package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.i18n.AsWellAsUsual
import furhatos.app.medicalscreener.i18n.AlmostAsWellAsUsual
import furhatos.app.medicalscreener.i18n.MuchLessThanUsual
import furhatos.app.medicalscreener.i18n.NotAtAll

val EPDSQuestion04: State = state(EPDSQuestionBase) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion4 state")
        furhat.askAndDo(i18n.phrases.EPDS_FOUR) {
            send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.EPDS_FOUR_RESPONSES_0}",
                    "1:${i18n.phrases.EPDS_FOUR_RESPONSES_1}",
                    "2:${i18n.phrases.EPDS_FOUR_RESPONSES_2}",
                    "3:${i18n.phrases.EPDS_FOUR_RESPONSES_3}"),
                i18n.phrases.EPDS_FOUR_PROMPT
            ))
        }
        delay(500)
    }
    // onResponse and onEvent handlers similar to EPDS01-EPDS03

    onResponse<AsWellAsUsual> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e4= 0
        ackAndGoto(EPDSQuestion05)
    }
    onResponse<AlmostAsWellAsUsual> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e4= 1
        users.current.epdsData.addToScore(1, "EPDS01")
        ackAndGoto(EPDSQuestion05)
    }
    onResponse<MuchLessThanUsual> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e4= 2
        users.current.epdsData.addToScore(2, "EPDS01")
        ackAndGoto(EPDSQuestion05)
    }
    onResponse<NotAtAll> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e4= 3
        users.current.epdsData.addToScore(3, "EPDS01")
        ackAndGoto(EPDSQuestion05)
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.lowercase()) {
            "0" -> {
                users.current.epdsData.e4= 0
                ackAndGoto(EPDSQuestion05)
            }
            "1" -> {
                users.current.epdsData.addToScore(1)
                users.current.epdsData.e4= 1
                ackAndGoto(EPDSQuestion05)
            }
            "2" -> {
                users.current.epdsData.addToScore(2)
                users.current.epdsData.e4= 2
                ackAndGoto(EPDSQuestion05)
            }
            "3" -> {
                users.current.epdsData.addToScore(3)
                users.current.epdsData.e4= 3
                ackAndGoto(EPDSQuestion05)
            }
        }
    }
}


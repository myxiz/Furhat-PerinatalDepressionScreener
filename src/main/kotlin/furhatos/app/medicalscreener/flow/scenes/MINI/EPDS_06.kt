package furhatos.app.medicalscreener.flow.scenes.MINI
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.i18n.i18n

val EPDSQuestion06: State = state(EPDSQuestionBase) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion6 state")
        furhat.askAndDo(i18n.phrases.EPDS_SIX) {
            send(ShowOptionsEvent(
                listOf(
                    "3:${i18n.phrases.EPDS_SIX_RESPONSES_3}",
                    "2:${i18n.phrases.EPDS_SIX_RESPONSES_2}",
                    "1:${i18n.phrases.EPDS_SIX_RESPONSES_1}",
                    "0:${i18n.phrases.EPDS_SIX_RESPONSES_0}"),
                i18n.phrases.EPDS_SIX_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<YesMostTimeNotCopeAtAll> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e6 = 3
        users.current.epdsData.addToScore(3, "EPDS06")
        ackAndGoto(EPDSQuestion07) // Assuming there's an EPDSQuestion07 state to go to next
    }
    onResponse<YesSometimesNotCopeAsWell> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e6 = 2
        users.current.epdsData.addToScore(2, "EPDS06")
        ackAndGoto(EPDSQuestion07)
    }
    onResponse<NoMostlyCopedWell> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e6 = 1
        users.current.epdsData.addToScore(1, "EPDS06")
        ackAndGoto(EPDSQuestion07)
    }
    onResponse<NoCopedAsUsual> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e6 = 0
        ackAndGoto(EPDSQuestion07) // Proceed to the next question
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e6 = 0
                goto(EPDSQuestion07)
            }
            "1" -> {
                users.current.epdsData.e6 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDSQuestion07)
            }
            "2" -> {
                users.current.epdsData.e6 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDSQuestion07)
            }
            "3" -> {
                users.current.epdsData.e6 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDSQuestion07)
            }
        }
    }
}

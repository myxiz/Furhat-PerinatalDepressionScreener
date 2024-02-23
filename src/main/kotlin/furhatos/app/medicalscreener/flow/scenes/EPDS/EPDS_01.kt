package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestions
import furhatos.app.medicalscreener.flow.scenes.log
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*


val EPDSQuestion01: State = state(EPDSQuestions) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion1 state")
        users.current.epdsData.score = 0
//        writeKpi(users.current, "Screening Started : EPDSQuestion1")
        furhat.askAndDo(i18n.phrases.EPDS_ONE) {
            send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.EPDS_ONE_RESPONSES_0}",
                    "1:${i18n.phrases.EPDS_ONE_RESPONSES_1}",
                    "2:${i18n.phrases.EPDS_ONE_RESPONSES_2}",
                    "3:${i18n.phrases.EPDS_ONE_RESPONSES_3}"),
                i18n.phrases.EPDS_ONE_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<Q1_0_AsMuchAsIAlwaysCould> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e1= 0
        ackAndGoto(EPDSQuestion02)
    }
    onResponse<Q1_1_NotQuiteSoMuchNow> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e1= 1
        users.current.epdsData.addToScore(1, "EPDS01")
        ackAndGoto(EPDSQuestion02)
    }
    onResponse<Q1_2_DefinitelyNotSoMuchNow> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e1= 2
        users.current.epdsData.addToScore(2, "EPDS01")
        ackAndGoto(EPDSQuestion02)
    }
    onResponse<Q1_3_NotAtAll> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e1= 3
        users.current.epdsData.addToScore(3, "EPDS01")
        ackAndGoto(EPDSQuestion02)
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e1 = 0
                goto(EPDSQuestion02)
            }
            "1" -> {
                users.current.epdsData.e1 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDSQuestion02)
            }
            "2" -> {
                users.current.epdsData.e1 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDSQuestion02)
            }
            "3" -> {
                users.current.epdsData.e1 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDSQuestion02)
            }
        }
    }
}


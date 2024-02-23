package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestions
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.log
import furhatos.util.CommonUtils

//private val log = CommonUtils.getLogger(EPDSQuestions::class.java)!!
val EPDSQuestion05: State = state(EPDSQuestions) {
    onEntry {
        log.debug("Entering EPDSQuestion5 state")
        furhat.askAndDo(i18n.phrases.EPDS_FIVE) {
            send(ShowOptionsEvent(
                // Keeping the reversed order as in the example provided
                listOf(
                    "3:${i18n.phrases.EPDS_FIVE_RESPONSES_3}",
                    "2:${i18n.phrases.EPDS_FIVE_RESPONSES_2}",
                    "1:${i18n.phrases.EPDS_FIVE_RESPONSES_1}",
                    "0:${i18n.phrases.EPDS_FIVE_RESPONSES_0}"),
                i18n.phrases.EPDS_FIVE_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<Q5_0_NoNotAtAll> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e5 = 0
        ackAndGoto(EPDSQuestion06)
    }
    onResponse<Q5_1_NoNotMuch> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e5 = 1
        users.current.epdsData.addToScore(1, "EPDS05")
        ackAndGoto(EPDSQuestion06)
    }
    onResponse<Q5_2_YesSometimes> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e5 = 2
        users.current.epdsData.addToScore(2, "EPDS05")
        ackAndGoto(EPDSQuestion06)
    }
    onResponse<Q5_3_YesQuiteALot> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e5 = 3
        users.current.epdsData.addToScore(3, "EPDS05")
        ackAndGoto(EPDSQuestion06)
    }


    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e5 = 0
                goto(EPDSQuestion06)
            }
            "1" -> {
                users.current.epdsData.e5 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDSQuestion06)
            }
            "2" -> {
                users.current.epdsData.e5 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDSQuestion06)
            }
            "3" -> {
                users.current.epdsData.e5 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDSQuestion06)
            }
        }

    }
}

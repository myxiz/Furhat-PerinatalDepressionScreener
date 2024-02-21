package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils

private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!
val EPDSQuestion07: State = state(EPDSQuestionBase) {
    onEntry {
        furhatos.app.medicalscreener.log.debug("Entering EPDSQuestion7 state")
        furhat.askAndDo(i18n.phrases.EPDS_SEVEN) {
            send(ShowOptionsEvent(
                listOf(
                    "3:${i18n.phrases.EPDS_SEVEN_RESPONSES_3}",
                    "2:${i18n.phrases.EPDS_SEVEN_RESPONSES_2}",
                    "1:${i18n.phrases.EPDS_SEVEN_RESPONSES_1}",
                    "0:${i18n.phrases.EPDS_SEVEN_RESPONSES_0}"),
                i18n.phrases.EPDS_SEVEN_PROMPT
            ))
        }
        delay(500)
    }

    onResponse<Q7_0_NoNotAtAll> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e7 = 0
        ackAndGoto(EPDSQuestion08)
    }
    onResponse<Q7_1_NoNotVeryOften> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e7 = 1
        users.current.epdsData.addToScore(1, "EPDS07")
        ackAndGoto(EPDSQuestion08)
    }
    onResponse<Q7_2_YesSometimes> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e7 = 2
        users.current.epdsData.addToScore(2, "EPDS07")
        ackAndGoto(EPDSQuestion08)
    }
    onResponse<Q7_3_YesMostOfTheTime> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e7 = 3
        users.current.epdsData.addToScore(3, "EPDS07")
        ackAndGoto(EPDSQuestion08)
    }


    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e7 = 0
                goto(EPDSQuestion08) // Adjust the transition target as per your questionnaire flow
            }
            "1" -> {
                users.current.epdsData.e7 = 1
                users.current.epdsData.addToScore(1)
                goto(EPDSQuestion08) // Adjust the transition target as per your questionnaire flow
            }
            "2" -> {
                users.current.epdsData.e7 = 2
                users.current.epdsData.addToScore(2)
                goto(EPDSQuestion08) // Adjust the transition target as per your questionnaire flow
            }
            "3" -> {
                users.current.epdsData.e7 = 3
                users.current.epdsData.addToScore(3)
                goto(EPDSQuestion08) // Adjust the transition target as per your questionnaire flow
            }
        }
    }
}

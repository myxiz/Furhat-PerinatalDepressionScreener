package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestions
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val EPDSQuestion04: State = state(EPDSQuestions) {
    onEntry {
        nextState = EPDSQuestion05
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

    onResponse<Q4_0_NoNotAtAll> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e4= 0
        handleNext()
    }
    onResponse<Q4_1_HardlyEver> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e4= 1
        users.current.epdsData.addToScore(1, "EPDS01")
        handleNext()
    }
    onResponse<Q4_2_YesSometimes> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e4= 2
        users.current.epdsData.addToScore(2, "EPDS01")
        handleNext()
    }
    onResponse<Q4_3_YesVeryOften> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e4= 3
        users.current.epdsData.addToScore(3, "EPDS01")
        handleNext()
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current,"User responded ${it.get("response")} through GUI")
        }
        when ((it.get("response") as String?)?.lowercase()) {
            "0" -> {
                users.current.epdsData.e4= 0
                handleNext()
            }
            "1" -> {
                users.current.epdsData.addToScore(1)
                users.current.epdsData.e4= 1
                handleNext()
            }
            "2" -> {
                users.current.epdsData.addToScore(2)
                users.current.epdsData.e4= 2
                handleNext()
            }
            "3" -> {
                users.current.epdsData.addToScore(3)
                users.current.epdsData.e4= 3
                handleNext()
            }
        }
    }
}


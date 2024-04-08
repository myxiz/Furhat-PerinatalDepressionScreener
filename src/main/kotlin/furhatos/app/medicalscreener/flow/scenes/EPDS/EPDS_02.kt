package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.log
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestions
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


val EPDSQuestion02: State = state(EPDSQuestions) {
    onEntry {
        nextState = EPDSQuestion03
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


    onResponse<Q2_0_AsMuchAsIEverDid> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e2 = 0
        handleNext()
    }
    onResponse<Q2_1_RatherLessThanIUsedTo> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e2 = 1
        users.current.epdsData.addToScore(1, "EPDS02")
        handleNext()
    }
    onResponse<Q2_2_DefinitelyLessThanIUsedTo> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e2 = 2
        users.current.epdsData.addToScore(2, "EPDS02")
        handleNext()
    }
    onResponse<Q2_3_HardlyAtAll> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e2 = 3
        users.current.epdsData.addToScore(3, "EPDS02")
        handleNext()
    }

    onEvent("UserResponse") {
        furhatos.app.medicalscreener.log.debug("User responded ${it.get("response")} through GUI")
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current,"User responded ${it.get("response")} through GUI")
        }
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e2 = 0 // Replace X with the question number
                handleNext() // Replace EPDSQuestion03 with the actual next question's state
            }
            "1" -> {
                users.current.epdsData.e2 = 1 // Replace X
                users.current.epdsData.addToScore(1) // Keep if scoring applies
                handleNext()
            }
            "2" -> {
                users.current.epdsData.e2 = 2 // Replace X
                users.current.epdsData.addToScore(2) // Keep if scoring applies
                handleNext()
            }
            "3" -> {
                users.current.epdsData.e2 = 3 // Replace X
                users.current.epdsData.addToScore(3) // Keep if scoring applies
                handleNext()
            }
        }
    }
}


package furhatos.app.medicalscreener.flow.scenes.EPDS
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestions
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils
import furhatos.app.medicalscreener.flow.scenes.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


val EPDSQuestion06: State = state(EPDSQuestions) {
    onEntry {
        nextState = EPDSQuestion07
        log.debug("Entering EPDSQuestion6 state")
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


    onResponse<Q6_0_NoIHaveBeenCopingAsWellAsEver> {
        send(OptionSelectedEvent("0"))
        users.current.epdsData.e6 = 0
        handleNext()
    }
    onResponse<Q6_1_NoMostOfTheTimeIHaveCopedQuiteWell> {
        send(OptionSelectedEvent("1"))
        users.current.epdsData.e6 = 1
        users.current.epdsData.addToScore(1, "EPDS06")
        handleNext()
    }
    onResponse<Q6_2_YesSometimesIHaveNotBeenCopingAsWellAsUsual> {
        send(OptionSelectedEvent("2"))
        users.current.epdsData.e6 = 2
        users.current.epdsData.addToScore(2, "EPDS06")
        handleNext()
    }
    onResponse<Q6_3_YesMostOfTheTimeIHaveNotBeenAbleToCopeAtAll> {
        send(OptionSelectedEvent("3"))
        users.current.epdsData.e6 = 3
        users.current.epdsData.addToScore(3, "EPDS06")
        handleNext()
    }


    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current,"User responded ${it.get("response")} through GUI")
        }
        when ((it.get("response") as String?)?.toLowerCase()) {
            "0" -> {
                users.current.epdsData.e6 = 0
                handleNext()
            }
            "1" -> {
                users.current.epdsData.e6 = 1
                users.current.epdsData.addToScore(1)
                handleNext()
            }
            "2" -> {
                users.current.epdsData.e6 = 2
                users.current.epdsData.addToScore(2)
                handleNext()
            }
            "3" -> {
                users.current.epdsData.e6 = 3
                users.current.epdsData.addToScore(3)
                handleNext()
            }
        }
    }
}

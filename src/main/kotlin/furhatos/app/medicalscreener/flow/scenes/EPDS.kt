@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.ScreeningConsent
import furhatos.app.medicalscreener.flow.scenes.EPDS.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.PreviousQuestion
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val log = CommonUtils.getLogger(InteractionWithBadResponse::class.java)

val EPDSQuestionBase = state(InteractionWithBadResponse,
        stateDefinition = abortableStateDef(ScreeningConsent, { it.epdsData.endTimestamp() }))
val EPDSQuestions = state(EPDSQuestionBase)
{
    onButton("EPDS1") {
        furhat.stopSpeaking()
        goto(EPDSQuestion01)
    }

    onButton("EPDS2") {
        furhat.stopSpeaking()
        goto(EPDSQuestion02)
    }
    onButton("EPDS3") {
        furhat.stopSpeaking()
        goto(EPDSQuestion03)
    }

    onButton("EPDS4") {
        furhat.stopSpeaking()
        goto(EPDSQuestion04)
    }

    onButton("EPDS5") {
        goto(EPDSQuestion05)
    }

    onButton("EPDS6") {
        goto(EPDSQuestion06)
    }

    onButton("EPDS7") {
        goto(EPDSQuestion07)
    }

    onButton("EPDS8") {
        goto(EPDSQuestion08)
    }

    onButton("EPDS9") {
        goto(EPDSQuestion09)
    }

    onButton("EPDS10") {
        goto(EPDSQuestion10)
    }

    onButton("Result") {
        goto(EPDS_Results)
    }

    onResponse<PreviousQuestion> {
        handlePrevious()
    }
}


val EPDSIntro: State = state(EPDSQuestions) {
    onEntry {
        log.debug("Entering EPDSIntro state")
        users.current.epdsData.score = 0
        users.current.personaliztionData.startTimestamp()
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current, "Entering EPDSIntro state")
        }
        goto(PersonalizationStart)
    }
}

val EPDSStartQuestion: State = state(EPDSQuestions) {

    include(ChangeLanguageBehavior)
    addRepeatQuestionHandler()
    addGoodbyeHandler()
    addTellAboutStatesHandlers()
    addGazeAversionBehaviour()
    include(NoOrInvalidResponseState())

    onEntry {
        val myScope = CoroutineScope(Dispatchers.Default)
        log.debug("Entering EPDSStart state")
        users.current.epdsData.score = 0
        users.current.epdsData.startTimestamp()
        myScope.launch {
            writeApi(users.current, "EPDS Screening Started")
        }
        furhat.sayAndRecord( i18n.phrases.EPDS_GETTING_STARTED + i18n.phrases.EPDS_OPTIONS_LIST)
        delay(1000)
        goto(EPDSQuestion01)
    }

}

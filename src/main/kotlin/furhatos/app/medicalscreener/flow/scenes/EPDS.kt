@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.ScreeningSelection
import furhatos.app.medicalscreener.flow.scenes.EPDS.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils

val EPDSQuestionBase = state(InteractionWithBadResponse,
        stateDefinition = abortableStateDef(ScreeningSelection, { it.epdsData.endTimestamp() }))


private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!

val EPDSIntro: State = state(EPDSQuestionBase) {
    onEntry {
        log.debug("Entering EPDSIntro state")
        users.current.epdsData.score = 0
        users.current.personaliztionData.startTimestamp()
        writeKpi(users.current, "Screening Started: EPDS intro")
        goto(PersonalizationStart)
    }
}

val EPDSStartQuestion: State = state(EPDSQuestionBase) {

    include(ChangeLanguageBehavior)
    addRepeatQuestionHandler()
    addGoodbyeHandler()
    addTellAboutStatesHandlers()
    addGazeAversionBehaviour()
    include(NoOrInvalidResponseState())

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

    onEntry {
        log.debug("Entering DiabetesStart state")
        users.current.epdsData.score = 0
        users.current.epdsData.startTimestamp()
        writeKpi(users.current, "Screening Started")
        furhat.say({
            +i18n.phrases.EPDS_GETTING_STARTED
        })
        delay(500)
        goto(EPDSQuestion01)
    }

}

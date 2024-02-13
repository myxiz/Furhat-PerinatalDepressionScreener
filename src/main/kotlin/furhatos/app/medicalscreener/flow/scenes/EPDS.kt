@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.IntroductionBaseState
import furhatos.app.medicalscreener.flow.introduction.ScreeningSelection
import furhatos.app.medicalscreener.flow.scenes.EPDS.*
import furhatos.app.medicalscreener.flow.scenes.diabetes.AgeQuestion
import furhatos.app.medicalscreener.flow.scenes.diabetes.AlreadyDiagnosed1
import furhatos.app.medicalscreener.flow.scenes.diabetes.Pregnant
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.nlu.Response
import furhatos.util.CommonUtils
import java.util.concurrent.TimeUnit

val EPDSQuestionBase = state(InteractionWithBadResponse,
        stateDefinition = abortableStateDef(ScreeningSelection, { it.epdsData.endTimestamp() }))

private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!

val EPDSIntro: State = state(EPDSQuestionBase) {
    onEntry {
        log.debug("Entering EPDSIntro state")
        users.current.epdsData.score = 0
        users.current.epdsData.startTimestamp()
        writeKpi(users.current, "Screening Started: EPDS intro")
//        furhat.say({
//            +i18n.phrases.EPDS_GETTING_STARTED
//        })
//        delay(500)
        goto(PersonalizationStart)
//        goto(DiabetesDisclaimer)
    }
}

val EPDSStartQuestion: State = state(EPDSQuestionBase) {
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


private fun TriggerRunner<*>.handleGoodBye() {
    furhat.say({
        + i18n.phrases.DIABETES_DISCLAIMER_REFUSED
        + behavior { send(ShowScreenEvent(text = i18n.phrases.DIABETES_DISCLAIMER_REFUSED_PROMPT, title = "")) }
    })
    goto(furhatos.app.medicalscreener.flow.introduction.Goodbye)
}

private fun TriggerRunner<*>.handleAffirmativeAnswer(it: Response<*>) {
    log.debug("User responded \"Yes\" (\"${it.text}\")")
    send(OptionSelectedEvent("yes"))
    sayGeneralAcknowledgement()
    delay(500, TimeUnit.MILLISECONDS)
    goto(AlreadyDiagnosed1)
}

private fun FlowControlRunner.diabetesSexResponse(response: String?, isNew: Boolean) {
    when (response?.toLowerCase()) {
        "male" -> {
            if (isNew) {
                this.users.current.epdsData.biologicalSex = "male"
                ackAndGoto(AgeQuestion)
            } else {
                goto(AgeQuestion)
            }
        }
        "female" -> {
            if (isNew) {
                this.users.current.epdsData.biologicalSex = "female"
                ackAndGoto(Pregnant)
            } else {
                goto(Pregnant)
            }
        }
        "other" -> {
            furhat.say(i18n.phrases.DIABETES_SEX_QUESTION_BIOLOGICAL_SEX)
            furhat.listen()
        }
        else -> reentry()
    }
}

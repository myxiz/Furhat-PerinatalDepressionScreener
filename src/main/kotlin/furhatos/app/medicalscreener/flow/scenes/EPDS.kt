@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.ScreeningSelection
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
    onEntry {
        log.debug("Entering DiabetesStart state")
        users.current.epdsData.score = 0
        users.current.epdsData.startTimestamp()
        writeKpi(users.current, "Screening Started")
        furhat.say({
            +i18n.phrases.EPDS_GETTING_STARTED
        })
        delay(500)
        goto(EPDSQuestion1)
//        goto(DiabetesDisclaimer)
    }
}


val EPDSQuestion1: State = state(EPDSQuestionBase) {
    onEntry {
        log.debug("Entering EPDSQuestion1 state")
        users.current.epdsData.score = 0
        users.current.epdsData.startTimestamp()
        writeKpi(users.current, "Screening Started : EPDSQuestion1")
        furhat.askAndDo(i18n.phrases.EPDS_ONE){

        }

        delay(500)
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

val SexQuestion = sexQuestion(
        EPDSQuestionBase,
        responseHandler = { response, isNew -> diabetesSexResponse(response, isNew) })

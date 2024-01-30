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
        stateDefinition = abortableStateDef(ScreeningSelection, { it.EPDSData.endTimestamp() }))

private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!

val EPDSStart: State = state(EPDSQuestionBase) {
    onEntry {
        log.debug("Entering DiabetesStart state")
        users.current.EPDSData.score = 0
        users.current.EPDSData.startTimestamp()
        writeKpi(users.current, "Screening Started")
        furhat.say({
            +i18n.phrases.EPDS_GETTING_STARTED
        })
        delay(500)
//        goto(DiabetesDisclaimer)
    }
}

//val DiabetesDisclaimer: State = state(DiabetesQuestionBase) {
//    withHelpOptions(i18n.phrases.DIABETES_DISCLAIMER_HELP_OPTION_1, i18n.phrases.DIABETES_DISCLAIMER_HELP_OPTION_2)
//    onEntry {
//        send(ClearScreen())
//        log.debug("Presenting diabetes disclaimer")
//        furhat.askAndDo(i18n.phrases.DIABETES_DISCLAIMER) {
//            send(ShowOptionsEvent(
//                    listOf("yes:${i18n.phrases.DIABETES_DISCLAIMER_I_UNDERSTAND}", "no:${i18n.phrases.GENERAL_NO}"),
//                    prompt = i18n.phrases.DIABETES_DISCLAIMER_PROMPT,
//                    append = true))
//        }
//    }
//
//    onReentry {
//        furhat.ask {
//            +behavior { send(ShowOptionsEvent(listOf("yes:${i18n.phrases.DIABETES_DISCLAIMER_I_UNDERSTAND}", "no:${i18n.phrases.GENERAL_NO}"), prompt = i18n.phrases.DIABETES_DISCLAIMER_PROMPT, append = false)) }
//            +i18n.phrases.DIABETES_DISCLAIMER
//        }
//    }
//
//    onResponse<Yes> {
//        handleAffirmativeAnswer(it)
//    }
//
//    onResponse<IUnderstand> {
//        handleAffirmativeAnswer(it)
//    }
//
//    onResponse<No> {
//        log.debug("User responded \"No\" (\"${it.text}\")")
//        send(OptionSelectedEvent("no"))
//        handleGoodBye()
//    }
//
//    onEvent("UserResponse") {
//        log.debug("User responded ${it.get("response")} through GUI")
//        when (it.get("response")) {
//            "yes" -> {
//                sayGeneralAcknowledgement()
//                delay(500, TimeUnit.MILLISECONDS)
//                goto(AlreadyDiagnosed1)
//            }
//            "no" -> {
//                handleGoodBye()
//            }
//        }
//    }
//}
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
                this.users.current.EPDSData.biologicalSex = "male"
                ackAndGoto(AgeQuestion)
            } else {
                goto(AgeQuestion)
            }
        }
        "female" -> {
            if (isNew) {
                this.users.current.EPDSData.biologicalSex = "female"
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

@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.IntroductionBaseState
import furhatos.app.medicalscreener.flow.introduction.ScreeningSelection
import furhatos.app.medicalscreener.flow.scenes.diabetes.AgeQuestion
import furhatos.app.medicalscreener.flow.scenes.diabetes.AlreadyDiagnosed1
import furhatos.app.medicalscreener.flow.scenes.diabetes.Pregnant
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.nlu.MoveOnIntent
import furhatos.app.medicalscreener.nlu.ChangeBack
import furhatos.flow.kotlin.*
import furhatos.nlu.Response
import furhatos.util.CommonUtils
import furhatos.util.Gender
import furhatos.app.medicalscreener.setRobotVoice
import furhatos.util.Language
import java.util.concurrent.TimeUnit

val PersonalizationQuestionBase = state(IntroductionBaseState,
        stateDefinition = abortableStateDef(ScreeningSelection, null))

private val log = CommonUtils.getLogger(PersonalizationQuestionBase::class.java)!!

val PersonalizationStart: State = state(PersonalizationQuestionBase) {
    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationStart state")
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_GENDER_MATTERS) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"),
                prompt = i18n.phrases.PERSONALIZATION_GENDER_MATTERS,
                append = true))
        }
    }
    onResponse<Yes> {
        log.debug("User responded \"yes\" (\"${it.text}\")")
        send(OptionSelectedEvent("yes"))
        handleMoveToGender()
    }
//
    onResponse<No> {
        log.debug("User responded \"No\" (\"${it.text}\")")
        send(OptionSelectedEvent("no"))
        handleMoveToFace()
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationGender)
            }
            "no" -> {
                handleMoveToFace()
            }
        }
    }
}

val PersonalizationGender: State = state(PersonalizationQuestionBase) {
    withHelpOptions(i18n.phrases.GENERAL_YES, i18n.phrases.GENERAL_NO)

    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationGender state")
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE) {
            send(ShowOptionsEvent(
                    listOf("male:${Gender.MALE}", "female:${Gender.FEMALE}"),
                    prompt = i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE,
                    append = true))
        }
    }
//
    onReentry {
        furhat.ask {
            +behavior { send(ShowOptionsEvent(listOf("male:${Gender.MALE}", "female:${Gender.FEMALE}"), prompt = i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE, append = false)) }
            +i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE
        }
    }

    onResponse<Male> {
        log.debug("User responded \"male\" (\"${it.text}\")")
        send(OptionSelectedEvent("male"))
        handleChooseMale()
    }
//
    onResponse<Female> {
        log.debug("User responded \"female\" (\"${it.text}\")")
        send(OptionSelectedEvent("female"))
        handleChooseFemale()
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "male" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationFace)
            }
            "female" -> {
                handleMoveToFace()
            }
        }
    }
}
val PersonalizationApplyMale: State = state(PersonalizationQuestionBase) {
    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationApplyMale state")
        furhat.setRobotVoice(currentLang,Gender.MALE)
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_MALE_VOICE) {
            send(ShowOptionsEvent(
                listOf("confirm:${i18n.phrases.GENERAL_MOVE_ON_REPLY}", "female:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_FEMALE}"
                ,"original:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_ORIGINAL}"),
                prompt = i18n.phrases.PERSONALIZATION_MALE_VOICE,
                append = true))
        }
    }
    onResponse<MoveOnIntent> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("confirm"))
        handleMoveToFace()
    }
//
    onResponse<Female> {
        log.debug("User responded \"female\" (\"${it.text}\")")
        send(OptionSelectedEvent("female"))
        handleChooseFemale()
    }

    onResponse<ChangeBack> {
        log.debug("User responded \"change back to neutral\" (\"${it.text}\")")
        send(OptionSelectedEvent("neutral"))
        furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
        handleMoveToFace()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "confirm" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationFace)
            }
            "female" -> {
                handleChooseFemale()
            }
            "original" -> {
                furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationFace)
            }
        }
    }
}

val PersonalizationApplyFemale: State = state(PersonalizationQuestionBase) {
    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationApplyMale state")
        furhat.setRobotVoice(currentLang,Gender.MALE)
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_MALE_VOICE) {
            send(ShowOptionsEvent(
                listOf("confirm:${i18n.phrases.GENERAL_MOVE_ON_REPLY}", "male:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_MALE}"
                    ,"original:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_ORIGINAL}"),
                prompt = i18n.phrases.PERSONALIZATION_MALE_VOICE,
                append = true))
        }
    }
    onResponse<MoveOnIntent> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("confirm"))
        handleMoveToFace()
    }
//
    onResponse<Male> {
        log.debug("User responded \"male\" (\"${it.text}\")")
        send(OptionSelectedEvent("male"))
        handleChooseMale()
    }

    onResponse<ChangeBack> {
        log.debug("User responded \"change back to neutral\" (\"${it.text}\")")
        send(OptionSelectedEvent("neutral"))
        furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
        handleMoveToFace()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "confirm" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationFace)
            }
            "male" -> {
                handleChooseMale()
            }
            "original" -> {
                furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationFace)
            }
        }
    }
}

val PersonalizationFace: State = state(EPDSQuestionBase) {
    onEntry {
        log.debug("Entering PersonalizationFace state")
        send(ClearScreen())
        writeKpi(users.current, "Face Choosing Started")
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_FACE_CHOOSE) {
            send(ShowOptionsEvent(
                listOf("confirm:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_MALE}", "female:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_FEMALE}",
                    "original:${ i18n.phrases.PERSONALIZATION_VOICE_OPTION_ORIGINAL}"),
                prompt = i18n.phrases.DIABETES_DISCLAIMER_PROMPT,
                append = true))
        }
        furhat.say({
            +i18n.phrases.PERSONALIZATION_FACE_CHOOSE
        })
        delay(500)
    }

}





private fun TriggerRunner<*>.handleMoveToFace() {
    goto(PersonalizationFace)
}
//
private fun TriggerRunner<*>.handleMoveToGender() {
    goto(PersonalizationGender)
}

private fun TriggerRunner<*>.handleChooseMale() {
    goto(PersonalizationApplyMale)
}

private fun TriggerRunner<*>.handleChooseFemale() {
    goto(PersonalizationApplyFemale)
}
//
//private fun FlowControlRunner.diabetesSexResponse(response: String?, isNew: Boolean) {
//    when (response?.toLowerCase()) {
//        "male" -> {
//            if (isNew) {
//                this.users.current.EPDSData.biologicalSex = "male"
//                ackAndGoto(AgeQuestion)
//            } else {
//                goto(AgeQuestion)
//            }
//        }
//        "female" -> {
//            if (isNew) {
//                this.users.current.EPDSData.biologicalSex = "female"
//                ackAndGoto(Pregnant)
//            } else {
//                goto(Pregnant)
//            }
//        }
//        "other" -> {
//            furhat.say(i18n.phrases.DIABETES_SEX_QUESTION_BIOLOGICAL_SEX)
//            furhat.listen()
//        }
//        else -> reentry()
//    }
//}
//
//val SexQuestion = sexQuestion(
//        EPDSQuestionBase,
//        responseHandler = { response, isNew -> diabetesSexResponse(response, isNew) })

@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.IntroductionBaseState
import furhatos.app.medicalscreener.flow.introduction.ScreeningSelection
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.nlu.MoveOnIntent
import furhatos.app.medicalscreener.nlu.ChangeBack
import furhatos.app.medicalscreener.nlu.Male
import furhatos.app.medicalscreener.nlu.Female
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils
import furhatos.util.Gender
import furhatos.app.medicalscreener.setRobotVoice
import furhatos.gestures.Gestures
import java.util.concurrent.TimeUnit


val PersonalizationQuestionBase = state(IntroductionBaseState,
        stateDefinition = abortableStateDef(ScreeningSelection, null))

private val log = CommonUtils.getLogger(PersonalizationQuestionBase::class.java)!!

val PersonalizationStart: State = state(PersonalizationQuestionBase) {
    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationStart state")
        users.current.personaliztionData.startTimestamp()
        writeKpi(users.current, "Personalization Started")
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_GENDER_MATTERS) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"),
                prompt = i18n.phrases.PERSONALIZATION_GENDER_MATTERS_PROMPT,
                ))
        }
    }
    onResponse<Yes> {
        log.debug("User responded \"yes, gender matters\" (\"${it.text}\")")
        users.current.personaliztionData.genderMatters = true
        users.current.personaliztionData.startTimestamp()
        writeKpi(users.current, "Personalization Started: "+"User responded \"yes, gender matters\" (\"${it.text}\")")
        send(OptionSelectedEvent("yes"))
        handleMoveToGender()
    }
//
    onResponse<No> {
        log.debug("User responded \"No, continue to faces\" (\"${it.text}\")")
        users.current.personaliztionData.genderMatters = false
        users.current.personaliztionData.startTimestamp()
        writeKpi(users.current, "Personalization Started: "+"User responded \"No, continue to faces\" (\"${it.text}\")")
        send(OptionSelectedEvent("no"))
        handleMoveToFace()
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> {
                users.current.personaliztionData.genderMatters = true
                users.current.personaliztionData.startTimestamp()
                writeKpi(users.current, "Personalization Started: "+"User responded \"Yes\" through GUI\"")
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationGender)
            }
            "no" -> {
                users.current.personaliztionData.genderMatters = false
                users.current.personaliztionData.startTimestamp()
                writeKpi(users.current, "Personalization Started: "+"User responded \"No\" through GUI\"")
                handleMoveToFace()
            }
        }
    }
}

val PersonalizationGender: State = state(PersonalizationStart) {
    withHelpOptions(i18n.phrases.GENERAL_YES, i18n.phrases.GENERAL_NO)

    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationGender state")
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE) {
            send(ShowOptionsEvent(
                    listOf("male:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_MALE}",
                        "female:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_FEMALE}",
                        "next:${i18n.phrases.GENERAL_CONTINUE}"),
                    prompt = i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE,
                    append = true))
        }
    }
//
    onReentry {
        furhat.ask {
            +behavior { send(ShowOptionsEvent(listOf("next:${i18n.phrases.GENERAL_CONTINUE}","male:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_MALE}", "female:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_FEMALE}"),
                prompt = i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE,
                append = false)) }
            +i18n.phrases.PERSONALIZATION_GENDER_PREFERENCE
        }
    }

    onResponse<Male> {
        log.debug("User responded \"male\" (\"${it.text}\")")
        handleChooseMale()
    }
//
    onResponse<Female> {
        log.debug("User responded \"female\" (\"${it.text}\")")
        handleChooseFemale()
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "male" -> {
//                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                handleChooseMale()
            }
            "female" -> {
//                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                handleChooseFemale()
            }
        }
    }
}
val PersonalizationApplyMale: State = state(PersonalizationGender) {
    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationApplyMale state")
        writeKpi(users.current, "PersonalizationApplyMale")
        furhat.setRobotVoice(currentLang,Gender.MALE)
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_MALE_VOICE) {
            send(ShowOptionsEvent(
                listOf( "female:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_FEMALE}"
                ,"original:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_ORIGINAL}","next:${i18n.phrases.GENERAL_MOVE_ON_REPLY}"),
                prompt = i18n.phrases.PERSONALIZATION_MALE_VOICE,
                append = true))
        }
    }
    onResponse<MoveOnIntent> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("next"))
        handleMoveToFace()
    }

    onResponse<Yes> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("next"))
        handleMoveToFace()
    }
//
    onResponse<Female> {
        log.debug("User responded \"female\" (\"${it.text}\")")
//        send(OptionSelectedEvent("female"))
        handleChooseFemale()
    }

    onResponse<ChangeBack> {
        log.debug("User responded \"change back to neutral\" (\"${it.text}\")")
        send(OptionSelectedEvent("original"))
        handleChooseOriginal()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "next" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationFace)
            }
            "female" -> {
                handleChooseFemale()
            }
            "original" -> {
                handleChooseOriginal()
            }
        }
    }
}

val PersonalizationApplyOriginal : State = state(PersonalizationGender) {
    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationApplyOriginal state")
        writeKpi(users.current, "PersonalizationApplyOriginal")
        furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_ORIGINAL_VOICE) {
            send(ShowOptionsEvent(
                listOf( "male:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_MALE}"
                    ,"female:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_FEMALE}",
                    "next:${i18n.phrases.GENERAL_MOVE_ON_REPLY}",),
                prompt = i18n.phrases.PERSONALIZATION_ORIGINAL_VOICE,
                append = true))
        }
    }
    onResponse<MoveOnIntent> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("next"))
        handleMoveToFace()

    }
    onResponse<Yes> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("next"))
        handleMoveToFace()
    }
//
    onResponse<Male> {
        log.debug("User responded \"male\" (\"${it.text}\")")
        handleChooseMale()
    }

    onResponse<ChangeBack> {
        log.debug("User responded \"change back to neutral\" (\"${it.text}\")")
        send(OptionSelectedEvent("original"))
        handleChooseOriginal()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "next" -> {
                handleMoveToFace()
            }
            "male" -> {
                handleChooseMale()
            }
            "original" -> {
                handleChooseOriginal()
            }
        }
    }
}

val PersonalizationApplyFemale: State = state(PersonalizationGender) {
    onEntry {
        send(ClearScreen())
        log.debug("Entering PersonalizationApplyFemale state")
        writeKpi(users.current, "PersonalizationApplyFemale")
        furhat.setRobotVoice(currentLang,Gender.FEMALE)
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_FEMALE_VOICE) {
            send(ShowOptionsEvent(
                listOf( "male:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_MALE}"
                    ,"original:${i18n.phrases.PERSONALIZATION_VOICE_OPTION_ORIGINAL}",
                    "next:${i18n.phrases.GENERAL_MOVE_ON_REPLY}",),
                prompt = i18n.phrases.PERSONALIZATION_FEMALE_VOICE,
                append = true))
        }
    }
    onResponse<MoveOnIntent> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("next"))
        handleMoveToFace()
    }

    onResponse<Yes> {
        log.debug("User responded \"move on\" (\"${it.text}\")")
        send(OptionSelectedEvent("next"))
        handleMoveToFace()
    }


//
    onResponse<Male> {
        log.debug("User responded \"male\" (\"${it.text}\")")
        handleChooseMale()
    }

    onResponse<ChangeBack> {
        log.debug("User responded \"change back to neutral\" (\"${it.text}\")")
        send(OptionSelectedEvent("original"))
        handleChooseOriginal()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "next" -> {
                handleMoveToFace()
            }
            "male" -> {
                handleChooseMale()
            }
            "original" -> {
                handleChooseOriginal()
            }
        }
    }
}

val PersonalizationFace: State = state(PersonalizationGender) {
    onEntry {
        log.debug("Entering PersonalizationFace state")
        writeKpi(users.current, "Personalization face choosing started")
        send(ClearScreen())
        writeKpi(users.current, "Face Choosing Started")
        send(ShowFacesEvent("show"))
        send(ShowOptionsEvent(
            listOf( "confirm:${i18n.phrases.GENERAL_CONTINUE}",
            ),
            append = true))
        furhat.say(i18n.phrases.PERSONALIZATION_FACE_CHOOSE)
    }
    onReentry{
        send(ShowFacesEvent("show"))
        send(ShowOptionsEvent(
            listOf( "confirm:${i18n.phrases.GENERAL_CONTINUE}",
            ),
            append = true))
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "confirm" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                handleToRememberPersonalization()
            }
            else -> {
                log.debug("User responded  ${it.get("response")} through GUI")
                handleApplyFace((it.get("response").toString()))
            }
        }
    }
}

val PersonalizationRemember: State = state(PersonalizationFace) {
    onEntry{
        log.debug("Entering PersonalizationRemember state")
        send(ClearScreen())
        writeKpi(users.current, "Face Choosing Waiting for Confirmation")
        furhat.askAndDo(
            utterance { Gestures.Smile
                +i18n.phrases.PERSONALIZATION_REMEMBER_CHOICE
            }) {
            send(ShowOptionsEvent(
                listOf( "yes:${i18n.phrases.PERSONALIZATION_REMEMBER_OPTION_YES}",
                    "no:${i18n.phrases.PERSONALIZATION_REMEMBER_OPTION_NO}",
                ),
                prompt = i18n.phrases.PERSONALIZATION_REMEMBER_CHOICE,
                append = true))
        }
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")}  through GUI")
        when (it.get("response")) {
            "yes" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                users.current.personaliztionData.remember = true
                handleMoveToEPDS()
            }
            "no" -> {
                users.current.personaliztionData.remember = false
                handleMoveToEPDS()
            }
        }
    }
}

private fun  TriggerRunner<*>.handleApplyFace(key: String?) {
    furhat.character = key
    delay(500)
    furhat.askAndDo(i18n.phrases.PERSONALIZATION_CONFIRMATION){
        send(ShowFacesEvent("show"))
    }
//    goto(PersonalizationFace)
}

private fun TriggerRunner<*>.handleMoveToFace() {
    send(OptionSelectedEvent("next"))
    sayGeneralAcknowledgement()
    delay(500, TimeUnit.MILLISECONDS)
    goto(PersonalizationFace)
}
//
private fun TriggerRunner<*>.handleMoveToGender() {
    goto(PersonalizationGender)
}

private fun TriggerRunner<*>.handleChooseMale() {
    send(OptionSelectedEvent("male"))
    goto(PersonalizationApplyMale)
}

private fun TriggerRunner<*>.handleChooseOriginal(){
    send(OptionSelectedEvent("neutral"))
    furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
    delay(500, TimeUnit.MILLISECONDS)
    goto(PersonalizationApplyOriginal)
}

private fun TriggerRunner<*>.handleChooseFemale() {
    send(OptionSelectedEvent("female"))
    goto(PersonalizationApplyFemale)
}

private fun TriggerRunner<*>.handleToRememberPersonalization(){
    goto(PersonalizationRemember)
}

private fun TriggerRunner<*>.handleRememberPersonalization(){
    goto(EPDSStartQuestion)
}
private fun TriggerRunner<*>.handleMoveToEPDS(){
    goto(EPDSStartQuestion)
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

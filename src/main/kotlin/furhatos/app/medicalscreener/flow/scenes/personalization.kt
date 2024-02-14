@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.*
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.nlu.*
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils
import furhatos.util.Gender
import furhatos.app.medicalscreener.setRobotVoice
import furhatos.gestures.Gestures
import java.lang.IllegalArgumentException
import java.util.concurrent.TimeUnit
import java.time.LocalDateTime

//val PersonalizationQuestionBase = state(Interaction, stateDefinition = abortableStateDef(ScreeningSelection, null))

val PersonalizationQuestionBase: State = state(IntroductionBaseState) {
    include(ChangeLanguageBehavior)
    addRepeatQuestionHandler()
    addGoodbyeHandler()
    addTellAboutStatesHandlers()
    addGazeAversionBehaviour()
    include(NoOrInvalidResponseState())
    onResponse<EnglishDontUnderstandLanguage> {
        handleLanguageChange(language = "en")
    }
}

private val log = CommonUtils.getLogger(PersonalizationQuestionBase::class.java)!!

val PersonalizationStart: State = state(PersonalizationQuestionBase) {
//    include(ChangeLanguageBehavior)
//    addRepeatQuestionHandler()
//    addGoodbyeHandler()
//    addTellAboutStatesHandlers()
//    addGazeAversionBehaviour()
//    include(NoOrInvalidResponseState())
    onEntry {
        log.debug("Entering PersonalizationStart state")
        users.current.personaliztionData.startTimestamp()
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_GENDER_MATTERS) {
            send(ClearScreen())
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"),
                prompt = i18n.phrases.PERSONALIZATION_GENDER_MATTERS_PROMPT,
                ))
        }
    }

    onReentry {
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_GENDER_MATTERS) {
            send(ClearScreen())
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"),
                prompt = i18n.phrases.PERSONALIZATION_GENDER_MATTERS_PROMPT,
            ))
        }
    }

    onResponse<Yes> { handleGenderMattersChoice("yes") }
    onResponse<YesYouCan> { handleGenderMattersChoice("yes") }
    onResponse<Maybe> { handleGenderMattersChoice("yes") }
    onResponse<LetsProceed> { handleGenderMattersChoice("no") }
    onResponse<No> { handleGenderMattersChoice("no") }
    onResponse("don't want to" ) { handleGenderMattersChoice("no") }


    onEvent("UserResponse") {
        furhatos.app.medicalscreener.flow.introduction.log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        when {
            response === null -> throw Error("Response from GUI was null")
            listOf("yes", "no").contains(response) -> {
                furhatos.app.medicalscreener.flow.introduction.log.debug("User selected screening ${it.get("response")} through GUI")
                handleGenderMattersChoice(it.get("response") as String?, true)
            }
            else -> handleLanguageChange(language = response)
        }
    }
}

private fun TriggerRunner<*>.handleGenderMattersChoice(choice: String?, respondedFromGui: Boolean = false) {

    when (choice) {
        "yes" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("yes"))
            }
            users.current.personaliztionData.genderMatters = true
            sayGeneralAcknowledgement()
            delay(500, TimeUnit.MILLISECONDS)
            goto(PersonalizationGender)
        }
        "no" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("no"))
            }
            users.current.personaliztionData.genderMatters = false
            log.debug( "Personalization Started: "+"User responded No")
            handleMoveToFace()
        }
        else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
    }
}

val PersonalizationGender: State = state(PersonalizationQuestionBase) {
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

    onResponse<Female> {
        log.debug("User responded \"female\" (\"${it.text}\")")
        handleChooseFemale()
    }

    onResponse<MoveOnIntent>{
        log.debug("User responded \"move on\" (\"${it.text}\")")
        handleMoveToFace()
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "male" -> {
                delay(500, TimeUnit.MILLISECONDS)

                handleChooseMale()
            }
            "female" -> {
                delay(500, TimeUnit.MILLISECONDS)
                handleChooseFemale()
            }
            "next" -> {
                sayGeneralAcknowledgement()
                delay(500, TimeUnit.MILLISECONDS)
                goto(PersonalizationFace)
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

    onResponse<Female> {
        log.debug("User responded \"female\" (\"${it.text}\")")
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

val PersonalizationApplyOriginal : State = state(PersonalizationQuestionBase) {
    onEntry {
        log.debug("Entering PersonalizationApplyOriginal state")
        writeKpi(users.current, "User Chose PersonalizationApplyOriginal on" + LocalDateTime.now() )
        furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_ORIGINAL_VOICE) {
            send(ClearScreen())
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

    onResponse<Male> {
        log.debug("User responded \"male\" (\"${it.text}\")")
        send(OptionSelectedEvent("male"))
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
                log.debug("User responded ${it.get("response")} through GUI")
                handleMoveToFace()
            }
            "male" -> {
                log.debug("User responded ${it.get("response")} through GUI")
                handleChooseMale()
            }
            "original" -> {
                log.debug("User responded ${it.get("response")} through GUI")
                handleChooseOriginal()
            }
        }
    }
}

val PersonalizationApplyFemale: State = state(PersonalizationQuestionBase) {
    onEntry {
        log.debug("Entering PersonalizationApplyFemale state")
        writeKpi(users.current, "PersonalizationApplyFemale")
        furhat.setRobotVoice(currentLang,Gender.FEMALE)
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_FEMALE_VOICE) {
            send(ClearScreen())
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

val PersonalizationFace: State = state(PersonalizationQuestionBase) {
    onEntry {
        log.debug("Entering PersonalizationFace state")
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_FACE_CHOOSE){
            send(ClearScreen())
            send(ShowFacesEvent("show"))
            send(ShowOptionsEvent(
                listOf( "yes:${i18n.phrases.GENERAL_CONTINUE}",
                )))
        }
    }
    onReentry{
        furhat.askAndDo(i18n.phrases.PERSONALIZATION_FACE_CHOOSE){
            send(ClearScreen())
            send(ShowFacesEvent("show"))
            send(ShowOptionsEvent(
                listOf( "yes:${i18n.phrases.GENERAL_CONTINUE}",
                )))
        }
    }
    onResponse<Yes>{
        sayGeneralAcknowledgement()
        send(OptionSelectedEvent("yes"))
        handleToRememberPersonalization()
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> {
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

val PersonalizationRemember: State = state(PersonalizationQuestionBase) {
    onEntry{
        log.debug("Entering PersonalizationRemember state")
        send(ClearScreen())
        furhat.askAndDo(
            utterance { Gestures.Smile
                +i18n.phrases.PERSONALIZATION_REMEMBER_CHOICE
            }) {
            send(ShowOptionsEvent(
                listOf( "yes:${i18n.phrases.PERSONALIZATION_REMEMBER_OPTION_YES}",
                    "no:${i18n.phrases.PERSONALIZATION_REMEMBER_OPTION_NO}",
                ),
                prompt = i18n.phrases.PERSONALIZATION_REMEMBER_CHOICE))
        }
    }

    onResponse<Yes>{
        sayGeneralAcknowledgement()
        users.current.personaliztionData.remember = true
        handleMoveToEPDS()
    }

    onResponse<No>{
        sayGeneralAcknowledgement()
        users.current.personaliztionData.remember = false
        handleMoveToEPDS()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")}  through GUI")
        when (it.get("response")) {
            "yes" -> {
                sayGeneralAcknowledgement()
                users.current.personaliztionData.remember = true
                handleMoveToEPDS()
            }
            "no" -> {
                sayGeneralAcknowledgement()
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
}

private fun TriggerRunner<*>.handleMoveToFace() {
    send(OptionSelectedEvent("next"))
    sayGeneralAcknowledgement()
    delay(500, TimeUnit.MILLISECONDS)
    goto(PersonalizationFace)
}

private fun TriggerRunner<*>.handleMoveToGender() {
    goto(PersonalizationGender)
}

private fun TriggerRunner<*>.handleChooseMale() {
    writeKpi(users.current, "User Chose Male" )
    send(OptionSelectedEvent("male"))
    goto(PersonalizationApplyMale)
}

private fun TriggerRunner<*>.handleChooseOriginal(){
    send(OptionSelectedEvent("neutral"))
    writeKpi(users.current, "User Chose Ori")
    furhat.setRobotVoice(currentLang,Gender.NEUTRAL)
    delay(500, TimeUnit.MILLISECONDS)
    goto(PersonalizationApplyOriginal)
}

private fun TriggerRunner<*>.handleChooseFemale() {
    writeKpi(users.current, "User Chose female")
    send(OptionSelectedEvent("female"))
    goto(PersonalizationApplyFemale)
}

private fun TriggerRunner<*>.handleToRememberPersonalization(){
    writeKpi(users.current, "User Chose Remember Personalization" )
    goto(PersonalizationRemember)
}

private fun TriggerRunner<*>.handleMoveToEPDS(){
    goto(EPDSStartQuestion)
}
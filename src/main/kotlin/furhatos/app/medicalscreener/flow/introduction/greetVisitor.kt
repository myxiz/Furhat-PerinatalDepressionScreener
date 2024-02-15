package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.name
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.EnglishDontUnderstandLanguage
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.util.Language

//val BaseState = state(Interaction, stateDefinition = abortableStateDef(Goodbye, null))

val GreetTuringOn : State = state(Interaction){
    addGazeAversionBehaviour()

    onEntry {
        send(ClearScreen())
        log.debug("In GreetTuringOn state")
        furhat.say(i18n.phrases.INTRODUCTION_GREETING_ON)
        send(ShowOptionsEvent(allButCurrentLang()+ "start: ${i18n.phrases.GENERAL_START}"))
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        if (response == "start"){
            goto(GreetVisitor)
        }
        else{handleLanguageChange(language = response)}

    }

    onButton ("Start"){
        users.current.interactionInfo.startTimestamp()
        writeKpi(users.current, "Interaction Started")
        goto(GreetVisitor)
    }
}


val GreetVisitor: State = state(IntroductionBaseState) {
    addGazeAversionBehaviour()
    onEntry {
        send(ClearScreen())
        furhat.askAndDo(i18n.phrases.INTRODUCTION_GREETING + name!!){

            furhat.gesture(Gestures.BigSmile)
            log.debug("In GreetVisitor state")
            send(ShowOptionsEvent(allButCurrentLang()))
            furhat.listen(300)
        }
    }

    onResponse<EnglishDontUnderstandLanguage> {
        handleLanguageChange(language = "en")
    }

    onResponse {
        furhat.gesture(Gestures.Smile)
        goto(ScreeningSelection)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        handleLanguageChange(language = response)
    }

    onNoResponse {
        goto(ScreeningSelection)
    }

    include(ChangeLanguageBehavior)
    addRepeatQuestionHandler()
    addGoodbyeHandler()
    addTellAboutStatesHandlers()
    addGazeAversionBehaviour()
    include(NoOrInvalidResponseState())
}

fun allButCurrentLang(): List<String> {
    val list = mutableListOf<String>()
    if (currentLang != Language.ENGLISH_US) list.add("en: ${i18n.phrases.CHANGE_TO_LANGUAGE_EN}")
    if (currentLang != Language.SWEDISH) list.add("sv: ${i18n.phrases.CHANGE_TO_LANGUAGE_SV}")
    if (currentLang != Language.MANDARIN) list.add("zh: ${i18n.phrases.CHANGE_TO_LANGUAGE_ZH}")
    return list
}

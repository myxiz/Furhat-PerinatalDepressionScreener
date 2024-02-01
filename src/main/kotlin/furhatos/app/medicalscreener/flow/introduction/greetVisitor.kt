package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.EnglishDontUnderstandLanguage
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.util.Language


val GreetVisitor: State = state(IntroductionBaseState) {
    onEntry {
        send(ClearScreen())
        log.debug("In GreetVisitor state")
        send(ShowOptionsEvent(allButCurrentLang()))
        users.current.interactionInfo.startTimestamp()
        writeKpi(users.current, "Interaction Started")
//        send(ShowFacesEvent("show"))
//        send(ShowOptionsEvent(allButCurrentLang()))

//        send(ShowOptionsEvent(listOf("male:${i18n.phrases.GENERAL_MALE}", "female:${i18n.phrases.GENERAL_FEMALE}")))
        furhat.say(utterance {
            +i18n.phrases.INTRODUCTION_GREETING
            +Gestures.Smile
            +i18n.phrases.INTRODUCTION_ROBOTINTRO
        })
        furhat.listen(timeout = 800)
    }


    onResponse<EnglishDontUnderstandLanguage> {
        handleLanguageChange(language = "en")
    }

    include(ChangeLanguageBehavior)

    addRepeatQuestionHandler()

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

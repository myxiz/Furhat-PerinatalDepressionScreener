package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.*
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.EnglishDontUnderstandLanguage
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.util.Language
import kotlinx.coroutines.*
import java.time.LocalDateTime


val GreetTuringOn : State = state(Interaction){
    addGazeAversionBehaviour()
    val myScope = CoroutineScope(Dispatchers.Default)

    onEntry {
        send(ClearScreen())

        runBlocking {
            val name = getUsername()
            println(name)
        }
        log.debug("In GreetTuringOn state")
        furhat.say(i18n.phrases.INTRODUCTION_GREETING_ON)
        send(ShowOptionsEvent(allButCurrentLang()+ "start: ${i18n.phrases.GENERAL_START}"))
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        if (response == "start"){
            users.current.interactionInfo.robotOnTime = LocalDateTime.now()
            myScope.launch {
                writeKpi(users.current, "Interaction Started")
                getUsername()
                log.info("user name: $userName")
            }
            goto(GreetVisitor)
        }
        else{handleLanguageChange(language = response)}
    }
    onButton ("Hello, Ask for consent"){
        users.current.interactionInfo.startTimestamp()
        GlobalScope.launch {
            writeKpi(users.current, "Interaction Started")
        }
        goto(GreetVisitor)
    }
}


val GreetVisitor: State = state(IntroductionBaseState) {
    addGazeAversionBehaviour()

    onEntry {
        send(ClearScreen())
        GlobalScope.launch {
            getUsername()
        }

        furhat.askAndDo(i18n.phrases.INTRODUCTION_GREETING +' '+ userName!!){

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
        goto(ScreeningConsent)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        handleLanguageChange(language = response)
    }

    onNoResponse {
        goto(ScreeningConsent)
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

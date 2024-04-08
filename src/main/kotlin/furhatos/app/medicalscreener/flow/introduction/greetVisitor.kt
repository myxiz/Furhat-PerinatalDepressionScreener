package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.*
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.EnglishDontUnderstandLanguage
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.util.Language
import kotlinx.coroutines.*



val GreetTuringOn : State = state(InteractionNoLeave){
    addGazeAversionBehaviour()
    val myScope = CoroutineScope(Dispatchers.Default)

    onEntry {
        send(ClearScreen())
        runBlocking {
            IP = test_IP(IP_ARRAY)
        }
        runBlocking {
            println(getUsername())
        }
        log.debug("In GreetTuringOn state")
        furhat.sayAndRecord(i18n.phrases.INTRODUCTION_GREETING_ON)
        send(ShowOptionsEvent(allButCurrentLang()+ "start: ${i18n.phrases.GENERAL_START}"))
    }

    onReentry {
        send(ClearScreen())
        runBlocking {
            val name = getUsername()
            println(name)
        }
        log.debug("Reentry GreetTuringOn state")
        furhat.gesture(Gestures.BigSmile)
        send(ShowOptionsEvent(allButCurrentLang()+ "start: ${i18n.phrases.GENERAL_START}"))
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        if (response == "start"){
            if (users.current.interactionInfo.startTime == null){
                users.current.interactionInfo.startTimestamp()
            }
            else{
                users.current.interactionInfo.robotOnTime
            }

            myScope.launch {
                writeApi(users.current, "Interaction Started")
                getUsername()
                log.info("user name: $userName")
            }
            goto(GreetVisitor)
        }
        else{handleLanguageChange(language = response)}
    }
    onButton ("Hello, Ask for consent"){
        users.current.interactionInfo.startTimestamp()
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current, "Interaction Started")
        }
        delay(300)
        goto(GreetVisitor)

    }
}


val GreetVisitor: State = state(IntroductionBaseState) {
    addGazeAversionBehaviour()

    onEntry {
        furhat.askAndDo(i18n.phrases.INTRODUCTION_GREETING +' '+ userName!!){
            furhat.gesture(Gestures.BigSmile)
            send(ClearScreen())
            log.debug("In GreetVisitor state")
//            send(ShowOptionsEvent(allButCurrentLang()))
            furhat.listen(100)
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

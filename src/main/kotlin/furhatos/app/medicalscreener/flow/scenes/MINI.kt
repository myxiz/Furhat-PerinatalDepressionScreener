@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.MINI.MINIQuestion_A1a
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.setRobotFace
import furhatos.app.medicalscreener.setRobotVoice
import furhatos.flow.kotlin.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


val MINIQuestionBase = state(InteractionNoLeave){
    onButton("Repeat", color = Color.Green) {
        furhat.stopSpeaking()
        reentry() }
}

val MINIInstructions = state(MINIQuestionBase) {
    onEntry {
        if (users.current.personaliztionData.remember == null || !users.current.personaliztionData.remember!!){
            furhat.setRobotVoice(lang = currentLang)
            furhat.setRobotFace()
        }
        users.current.miniData.startTimestamp()
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current,"MINI started")
        }
        furhat.sayAndRecord(i18n.phrases.MINIInterviewIntroduction)
        delay(300)
    }

    onButton("Start") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A1a)
    }
}



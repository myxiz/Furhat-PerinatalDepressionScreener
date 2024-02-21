@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.scenes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.Goodbye
import furhatos.app.medicalscreener.flow.introduction.ScreeningSelection
import furhatos.app.medicalscreener.flow.scenes.EPDS.*
import furhatos.app.medicalscreener.flow.scenes.MINI.MINIQuestion_A1a
import furhatos.app.medicalscreener.flow.scenes.MINI.MINIQuestion_A2a
import furhatos.app.medicalscreener.flow.scenes.MINI.MINIQuestion_A3a
import furhatos.app.medicalscreener.flow.scenes.MINI.MINIQuestion_A3b
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils


val MINIQuestionBase = state(InteractionNoLeave,
    stateDefinition = abortableStateDef(Goodbye, { it.miniData.endTimestamp() }))

val MINIInstructions = state(MINIQuestionBase) {
    onEntry {
        furhat.say(i18n.phrases.MINIInterviewIntroduction)
        delay(800)
    }

    onButton("Repeat", color = Color.Green) {
        onButton("Repeated", color = Color.Red) {  }
        furhat.stopSpeaking()
        reentry() }
    onButton("Start") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A1a)
    }

}

private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!



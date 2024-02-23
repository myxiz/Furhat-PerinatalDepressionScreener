package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase


val MINIQuestionC = state(MINIQuestionBase) {

    // Transition to MINIQuestion_C1a state
    onButton("MINI C1a") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C1a)
    }

// Transition to MINIQuestion_C1b state
    onButton("MINI C1b") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C1b)
    }

// Transition to MINIQuestion_C2a state
    onButton("MINI C2a") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C2a)
    }

// Transition to MINIQuestion_C2b state
    onButton("MINI C2b") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C2b)
    }

// Transition to MINIQuestion_C3 Intro state
    onButton("MINI C3 Intro") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3_Intro)
    }

// Transition to MINIQuestion_C3a state
    onButton("MINI C3a") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3a)
    }

// Transition to MINIQuestion_C3b state
    onButton("MINI C3b") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3b)
    }

// Transition to MINIQuestion_C3c state
    onButton("MINI C3c") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3c)
    }

// Transition to MINIQuestion_C3d state
    onButton("MINI C3d") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3d)
    }

// Transition to MINIQuestion_C3e state
    onButton("MINI C3e") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3e)
    }

// Transition to MINIQuestion_C3f state
    onButton("MINI C3f") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3f)
    }

// Transition to MINIQuestion_C3g state
    onButton("MINI C3g") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C3g)
    }

    onButton("Previous Question") {
        goto(lastState)
    }

    onButton("Next Question", color = Color.Yellow) {
        furhat.stopSpeaking()
        delay(10)
        handleNext()
    }

}

// Hypothetical implementation for MINI B intro or bridge state
val MINIQuestion_C_Intro: State = state(MINIQuestionBase) {
    onEntry {
        furhat.say(i18n.phrases.MINI_MOVE_TO_NEXT_SECTION)
        delay(10)
        goto(MINIQuestion_C1a)
    }
}

// Assuming the setup for phrases and navigation is similar to previous examples


val MINIQuestion_C1a: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C1a_QUESTION)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C1b
        handleRecordScore("yes", "C1a")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C2a
        handleRecordScore("no", "C1a")
    }
}

val MINIQuestion_C1b: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C1b_QUESTION)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C2a // Assuming you want to continue to C2 regardless of answer
        handleRecordScore("yes", "C1b")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C2a
        handleRecordScore("no", "C1b")
    }
    onButton("Next"){
        handleNext()
    }
}
val MINIQuestion_C2a: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C2a_QUESTION)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C2b
        handleRecordScore("yes", "C2a")
    }
    onButton(noButton) {
        nextState = if (users.current.miniData.C1b == 0){
            MINIQuestionFinished
        } else{
            MINIQuestion_C3_Intro
        }
        handleRecordScore("no", "C2a")
    }
    onButton("Next"){
        handleNext()
    }
}

val MINIQuestion_C2b: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C2b_QUESTION)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C3_Intro // Change to the appropriate next state
        handleRecordScore("yes", "C2b")
    }
    onButton(noButton) {
        nextState = if (users.current.miniData.C1b == 0){
            MINIQuestionFinished
        } else{
            MINIQuestion_C3_Intro
        }
        handleRecordScore("no", "C2b")
    }
    onButton("Next"){
        handleNext()
    }
}


val MINIQuestion_C3_Intro: State = state(MINIQuestionC) {
    nextState = MINIQuestion_C3a // You need to define this function based on your flow
    currentQuestions = "C3"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3_INTRO)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3_INTRO
        ))
    }
}

val MINIQuestion_C3a: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3a_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3a_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        handleRecordScore("yes", "C3a")
        nextState = MINIQuestion_C3b
        furhat.say(i18n.phrases.MINI_ASK_FOR_EXAMPLES)
        onButton ("Delusion yes") {
            handleRecordScore("yes", "C3a_delu")
        }
        onButton("Delusion No") {
            handleRecordScore("no", "C3a_delu")
        }

    }
    onButton(noButton) {
        nextState = MINIQuestion_C3b
        handleRecordScore("no", "C3a")
    }
}

val MINIQuestion_C3b: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3b_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3b_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C3c
        handleRecordScore("yes", "C3b")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C3c
        handleRecordScore("no", "C3b")
    }
}

val MINIQuestion_C3c: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3c_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3c_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C3d
        handleRecordScore("yes", "C3c")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C3d
        handleRecordScore("no", "C3c")
    }
}

val MINIQuestion_C3d: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3d_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3d_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C3e
        handleRecordScore("yes", "C3d")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C3e
        handleRecordScore("no", "C3d")
    }
}

val MINIQuestion_C3e: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3e_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3e_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C3f
        handleRecordScore("yes", "C3e")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C3f
        handleRecordScore("no", "C3e")
    }
}

val MINIQuestion_C3f: State = state(MINIQuestionC) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3f_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3f_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C3g
        handleRecordScore("yes", "C3f")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C3g
        handleRecordScore("no", "C3f")
    }
}

val MINIQuestion_C3g: State = state(MINIQuestionC) {
    nextState = MINIQuestionFinished
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C3g_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_C3g_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        // Set next state or handle continue based on your flow
        handleRecordScore("yes", "C3g")
    }
    onButton(noButton) {
        // Set next state or handle continue based on your flow
        handleRecordScore("no", "C3g")
    }
}


package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase



//var inquireOngoingEpisode : Boolean? = null
//var inquireMostDifficultPastEpisodeOnly : Boolean? = null

val MINIQuestionCButtons = state(MINIQuestionBase) {
    onButton("Repeat Question",color = Color.Green) {
        furhat.stopSpeaking()
        reentry()
    }
    onButton("Next Question", color = Color.Yellow) {
        furhat.stopSpeaking()
        goto(nextState)
    }

    onButton("Last Question") {
        goto(lastState)
    }

    // Transition to MINIQuestion_C1a state
    onButton("MINI C1a") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C1a)
    }

// Transition to MINIQuestion_C1b state
    onButton("MINI C1b") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C1b)
    }

// Transition to MINIQuestion_C2a state
    onButton("MINI C2a") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C2a)
    }

// Transition to MINIQuestion_C2b state
    onButton("MINI C2b") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C2b)
    }

// Transition to MINIQuestion_C3 Intro state
    onButton("MINI C3 Intro") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3_Intro)
    }

// Transition to MINIQuestion_C3a state
    onButton("MINI C3a") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3a)
    }

// Transition to MINIQuestion_C3b state
    onButton("MINI C3b") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3b)
    }

// Transition to MINIQuestion_C3c state
    onButton("MINI C3c") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3c)
    }

// Transition to MINIQuestion_C3d state
    onButton("MINI C3d") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3d)
    }

// Transition to MINIQuestion_C3e state
    onButton("MINI C3e") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3e)
    }

// Transition to MINIQuestion_C3f state
    onButton("MINI C3f") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3f)
    }

// Transition to MINIQuestion_C3g state
    onButton("MINI C3g") {
        furhat.stopSpeaking()
        goto(MINIQuestion_C3g)
    }

}

// Hypothetical implementation for MINI B intro or bridge state
val MINIQuestion_C_Intro: State = state(MINIQuestionBase) {
    onEntry {
        furhat.say(i18n.phrases.MINI_MOVE_TO_NEXT_SECTION)
        delay(800)
        goto(MINIQuestion_C1a)
    }
}

// Assuming the setup for phrases and navigation is similar to previous examples


val MINIQuestion_C1a: State = state(MINIQuestionCButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C1a_QUESTION)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_C1b
        handleContinue("yes", "C1a")
    }
    onButton("No") {
        nextState = MINIQuestion_C2a
        handleContinue("no", "C1a")
    }
}

val MINIQuestion_C1b: State = state(MINIQuestionCButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C1b_QUESTION)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_C2a // Assuming you want to continue to C2 regardless of answer
        handleContinue("yes", "C1b")
    }
    onButton("No") {
        nextState = MINIQuestion_C2a
        handleContinue("no", "C1b")
    }
}
val MINIQuestion_C2a: State = state(MINIQuestionCButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C2a_QUESTION)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_C2b
        handleContinue("yes", "C2a")
    }
    onButton("No") {
        nextState = MINIQuestion_C3_Intro // Change to the appropriate next state
        handleContinue("no", "C2a")
    }
}

val MINIQuestion_C2b: State = state(MINIQuestionCButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_C2b_QUESTION)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_C3_Intro // Change to the appropriate next state
        handleContinue("yes", "C2b")
    }
    onButton("No") {
        //TODO logic to stop or into C3
        nextState = MINIQuestion_C3_Intro // Change to the appropriate next state
        handleContinue("no", "C2b")
    }
}


val MINIQuestion_C3_Intro: State = state(MINIQuestionCButtons) {
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

    onExit { lastState = currentState }

    onButton("Yes") {
        handleContinue("yes", "C3")
    }
    onButton("No") {
        handleContinue("no", "C3")
    }
}

val MINIQuestion_C3a: State = state(MINIQuestionCButtons) {
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
    onButton("Yes") {
        nextState = MINIQuestion_C3b
        handleContinue("yes", "C3a")
    }
    onButton("No") {
        nextState = MINIQuestion_C3b
        handleContinue("no", "C3a")
    }
}

val MINIQuestion_C3b: State = state(MINIQuestionCButtons) {
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
    onButton("Yes") {
        nextState = MINIQuestion_C3c
        handleContinue("yes", "C3b")
    }
    onButton("No") {
        nextState = MINIQuestion_C3c
        handleContinue("no", "C3b")
    }
}

val MINIQuestion_C3c: State = state(MINIQuestionCButtons) {
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
    onButton("Yes") {
        nextState = MINIQuestion_C3d
        handleContinue("yes", "C3c")
    }
    onButton("No") {
        nextState = MINIQuestion_C3d
        handleContinue("no", "C3c")
    }
}

val MINIQuestion_C3d: State = state(MINIQuestionCButtons) {
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
    onButton("Yes") {
        nextState = MINIQuestion_C3e
        handleContinue("yes", "C3d")
    }
    onButton("No") {
        nextState = MINIQuestion_C3e
        handleContinue("no", "C3d")
    }
}

val MINIQuestion_C3e: State = state(MINIQuestionCButtons) {
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
    onButton("Yes") {
        nextState = MINIQuestion_C3f
        handleContinue("yes", "C3e")
    }
    onButton("No") {
        nextState = MINIQuestion_C3f
        handleContinue("no", "C3e")
    }
}

val MINIQuestion_C3f: State = state(MINIQuestionCButtons) {
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
    onButton("Yes") {
        nextState = MINIQuestion_C3g
        handleContinue("yes", "C3f")
    }
    onButton("No") {
        nextState = MINIQuestion_C3g
        handleContinue("no", "C3f")
    }
}

val MINIQuestion_C3g: State = state(MINIQuestionCButtons) {
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
    onButton("Yes") {
        // Set next state or handle continue based on your flow
        handleContinue("yes", "C3g")
    }
    onButton("No") {
        // Set next state or handle continue based on your flow
        handleContinue("no", "C3g")
    }
}


// Repeat the pattern for the remaining sub-questions C3d to C3g

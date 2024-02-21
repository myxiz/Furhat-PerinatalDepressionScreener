package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase


//var inquireOngoingEpisode : Boolean? = null
//var inquireMostDifficultPastEpisodeOnly : Boolean? = null



val MINIQuestionBButtons = state(MINIQuestionBase) {
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




    // Transition to MINIQuestion_B1 state
    onButton("MINI B1") {
        furhat.stopSpeaking()
        goto(MINIQuestion_B1)
    }

// Transition to MINIQuestion_B1a state
    onButton("MINI B1a") {
        furhat.stopSpeaking()
        goto(MINIQuestion_B1a)
    }

// Transition to MINIQuestion_B1b state
    onButton("MINI B1b") {
        furhat.stopSpeaking()
        goto(MINIQuestion_B1b)
    }

// Transition to MINIQuestion_B2 state
    onButton("MINI B2") {
        furhat.stopSpeaking()
        goto(MINIQuestion_B2)
    }

// Transition to MINIQuestion_B3 state
    onButton("MINI B3") {
        furhat.stopSpeaking()
        goto(MINIQuestion_B3)
    }

// Transition to MINIQuestion_B4 state
    onButton("MINI B4") {
        furhat.stopSpeaking()
        goto(MINIQuestion_B4)
    }

// Transition to MINIQuestion_B5 state
    onButton("MINI B5") {
        furhat.stopSpeaking()
        goto(MINIQuestion_B5)
    }

}
val MINIQuestion_B_Intro: State = state(MINIQuestionBase) {
    onEntry {
        furhat.say(i18n.phrases.MINI_MOVE_TO_NEXT_SECTION)
        delay(400)
        goto(MINIQuestion_B1)
    }
}

// Assuming the setup for phrases and navigation is similar to previous examples

val MINIQuestion_B1: State = state(MINIQuestionBButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_B1_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_B1_QUESTION
        ))
    }

    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_B1a
        handleContinue("yes", "B1")
    }
    onButton("No") {
        nextState = MINIQuestion_B2
        handleContinue("no", "B1")
    }
}

val MINIQuestion_B1a: State = state(MINIQuestionBButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_B1a_QUESTION)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_B1b
        handleContinue("yes", "B1a")
    }
    onButton("No") {
        nextState = MINIQuestion_B2
        handleContinue("no", "B1a")
    }
}

val MINIQuestion_B1b: State = state(MINIQuestionBButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_B1b_QUESTION)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_B2 // Assuming you want to continue to B2 regardless of answer
        handleContinue("yes", "B1b")
    }
    onButton("No") {
        nextState = MINIQuestion_B2
        handleContinue("no", "B1b")
    }
}

val MINIQuestion_B2: State = state(MINIQuestionBButtons) {
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_B2_QUESTION)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_B3
        handleContinue("yes", "B2")
    }
    onButton("No") {
        nextState = MINIQuestion_B3 // Implement this logic based on your flow
        handleContinue("no", "B2")
    }
}


val MINIQuestion_B3: State = state(MINIQuestionBButtons) {
    nextState = MINIQuestion_B4 // You need to define this function based on your flow
    currentQuestions = "B3"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_B3_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_B3_QUESTION
        ))
    }

    onExit { lastState = currentState }

    onButton("Yes") {
        handleContinue("yes", "B3")
    }
    onButton("No") {
        handleContinue("no", "B3")
    }
}

val MINIQuestion_B4: State = state(MINIQuestionBButtons) {
    nextState = MINIQuestion_B5 // Adjust as necessary for your interview flow
    currentQuestions = "B4"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_B4_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_B4_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes", "B4") }
    onButton("No") { handleContinue("no", "B4") }
}

val MINIQuestion_B5: State = state(MINIQuestionBButtons) {
    nextState = MINIQuestion_C_Intro // Define this function based on your flow to decide the next state
    currentQuestions = "B5"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_B5_QUESTION)
        send(ShowOptionsEvent(
            listOf(
                "0:${i18n.phrases.GENERAL_NO}",
                "1:${i18n.phrases.GENERAL_YES}"
            ),
            i18n.phrases.MINIQuestion_B5_QUESTION
        ))
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes", "B5") }
    onButton("No") { handleContinue("no", "B5") }
}




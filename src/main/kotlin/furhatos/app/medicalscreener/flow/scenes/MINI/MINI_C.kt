package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.*
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.GreetVisitor
import furhatos.app.medicalscreener.flow.scenes.EPDSStartQuestion
import furhatos.app.medicalscreener.flow.scenes.MINIInstructions
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase
import furhatos.gestures.Gestures
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val DelusionButtons = partialState {
    onButton ("Delusion yes") {
        handleRecordScore("yes", "C3a_delu")
    }
    onButton("Delusion No") {
        handleRecordScore("no", "C3a_delu")
    }
}

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
        goto(MINIQuestion_C2a_1)
    }

// Transition to MINIQuestion_C2b state
    onButton("MINI C2b") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_C2b)
    }

//// Transition to MINIQuestion_C3 Intro state
//    onButton("MINI C3 Intro") {
//        furhat.stopSpeaking()
//        delay(10)
//        goto(MINIQuestion_C3_Intro)
//    }

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
        furhat.sayAndRecord(i18n.phrases.MINI_MOVE_TO_NEXT_SECTION)
        delay(10)
        goto(MINIQuestion_C1a)
    }
}

// Assuming the setup for phrases and navigation is similar to previous examples


val MINIQuestion_C1a: State = state(MINIQuestionC) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C1a_QUESTION)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C1b
        handleRecordScore("yes", "C1a")
    }
    onButton(noButton) {
        nextState = MINIQuestion_C2a_1
        handleRecordScore("no", "C1a")
    }
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_C1b: State = state(MINIQuestionC) {
    nextState = MINIQuestion_C2a_1
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C1b_QUESTION)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        handleRecordScore("yes", "C1b")
    }
    onButton(noButton) {
        handleRecordScore("no", "C1b")
    }
    onButton("Next"){
        handleNext()
    }
}
val MINIQuestion_C2a_1: State = state(MINIQuestionC) {
    nextState = MINIQuestion_C2a_2
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C2a_QUESTION_1)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        handleRecordScore("yes", "C2a")
    }
    onButton(noButton) {
        handleRecordScore("no", "C2a")
    }
    onButton("Next"){
        handleNext()
    }
}

val MINIQuestion_C2a_2: State = state(MINIQuestionC) {
    onEntry {
        if (users.current.miniData.C2a == 1){
            nextState = MINIQuestion_C2b
        }
        else{
            nextState = if (users.current.miniData.C1b == 0){
                MINIQuestionFinished
            } else{
                MINIQuestion_C3a
            }
        }
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C2a_QUESTION_2)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C2b
        handleRecordScore("yes", "C2a")
    }
    onButton(noButton) {
        //doesn't change the status
    }
    onButton("Next"){
        handleNext()
    }
}

val MINIQuestion_C2b: State = state(MINIQuestionC) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C2b_QUESTION)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_C3a // Change to the appropriate next state
        handleRecordScore("yes", "C2b")
    }
    onButton(noButton) {
        nextState = if (users.current.miniData.C1b == 0){
            MINIQuestionFinished
        } else{
            MINIQuestion_C3a
        }
        handleRecordScore("no", "C2b")
    }
    onButton("Next"){
        handleNext()
    }
}

//
//val MINIQuestion_C3_Intro: State = state(MINIQuestionC) {
//    nextState = MINIQuestion_C3a // You need to define this function based on your flow
//    onEntry {
//        furhat.speak(i18n.phrases.MINIQuestion_C3_INTRO)
//        send(ShowOptionsEvent(
//            listOf(
//                "0:${i18n.phrases.GENERAL_NO}",
//                "1:${i18n.phrases.GENERAL_YES}"
//            ),
//            i18n.phrases.MINIQuestion_C3_INTRO
//        ))
//    }
//}


val MINIQuestion_C3a: State = state(MINIQuestionC) {
    onEntry {
        nextState = MINIQuestion_C3b
        currentQuestions = "C3a"
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C3_INTRO + i18n.phrases.MINIQuestion_C3a_QUESTION)
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
//        furhat.sayAndRecord(i18n.phrases.MINI_ASK_FOR_EXAMPLES)
    }
    var showDelusionButtons = 0
    onButton("Ask Example") {
        if  (showDelusionButtons==0){
            include(DelusionButtons)
            showDelusionButtons = 1
        }
        furhat.sayAndRecord(i18n.phrases.MINI_ASK_FOR_EXAMPLES)
    }



    onButton(noButton) {
        handleRecordScore("no", "C3a")
    }
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_C3b: State = state(MINIQuestionC) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C3b_QUESTION)
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
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_C3c: State = state(MINIQuestionC) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C3c_QUESTION)
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
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_C3d: State = state(MINIQuestionC) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C3d_QUESTION)
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
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_C3e: State = state(MINIQuestionC) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C3e_QUESTION)
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
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_C3f: State = state(MINIQuestionC) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C3f_QUESTION)
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
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_C3g: State = state(MINIQuestionC) {
    nextState = MINIQuestionFinished
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_C3g_QUESTION)
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
        handleRecordScore("yes", "C3g")
    }
    onButton(noButton) {
        handleRecordScore("no", "C3g")
    }
    onButton("Next") {
        handleNext()
    }
}


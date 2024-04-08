package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.log
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures.Nod
import java.lang.IllegalArgumentException
import furhatos.app.medicalscreener.flow.miniData
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase
import furhatos.records.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


var nextState = MINIQuestionBase
var lastState = MINIQuestionBase

var currentQuestions = ""

val MINIQuestionA = state(MINIQuestionBase) {

    onButton("MINI A1") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A1a)
    }

    onButton("MINI A2") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A2a)
    }

// Add similar handlers for other options such as MINI A3, MINI A4, etc.

    onButton("MINI A3a") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A3a)
    }

    onButton("MINI A3b") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A3b)
    }

    onButton("MINI A3c") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A3c)
    }

    onButton("MINI A3d") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A3d)
    }

    onButton("MINI A3e") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A3e)
    }

    onButton("MINI A3f") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A3f)
    }

    onButton("MINI A3g") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A3g)
    }

    onButton("MINI A4") {
        furhat.stopSpeaking()
        delay(10)
        goto(MINIQuestion_A4)
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

val MINIQuestion_A1a: State = state(MINIQuestionA) {
    currentQuestions = "A1a"
//    lastState = MINIQuestion_A1a
    onEntry {
//        users.current.miniData.set(currentState.name,1)
        users.current.miniData.score = 0
        log.debug("minidata: " + users.current.miniData)
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A1a_QUESTION)
        delay(10)
        send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.GENERAL_NO}",
                    "1:${i18n.phrases.GENERAL_YES}"
                ),
                i18n.phrases.MINIQuestion_A1a_PROMPT
            ))
    }
    onExit {  lastState = currentState }
    onButton(yesButton) {
        nextState = MINIQuestion_A1b
        handleRecordScore( "yes")
    }
    onButton(noButton) {
        nextState = MINIQuestion_A2a
        handleRecordScore( "no")
        log.debug("minidata: " + users.current.miniData)
    }
    onButton("Next") {
        handleNext()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        nextState = when (response) {
            "yes" -> { MINIQuestion_A1b }
            "no"  -> { MINIQuestion_A2a }
            else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
        }
        handleRecordScore( response, currentQuestions)
    }
}

// Example state for Question A1b
val MINIQuestion_A1b: State = state(MINIQuestionA) {
    nextState = MINIQuestion_A2a
    currentQuestions = "A1b"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A1b_QUESTION)
        delay(10)
        send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.GENERAL_NO}",
                    "1:${i18n.phrases.GENERAL_YES}"
                ),
                i18n.phrases.MINIQuestion_A1b_PROMPT
            ))
    }

    onExit {
        lastState = currentState
    }
    onButton(yesButton) {
        handleRecordScore( "yes")
    }
    onButton(noButton) {
        handleRecordScore( "no")
        log.debug("minidata: " + users.current.miniData)
    }
    onButton("Next") {
        handleNext()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        handleRecordScore( response)
    }
}

// Example state for Question A2a
val MINIQuestion_A2a: State = state(MINIQuestionA) {
    currentQuestions = "A2a"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A2a_QUESTION)
        delay(10)
        send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.GENERAL_NO}",
                    "1:${i18n.phrases.GENERAL_YES}"
                ),
                i18n.phrases.MINIQuestion_A2a_PROMPT
            ))

    }

    onExit {
        lastState = currentState
    }

    onButton(yesButton) {
        nextState = MINIQuestion_A2b
        handleRecordScore( "yes")
    }


    onButton(noButton) {
        nextState = if (checkA1aOrA2aResponse(users.current) ){
            MINIQuestion_Bridge_A3
        } else{
            MINIQuestion_B_Intro
        }
        handleRecordScore( "no")
        log.debug("minidata: " + users.current.miniData)
    }

    onButton("Next") {
        handleNext()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        nextState = when (response) {
            "yes" -> {
                MINIQuestion_A1b
            }
            "no" -> {
                if (checkA1aOrA2aResponse(users.current) ){
                    MINIQuestion_Bridge_A3
                } else{
                    MINIQuestion_B_Intro
                }
            }
            else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
        }
        handleRecordScore( response)
    }
}

// Example state for Question A2b
val MINIQuestion_A2b: State = state(MINIQuestionA) {
    currentQuestions = "A2b"
    nextState = MINIQuestion_Bridge_A3
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A2b_QUESTION)
        delay(10)
        send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.GENERAL_NO}",
                    "1:${i18n.phrases.GENERAL_YES}"
                ),
                i18n.phrases.MINIQuestion_A2b_PROMPT
            ))
    }

    onExit {
        lastState = currentState
    }

    onButton(yesButton) {
        handleRecordScore( "yes")
    }
    onButton(noButton) {
        nextState = if (checkA1aOrA2aResponse(users.current) ){
            MINIQuestion_Bridge_A3
        } else{
            MINIQuestion_B_Intro
        }
        handleRecordScore( "no")
        log.debug("minidata: " + users.current.miniData)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        nextState = when (response) {
            "yes" -> {
                MINIQuestion_A1b
            }

            "no" -> {
                if (checkA1aOrA2aResponse(users.current) ){
                    MINIQuestion_Bridge_A3
                } else{
                    MINIQuestion_B_Intro
                }
            }

            else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
        }
        handleRecordScore( response)
    }
    onButton("Next"){
        handleNext()
    }
}
fun checkA1aOrA2aResponse(user: User): Boolean {
    // Check if either A1a or A2a has been coded as 'Yes'
    return user.miniData.A1a == 1 || user.miniData.A2a == 1
}

fun inquireEpisodes(user: User): String? {
    val a1bResponse = user.miniData.A1b
    val a2bResponse = user.miniData.A2b

    when {
        // OM A1b ELLER A2b = JA
        a1bResponse == 1 || a2bResponse == 1 -> {
//            inquireOngoingEpisode = true
            return i18n.phrases.MINITwoWeeksPeriodStatement
        }
        // OM A1b OCH A2b = NEJ STOP
        a1bResponse == 0 && a2bResponse == 0 -> {
//            inquireMostDifficultPastEpisodeOnly = true
            return null
        }
        else -> {
            log.error("A1b and A2b response error, A1b:  $a1bResponse, A2b: $a2bResponse")
        }
    }
    return null
}

var INQUIRE_EPISODES : String? = null

// Example state for Question A3


val yesButton = Button("Yes", key = "A3_yes_button", color = Color.Red )
val noButton = Button("No", key = "A3_no_button", color = Color.Green)

val MINIQuestion_Bridge_A3: State = state(MINIQuestionA) {
    onEntry {
        INQUIRE_EPISODES = inquireEpisodes(user = users.current)
        if (INQUIRE_EPISODES!= null){
            furhat.sayAndRecord(INQUIRE_EPISODES!!)
            delay(10)
            send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.GENERAL_NO}",
                    "1:${i18n.phrases.GENERAL_YES}"
                ),
                INQUIRE_EPISODES
            ))
            goto(MINIQuestion_A3a)
        }
        else {
            goto(MINIQuestion_B_Intro)
        }
    }
}

val MINIQuestion_A3a: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A3a_2
    currentQuestions = "A3a"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3a_QUESTION_1)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
        handleRecordScore("no")
    }
    onButton("Next") {
        handleNext()
    }
}


val MINIQuestion_A3a_2: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A3b
    currentQuestions = "A3a"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3a_QUESTION_2)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
    }
    onButton("Next") {
        handleNext()
    }
}

val MINIQuestion_A3b: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A3c
    currentQuestions = "A3b"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3b_QUESTION)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
        handleRecordScore("no")
    }
    onButton("Next") {handleNext()  }
}

val MINIQuestion_A3c: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A3d
    currentQuestions = "A3b"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3c_QUESTION)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton) {
        handleRecordScore("yes")
        onButton("(abandon) Ask Examples") {
            furhat.sayAndRecord(i18n.phrases.MINI_ASK_FOR_EXAMPLES)
            delay(10)
        }
        onButton("Delution yes") { handleRecordScore("yes", "A3c_delu") }

    }
    onButton(noButton) { handleRecordScore("no") }
    onButton("Next") {
        furhat.gesture(Nod, priority = 10)
        goto(nextState)}
}


val MINIQuestion_A3d: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A3e
    currentQuestions = "A3d"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3d_QUESTION)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
        handleRecordScore("no")
    }
    onButton("Next") {handleNext()  }
}

val MINIQuestion_A3e: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A3f
    currentQuestions = "A3e"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3e_QUESTION)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
        handleRecordScore("no")
    }
    onButton("Next") {handleNext()  }
}

val MINIQuestion_A3f: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A3g
    currentQuestions = "A3f"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3f_QUESTION)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
        handleRecordScore("no")
    }
    onButton("Next") {handleNext()  }
}

val MINIQuestion_A3g: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_A4 // Assuming A4 is the next question, adjust as needed
    currentQuestions = "A3g"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A3g_QUESTION)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
        handleRecordScore("no")
    }
    onButton("Next") {handleNext()  }
}

val MINIQuestion_A4: State = state(MINIQuestion_Bridge_A3) {
    nextState = MINIQuestion_B_Intro // This needs to be defined based on your interview flow
    currentQuestions = "A4"
    onEntry {
        furhat.sayAndRecord(i18n.phrases.MINIQuestion_A4_QUESTION)
        delay(10)
    }
    onExit { lastState = currentState }
    onButton(yesButton ) {
        handleRecordScore("yes")
    }
    onButton(noButton ) {
        handleRecordScore("no")
    }
    onButton("Next") {handleNext()  }
}


fun TriggerRunner<*>.handleRecordScore(choice: String?, key: String = currentQuestions ) {
    when (choice) {
        "yes" -> users.current.setMiniScore(key, 1)
        "no" -> users.current.setMiniScore(key, 0)
        else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
    }
    CoroutineScope(Dispatchers.Default).launch{
        writeApi(users.current, "MINI $key Recorded ")
    }
    log.debug("minidata: ${users.current.miniData}")
//    goto(nextState)
}

fun TriggerRunner<*>.handleNext() {
    furhat.gesture(Nod, async = true)
    delay(1500)
    goto(nextState)
}


package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.log
import furhatos.flow.kotlin.*
import java.lang.IllegalArgumentException
import furhatos.app.medicalscreener.flow.miniData
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase
import furhatos.records.User


var nextState = MINIQuestionBase
var lastState = MINIQuestionBase

var currentQuestions = ""
//var inquireOngoingEpisode : Boolean? = null
//var inquireMostDifficultPastEpisodeOnly : Boolean? = null



val MINIQuestionAButtons = state(MINIQuestionBase) {
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

    onButton("MINI A1") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A1a)
    }

    onButton("MINI A2") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A2a)
    }

// Add similar handlers for other options such as MINI A3, MINI A4, etc.


    onButton("MINI A3a") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A3a)
    }

    onButton("MINI A3b") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A3b)
    }

    onButton("MINI A3c") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A3c)
    }

    onButton("MINI A3d") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A3d)
    }

    onButton("MINI A3e") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A3e)
    }

    onButton("MINI A3f") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A3f)
    }

    onButton("MINI A3g") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A3g)
    }

    onButton("MINI A4") {
        furhat.stopSpeaking()
        goto(MINIQuestion_A4)
    }

}

val MINIQuestion_A1a: State = state(MINIQuestionAButtons) {
    currentQuestions = "A1a"
//    lastState = MINIQuestion_A1a
    onEntry {
//        users.current.miniData.set(currentState.name,1)
        users.current.miniData.score = 0
        log.debug("minidata: " + users.current.miniData)
        furhat.say(i18n.phrases.MINIQuestion_A1a_QUESTION)
        delay(800)
        send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.GENERAL_NO}",
                    "1:${i18n.phrases.GENERAL_YES}"
                ),
                i18n.phrases.MINIQuestion_A1a_PROMPT
            ))
    }
    onExit {  lastState = currentState }
    onButton("Yes") {
        nextState = MINIQuestion_A1b
        handleContinue( "yes")
    }
    onButton("No") {
        nextState = MINIQuestion_A2a
        handleContinue( "no")
        log.debug("minidata: " + users.current.miniData)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        when (response) {
            "yes" -> {
                nextState = MINIQuestion_A1b
            }
            "no" -> {
                nextState = MINIQuestion_A2a
            }
            else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
        }
        handleContinue( response, currentQuestions, respondedFromGui = true)
    }
}

// Example state for Question A1b
val MINIQuestion_A1b: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A2a
    currentQuestions = "A1b"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A1b_QUESTION)
        delay(800)
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
    onButton("Yes") {
        handleContinue( "yes")
    }
    onButton("No") {
        handleContinue( "no")
        log.debug("minidata: " + users.current.miniData)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        handleContinue( response, respondedFromGui = true)
    }
}

// Example state for Question A2a
val MINIQuestion_A2a: State = state(MINIQuestionAButtons) {
    currentQuestions = "A2a"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A2a_QUESTION)
        delay(800)
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

    onButton("Yes") {
        nextState = MINIQuestion_A2b
        handleContinue( "yes")
    }
    onButton("No") {
        if (checkA1aOrA2aResponse(users.current) ){
            nextState = MINIQuestion_Bridge_A3
        }
        else{
            nextState = MINIQuestion_B_Intro
        }
        handleContinue( "no")
        log.debug("minidata: " + users.current.miniData)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        when (response) {
            "yes" -> {
                nextState = MINIQuestion_A1b
            }
            "no" -> {
                if (checkA1aOrA2aResponse(users.current) ){
                    nextState = MINIQuestion_Bridge_A3
                }
                else{
                    nextState = MINIQuestion_B_Intro
                }
            }
            else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
        }
        handleContinue( response,respondedFromGui = true)
    }
}

// Example state for Question A2b
val MINIQuestion_A2b: State = state(MINIQuestionAButtons) {
    currentQuestions = "A2b"
    nextState = MINIQuestion_Bridge_A3
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A2b_QUESTION)
        delay(800)
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

    onButton("Yes") {
        handleContinue( "yes")
    }
    onButton("No") {
        if (checkA1aOrA2aResponse(users.current) ){
            nextState = MINIQuestion_Bridge_A3
        }
        else{
            nextState = MINIQuestion_B_Intro
        }
        handleContinue( "no")
        log.debug("minidata: " + users.current.miniData)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        when (response) {
            "yes" -> {
                nextState = MINIQuestion_A1b
            }
            "no" -> {
                if (checkA1aOrA2aResponse(users.current) ){
                    nextState = MINIQuestion_Bridge_A3
                }
                else{
                    nextState = MINIQuestion_B_Intro
                }
            }
            else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
        }
        handleContinue( response,respondedFromGui = true)
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
val MINIQuestion_Bridge_A3: State = state(MINIQuestionAButtons) {
    onEntry {
        INQUIRE_EPISODES = inquireEpisodes(user = users.current)
        if (INQUIRE_EPISODES!= null){
            furhat.say(INQUIRE_EPISODES!!)
            delay(800)
            send(ShowOptionsEvent(
                listOf(
                    "0:${i18n.phrases.GENERAL_NO}",
                    "1:${i18n.phrases.GENERAL_YES}"
                ),
                INQUIRE_EPISODES
            ))
        }
        else {
            goto(MINIQuestion_B_Intro)
        }
    }

    onButton("continue"){
        goto(MINIQuestion_A3a)
    }
}

val MINIQuestion_A3a: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A3b
    currentQuestions = "A3a"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A3a_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes") }
    onButton("No") { handleContinue("no") }
}

val MINIQuestion_A3b: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A3c
    currentQuestions = "A3b"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A3b_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes") }
    onButton("No") { handleContinue("no") }
}

val MINIQuestion_A3c: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A3d
    currentQuestions = "A3b"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A3c_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") {
        onButton("Ask Examples") {
            furhat.say(i18n.phrases.MINI_ASK_FOR_EXAMPLES)
            delay(800)
            onButton("Delution") {users.current.miniData.A3e_Delu =1
                onButton("Recorded"){} }
            onButton("Continue") {handleContinue("yes")  }
        }
    }
    onButton("No") {
        onButton("Recorded No"){}
        handleContinue("no") }
}

val MINIQuestion_A3d: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A3e
    currentQuestions = "A3d"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A3d_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes") }
    onButton("No") { handleContinue("no") }
}

val MINIQuestion_A3e: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A3f
    currentQuestions = "A3e"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A3e_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes") }
    onButton("No") { handleContinue("no") }
}

val MINIQuestion_A3f: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A3g
    currentQuestions = "A3f"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A3f_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes") }
    onButton("No") { handleContinue("no") }
}

val MINIQuestion_A3g: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_A4 // Assuming A4 is the next question, adjust as needed
    currentQuestions = "A3g"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A3g_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes") }
    onButton("No") { handleContinue("no") }
}

val MINIQuestion_A4: State = state(MINIQuestionAButtons) {
    nextState = MINIQuestion_B_Intro // This needs to be defined based on your interview flow
    currentQuestions = "A4"
    onEntry {
        furhat.say(i18n.phrases.MINIQuestion_A4_QUESTION)
        delay(800)
    }
    onExit { lastState = currentState }
    onButton("Yes") { handleContinue("yes") }
    onButton("No") { handleContinue("no") }
}


fun TriggerRunner<*>.handleContinue(choice: String?, key: String = currentQuestions, respondedFromGui: Boolean = false) {
    when (choice) {
        "yes" -> users.current.setMiniScore(key, 1)
        "no" -> users.current.setMiniScore(key, 0)
        else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
    }
    log.debug("minidata: ${users.current.miniData}")
//    goto(nextState)
}



@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.Abort
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.Goodbye
import furhatos.event.EventSystem.send
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.records.User
import kotlinx.coroutines.*

val goodByeTimeout = 100000

val Goodbye: State = state(Interaction) {
        onEntry {
            log.debug("In Goodbye state")
            if (users.count < 1) goto(Idle) // User leaves at the end of another state leading to this one
            users.current.interactionInfo.endTimestamp()
            endAndWriteApi(users.current)
            send(ClearScreen())
            furhat.say({
                +Gestures.BigSmile
                +i18n.phrases.INTRODUCTION_SAY_GOODBYE
                +behavior { send(ShowScreenEvent(i18n.phrases.INTRODUCTION_SAY_GOODBYE_PROMPT, i18n.phrases.INTRODUCTION_GOODBYE_TITLE_PROMPT)) }
            })

            delay(3000)
            send(ShowOptionsEvent(
                listOf("restart:${i18n.phrases.GENERAL_RESTART}"))
            )
            furhat.listen(timeout = goodByeTimeout)
        }
        include(GoodbyeShared)
    }

val GoodbyeNoSpeech: State = state(Interaction) {
        onEntry {
            log.debug("In GoodbyeNoSpeech state")
            endAndWriteApi(users.current)
            furhat.listen(timeout = goodByeTimeout)
        }

        send(ShowOptionsEvent(
            listOf("restart:${i18n.phrases.GENERAL_RESTART}"))
        )
        include(GoodbyeShared)
    }

val GoodbyeShared = partialState {
    onUserEnter {
        log.debug("User entered during goodbye-state")
        users.current = it
//        users.current.reset()
        goto(Idle)
    }

    onUserLeave {
        log.debug("User exited during goodbye-state")
//        users.current.reset()
        goto(Idle)
    }

    onResponse(listOf(Abort())) {
        furhat.sayAndRecord(i18n.phrases.GENERAL_OK_NO_PROBLEM)
        send(OptionSelectedEvent("restart"))
        delay(1000)
//        users.current.reset()
        goto(Idle)
    }

    onResponse<Goodbye> {
        furhat.gesture(Gestures.BigSmile)
        furhat.listen(timeout = goodByeTimeout)
    }

    onNoResponse {
        furhat.listen(timeout = goodByeTimeout)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?

        if (response == "restart") {
            furhatos.app.medicalscreener.log.warn("Restarting interaction")
            send(OptionSelectedEvent("restart"))
            users.current.reset()
            goto(Idle)
        }
        handleLanguageChange(language = response)
    }
}

fun endAndWriteApi(user : User) {
    user.interactionInfo.endTimestamp()
    CoroutineScope(Dispatchers.Default).launch {
        writeApi(user, "Interaction Completed")
    }
}
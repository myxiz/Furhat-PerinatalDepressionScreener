@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.No
import furhatos.app.medicalscreener.i18n.Yes
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*

val StartOver : State = state(IntroductionBaseState) {
    onEntry {
        furhat.askAndDo(i18n.phrases.INTRODUCTION_START_OVER) {
            send(ShowOptionsEvent(
                listOf("yes:${i18n.phrases.GENERAL_YES}","no:${i18n.phrases.EPDS_RESTART_TEST_OPTIONS_NO}"),
                i18n.phrases.INTRODUCTION_START_OVER_PROMPT
            ))
        }
    }
    onResponse<Yes> {
        onYes()
    }
    onResponse<No> {
        onNo()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        when (it.get("response")) {
            "yes" -> onYes()
            "no" -> onNo()
        }
    }
}

private fun TriggerRunner<*>.onNo() {
    send(OptionSelectedEvent("no"))
    furhat.say(i18n.phrases.GENERAL_OK_NO_PROBLEM)
    delay(500)
    goto(Goodbye)
}

private fun TriggerRunner<*>.onYes() {
    send(OptionSelectedEvent("yes"))
    furhat.say(i18n.phrases.INTRODUCTION_START_OVER_CONFIRMED)
    delay(1000)
    users.current.reset()
    goto(ScreeningConsent)
}
@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.*
import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.nlu.*
import furhatos.app.medicalscreener.screenerPolicy
import furhatos.app.medicalscreener.randomGesture
import furhatos.app.medicalscreener.setLindaVoice
import furhatos.autobehavior.prominenceGesture
import furhatos.autobehavior.userSpeechStartGesture
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.AzureVoice
import furhatos.flow.kotlin.voice.PollyVoice
import furhatos.gestures.Gestures
import furhatos.util.CommonUtils
import furhatos.util.Language

val log = CommonUtils.getLogger(Interaction::class.java)!!

//var petraVoice : PollyVoice = PollyVoice()
var petraVoice : AzureVoice = AzureVoice()

val Idle: State = state(Interaction) {
    init {
        parallel(abortOnExit = false) { goto(ParallelEventHandlers) }
        setup()
        if (users.count > 0) {
            furhat.attend(users.random)
            log.debug("Starting to attend a user")
            goto(GreetVisitor)
        }
    }

    onEntry {
        log.debug("Entering idle state")
        send(ClearScreen())
        if (users.count > 0) {
            log.debug("New users found")
            if (users.current.isNotEmpty) {
                furhat.attend(users.current)
            } else {
                furhat.attend(users.random)
            }
            goto(GreetVisitor)
        } else {
            furhat.attendNobody()
        }
    }

    onTime(instant = true, repeat = 4000..8000) {
        furhat.attendRandomLocation()
        delay(500)
        furhat.randomGesture()
    }

    onUserEnter {
        furhat.attend(it)
        log.debug("Starting to attend a user ${it.id}")
        goto(GreetVisitor)
    }

    onResponse {
        log.debug("user responded in idle state")
    }
}

val IntroductionBaseState = state(Interaction, stateDefinition = abortableStateDef(Goodbye, null))

val DefaultLang: Language = Language.SWEDISH

private fun FlowControlRunner.setup() : Unit {    
    log.debug("Starting debug from Idle state")
    log.info("Logging with level: " + log.level)

    currentLang = DefaultLang
    furhat.setLindaVoice(DefaultLang)
    furhat.setModel("adult", "Isabel")
    furhat.prominenceGesture = listOf(Gestures.BrowRaise, Gestures.BrowFrown, Gestures.Smile)
    furhat.userSpeechStartGesture = listOf(Gestures.BrowRaise, Gestures.Smile)
    furhat.param.endSilTimeout = DEFAULT_ENDSIL_MS
    furhat.param.noSpeechTimeout = DEFAULT_NO_SPEECH_MS
    furhat.param.maxSpeechTimeout = DEFAULT_MAX_SPEECH_MS

    val policy = screenerPolicy(userManager = users)
    users.setEngagementPolicy(policy)
}
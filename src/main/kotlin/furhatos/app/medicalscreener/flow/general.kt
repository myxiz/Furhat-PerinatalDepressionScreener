@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow
import furhatos.app.medicalscreener.*
import furhatos.app.medicalscreener.flow.introduction.*
import furhatos.app.medicalscreener.flow.scenes.EPDSStartQuestion
import furhatos.app.medicalscreener.flow.scenes.MINIInstructions
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.log
import furhatos.app.medicalscreener.nlu.*
import furhatos.event.Event
import furhatos.event.actions.ActionSetSolidLED
import furhatos.event.monitors.MonitorListenStart
import furhatos.event.monitors.MonitorSpeechEnd
import furhatos.event.monitors.MonitorSpeechStart
import furhatos.flow.kotlin.*
import furhatos.gestures.BasicParams
import furhatos.gestures.Gestures
import furhatos.gestures.defineGesture
import furhatos.app.medicalscreener.nlu.Goodbye
import furhatos.gestures.Gestures.BigSmile
import furhatos.gestures.Gestures.Nod
import furhatos.records.Location
import furhatos.records.User
import furhatos.util.Language
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit


val LedLight = ActionSetSolidLED.Builder().red(20).green(5).blue(40).buildEvent()
val LightsOff = ActionSetSolidLED.Builder().red(0).green(0).blue(0).buildEvent()

data class UserLeft(val user: User): Event()

data class UserDefinitelyGone(val user: User): Event()

val Interaction: State = state {
    onUserLeave(instant = true) {
        when {
            users.current == it -> { // user.other == it means that there is no other user
                log.debug("Current user ${it.id} left at state ${this.currentState.name}")
                parallel(waitForUserReturn(it), abortOnExit = false)
            }
            users.count < 1 -> {
                log.debug("the last user left while being unattended")
                goto(Idle)
            }
            else -> {
                log.debug("Someone who is not the user left (user ${it.id})")
                furhat.glance(it)
            }
        }
    }

    onEvent<UserDefinitelyGone> {
        log.debug("User ${it.user.id} did not return")
        it.user.reset()
        goto(Goodbye)
    }

    onUserEnter(instant = true) {
        log.debug("User ${it.id} entered")
        furhat.glance(it)
    }

    onEvent(eventClass = MonitorSpeechStart::class, instant = true, priority = true) {
        log.debug("Furhat is saying: \"${it.text}\" (${it.length} ms in ${this.currentState.name})")
        send(LightsOff)
        propagate()
    }

    onEvent("Restart") {
        log.warn("Restarting interaction")
        furhat.setRobotVoice(lang = currentLang)
        furhat.setRobotFace()
        users.current.reset()
        goto(Idle)
    }

    include(RemoteButtons)
    include(ChangeLanguageBehavior)

    onEvent<MonitorListenStart>(instant = true) {
        send(LedLight)
        propagate()
    }
}

val StandBy : State = state {
    onUserEnter(instant = true) {
        log.debug("User ${it.id} entered")
        furhat.attend(it)
    }

    onEvent(eventClass = MonitorSpeechStart::class, instant = true, priority = true) {
        log.debug("Furhat is saying: \"${it.text}\" (${it.length} ms in ${this.currentState.name})")
        send(LightsOff)
        propagate()
    }

    onEvent("Restart") {
        log.warn("Restarting interaction")
        users.current.reset()
        goto(Idle)
    }

    include(RemoteButtons)
    addGazeAversionBehaviour()

    onEvent<MonitorListenStart>(instant = true) {
        send(LedLight)
        propagate()
    }
}

val InteractionNoLeave: State = state {
    onEvent<UserDefinitelyGone> {
        log.debug("User ${it.user.id} did not return")
        it.user.reset()
        goto(Goodbye)
    }

    onUserEnter(instant = true) {
        log.debug("User ${it.id} entered")
        furhat.attend(it)
    }

    onEvent(eventClass = MonitorSpeechStart::class, instant = true, priority = true) {
        log.debug("Furhat is saying: \"${it.text}\" (${it.length} ms in ${this.currentState.name})")
        send(LightsOff)
        propagate()
    }

    onEvent("Restart") {
        log.warn("Restarting interaction")
        users.current.reset()
        goto(Idle)
    }

    include(RemoteButtons)
    include(ChangeLanguageBehavior)
    onEvent<MonitorListenStart>(instant = true) {
        send(LedLight)
        propagate()
    }
}

val RemoteButtons = partialState {
    onButton("Restart") {
        send("Restart")
    }

    onButton("Standby", key = "Standby_button", visible =true, color = Color.Green) {
        goto(StandBy)
    }

    onButton("Reset Appearance", color = Color.Red) {
        furhat.setRobotVoice(lang = currentLang)
        furhat.setRobotFace()
    }

    onButton("Retrieve Appearance", color = Color.Green) {
        if (users.current.personaliztionData.voice != null){
            furhat.voice = users.current.personaliztionData.voice
        }
        log.info("${users.current.personaliztionData.mask} ${users.current.personaliztionData.voice} retrieved")
        if (users.current.personaliztionData.mask != null ){
            furhat.setRobotFace(users.current.personaliztionData.mask!!)
        }
    }

    onButton("Nod", instant = true, color = Color.Red) {
        furhat.gesture(Nod)
        delay(800)
    }

    onButton("Smile", instant = true,color = Color.Red) {
        furhat.gesture(BigSmile)
        delay(800)
    }

    onButton ("Hello, Ask for consent"){
        users.current.interactionInfo.startTimestamp()
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current, "Interaction Started")
        }
        goto(GreetVisitor)
    }

    onButton("EPDS start")  {
        furhat.stopSpeaking()
        goto(EPDSStartQuestion)
    }
    
    onButton("Set language: English") {
        furhat.setEnglishLanguage()
        reentry()
    }

    onButton("Set language: Swedish") {
        furhat.setSwedishLanguage()
        reentry()
    }

    onButton("Log Current Score", instant = true) {
        try {
            log.info("Current score, ${users.current.epdsData}")
        } catch(error: Error) {
            // Let fail silently
            log.info("Couldn't log score, $error")
        }
    }

    onButton("Start MINI") {
        goto(MINIInstructions)
    }
}

fun waitForUserReturn(user: User) = state(null) {
    var pendingUserReturn: User? = user
    onEntry {
        log.debug("Waiting for user ${user.id} to return")
    }

    onUserEnter(instant = true, priority = true) {
        log.debug("${it.id} entered, while waiting for user ${pendingUserReturn?.id} to return")
        if (it == pendingUserReturn) {
            log.debug("User ${it.id} returned")
            furhat.say({ Gestures.GazeAway })
            furhat.attend(it)
            pendingUserReturn = null
            terminate()
        }
    }

    onTime(delay = 2500) {
        if (users.count > 0) {
            val newUser = users.random
            furhat.attend(newUser)
            users.current = newUser
            terminate()
        } else {
            send(UserDefinitelyGone(users.current))
        }
    }

    onTime(repeat=3000) {
        log.debug("State ${thisState.name} is active")
    }
}

fun AboutState(text: String, event: Event): State = state(Interaction) {
    var waitedPeriods = 0
    onEntry {
        log.debug("User is reading about something")
        waitedPeriods = 0
        send(event)
        furhat.ask(text)
    }

    onResponse<MoveOnIntent> {
        log.debug("User asked to continue while hearing about something (Said \"${it.text}\")")
        send(CloseModal())
        furhat.say(i18n.phrases.GENERAL_MOVE_ON_REPLY, abort = true)
        terminate()
    }

    addGoodbyeHandler()

    onNoResponse {
        waitedPeriods++
        if (waitedPeriods > 5) {
            furhat.sayAndRecord(i18n.phrases.GENERAL_REMIND_TO_MOVE_ON)
            waitedPeriods = 0
        }
        furhat.listen()
    }

    // Ignore any other responses and keep waiting
    onResponse {
        furhat.listen()
    }

    onEvent("ModalClosed") {
        log.debug("User closed the modal")
        furhat.say(i18n.phrases.GENERAL_MOVE_ON_REPLY, abort = true)
        terminate()
    }
}

fun StateBuilder.withHelpOptions(vararg options: String) {
    val helpOptions: Iterable<String> = options.asIterable()
    onResponse<Help> {
        furhat.say(i18n.phrases.GENERAL_OPTIONS_LIST(helpOptions))
        furhat.listen()
    }
}

fun NoOrInvalidResponseState(customBadResponse: (StateBuilder.() -> Unit)? = null) = partialState {
    var noResponse = 0
    var badResponse = 0
    fun numRepeats(): Int = noResponse + badResponse

    onNoResponse {
        noResponse++
        log.debug("User did not respond ${noResponse} times (${badResponse} bad responses)")
        users.current.numNoResponse++
        when {
            users.current.numNoResponse == 1 -> {
                furhat.ask(utterance {
                    +i18n.phrases.GENERAL_LET_USER_KNOW_WHEN_TO_ANSWER
                    +behavior { furhat.gesture(Gestures.Smile) }
                })
            }
            numRepeats() <= 1 -> {
                furhat.ask(utterance {
                    random {
                        +i18n.phrases.GENERAL_NO_RESPONSE_REPLY_VAR1
                        +i18n.phrases.GENERAL_NO_RESPONSE_REPLY_VAR2
                        +i18n.phrases.GENERAL_NO_RESPONSE_REPLY_VAR3
                    }
                })
            }
            numRepeats() == 2 -> {
                furhat.say {
                    random {
                        +i18n.phrases.GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR1
                        +i18n.phrases.GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR2
                        +i18n.phrases.GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR3
                    }
                }
                reentry()
            }
            numRepeats() in 3..4 -> {
                furhat.ask(
                    utterance {
                        random {
                            utterance {
                                +attend(Location.DOWN)
                                +i18n.phrases.GENERAL_NO_RESPONSE_USE_SCREEN_VAR1
                                +attend(users.current)
                            }
                            utterance {
                                +attend(Location.DOWN)
                                +i18n.phrases.GENERAL_NO_RESPONSE_USE_SCREEN_VAR2
                                +attend(users.current)
                            }
                        }
                    }
                )
            }
            else -> {
                if (call(UserMightBeGone) as Boolean) {
                    reentry()
                } else {
                    goto(Goodbye)
                }
            }
        }
    }

    if (customBadResponse != null) {
        customBadResponse()
    } else {
        onResponse {
            badResponse++
            log.debug("User response (\"${it.text}\") was not understood (${badResponse} bad responses, ${noResponse} no response)")
            when {
                numRepeats() <= 1 -> {
                    if (it.text.split(' ').count() < 3) {
                        furhat.ask {
                            random {
                                +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_REPLY_VAR1
                                +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_REPLY_VAR2(it.text)
                                +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_REPLY_VAR3
                                +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_REPLY_VAR4
                            }
                        }
                    } else {
                        furhat.ask {
                            random {
                                +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_REPLY_VAR1
                                +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_REPLY_VAR4
                            }
                        }
                    }
                }
                numRepeats() == 2 -> {
                    furhat.ask {
                        random {
                            +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_ASK_TO_REPEAT_QUESTION
                            +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_ASK_TO_REPHRASE_ANSWER
                        }
                    }
                    furhat.listen()
                }
                else -> {
                    furhat.ask {
                        +attend(Location.DOWN)
                        +i18n.phrases.GENERAL_CANNOT_UNDERSTAND_PLEASE_USE_SCREEN
                        +attend(users.current)
                    }
                }
            }
        }
    }
}

val InteractionWithBadResponse = state(Interaction) {

    addRepeatQuestionHandler()

    addGoodbyeHandler()

    addTellAboutStatesHandlers()

    addGazeAversionBehaviour()

//    addProvideExplanationsDefaultBehaviour()

    include(NoOrInvalidResponseState())
}

//fun StateBuilder.addProvideExplanationsDefaultBehaviour() {
//    onPartialResponse<WhatIs>( priority = true) {
//        log.debug("Got WhatIs intent ${it.text}, ${it.multiIntent}, ${it.secondaryIntent}")
//        if (it.secondaryIntent is SimpleIntent) {
//            val explanationIntent = Explanations.find { explanation -> it.text.contains(explanation.term) }
//            explanationIntent?.let { found -> it.secondaryIntent = found }
//        }
//        raise(it, it.secondaryIntent)
//        reentry()
//    }
//
//    onResponse(Explanations) {
//        furhat.say((it.intent as ExplanationIntent).explanation)
//        reentry()
//    }
//}

fun StateBuilder.addGazeAversionBehaviour() {
    onEvent(MonitorSpeechStart::class, instant = true) {
        val maxLength = it.length.toLong()
        if (maxLength > 1500) {
            randomlyGazeAway(maxLength, 0.75)
        }
        furhat.gesture(Gestures.BrowRaise)
        propagate()
    }

    onEvent(MonitorSpeechEnd::class, instant = true, priority = true) {
        if (ThreadLocalRandom.current().nextDouble(1.0) < 0.6) {
            furhat.gesture(random(Gestures.Smile, Gestures.BrowRaise, Gestures.Oh))
        }
        propagate()
    }

    onEvent(MonitorListenStart::class, instant = true) {
        runDelayed(first = 500..1000, repeat = null, instant = true, timeUnit = TimeUnit.MILLISECONDS) {
            randomlyGazeAway(4000, 0.75)
        }
        propagate()
    }
}

fun StateBuilder.addRepeatQuestionHandler() {
    onResponse<RepeatQuestion> {
        log.debug("User asked to repeat (Said \"${it.text}\")")
        furhat.say{
            +Gestures.Smile
            random {
                +i18n.phrases.GENERAL_REPEATING_QUESTION_VAR1
                +i18n.phrases.GENERAL_REPEATING_QUESTION_VAR2
            }
        }
        reentry()
    }
}

val ChangeLanguageBehavior = partialState {
    onResponse<ChangeLanguage> {
        val language = it.intent.language?.value
        log.debug("User asked to change language (Said \"${it.text}\")")
        handleLanguageChange(language = language)
    }
    onEvent("SelectLanguageGui") {
        val language = it.get("language") as String
        log.debug("User changed language through GUI: $language")
        handleLanguageChange(language = language)
    }
}

fun FlowControlRunner.handleLanguageChange(language : String?) {
    log.debug("User changed language (\"$language\")")
    if (furhat.isSpeaking) { furhat.stopSpeaking() }
    when (language) {
        "en" -> {
            furhat.say(i18n.phrases.CHANGE_LANGUAGE_SUPPORT)
            delay(1000)
            furhat.setEnglishLanguage()
            furhat.say(i18n.phrases.CHANGE_LANGUAGE_SOUNDS_BETTER)
            delay(500)
        }
        "sv" -> {
            furhat.say(i18n.phrases.CHANGE_LANGUAGE_SUPPORT)
            delay(1000)
            furhat.setSwedishLanguage()
            furhat.say(i18n.phrases.CHANGE_LANGUAGE_SOUNDS_BETTER)
            delay(500)
        }
        "zh" -> {
            furhat.say(i18n.phrases.CHANGE_LANGUAGE_SUPPORT)
            delay(1000)
            furhat.setChineseLanguage()
            furhat.say(i18n.phrases.CHANGE_LANGUAGE_SOUNDS_BETTER)
            delay(500)
        }
        else -> {
            furhat.say(i18n.phrases.CHANGE_LANGUAGE_NO_SUPPORT)
            delay(500)
        }
    }
    reentry()
}

fun StateBuilder.addGoodbyeHandler() {
    onResponse<Goodbye> {
        log.debug("User said goodbye (\"${it.text}\")")
        goto(Goodbye)
    }
}

fun StateBuilder.addTellAboutStatesHandlers() {
    onResponse<AboutFurhat> {
        log.debug("User asked about Furhat (\"${it.text}\")")
        call(AboutState(i18n.phrases.GENERAL_ABOUT_FURHAT, ShowAboutFurhat()))
        reentry()
    }

    onEvent("TellAboutFurhat") {
        log.debug("User asked about Furhat through GUI")
        call(AboutState(i18n.phrases.GENERAL_ABOUT_FURHAT, ShowAboutFurhat()))
        reentry()
    }
}

val UserMightBeGone = state {
    // Terminates true if user still here
    onEntry {
        furhat.ask(i18n.phrases.GENERAL_ASK_USER_IS_STILL_THERE)
    }
    onResponse<No> {
        furhat.say(i18n.phrases.GENERAL_USER_NOT_RESPONDING_PROBABLY_GONE_REPLY)
        terminate(true)
    }
    onResponse {
        terminate(true)
    }
    onNoResponse {
        log.debug("User gone")
        terminate(false)
    }
    onUserLeave(instant = false) {
        if (users.current == it) { // user.other == it means that there is no other user
            log.debug("Current user ${it.id} left at state ${this.currentState.name}")
            terminate(false)
        }
    }
}

fun WaitForCommand(nextState: State) = state(Interaction) {
    var waitedPeriods = 0

    withHelpOptions("Continue")

    onEntry {
        waitedPeriods = 0
    }

    onResponse<MoveOnIntent> {
        log.debug("user requested to continue")
        send(OptionSelectedEvent("continuefurhat."))
        continueTo(nextState)
    }

    addGoodbyeHandler()

    addGoHomeHandler()

    // Do nothing, keep waiting
    onNoResponse {
        waitedPeriods++

        if (waitedPeriods > 5) {
            furhat.say(i18n.phrases.GENERAL_REMIND_TO_MOVE_ON)
            waitedPeriods = 0
        }

        furhat.listen()
    }

    // Ignore any other responses and keep waiting
    onResponse {
        furhat.listen()
    }

    onEvent("UserResponse") {
        log.debug("User pressed continue button")
        if (it.get("response")?.toString()?.toLowerCase() == "continue") {
            send(OptionSelectedEvent("continue"))
            continueTo(nextState)
        } else {
            furhat.listen()
        }
    }
}

private fun StateBuilder.addGoHomeHandler() {
    onResponse<GoHome> {
        log.debug("User said asked to go back (\"${it.text}\")")
        val yesOrNo = furhat.askYN(i18n.phrases.GENERAL_CONFIRM_GO_TO_HOME)
        if (yesOrNo == null || yesOrNo) {
            log.debug("User confirmed to go back (\"${it.text}\")")
            goto(ScreeningConsent)
        }
    }
}

private fun TriggerRunner<*>.continueTo(nextState: State) {
    furhat.say(i18n.phrases.GENERAL_MOVE_ON_REPLY)
    send(ClearScreen())
    goto(nextState)
}

fun FlowControlRunner.ackAndGoto(nextState: State, lastQuestion: Boolean = false) {
    val charmSmile = defineGesture {
        frame(1.2) {
            BasicParams.SMILE_CLOSED to 0.6
            BasicParams.SMILE_OPEN to 0.5
            BasicParams.BROW_UP_RIGHT to 0.3
        }
        reset(1.5)
    }

    val isSwedish = furhat.inputLanguages.first() == Language.SWEDISH

    furhat.say({
        random {
            +i18n.phrases.GENERAL_ACKNOWLEDGE_OK
            +i18n.phrases.GENERAL_ACKNOWLEDGE_GOT_IT
            +i18n.phrases.GENERAL_ACKNOWLEDGE_ALRIGHT
            +i18n.phrases.GENERAL_ACKNOWLEDGE_I_UNDERSTAND
            +i18n.phrases.GENERAL_ACKNOWLEDGE_UNDERSTOOD
            +i18n.phrases.GENERAL_ACKNOWLEDGE_AHA
        }

        // In german these get really repetitive, so we only do them 25% as often
        if (!lastQuestion && !isSwedish || Math.random() > 0.75) {
            random {
                +i18n.phrases.GENERAL_NEXT_QUESTION_VAR1
                +i18n.phrases.GENERAL_NEXT_QUESTION_VAR2
                +i18n.phrases.GENERAL_NEXT_QUESTION_VAR3
                +i18n.phrases.GENERAL_NEXT_QUESTION_VAR4
            }
        }
        random {
            +Gestures.Smile
            +Gestures.Thoughtful
            +charmSmile
            +{ } // Do nothing
        }
    })
    log.debug("Acknowledged and moving to state ${nextState.name}")
    delay(500, TimeUnit.MILLISECONDS)
    send(ClearScreen())
    goto(nextState)
}

fun abortableStateDef(abortTo: State, onAbort: ((User) -> Unit)?): StateBuilder.() -> Unit {
    return partialState {
        onResponse<Abort> {
            log.debug("User requested to abort (\"${it.text}\")")
            val yesOrNo = furhat.askYN(i18n.phrases.GENERAL_CONFIRM_ABORT)
            if (yesOrNo == true) {
                log.debug("User confirmed to abort")
                if (onAbort != null) onAbort(users.current)
                goto(abortTo)
            } else {
//                furhat.speak("OK, let's continue")
                reentry()
            }
        }

        onResponse<Goodbye> {
            log.debug("User said goodbye (\"${it.text}\")")
            if (onAbort != null) onAbort(users.current)
            goto(Goodbye)
        }

//        onResponse<GoHome> {
//            log.debug("User requested to go home (\"${it.text}\")")
//            val yesOrNo = furhat.askYN(i18n.phrases.GENERAL_CONFIRM_GO_TO_HOME)
//            if (yesOrNo == null || yesOrNo) {
//                log.debug("User confirmed to go home")
//                if (onAbort != null) onAbort(users.current)
//                goto(ScreeningConsent)
//            } else {
//                furhat.say("OK, let's continue")
//                reentry()
//            }
//        }

        onEvent("GoHome") {
            log.debug("User requested to go home from GUI")
            ackAndGoto(GreetTuringOn, lastQuestion = true)
        }
    }
}

fun TriggerRunner<*>.sayGeneralAcknowledgement() {
    furhat.say({
        random {
            +i18n.phrases.GENERAL_ACKNOWLEDGE_ALRIGHT
            +i18n.phrases.GENERAL_ACKNOWLEDGE_OK
            +i18n.phrases.GENERAL_POSITIVE_ACKNOWLEDGE_1
            +i18n.phrases.GENERAL_POSITIVE_ACKNOWLEDGE_2
        }
    })
}

fun <D> yesNoQuestion(question: String,
                      nextState: State,
                      onYes: (D) -> Unit,
                      onNo: (D) -> Unit,
                      onMaybe: (D) -> Unit,
                      dataGetter: (User) -> D,
                      lastQuestion: Boolean = false,
                      extraYesPhrases: List<String> = emptyList(),
                      extraNoPhrases: List<String> = emptyList()
            ): StateBuilder.() -> Unit = partialState {
            withHelpOptions(i18n.phrases.GENERAL_YES, i18n.phrases.GENERAL_NO)
            onEntry {
                log.debug("Entering '$question' state")
                furhat.askAndDo(question) {
                    send(ShowOptionsEvent(listOf("yes:${i18n.phrases.GENERAL_YES}", "no:${i18n.phrases.GENERAL_NO}"), prompt = question))
                }
            }

            onResponse<Yes> {
                log.debug("User responded \"Yes\" (\"${it.text}\")")
                send(OptionSelectedEvent("yes"))
                onYes(dataGetter(this.users.current))
                ackAndGoto(nextState, lastQuestion)
            }

            onResponse<No> {
                log.debug("User responded \"No\" (\"${it.text}\")")
                send(OptionSelectedEvent("no"))
                onNo(dataGetter(this.users.current))
                ackAndGoto(nextState, lastQuestion)
            }

            onResponse<DontKnow> {
                log.debug("User responded \"Don't Know\" (\"${it.text}\")")
                onMaybe(dataGetter(this.users.current))
                ackAndGoto(nextState, lastQuestion)
            }

            onResponse<Maybe> {
                log.debug("User responded \"Maybe\" (\"${it.text}\")")
                onMaybe(dataGetter(this.users.current))
                ackAndGoto(nextState, lastQuestion)
            }

            onResponse<NoneOfTheAbove> {
                log.debug("User responded \"None\" (\"${it.text}\")")
                onNo(dataGetter(this.users.current))
                ackAndGoto(nextState, lastQuestion)
            }

//            onPartialResponse<WhatIsX>(prefix = true) {
//                log.debug("User is not familiar with term (\"${it.text}\")")
//                val definition = it.intent.getDefinition(it.text)
//                if (definition != null) {
//                    furhat.say(definition)
//                    reentry()
//                } else {
//                    furhat.say({
//                        random {
//                            +i18n.phrases.GENERAL_USER_NOT_FAMILIAR_WITH_TERM
//                            +i18n.phrases.GENERAL_USER_NOT_FAMILIAR_WITH_TERM_2
//                        }
//                    })
//                    send(OptionSelectedEvent("yes"))
//                    onMaybe(dataGetter(this.users.current))
//                    goto(nextState)
//                }
//            }

            if (extraYesPhrases.isNotEmpty()) {
                onResponse(*extraYesPhrases.toTypedArray()) {
                    log.debug("User responded with yes-example from the list (\"${it.text}\")")
                    send(OptionSelectedEvent("yes"))
                    onYes(dataGetter(this.users.current))
                    ackAndGoto(nextState, lastQuestion)
                }
            }

            if (extraNoPhrases.isNotEmpty()) {
                onResponse(*extraNoPhrases.toTypedArray()) {
                    log.debug("User responded with no-example from the list (\"${it.text}\")")
                    send(OptionSelectedEvent("no"))
                    onNo(dataGetter(this.users.current))
                    ackAndGoto(nextState, lastQuestion)
                }
            }

            onEvent("UserResponse") {
                log.debug("User responded ${it.get("response")} through GUI")
                when ((it.get("response") as String?)?.lowercase()) {
                    "yes" -> onYes(dataGetter(this.users.current))
                    "no" -> onNo(dataGetter(this.users.current))
                }
                ackAndGoto(nextState, lastQuestion)
            }
        }

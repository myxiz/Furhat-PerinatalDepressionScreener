@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSIntro
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.nlu.*
import furhatos.flow.kotlin.*
import java.lang.IllegalArgumentException

val ScreeningSelection: State = state(IntroductionBaseState) {

    withHelpOptions(i18n.phrases.GENERAL_YES, i18n.phrases.GENERAL_NO)

    onEntry {
        log.debug("In ScreeningSelection state")
        furhat.askAndDo(i18n.phrases.INTRODUCTION_ROBOTINTRO
                +i18n.phrases.INTRODUCTION_EPDS_CONSENT) {
            send(ClearScreen())
            send(ShowOptionsEvent(
                    listOf(
                        "yes:${i18n.phrases.GENERAL_YES}",
                        "no:${i18n.phrases.GENERAL_NO}"
                    ),
                    prompt = i18n.phrases.INTRODUCTION_EPDS_CONSENT
            ))
        }
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        when {
            response === null -> throw Error("Response from GUI was null")
            listOf("yes", "no").contains(response) -> {
                log.debug("User selected screening ${it.get("response")} through GUI")
                handleScreeningChoice(it.get("response") as String?, true)
            }
            else -> handleLanguageChange(language = response)
        }
    }

    onReentry {
        log.debug("Reentering ScreenSelection state")
        furhat.askAndDo(utterance {
            random {
                +i18n.phrases.INTRODUCTION_EPDS_CONSENT
                +i18n.phrases.INTRODUCTION_EPDS_CONSENT
            }
        }) {
            delay(800)
            send(ShowOptionsEvent(
                    listOf(
                            "yes:${i18n.phrases.GENERAL_YES}",
                            "no:${i18n.phrases.GENERAL_NO}"
                    ),
                    i18n.phrases.INTRODUCTION_EPDS_CONSENT,
                    append = false))
        }
    }

    onResponse<Yes> { handleScreeningChoice("yes") }
    onResponse<YesYouCan> { handleScreeningChoice("yes") } // in mandarin, "can" is often the answer given to any question beginning with "can i..." or "can you..."
    onResponse("tell me", "want to know", "why is it important") { handleScreeningChoice("yes") }
    onResponse<Maybe> { handleScreeningChoice("yes") }
    onResponse<LetsProceed> { handleScreeningChoice("yes") }
    onResponse<No> { handleScreeningChoice("no") }
    onResponse("don't want to know", "already know") { handleScreeningChoice("no") }
    onResponse<Start> { handleScreeningChoice("no") }

    addRepeatQuestionHandler()
    addGoodbyeHandler()
    addTellAboutStatesHandlers()
    addGazeAversionBehaviour()

    onResponse<EnglishDontUnderstandLanguage> {
        handleLanguageChange(language = "en")
    }

    include(ChangeLanguageBehavior)
    include(NoOrInvalidResponseState(customBadResponse = {
        onResponse {
            log.debug("Unrecognized response to ScreeningSelection (\"${it.text}\")")
            users.current.showScreeningButtons = true
            furhat.say({
                random {
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR1
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR2
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR3
                }
            })
            furhat.askAndDo(i18n.phrases.INTRODUCTION_PND_DESCRIPTION) {
                send(ShowOptionsEvent(
                        listOf(
                                "yes:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_YES}",
                                "no:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_NO}"
                        ),
                        prompt = i18n.phrases.INTRODUCTION_PND_PROMPT,

                ))
            }
        }
    }))
    include(abortableStateDef(Goodbye, null))
}


val PNDIntro :State = state(IntroductionBaseState) {
    onEntry {
        send(ClearScreen())
        log.debug("In ScreeningSelection state")
        furhat.askAndDo(utterance = i18n.phrases.INTRODUCTION_PND_PROMPT) {
            send(ShowOptionsEvent(
                listOf(
                    "yes:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_YES}",
                    "no:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_NO}"
                ),
                prompt = i18n.phrases.INTRODUCTION_PND_PROMPT
            ))
        }
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        when {
            response === null -> throw Error("Response from GUI was null")
            listOf("yes", "no").contains(response) -> {
                log.debug("User selected screening ${it.get("response")} through GUI")
                handleIntroChoice(it.get("response") as String?, true)
            }
            else -> handleLanguageChange(language = response)
        }
    }

    onReentry {
        log.debug("Reentering ScreenSelection state")
        furhat.askAndDo(utterance {
            random {
                +i18n.phrases.INTRODUCTION_REPEAT_OPTIONS_VAR1
                +i18n.phrases.INTRODUCTION_REPEAT_OPTIONS_VAR2
            }
        }) {
            delay(800)
            send(ShowOptionsEvent(
                listOf(
                    "yes:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_YES}",
                    "no:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_NO}"
                ),
                i18n.phrases.INTRODUCTION_PND_PROMPT,
                append = false))
        }
    }

    onResponse<Yes> { handleIntroChoice("yes") }
    onResponse<YesYouCan> { handleIntroChoice("yes") } // in mandarin, "can" is often the answer given to any question beginning with "can i..." or "can you..."
    onResponse("tell me", "want to know", "why is it important") { handleIntroChoice("yes") }
    onResponse<Maybe> { handleIntroChoice("yes") }
    onResponse<LetsProceed> { handleIntroChoice("yes") }
    onResponse<No> { handleIntroChoice("no") }
    onResponse("don't want to know", "already know") { handleIntroChoice("no") }
    onResponse<Start> { handleIntroChoice("no") }

    addRepeatQuestionHandler()
    addGoodbyeHandler()
    addTellAboutStatesHandlers()
    addGazeAversionBehaviour()

    onResponse<EnglishDontUnderstandLanguage> {
        handleLanguageChange(language = "en")
    }

    include(ChangeLanguageBehavior)
    include(NoOrInvalidResponseState(customBadResponse = {
        onResponse {
            log.debug("Unrecognized response to ScreeningSelection (\"${it.text}\")")
            users.current.showScreeningButtons = true
            furhat.say({
                random {
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR1
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR2
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR3
                }
            })
            furhat.askAndDo(i18n.phrases.INTRODUCTION_PND_PROMPT) {
                send(ShowOptionsEvent(
                    listOf(
                        "yes:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_YES}",
                        "no:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_NO}"
                    ),
                    prompt = i18n.phrases.INTRODUCTION_PND_PROMPT,

                ))
            }
        }
    }))
    include(abortableStateDef(Goodbye, null))

}
private fun TriggerRunner<*>.handleScreeningChoice(choice: String?, respondedFromGui: Boolean = false) {
    users.current.showScreeningButtons = true
    when (choice) {
        "yes" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("yes"))
            }
            furhat.say(i18n.phrases.INTRODUCTION_THANSFORTURST)
            delay(400)
            send(ClearScreen())
            goto(EPDSIntro)
        }
        "no" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("no"))
            }
            furhat.say(i18n.phrases.GENERAL_OK_NO_PROBLEM)
            delay(400)
            send(ClearScreen())
            goto(Goodbye)
        }
        else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
    }
}

private fun TriggerRunner<*>.handleIntroChoice(choice: String?, respondedFromGui: Boolean = false) {
    when (choice) {
        "yes" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("yes"))
            }
            sayGeneralAcknowledgement()
            delay(400)
            send(ClearScreen())
            furhat.say(i18n.phrases.INTRODUCTION_PND_DESCRIPTION)
            delay(400)
            goto(EPDSIntro)
        }
        "no" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("no"))
            }
            furhat.say(i18n.phrases.INTRODUCTION_EPDS_NO_DESCRIPTION)
            delay(400)
            goto(EPDSIntro)
        }
        else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
    }
}

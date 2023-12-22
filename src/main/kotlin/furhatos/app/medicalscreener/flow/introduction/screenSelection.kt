@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.DiabetesStart
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.nlu.*
import furhatos.flow.kotlin.*
import java.lang.IllegalArgumentException

val ScreeningSelection: State = state(IntroductionBaseState) {
    withHelpOptions(i18n.phrases.GENERAL_YES, i18n.phrases.GENERAL_NO)

    onEntry {
        log.debug("In ScreeningSelection state")
        furhat.askAndDo(i18n.phrases.INTRODUCTION_DIABETES) {
            send(ClearScreen())
            delay(800)
            send(ShowOptionsEvent(
                    listOf(
                        "yes:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_YES}",
                        "no:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_NO}"
                    ),
                    prompt = i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_PROMPT
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
                +i18n.phrases.INTRODUCTION_REPEAT_OPTIONS_VAR1
                +i18n.phrases.INTRODUCTION_REPEAT_OPTIONS_VAR2
            }
        }) {
            send(ShowOptionsEvent(
                    listOf(
                            "yes:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_YES}",
                            "no:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_NO}"
                    ),
                    i18n.phrases.INTRODUCTION_DIABETES_PROMPT,
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
            users.current.showSscreeningButtons = true
            furhat.say({
                random {
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR1
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR2
                    +i18n.phrases.INTRODUCTION_INVALID_RESPONSE_VAR3
                }
            })
            furhat.askAndDo(i18n.phrases.INTRODUCTION_DIABETES) {
                send(ShowOptionsEvent(
                        listOf(
                                "yes:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_YES}",
                                "no:${i18n.phrases.INTRODUCTION_DESCRIPTION_OPTION_NO}"
                        ),
                        prompt = i18n.phrases.INTRODUCTION_DIABETES_PROMPT,
                        append = true
                ))
            }
        }
    }))
    include(abortableStateDef(Goodbye, null))
}

private fun TriggerRunner<*>.handleScreeningChoice(choice: String?, respondedFromGui: Boolean = false) {
    users.current.showSscreeningButtons = true
    when (choice) {
        "yes" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("yes"))
            }
            sayGeneralAcknowledgement()
            delay(400)
            send(ClearScreen())
            furhat.say(i18n.phrases.INTRODUCTION_DIABETES_DESCRIPTION)
            delay(400)
            goto(DiabetesStart)
        }
        "no" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("no"))
            }
            furhat.say(i18n.phrases.INTRODUCTION_DIABETES_NO_DESCRIPTION)
            delay(400)
            goto(DiabetesStart)
        }
        else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
    }
}
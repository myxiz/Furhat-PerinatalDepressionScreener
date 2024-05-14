@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSIntro
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.nlu.*
import furhatos.flow.kotlin.*
import java.lang.IllegalArgumentException

val ScreeningConsent: State = state(IntroductionBaseState) {
    withHelpOptions(i18n.phrases.GENERAL_YES, i18n.phrases.GENERAL_NO)
    val options = listOf(
        "yes:${i18n.phrases.GENERAL_YES}",
        "no:${i18n.phrases.GENERAL_NO}"
    )
    onEntry {
        log.debug("In ScreeningSelection state")
        furhat.askAndDo(i18n.phrases.INTRODUCTION_ROBOTINTRO
                + ' '
                + i18n.phrases.INTRODUCTION_EPDS_CONSENT) {
                send(ClearScreen())
                send(ShowOptionsEvent(
                options,
                    prompt = i18n.phrases.INTRODUCTION_EPDS_CONSENT

            ))
//            furhat.say(i18n.phrases.GENERAL_OPTIONS_LIST(helpOptions))
        }
    }
    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val response = it.get("response") as String?
        when {
            response === null -> throw Error("Response from GUI was null")
            listOf("yes", "no").contains(response) -> {
                log.debug("User selected screening ${it.get("response")} through GUI")
                handleConsentChoice(it.get("response") as String?, true)
            }
            else -> handleLanguageChange(language = response)
        }
    }

    onReentry {
        log.debug("Reentering ScreenSelection state")
        furhat.askAndDo(utterance {
                i18n.phrases.INTRODUCTION_EPDS_CONSENT
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

    onResponse<Yes> { handleConsentChoice("yes") }
    onResponse<YesYouCan> { handleConsentChoice("yes") } // in mandarin, "can" is often the answer given to any question beginning with "can i..." or "can you..."
    onResponse("tell me", "want to know", "why is it important") { handleConsentChoice("yes") }
    onResponse<Maybe> { handleConsentChoice("yes") }
    onResponse<LetsProceed> { handleConsentChoice("yes") }
    onResponse<No> { handleConsentChoice("no") }
    onResponse("don't want to know", "already know") { handleConsentChoice("no") }
    onResponse<Start> { handleConsentChoice("no") }

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
            furhat.askAndDo(i18n.phrases.INTRODUCTION_EPDS_CONSENT) {
                send(ShowOptionsEvent(
                        listOf(
                            "yes:${i18n.phrases.GENERAL_YES}",
                            "no:${i18n.phrases.GENERAL_NO}"
                        ),
                        prompt = i18n.phrases.INTRODUCTION_EPDS_CONSENT,
                ))
            }
        }
    }))
    include(abortableStateDef(Goodbye, null))
}

private fun TriggerRunner<*>.handleConsentChoice(choice: String?, respondedFromGui: Boolean = false) {
    users.current.showScreeningButtons = true
    when (choice) {
        "yes" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("yes"))
            }
            furhat.sayAndRecord(i18n.phrases.INTRODUCTION_THANSFORTURST)
            users.current.epdsData.consent = "yes"
            delay(400)
            send(ClearScreen())
            goto(EPDSIntro)
        }
        "no" -> {
            if (!respondedFromGui) {
                send(OptionSelectedEvent("no"))
            }
            users.current.epdsData.consent = "no"
            furhat.sayAndRecord(i18n.phrases.GENERAL_OK_NO_PROBLEM)
            delay(400)
            send(ClearScreen())
            goto(Goodbye)
        }
        else -> throw IllegalArgumentException("Must be either 'yes' or 'no'")
    }
}

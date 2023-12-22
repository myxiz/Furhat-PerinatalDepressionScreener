package furhatos.app.medicalscreener.flow

import furhatos.flow.kotlin.Utterance
import furhatos.flow.kotlin.UtteranceBuilder
import furhatos.flow.kotlin.behavior
import furhatos.flow.kotlin.utterance
import furhatos.skills.HostedGUI


fun initGUI() = ScreenerGUI

val ScreenerGUI = HostedGUI("ScreenerGUI", port = 1237)

fun sayAndAppendToGui(text: String): UtteranceBuilder.() -> Unit {
    return {
        +behavior { send(AppendTextEvent(text)) }
        +text
    }
}

fun sayAndShowScreen(text: String, title: String? = null): UtteranceBuilder.() -> Unit {
    return {
        +behavior { send(ShowScreenEvent(title ?: "", text)) }
        +text
    }
}

fun askAndShowOptions(
        question: String,
        options: Iterable<String>,
        clearScreen: Boolean = true,
        delay: Double = 0.5,
        title: String? = null): Utterance = utterance {
            +behavior { send(ShowOptionsEvent(options.toList(), question, append = !clearScreen, delaySeconds = delay, title = title)) }
            +question
        }

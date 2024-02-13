package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.OptionSelectedEvent
import furhatos.app.medicalscreener.flow.ShowOptionsEvent
import furhatos.app.medicalscreener.flow.askAndDo
import furhatos.app.medicalscreener.flow.epdsData
import furhatos.app.medicalscreener.flow.scenes.EPDSStartQuestion
import furhatos.app.medicalscreener.i18n.*
import furhatos.app.medicalscreener.nlu.*
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils
import java.util.concurrent.TimeUnit

private val log = CommonUtils.getLogger(EPDSStartQuestion::class.java)!!

val relativeOptions : Map<String, String> = mapOf(
        "no" to i18n.phrases.GENERAL_NO,
        "yes" to i18n.phrases.GENERAL_YES,
        "close" to i18n.phrases.DIABETES_FAMILY_HISTORY_ALTERNATIVE_1,
        "distant" to i18n.phrases.DIABETES_FAMILY_HISTORY_ALTERNATIVE_2
)

val FamilyQuestion1: State = state(EPDSStartQuestion) {
    onEntry {
        furhat.askAndDo(i18n.phrases.DIABETES_FAMILY_HISTORY_QUESTION_1) {
            send(ShowOptionsEvent(
                relativeOptions.map { "${it.key}:${it.value}" },
                i18n.phrases.DIABETES_FAMILY_HISTORY_QUESTION_PROMT
            ))
        }
    }

    onResponse<FamilyHistoryYes> {
        send(OptionSelectedEvent("yes"))
        handleUserResponse("yes")
    }

    onResponse<Yes> {
        send(OptionSelectedEvent("yes"))
        handleUserResponse("yes")
    }
    onResponse<No> {
        send(OptionSelectedEvent("no"))
        handleUserResponse("no")
    }

    include(sharedResponseHandlers)
}


val FamilyQuestion2: State = state(EPDSStartQuestion) {
    onEntry {
        furhat.askAndDo(i18n.phrases.DIABETES_FAMILY_HISTORY_QUESTION_2) {
            send(ShowOptionsEvent(
                relativeOptions.map { "${it.key}:${it.value}" }.takeLast(2),
                i18n.phrases.DIABETES_FAMILY_HISTORY_QUESTION_PROMT
            ))
        }
    }
    include(sharedResponseHandlers)
}

private fun TriggerRunner<*>.handleUserResponse(res : String?) {
    furhat.say(i18n.phrases.GENERAL_ACKNOWLEDGE_THANK_YOU)
    delay(500, TimeUnit.MILLISECONDS)

    when {
        (res == "close") -> {
            log.debug("User responded 'close'")
            users.current.epdsData.addToScore(5, "FamilyQuestion")
            goto(Results)
        }
        (res == "distant") -> {
            log.debug("User responded 'distant'")
            users.current.epdsData.addToScore(3, "FamilyQuestion")
            goto(Results)
        }
        (res == "no") -> goto(Results)
        (res == "yes") -> goto(FamilyQuestion2)
        else -> throw IllegalArgumentException("Must be either close, distant, yes, or no")
    }
}

private val sharedResponseHandlers = partialState {
    onResponse<RelativeIntent> {
        send(OptionSelectedEvent(it.intent.relative?.value))
        handleUserResponse(it.intent.relative?.value)
    }

    onResponse(listOf(Maybe(), DontKnow())) {
        furhat.say("${i18n.phrases.GENERAL_OK_NO_PROBLEM}, ${i18n.phrases.GENERAL_MOVE_ON_REPLY}")

        // When not known, we assume the worst-case scenario
        users.current.epdsData.addToScore(5, "FamilyQuestion")
        goto(Results)
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val res = it.get("response") as String?
        handleUserResponse(res)
    }
}
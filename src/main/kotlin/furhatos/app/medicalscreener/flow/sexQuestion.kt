package furhatos.app.medicalscreener.flow

import furhatos.app.medicalscreener.ScreenerSkill
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.i18n.DontKnow
import furhatos.app.medicalscreener.nlu.NoneOfTheAbove
import furhatos.app.medicalscreener.i18n.SpecifySex
import furhatos.flow.kotlin.*
import furhatos.records.User
import furhatos.util.CommonUtils

private val log = CommonUtils.getLogger(ScreenerSkill::class.java)!!

fun sexQuestion(parent: State, responseHandler: FlowControlRunner.(String?, Boolean) -> Unit): State {
    return state(parent) {
        withHelpOptions(i18n.phrases.SEX_QUESTION_MALE, i18n.phrases.SEX_QUESTION_FEMALE)
        onEntry {
            log.debug("Entering SexQuestion state")
            if (users.current.sex != Sex.Unknown) {
                responseHandler(this, users.current.sex.name, false)
            } else {
                furhat.setSpeechRecPhrases(listOf("male", "man", "female", "woman"))
                furhat.askAndDo(
                    utterance = i18n.phrases.SEX_QUESTION
                ) {
                    send(ShowOptionsEvent(
                            listOf("male:${i18n.phrases.SEX_QUESTION_MALE}", "female:${i18n.phrases.SEX_QUESTION_FEMALE}"),
                            i18n.phrases.SEX_QUESTION_PROMPT))
                }
            }
        }

        onResponse<SpecifySex> {
            log.debug("User answered '${it.intent.sex?.text}' meaning his/her sex is ${it.intent.sex?.value}")
            updateSex(users.current, it.intent.sex?.value)
            send(OptionSelectedEvent(it.intent.sex?.value))
            responseHandler(it.intent.sex?.value, true)
        }

        onResponse(listOf(NoneOfTheAbove(), DontKnow())) {
            log.debug("User answered '${it.text}' when asked for it's sex")
            furhat.say(i18n.phrases.DIABETES_SEX_QUESTION_BIOLOGICAL_SEX)
            furhat.listen()
        }

        onEvent("UserResponse") {
            log.debug("User responded ${it.get("response")} through GUI")
            val response = it.get("response")?.toString()
            updateSex(users.current, response)
            responseHandler(response, true)
        }
    }
}


private fun updateSex(user: User, response: String?) {
    when (response?.toLowerCase()) {
        "male" -> user.sex = Sex.Male
        "female" -> user.sex = Sex.Female
        "other" -> user.sex = Sex.Unspecified
    }
}
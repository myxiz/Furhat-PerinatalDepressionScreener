package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.i18n.*
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils

private fun TriggerRunner<*>.handleAgeResponse(age: Int?, isCategory: Boolean): Boolean {
    users.current.age = age
    age?.let {
        when {
            age < 0 -> {
                furhat.say(i18n.phrases.DIABETES_AGE_INVALID_ANSWER_1)
                return false
            }
            age in 0..17 -> {
                furhat.say(i18n.phrases.DIABETES_AGE_INVALID_ANSWER_2)
                return false
            }
            age < 45 -> {
                send(OptionSelectedEvent("39"))
                users.current.userAge = if (isCategory) UserAge.AgeCategory(UserAge.AgeCategories.YoungerThan40) else UserAge.SpecificAge(age)
                return true
            }
            age in 45..54 -> {
                send(OptionSelectedEvent("49"))
                users.current.userAge = if (isCategory) UserAge.AgeCategory(UserAge.AgeCategories.Between40to49) else UserAge.SpecificAge(age)
                this.users.current.epdsData.addToScore(2, "AgeQuestion")
                return true
            }
            age in 55..64 -> {
                send(OptionSelectedEvent("59"))
                users.current.userAge = if (isCategory) UserAge.AgeCategory(UserAge.AgeCategories.Between50to59) else UserAge.SpecificAge(age)
                this.users.current.epdsData.addToScore(3, "AgeQuestion")
                return true
            }
            age in 65..120 -> {
                send(OptionSelectedEvent("60"))
                users.current.userAge = if (isCategory) UserAge.AgeCategory(UserAge.AgeCategories.Over60) else UserAge.SpecificAge(age)
                this.users.current.epdsData.addToScore(4, "AgeQuestion")
                return true
            }
            age > 120 -> {
                furhat.say(i18n.phrases.DIABETES_AGE_INVALID_ANSWER_3)
                return false
            }
            else -> {
                furhat.say(i18n.phrases.DIABETES_AGE_INVALID_ANSWER_4)
                return false
            }
        }
    }
    return false
}

private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!

val AgeQuestion = state(EPDSQuestionBase) {
    withHelpOptions(i18n.phrases.DIABETES_AGE_QUESTION_PROMT)
    onEntry {
        log.debug("Entering AgeQuestion state")
        furhat.askAndDo(i18n.phrases.DIABETES_AGE_QUESTION) {
                send(ShowOptionsEvent(
                        listOf(
                                "39:${i18n.phrases.DIABETES_AGE_OPTION1}",
                                "49:${i18n.phrases.DIABETES_AGE_OPTION2}",
                                "59:${i18n.phrases.DIABETES_AGE_OPTION3}",
                                "60:${i18n.phrases.DIABETES_AGE_OPTION4}"
                        ),
                        i18n.phrases.DIABETES_AGE_QUESTION
                ))
        }
    }

    onResponse<SpecifyAge> {
        val age = it.intent?.age?.value
        log.debug("User's age is $age (\"${it.text}\")")
        val isValidAnswer = handleAgeResponse(age, false)
        if (isValidAnswer) {
            ackAndGoto(HeightQuestion)
        } else {
            furhat.listen()
        }
    }

    onResponse<SpecifyAboveAge> {
        val age = it.intent?.age?.value
        log.debug("User's age is over $age (\"${it.text}\")")
        val isValidAnswer = handleAgeResponse(age?.let { n -> n + 1 }, true)
        if (isValidAnswer) {
            ackAndGoto(HeightQuestion)
        } else {
            furhat.listen()
        }
    }

    onResponse<SpecifyBelowAge> {
        val age = it.intent?.age?.value
        log.debug("User's age is under $age (\"${it.text}\")")
        val isValidAnswer = handleAgeResponse(age?.let { n -> n - 1 }, true)
        if (isValidAnswer) {
            ackAndGoto(HeightQuestion)
        } else {
            furhat.listen()
        }
    }

    onResponse<DontKnow> {
        log.debug("User doesn't know what its age (\"${it.text}\")")
        furhat.say(i18n.phrases.DIABETES_AGE_ESTIMATE)
        furhat.listen()
    }

    onEvent("UserResponse") {
        log.debug("User responded ${it.get("response")} through GUI")
        val age = (it.get("response") as String?)?.toIntOrNull()
        handleAgeResponse(age, true)
        ackAndGoto(HeightQuestion)
    }
}

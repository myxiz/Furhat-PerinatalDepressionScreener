package furhatos.app.medicalscreener.i18n

import furhatos.nlu.ComplexEnumEntity
import furhatos.nlu.EnumEntity
import furhatos.util.Language

class FurhatEntity : EnumEntity(speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> =
        when (lang) {
            // TODO
            Language.MANDARIN -> listOf("furhat")
            Language.SWEDISH -> listOf("furhat")
            else -> listOf("furhat")
        }
}


//--------Not using in our application-----------------

//class WhatIsX(val x: String? = null) : ComplexEnumEntity() {
//    override fun getEnum(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "什么是 @x",
//                "是什么 @x",
//                "那什么是 @x",
//                "我不知道什么是 @x",
//                "我不确定我知道什么 @x means",
//                "我不确定我知道什么是 @x",
//                "我不知道是什么 @x is",
//                "这是什么意思?",
//                "这是什么 @x 意思?",
//                "什么 @x",
//                "是什么 @x",
//                "定义 @x",
//                "解释 @x",
//                "我不理解 @x")
//            Language.GERMAN -> listOf(
//                "was ist @x",
//                "was ist der @x",
//                "was ist die @x",
//                "was ist das @x",
//                "was ist ein @x",
//                "was ist eine @x",
//                "und was ist @x",
//                "und was ist der @x",
//                "und was ist die @x",
//                "und was ist das @x",
//                "und was ist ein @x",
//                "und was ist eine @x",
//                "ich weiß nicht was ein @x ist",
//                "ich weiß nicht was eine @x ist",
//                "ich weiß nicht was der @x ist",
//                "ich weiß nicht was die @x ist",
//                "ich weiß nicht was das @x ist",
//                "ich bin mir nicht sicher was @x bedeutet",
//                "keine Ahnung was @x bedeutet",
//                "keine Ahnung was @x ist",
//                "ich bin mir unsicher was @x bedeutet",
//                "ich bin mir unsicher was @x ist",
//                "Was bedeutet das?",
//                "was bedeutet @x ?",
//                "Was is @x", "Was ist @x",
//                "Was ist @x",
//                "Was is @x",
//                "Was ist der @x",
//                "Was ist das @x",
//                "Was ist die @x",
//                "Was ist ein @x",
//                "Was ist eine @x",
//                "definire @x",
//                "explain @x",
//                "ich verstehe @x nicht")
//            else -> listOf(
//                "what is @x",
//                "what is the @x",
//                "and what is @x",
//                "I don't know what is @x",
//                "Not sure I know what @x means",
//                "I'm not sure what's @x",
//                "I'm not sure what @x is",
//                "what does it mean?",
//                "what does @x mean?",
//                "what's @x",
//                "what's the @x",
//                "define @x",
//                "explain @x",
//                "I don't understand @x")
//        }

//    fun getDefinition(response: String?): String? {
//        val responseText = response ?: text
//        return when {
//            responseText.contains(i18n.phrases.QUESTION_DIABETES) -> i18n.phrases.EXPLANATION_DIABETES
//            responseText.contains(i18n.phrases.QUESTION_PHYSICAL_ACTIVITY) -> i18n.phrases.EXPLANATION_PHYSICAL_ACTIVITY
//            responseText.contains(i18n.phrases.QUESTION_HIGH_BLOOD_PRESSURE) -> i18n.phrases.EXPLANATION_HIGH_BLOOD_PRESSURE
//            responseText.contains(i18n.phrases.QUESTION_NAME) -> i18n.phrases.EXPLANATION_NAME
//            responseText.contains(i18n.phrases.QUESTION_YOUR_QUEST) -> i18n.phrases.EXPLANATION_YOUR_QUEST
//            else -> null
//        }
//    }
//}
//



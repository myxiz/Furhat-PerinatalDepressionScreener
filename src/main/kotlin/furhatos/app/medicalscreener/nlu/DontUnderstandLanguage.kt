package furhatos.app.medicalscreener.nlu

import furhatos.nlu.Intent
import furhatos.util.Language

// This is for when an english speaker says something like "I don't understand" when listening in german or chinese
val englishExamples = listOf(
    "I don't understand what you're saying",
    "I don't understand you",
    "I don't understand your language",
    "I'm sorry, I do not speak chinese",
    "I'm sorry, I do not speak german"
)

class EnglishDontUnderstandLanguage : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> englishExamples
            Language.GERMAN -> englishExamples
            else -> listOf(

            )
        }
}

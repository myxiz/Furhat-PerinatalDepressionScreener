package furhatos.app.medicalscreener.nlu

import furhatos.nlu.Intent
import furhatos.util.Language


class FamilyHistoryYes : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "有",
                "有的",
                "我有"
            )
            Language.GERMAN -> listOf(
                "ja",
                "habe ich",
                "haben sie ",
                "haben die"
            )
            else -> listOf(
                "They have", "One has"
            )
        }

}


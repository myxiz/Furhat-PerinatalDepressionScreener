package furhatos.app.medicalscreener.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

class ChangeLanguage : Intent() {
    var language: LanguageEntity? = null

    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "@language",
                "切换到 @language",
                "我们可以切换到 @language?",
                "你会说 @language?",
                "你可以说 @language?",
                "可以说 @language?",
                "@language 谢谢",
                "我说 @language",
                "@language 你会说吗",
                "@language 你可以说吗"
            )
            Language.GERMAN -> listOf(
                "@language",
                "Wechsel zu @language",
                "Können wir zu @language wechseln?",
                "Sprichst Du @language?",
                "Sprechen Sie @language?",
                "cancel @language?", // what "kannst du" sounds like
                "Kannst du @language sprechen?",
                "Können Sie @language sprechen?",
                "@language bitte",
                "ich spreche @language"
            )
            else -> listOf(
                "@language",
                "Switch to @language",
                "Can we switch to @language",
                "Do you speak @language",
                "Can you speak @language",
                "@language please",
                "i speak @language"
            )
        }
}

class LanguageEntity : EnumEntity() {
    override fun getEnum(lang: Language): List<String> =
        when (lang) {
            // TODO needs improvement
            Language.MANDARIN -> listOf(
                "en:English,english,brittish,american,Englisch,speak English, 英文, 英语",
                "zh:普通话,中文, 中国的语言, 中文的,中国官话,普通话中文",
                "de:German,german,Deutsche Sprache,Deutsche,dutch,deutsche Sprechen,dodge,dice, 德语",
                "ko:korean, 韩语"
            )
            Language.GERMAN -> listOf(
                "en:English,english,brittish,american,Englisch,speak English",
                "zh:普通话,中文, 中国的语言, 中文的,中国官话,普通话中文,Nina,nina Schuhe,ninja,neon, Nina jung,nina george,Schuhe jung,Roboter Uni,war Buddha, nina emma, nina holly julia, nina julia",
                "de:German,german,Deutsche Sprache,Deutsche,dutch,deutsche Sprechen,dodge,dice",
                "ko:korean"
            )
            else -> listOf(
                "en:English,english,brittish,american,Englisch,speak English",
                "zh:chinese, mandarin, 普通话,中文, 中国的语言, 中文的,中国官话,普通话中文,nucleus,nicloe you,jungle, dongle,well england,wobble young,what union,hangman, hyena,nina shore,nina sure,nina saudi,nino,nino's",
                "de:German,german,Deutsche Sprache,Deutsche,dutch,deutsche Sprechen,dodge,dice,ice dragon",
                "ko:korean"
            )
        }
}


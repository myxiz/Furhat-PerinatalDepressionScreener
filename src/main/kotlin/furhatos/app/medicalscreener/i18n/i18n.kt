package furhatos.app.medicalscreener.i18n

import furhatos.util.Language

val en = Language.ENGLISH_US
val sv = Language.SWEDISH
val zh = Language.MANDARIN

class I18n(lang : Language = Language.SWEDISH) {
    val phrases : I18nPhrases = I18nPhrases()
    val intents : I18nIntents = I18nIntents()
}

var i18n = I18n()

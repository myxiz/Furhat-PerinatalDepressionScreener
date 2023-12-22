package furhatos.app.medicalscreener

import furhatos.app.medicalscreener.flow.ClearScreen
import furhatos.app.medicalscreener.flow.SetLanguageEvent
import furhatos.app.medicalscreener.flow.introduction.petraVoice
import furhatos.app.medicalscreener.i18n.I18n
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.event.EventSystem.send
import furhatos.flow.kotlin.Furhat
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.voice.PollyVoice
import furhatos.gestures.Gestures.BigSmile
import furhatos.gestures.Gestures.Nod
import furhatos.gestures.Gestures.Surprise
import furhatos.gestures.Gestures.Thoughtful
import furhatos.gestures.Gestures.Wink
import furhatos.records.Location
import furhatos.util.Language

var currentLang: Language = Language.ENGLISH_US

fun Furhat.randomGesture() {
    val myGestures = listOf(Thoughtful, BigSmile, Wink, Surprise, Nod)
    runner.random(myGestures.map { { gesture(it) } })
}

fun Furhat.attendRandomLocation() {
    runner.random(
            { attend(Location(0.3,0.0,1.0))  },
            { attend(Location(-0.3,0.0,1.0))  },
            { attend(Location(0.1,0.1,1.0))  },
            { attend(Location(-0.1,-0.1,1.0))  },
            { attend(Location(0.0,0.0,1.0))  }
    )
}

fun Furhat.setLindaVoice(lang : Language) {
    i18n = I18n(lang)
    val speakingRate = 0.95
    petraVoice = mapOf<Language, PollyVoice>(
            Language.ENGLISH_US to PollyVoice(name = "Salli-Neural", language = Language.ENGLISH_US, rate = speakingRate),
            Language.MANDARIN to PollyVoice(name="Zhiyu", language = Language.MANDARIN, rate = speakingRate),
            Language.GERMAN to PollyVoice(name = "Marlene", language = Language.GERMAN, rate = speakingRate)
    )[lang]!!
    runner.furhat.voice = petraVoice
}

fun Furhat.setEnglishLanguage() {
    currentLang = Language.ENGLISH_US
    send(ClearScreen())
    send(SetLanguageEvent("en"))
    setLindaVoice(currentLang)
}

fun Furhat.setGermanLanguage() {
    currentLang = Language.GERMAN
    send(ClearScreen())
    send(SetLanguageEvent("de"))
    setLindaVoice(currentLang)
}

fun Furhat.setChineseLanguage() {
    currentLang = Language.MANDARIN
    send(ClearScreen())
    send(SetLanguageEvent("zh"))
    setLindaVoice(currentLang)
}

package furhatos.app.medicalscreener

import furhatos.app.medicalscreener.flow.ClearScreen
import furhatos.app.medicalscreener.flow.SetLanguageEvent
import furhatos.app.medicalscreener.flow.introduction.petraVoice
import furhatos.app.medicalscreener.flow.introduction.petraVoiceF
import furhatos.app.medicalscreener.flow.introduction.petraVoiceM
import furhatos.app.medicalscreener.i18n.I18n
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.event.EventSystem.send
import furhatos.flow.kotlin.Furhat
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.voice.AzureVoice
import furhatos.gestures.Gestures.BigSmile
import furhatos.gestures.Gestures.Nod
import furhatos.gestures.Gestures.Surprise
import furhatos.gestures.Gestures.Thoughtful
import furhatos.gestures.Gestures.Wink
import furhatos.records.Location
import furhatos.skills.FurhatFace
import furhatos.util.Gender
import furhatos.util.Language

var currentLang: Language = Language.SWEDISH

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

fun Furhat.setRobotFace(face: String = "Titan"){
    runner.furhat.character = face
}
fun Furhat.setRobotVoice(lang : Language, gen: Gender = Gender.NEUTRAL) {
    i18n = I18n(lang)
    val speakingRate = 0.95
    petraVoice = mapOf<Language, AzureVoice>(
            Language.ENGLISH_US to AzureVoice(name = "NancyNeural", language = Language.ENGLISH_US, rate = speakingRate),
            Language.MANDARIN to AzureVoice(name="XiaoxiaoNeural", language = Language.MANDARIN, rate = speakingRate),
            Language.SWEDISH to AzureVoice(name = "HilleviNeural", language = Language.SWEDISH, rate = speakingRate)
    )[lang]!!
    petraVoiceM = mapOf<Language, AzureVoice>(
        Language.ENGLISH_US to AzureVoice(name = "BlueNeural", language = Language.ENGLISH_US, rate = speakingRate),
        Language.MANDARIN to AzureVoice(name="YunyiMultilingualNeural", language = Language.MANDARIN, rate = speakingRate),
        Language.SWEDISH to AzureVoice(name = "MattiasNeural", language = Language.SWEDISH, rate = speakingRate)
    )[lang]!!
    petraVoiceF = mapOf<Language, AzureVoice>(
        Language.ENGLISH_US to AzureVoice(name = "Emma-Neural", language = Language.ENGLISH_GB, rate = speakingRate),
        Language.MANDARIN to AzureVoice(name="XiaoxiaoNeural", language = Language.MANDARIN, rate = speakingRate),
        Language.SWEDISH to AzureVoice(name = "SofieNeural", language = Language.SWEDISH, rate = speakingRate)
    )[lang]!!

    when (gen) {
        Gender.MALE -> runner.furhat.voice = petraVoiceM
        Gender.FEMALE -> runner.furhat.voice = petraVoiceF
        Gender.NEUTRAL -> runner.furhat.voice = petraVoice
    }

}

fun Furhat.setEnglishLanguage(gen : Gender = Gender.NEUTRAL) {
    currentLang = Language.ENGLISH_US
    send(ClearScreen())
    send(SetLanguageEvent("en"))
    setRobotVoice(currentLang,gen)
}

fun Furhat.setSwedishLanguage(gen : Gender = Gender.NEUTRAL) {
    currentLang = Language.SWEDISH
    send(ClearScreen())
    send(SetLanguageEvent("sv"))
    setRobotVoice(currentLang,gen)
}

fun Furhat.setChineseLanguage(gen : Gender = Gender.NEUTRAL) {
    currentLang = Language.MANDARIN
    send(ClearScreen())
    send(SetLanguageEvent("zh"))
    setRobotVoice(currentLang, gen)
}

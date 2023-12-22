package furhatos.app.medicalscreener.nlu

import furhatos.app.medicalscreener.i18n.i18n
import furhatos.nlu.Intent
import furhatos.util.Language

class Start : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return i18n.intents.Start.examples
    }
}

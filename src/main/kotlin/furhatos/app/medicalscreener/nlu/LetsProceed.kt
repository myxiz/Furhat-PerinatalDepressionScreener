package furhatos.app.medicalscreener.nlu

import furhatos.app.medicalscreener.i18n.i18n
import furhatos.nlu.Intent
import furhatos.util.Language

class LetsProceed : Intent() {
    override fun getExamples(lang: Language): List<String> =
            i18n.intents.LetsProceed.examples
}
package furhatos.app.medicalscreener.flow.scenes.diabetes

import furhatos.app.medicalscreener.flow.epdsData
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.flow.yesNoQuestion
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.state

val BloodPressureMedicationQuestion: State = state(EPDSQuestionBase) {
    include(
        yesNoQuestion(
            i18n.phrases.DIABETES_BLOOD_PRESSURE_MEDICATION_QUESTION,
            nextState = BloodGlucoseQuestion1,
            onYes = { it.addToScore(2, "BloodPressureMedicationQuestion") },
            onNo = { Unit },
            onMaybe = { it.addToScore(2, "BloodPressureMedicationQuestion") },
            dataGetter = { user -> user.epdsData }
        )
    )
}

package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.Idle
import furhatos.app.medicalscreener.flow.introduction.endAndWriteKpi
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


val MINIQuestionFinished = state(MINIQuestionBase) {
    onEntry {
        furhat.say(i18n.phrases.LAST_QUESTION_MESSAGE)
        users.current.miniData.endTimestamp()
        CoroutineScope(Dispatchers.Default).launch {
            writeKpi(users.current,"MINI finished")
        }
        goto(StandBy)
    }
}
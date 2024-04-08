package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.flow.kotlin.*
import furhatos.app.medicalscreener.flow.scenes.MINIQuestionBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


val MINIQuestionFinished = state(MINIQuestionBase) {
    onEntry {
        furhat.sayAndRecord(i18n.phrases.LAST_QUESTION_MESSAGE)
        users.current.miniData.endTimestamp()
        users.current.interactionInfo.endTimestamp()
        CoroutineScope(Dispatchers.Default).launch {
            writeApi(users.current,"MINI finished")
        }
        goto(StandBy)
    }
}
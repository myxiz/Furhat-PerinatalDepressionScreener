package furhatos.app.medicalscreener.flow

import furhatos.app.medicalscreener.nlu.DEFAULT_ENDSIL_MS
import furhatos.app.medicalscreener.nlu.DEFAULT_MAX_SPEECH_MS
import furhatos.app.medicalscreener.nlu.DEFAULT_NO_SPEECH_MS
import furhatos.flow.kotlin.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun Furhat.askAndDo(
        utterance: Utterance,
        timeout : Int = DEFAULT_NO_SPEECH_MS,
        endSil : Int = DEFAULT_ENDSIL_MS,
        maxSpeech : Int = DEFAULT_MAX_SPEECH_MS,
        DoBlock :  () -> Unit // Todo: Naming
) {
    say(utterance)
    DoBlock()
    listen(timeout = timeout, endSil = endSil, maxSpeech = maxSpeech)
}

fun Furhat.askAndDo(
        utterance: String,
        timeout : Int = DEFAULT_NO_SPEECH_MS,
        endSil : Int = DEFAULT_ENDSIL_MS,
        maxSpeech : Int = DEFAULT_MAX_SPEECH_MS,
        DoBlock :  () -> Unit // Todo: Naming
) {
    say(utterance)
    CoroutineScope(Dispatchers.Default).launch {
        writeApi(users.current,"furhat speaked")
    }
    DoBlock()
    listen(timeout = timeout, endSil = endSil, maxSpeech = maxSpeech)
}
fun Furhat.sayAndRecord(
    utterance: String
) {
    say(utterance)
    CoroutineScope(Dispatchers.Default).launch {
        writeApi(users.current,"furhat speaked")
    }
}
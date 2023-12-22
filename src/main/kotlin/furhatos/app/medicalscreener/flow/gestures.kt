package furhatos.app.medicalscreener.flow

import furhatos.event.senses.SenseSpeechStart
import furhatos.flow.kotlin.*
import furhatos.records.Location
import java.util.concurrent.TimeUnit

val gazeOffsetPositions = listOf(
        Location(0.1, -0.1, 1.2),
        Location(-0.1, -0.1, 1.2)
)

fun FlowControlRunner.randomlyGazeAway(
        maxLength: Long,
        probability: Double,
        endTimeMargin: Int = 1000,
        startDelay: Int = 500,
        offsets: Collection<Location> = gazeOffsetPositions
) {
    /*if (ThreadLocalRandom.current().nextDouble(1.0) <= probability) {
        parallel {
            call(GazeAwayState(maxLength, endTimeMargin, startDelay, offsets))
        }
    }*/
}

private fun GazeAwayState(
        maxLength: Long,
        endTimeMargin: Int = 500,
        startDelay: Int = 500,
        offsets: Collection<Location> = gazeOffsetPositions
): State {
    return state {
        val timeOffset = 250 //ThreadLocalRandom.current().nextInt(startDelay, maxLength.toInt() - endTimeMargin)
        onTime(timeOffset) {
            val offset = random(*offsets.toTypedArray())
            val timeGazingAwayMillis = 250L
            gazeAway(offset, timeGazingAwayMillis)
            terminate()
        }

        onEvent(SenseSpeechStart::class) {
            furhatos.app.medicalscreener.log.debug("Looking back at user")
            furhat.attend(users.current)
            terminate()
        }
    }
}

private fun FlowControlRunner.gazeAway(offset: Location, timeGazingAwayMillis: Long) {
    val newLocation = Location.sum(users.current.head.location, offset)
    furhat.attend(newLocation)
    furhatos.app.medicalscreener.log.debug("Furhat gazes or attends point ${offset} away for ${timeGazingAwayMillis}ms")
    delay(timeGazingAwayMillis, TimeUnit.MILLISECONDS)
    furhat.attend(users.current)
}

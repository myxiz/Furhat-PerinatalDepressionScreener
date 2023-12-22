@file:Suppress("MoveLambdaOutsideParentheses")

package furhatos.app.medicalscreener.flow.introduction

import furhatos.app.medicalscreener.flow.*
import furhatos.event.EventSystem
import furhatos.event.monitors.MonitorSpeechStart
import furhatos.flow.kotlin.*
import furhatos.gestures.BasicParams
import furhatos.gestures.Gestures.Blink
import furhatos.gestures.defineGesture
import furhatos.records.Location

val ParallelEventHandlers : State = state {

    include(automaticBehavior)

    onEvent("GetLanguageGui") {
        log.debug("Gui requested current language")
        EventSystem.send(SetLanguageEvent(furhat.voice.language?.main!!))
    }

    onTime(repeat=3000) {
        furhatos.app.medicalscreener.log.debug("State ${thisState.name} is active")
    }
}


/*
 * ADD SUBTLE BEHAVIOURS TO MAKE THE ROBOT SEEM MORE 'ALIVE'
 */

val automaticBehavior = partialState {

    // Settings:

    val blinkFrequency = 500..5000
    val idleHeadMovementFrequency = 10000..15000
    val lengthOfUtteranceToGazeAway = 3000
    val threshholdForGazeAversion = 0.5
    val gazeAversionMaxStrength = 0.5
    val gazeAversionDurationMultiplier = 0.5 //1.0 -> frame (1.0)-(2.0) and reset at 3.0

    // Function:

    onTime(repeat = blinkFrequency, instant = true) {
        if (furhat.isSpeaking) {
            if (Math.random() > (1.0 / 3.0)) furhat.gesture(Blink)
        } else {
            furhat.gesture(Blink)
        }
    }

    onTime(repeat = idleHeadMovementFrequency, instant = true) {
        furhat.gesture(idleHeadMovements())
    }
    onEvent<MonitorSpeechStart>(instant = true) {
        val length = it.length
        if (length > lengthOfUtteranceToGazeAway) {
            if (Math.random() > threshholdForGazeAversion) {
                parallel(abortOnExit = false) {
                    delay(length / 2L)
                    furhat.gesture(
                            GazeAversion(strength = if (Math.random() > 0.5) -gazeAversionMaxStrength else gazeAversionMaxStrength,
                                    duration = gazeAversionDurationMultiplier
                            )
                    )
                    terminate()
                }
            }
        }
        propagate()
    }
}

fun idleHeadMovements(strength: Double = 1.0, duration: Double = 1.0, amplitude: Double = 5.0, gazeAway: Boolean = false) =
        defineGesture("headMove", strength = strength, duration = duration) {
            val loc = Location(amplitude * getScaleParameter(), amplitude * getScaleParameter(), amplitude * getScaleParameter())
            frame(1.5, 8.5) {
                /* but i don't think these values are respected at all! */
                BasicParams.NECK_TILT to loc.x
                BasicParams.NECK_ROLL to loc.y
                BasicParams.NECK_PAN to loc.z
            }
            /* this gaze-movement only happens about once every five times the neck moves */
            if (gazeAway) {
                //if (Math.random() < 0.2) {
                frame(0.0, 1.25) {
                    BasicParams.GAZE_PAN to 0
                    BasicParams.GAZE_TILT to 0
                }
                frame(1.5, 2.5) {
                    BasicParams.GAZE_PAN to loc.x
                    BasicParams.GAZE_TILT to loc.y
                }
                frame(2.75, 3.0) {
                    BasicParams.GAZE_PAN to 0
                    BasicParams.GAZE_TILT to 0
                }
            }
            reset(10.0)
        }

fun getPlusMinusUnit(): Double {
    return if (Math.random() < 0.5)
        -1.0 // negative
    else
        +1.0 // positive
}

fun getScaleParameter(): Double {
    return getPlusMinusUnit() * (Math.random() + 0.5)
}

fun GazeAversion(strength: Double = 1.0, duration: Double = 1.0) =
        defineGesture("GazeAway", strength, duration) {
            frame((1.0 * duration), (2.0 * duration)) {
                BasicParams.GAZE_PAN to (20 * strength)
                BasicParams.GAZE_TILT to (20 * strength)
            }
            reset(3.0 * duration)
        }
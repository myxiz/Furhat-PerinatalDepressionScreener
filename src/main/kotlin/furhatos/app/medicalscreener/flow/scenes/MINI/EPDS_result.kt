package furhatos.app.medicalscreener.flow.scenes.MINI

import furhatos.app.medicalscreener.flow.*
import furhatos.app.medicalscreener.flow.introduction.Goodbye
import furhatos.app.medicalscreener.flow.scenes.EPDSQuestionBase
import furhatos.app.medicalscreener.flow.introduction.StartOver
import furhatos.app.medicalscreener.i18n.i18n
import furhatos.app.medicalscreener.nlu.ImDone
import furhatos.app.medicalscreener.nlu.RepeatQuestion
import furhatos.app.medicalscreener.nlu.ThankYou
import furhatos.flow.kotlin.*
import furhatos.records.Location
import furhatos.util.CommonUtils

private val log = CommonUtils.getLogger(EPDSQuestionBase::class.java)!!

val EPDS_Results = state(WaitForCommand(nextState = StartOver)) {
    onEntry {
        val user = this.users.current
        val epdsData = user.epdsData
        epdsData.completed = true
        users.current.epdsData.endTimestamp()
        log.debug("Completed EPDS screening. Data: $epdsData")

        log.debug("Waiting for user to continue")
        writeKpi(users.current, "Screening Completed")

        val isPositive = epdsData.score >= 12

        send(ShowResultsEvent("EPDS", isPositive, epdsData.score))
        furhat.ask {
            +attend(Location.DOWN)
            +i18n.phrases.EPDS_READ_RESULTS_1
            +attend(user)
        }
    }

    onResponse<RepeatQuestion> {
        furhat.ask {
            +i18n.phrases.EPDS_READ_RESULTS_1
            +attend(users.current)
        }
    }

    onResponse<ThankYou> { goto(Goodbye) }
    onResponse<ImDone> { goto(Goodbye) }

    onUserLeave(instant = true) {
        when {
            users.current == it -> { // user.other == it means that there is no other user
                furhatos.app.medicalscreener.log.debug("Current user ${it.id} left at state ${this.currentState.name}")
                goto(Goodbye)
            }
            users.count < 1 -> {
                furhatos.app.medicalscreener.log.debug("the last user left while being unattended")
                goto(Goodbye)
            }
            else -> {
                furhatos.app.medicalscreener.log.debug("Someone who is not the user left (user ${it.id})")
                furhat.glance(it)
            }
        }
    }
}
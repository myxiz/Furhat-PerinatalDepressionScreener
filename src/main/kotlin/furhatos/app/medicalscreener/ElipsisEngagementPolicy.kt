package furhatos.app.medicalscreener

import furhatos.event.EventSystem
import furhatos.event.senses.SenseInteractionSpaces
import furhatos.event.senses.SenseUserEnter
import furhatos.event.senses.SenseUserLeave
import furhatos.records.Ellipse
import furhatos.records.Space
import furhatos.skills.EngagementPolicy
import furhatos.skills.UserManager

class EllipseEngagementPolicy(
        private val userManager: UserManager,
        private val maxUsers: Int,
        innerRadiusX: Double,
        innerRadiusZ: Double = innerRadiusX,
        outerRadiusX: Double,
        outerRadiusZ: Double = outerRadiusX
) : EngagementPolicy {

    private val spaces: List<Space>
    private val innerSpace: Space
    private val outerSpace: Space

    init {
        if (innerRadiusX > outerRadiusX || innerRadiusZ > outerRadiusZ) {
            throw IllegalArgumentException("Inner space has to be fully contained by outer space")
        }
        this.innerSpace = Ellipse("inner", userManager.robotLocation, innerRadiusX, innerRadiusZ)
        this.outerSpace = Ellipse("outer", userManager.robotLocation, outerRadiusX, outerRadiusZ)
        this.spaces = listOf(innerSpace, outerSpace)
    }

    override fun checkEngagement() {
        val engagedUsers = userManager.list.map { user -> user.id }

        userManager.all.forEach { user ->
            if (!user.isEngaged && user.isVisible && innerSpace.contains(user.head.location)) {
                // User entered
                if (userManager.count < maxUsers) {
                    user.isEngaged = true
                    sendSenseEnter(user.id)
                }
            } else if (user.isEngaged && (!user.isVisible || !outerSpace.contains(user.head.location))) {
                // User left
                user.isEngaged = false
                sendSenseLeave(user.id)
            }
        }

        val newEngagedUsers = userManager.list.map { user -> user.id }

        if (engagedUsers != newEngagedUsers) {
            userManager.sendUserStatus()
        }
    }

    override fun requestInteractionSpaces() {
        EventSystem.send(SenseInteractionSpaces.Builder().spaces(spaces).buildEvent())
    }

    private fun sendSenseLeave(userId: String) {
        val senseUserLeave = SenseUserLeave.Builder()
                .userId(userId)
        EventSystem.send(senseUserLeave.buildEvent())
    }

    private fun sendSenseEnter(userId: String) {
        val senseUserEnter = SenseUserEnter.Builder()
                .userId(userId)
        EventSystem.send(senseUserEnter.buildEvent())
    }
}

fun screenerPolicy(userManager: UserManager): EngagementPolicy {
    return EllipseEngagementPolicy(
            userManager = userManager,
            maxUsers = 1,
            innerRadiusX = 1.2,
            innerRadiusZ = 1.2,
            outerRadiusX = 1.8,
            outerRadiusZ = 1.3
    )
}

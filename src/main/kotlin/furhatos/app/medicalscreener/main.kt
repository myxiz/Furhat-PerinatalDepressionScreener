package furhatos.app.medicalscreener

import furhatos.app.medicalscreener.flow.initGUI
import furhatos.skills.Skill
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils
import kotlinx.coroutines.*


class ScreenerSkill : Skill() {
    override fun start() {
        initGUI()

        val flow = Flow()
        flow.flowLogger
        flow.run(furhatos.app.medicalscreener.flow.introduction.Idle)
    }
}

val log = CommonUtils.getLogger(ScreenerSkill::class.java)

var userName: String? = ""

fun readName() {
    userName = readlnOrNull()

    // Check if the input is not null before using it
    if (userName != null && userName!!.isNotEmpty()) {
        println("Hello, $userName!")
    } else {
        println("No name was entered.")
    }
}

fun main(args: Array<String>) {

    Skill.main(args)
}

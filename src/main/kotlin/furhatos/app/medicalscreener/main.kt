package furhatos.app.medicalscreener

import furhatos.app.medicalscreener.flow.initGUI
import furhatos.skills.Skill
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils


class ScreenerSkill : Skill() {
    override fun start() {
        initGUI()

        val flow = Flow()
        flow.flowLogger
        flow.run(furhatos.app.medicalscreener.flow.introduction.Idle)
    }
}

val log = CommonUtils.getLogger(ScreenerSkill::class.java)!!

var name: String? = ""

fun readName() {
    name = readlnOrNull()

    // Check if the input is not null before using it
    if (name != null && name!!.isNotEmpty()) {
        println("Hello, $name!")
    } else {
        println("No name was entered.")
    }
}

fun main(args: Array<String>) {
    println("Please enter user name:")
    readName()
    // Read a line of input from the command line
    Skill.main(args)
}

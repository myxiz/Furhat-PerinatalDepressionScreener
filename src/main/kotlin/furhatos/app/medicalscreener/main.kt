package furhatos.app.medicalscreener

import furhatos.app.medicalscreener.flow.initGUI
import furhatos.skills.Skill
import furhatos.flow.kotlin.*
import furhatos.util.CommonUtils
import kotlinx.coroutines.*

var userName : String = ""
var IP : String? = null
val IP_ARRAY = arrayOf("10.0.1.2:5001", "130.238.16.96:5001", "localhost:5001")

class ScreenerSkill : Skill() {
    override fun start() {
        initGUI()

        val flow = Flow()
        flow.flowLogger
        flow.run(furhatos.app.medicalscreener.flow.introduction.Idle)
    }
}

val log = CommonUtils.getLogger(ScreenerSkill::class.java)

fun main(args: Array<String>) {
    Skill.main(args)
}

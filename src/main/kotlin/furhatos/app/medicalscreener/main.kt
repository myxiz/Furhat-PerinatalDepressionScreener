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

fun main(args: Array<String>) {
    Skill.main(args)
}

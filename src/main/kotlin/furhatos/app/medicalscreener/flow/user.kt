package furhatos.app.medicalscreener.flow

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
import com.eclipsesource.json.JsonValue
import furhatos.app.medicalscreener.userName
import furhatos.flow.kotlin.NullSafeUserDataDelegate
import furhatos.flow.kotlin.users
import furhatos.records.Record
import furhatos.records.User
import furhatos.util.Gender
import java.time.LocalDateTime

interface Completable {
    var completed: Boolean
}

interface Timestamped {
    var startTime: LocalDateTime?
    var endTime: LocalDateTime?
    fun startTimestamp() {
        startTime = LocalDateTime.now()
    }

    fun endTimestamp() {
        endTime = LocalDateTime.now()
    }

    fun reset() {
        startTime = null
        endTime = null
    }
}

data class PersonalizationData(
    var genderMatters : Boolean = false,
    var gender :Gender = Gender.NEUTRAL,
    var mask: String? = "none",
    var remember : Boolean = true,
    override var startTime: LocalDateTime? = null,
    override var endTime: LocalDateTime? = null
) : Timestamped, Record()


val User.personaliztionData : PersonalizationData
    get() = data.getOrPut(PersonalizationData::class.qualifiedName, PersonalizationData())

data class EpdsData(
    var score: Int = 0,
    var consent : String? = null ,
    var biologicalSex: Int? = null,
    var e1 : Int? = null,
    var e2 : Int? = null,
    var e4 : Int? = null,
    var e5 : Int? = null,
    var e3 : Int? = null,
    var e6 : Int? = null,
    var e7 : Int? = null,
    var e8 : Int? = null,
    var e9 : Int? = null,
    var e10 : Int? = null,
    override var completed: Boolean = false,
    override var startTime: LocalDateTime? = null,
    override var endTime: LocalDateTime? = null
) : Completable, Timestamped, Record() {
    fun addToScore(points : Int, question: String? = null) {
        score += points
        if (question != null) {
            println("$question - Added $points to score.")
            println("$question - Current score: $score.")
        } else {
            println("Added $points to score.")
            println("Current score: $score.")
        }
    }
    override fun reset() {
        println("resetting user: $this")
        score = 0
        completed = false
        e1 = null
        e2 = null
        e4 = null
        e5 = null
        e3 = null
        e6 = null
        e7 = null
        e8 = null
        e9 = null
        e10= null
        super.reset()
    }
}
data class MiniData(
    var score: Int = 0,
    var consent : String? = null ,
    // Group A Variables
    var A1a: Int? = null,
    var A1b: Int? = null,
    var A2a: Int? = null,
    var A2b: Int? = null,
    var A3a: Int? = null,
    var A3b: Int? = null,
    var A3c: Int? = null,
    var A3d: Int? = null,
    var A3e: Int? = null,
    var A3e_Delu: Int? = null,
    var A3f: Int? = null,
    var A3g: Int? = null,
    var A4: Int? = null,
    var A5: Int? = null,
    var A6: Int? = null,

// Group B Variables
    var B1: Int? = null,
    var B1a: Int? = null,
    var B1b: Int? = null,
    var B2: Int? = null,
    var B3: Int? = null,
    var B3_fre: Int? = null,
    var B3_int: Int? = null,

// Group C Variables
    var C1a: Int? = null,
    var C1b: Int? = null,
    var C2a: Int? = null,
    var C2b: Int? = null,
    var C3: Int? = null,
    var C3a: Int? = null,
    var C3a_delu: Int? = null,
    var C3b: Int? = null,
    var C3c: Int? = null,
    var C3d: Int? = null,
    var C3e: Int? = null,
    var C3f: Int? = null,
    var C3g: Int? = null,
    var C4: Int? = null,
    var C5: Int? = null,
    var C6: Int? = null,
    var C7: Int? = null,
    var C8a: Int? = null,
    var C8b: Int? = null,
    var C8c: Int? = null,

// Group Ongoing and Period Indicator Variables
    var OngoingA: Int? = null,
    var OngoingC: Int? = null,
    var PeriodIndicatorA: Int? = null,

// Group Hypomania, Depression, and Mania Variables
    var Hypoman_current: Int? = null,
    var Hypoman_past: Int? = null,
    var HypomanSyptom_current: Int? = null,
    var HypomanSyptom_past: Int? = null,
    var Manic_past: Int? = null,
    var Depression_current: Int? = null,
    var Depression_previous: Int? = null,
    var Depression_recurrent: Int? = null,

    override var completed: Boolean = false,
    override var startTime: LocalDateTime? = null,
    override var endTime: LocalDateTime? = null
) : Completable, Timestamped, Record() {
    fun addToScore(points : Int, question: String? = null) {
        score += points
        if (question != null) {
            println("$question - Added $points to score.")
            println("$question - Current score: $score.")
        } else {
            println("Added $points to score.")
            println("Current score: $score.")
        }
    }
    override fun reset() {
        println("resetting user: $this")
        score = 0
        completed = false
        super.reset()
    }
}

val User.epdsData: EpdsData
    get() = data.getOrPut(EpdsData::class.qualifiedName, EpdsData())

val User.miniData: MiniData
    get() = data.getOrPut(MiniData::class.qualifiedName, MiniData())


val User.name: String?
    get() = data.getOrPut("name", userName)

var User.numNoResponse: Int
    get() = data.getOrPut("numNoResponse", 0)
    set(value) = data.put("numNoResponse", value)

var User.showScreeningButtons: Boolean
    get() = data.getOrPut("showScreeningButtons", false)
    set(v) = data.put("showScreeningButtons", v)

data class InteractionInfo(
    var robotOnTime: LocalDateTime? = null,
    override var startTime: LocalDateTime? = null,
    override var endTime: LocalDateTime? = null
) : Timestamped, Record()

val User.interactionInfo: InteractionInfo
    get() = data.getOrPut("interactionInfo", InteractionInfo())

var User.restarted: Boolean
    get() = data.getOrPut("restarted", false)
    set(value) = data.put("restarted", value)

fun User.reset() {
    epdsData.reset()
    miniData.reset()
    restarted = true
}

fun User.asJson(phase: String) =
    JsonObject()
        .add("name", userName)
        .add("id", id)
        .add("epdsData", JsonObject()
            .add("completed", epdsData.completed)
            .add("score", epdsData.score)
            .add("e1", epdsData.e1?.toString())
            .add("e2", epdsData.e2?.toString())
            .add("e3", epdsData.e3?.toString())
            .add("e4", epdsData.e4?.toString())
            .add("e5", epdsData.e5?.toString())
            .add("e6", epdsData.e6?.toString())
            .add("e7", epdsData.e7?.toString())
            .add("e8", epdsData.e8?.toString())
            .add("e9", epdsData.e9?.toString())
            .add("e10", epdsData.e10?.toString())
            .add("startTime", epdsData.startTime?.toString())
            .add("endTime", epdsData.endTime?.toString())
        )
        .add("personalization", JsonObject()
            .add("mask", personaliztionData.mask)
            .add("genderMatters", personaliztionData.genderMatters)
            .add("gender", personaliztionData.gender.toString())
            .add("remember", personaliztionData.remember)
            .add("startTime", epdsData.startTime?.toString())
            .add("endTime", epdsData.endTime?.toString())
        )
        .add("interactionInfo", JsonObject()
//            .add("robotOnTime", interactionInfo.robotOnTime?.toString())
            .add("startTime", interactionInfo.startTime?.toString())
            .add("endTime", interactionInfo.endTime?.toString()))
        .add("timeStamp",LocalDateTime.now().toString())
        .add("phase", phase)


fun User.setMiniScore(key: String, score: Int?) {
    when (key) {
        "A1a" -> miniData.A1a = score
        "A1b" -> miniData.A1b = score
        "A2a" -> miniData.A2a = score
        "A2b" -> miniData.A2b = score
        "A3a" -> miniData.A3a = score
        "A3b" -> miniData.A3b = score
        "A3c" -> miniData.A3c = score
        "A3d" -> miniData.A3d = score
        "A3e" -> miniData.A3e = score
        "A3e_Delu" -> miniData.A3e_Delu = score
        "A3f" -> miniData.A3f = score
        "A3g" -> miniData.A3g = score
        "A4" -> miniData.A4 = score
        "A5" -> miniData.A5 = score
        "A6" -> miniData.A6 = score
        "B1" -> miniData.B1 = score
        "B1a" -> miniData.B1a = score
        "B1b" -> miniData.B1b = score
        "B2" -> miniData.B2 = score
        "B3" -> miniData.B3 = score
        "B3_fre" -> miniData.B3_fre = score
        "B3_int" -> miniData.B3_int = score
        "C1a" -> miniData.C1a = score
        "C1b" -> miniData.C1b = score
        "C2a" -> miniData.C2a = score
        "C2b" -> miniData.C2b = score
        "C3" -> miniData.C3 = score
        "C3a" -> miniData.C3a = score
        "C3a_delu" -> miniData.C3a_delu = score
        "C3b" -> miniData.C3b = score
        "C3c" -> miniData.C3c = score
        "C3d" -> miniData.C3d = score
        "C3e" -> miniData.C3e = score
        "C3f" -> miniData.C3f = score
        "C3g" -> miniData.C3g = score
        "C4" -> miniData.C4 = score
        "C5" -> miniData.C5 = score
        "C6" -> miniData.C6 = score
        "C7" -> miniData.C7 = score
        "C8a" -> miniData.C8a = score
        "C8b" -> miniData.C8b = score
        "C8c" -> miniData.C8c = score
        "OngoingA" -> miniData.OngoingA = score
        "OngoingC" -> miniData.OngoingC = score
        "PeriodIndicatorA" -> miniData.PeriodIndicatorA = score
        "Hypoman_current" -> miniData.Hypoman_current = score
        "Hypoman_past" -> miniData.Hypoman_past = score
        "HypomanSyptom_current" -> miniData.HypomanSyptom_current = score
        "HypomanSyptom_past" -> miniData.HypomanSyptom_past = score
        "Manic_past" -> miniData.Manic_past = score
        "Depression_current" -> miniData.Depression_current = score
        "Depression_previous" -> miniData.Depression_previous = score
        "Depression_recurrent" -> miniData.Depression_recurrent = score
        // Ensure all properties are covered
    }
    furhatos.app.medicalscreener.log.info("minidata $key : $score saved in : ${miniData}")
}

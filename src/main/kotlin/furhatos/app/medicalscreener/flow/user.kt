package furhatos.app.medicalscreener.flow

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
import com.eclipsesource.json.JsonValue
import furhatos.flow.kotlin.NullSafeUserDataDelegate
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
    var biologicalSex: String? = null,
    var e1 : Int = -99,
    var e2 : Int = -99,
    var e4 : Int = -99,
    var e5 : Int = -99,
    var e3 : Int = -99,
    var e6 : Int = -99,
    var e7 : Int = -99,
    var e8 : Int = -99,
    var e9 : Int = -99,
    var e10 : Int = -99,
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

var User.numNoResponse: Int
    get() = data.getOrPut("numNoResponse", 0)
    set(value) = data.put("numNoResponse", value)

var User.showScreeningButtons: Boolean
    get() = data.getOrPut("showScreeningButtons", false)
    set(v) = data.put("showScreeningButtons", v)

enum class Sex {
    Male,
    Female,
    Unspecified,
    Unknown
}

var User.sex: Sex
    get() = data.getOrPut("sex", Sex.Unknown)
    set(sex) = data.put("sex", sex)





abstract class UserAge {
    class UnknownAge : UserAge() {
        override fun toJSON() = Json.value("UnknownAge")
    }

    data class SpecificAge(val age: Int) : UserAge() {
        override fun toJSON(): JsonValue = Json.value(age)
    }

    data class AgeCategory(val category: AgeCategories) : UserAge() {
        override fun toJSON(): JsonValue = Json.value(category.name)
    }

    enum class AgeCategories {
        YoungerThan40,
        Between40to49,
        Between50to59,
        Over60
    }

    abstract fun toJSON(): JsonValue
}

var User.userAge: UserAge
    get() = data.getOrPut("userAge", UserAge.UnknownAge())
    set(value) = data.put("userAge", value)

var User.height : Int by NullSafeUserDataDelegate { 0 }
var User.weight : Int by NullSafeUserDataDelegate { 0 }

data class InteractionInfo(
    override var startTime: LocalDateTime? = null,
    override var endTime: LocalDateTime? = null
) : Timestamped, Record()

val User.interactionInfo: InteractionInfo
    get() = data.getOrPut("interactionInfo", InteractionInfo())

var User.restarted: Boolean
    get() = data.getOrPut("restarted", false)
    set(value) = data.put("restarted", value)

fun User.reset() {
    userAge = UserAge.UnknownAge()
    sex = Sex.Unknown
    epdsData.reset()
    restarted = true
}

fun User.asJson(phase: String) =
    JsonObject()
        .add("epdsData", JsonObject()
            .add("completed", epdsData.completed)
            .add("score", epdsData.score)
            .add("e1", epdsData.e1)
            .add("e2", epdsData.e2)
            .add("e3", epdsData.e3)
            .add("e4", epdsData.e4)
            .add("e5", epdsData.e5)
            .add("e6", epdsData.e6)
            .add("e7", epdsData.e7)
            .add("e8", epdsData.e8)
            .add("e9", epdsData.e9)
            .add("e10", epdsData.e10)
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
        .add("sex", sex.name)
        .add("interactionInfo", JsonObject()
            .add("startTime", interactionInfo.startTime?.toString())
            .add("endTime", interactionInfo.endTime?.toString()))
        .add("age", userAge.toJSON())
        .add("id", id)
        .add("phase", phase)


package furhatos.app.medicalscreener.flow

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
import com.eclipsesource.json.JsonValue
import furhatos.flow.kotlin.NullSafeUserDataDelegate
import furhatos.records.Record
import furhatos.records.User
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

data class DiabetesData(
        var score: Int = 0,
        var biologicalSex: String? = null,
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

val User.diabetesData: DiabetesData
    get() = data.getOrPut(DiabetesData::class.qualifiedName, DiabetesData())

var User.numNoResponse: Int
    get() = data.getOrPut("numNoResponse", 0)
    set(value) = data.put("numNoResponse", value)

var User.showSscreeningButtons: Boolean
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
    diabetesData.reset()
    restarted = true
}

fun User.asJson(phase: String) =
        JsonObject()
                .add("diabetesData", JsonObject()
                        .add("completed", diabetesData.completed)
                        .add("score", diabetesData.score)
                        .add("startTime", diabetesData.startTime?.toString())
                        .add("endTime", diabetesData.endTime?.toString())
                )
                .add("sex", sex.name)
                .add("interactionInfo", JsonObject()
                        .add("startTime", interactionInfo.startTime?.toString())
                        .add("endTime", interactionInfo.endTime?.toString()))
                .add("age", userAge.toJSON())
                .add("id", id)
                .add("phase", phase)


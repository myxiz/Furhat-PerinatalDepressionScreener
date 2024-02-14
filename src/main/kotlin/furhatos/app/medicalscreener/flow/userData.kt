package furhatos.app.medicalscreener.flow

import furhatos.app.medicalscreener.ScreenerSkill
import furhatos.records.User
import furhatos.util.CommonUtils
import java.io.IOException
import java.nio.file.Paths
import java.time.LocalDateTime
import kotlin.io.resolve


private val BASE_DIR = Paths.get(System.getProperty("user.home")).toFile().resolve("logs/screener")
private val dirCreated = BASE_DIR.mkdirs()
private val OUTPUT_FILE = BASE_DIR.resolve("kpi-${LocalDateTime.now()}")

private val bufferedWriter = OUTPUT_FILE.bufferedWriter()

private val log = CommonUtils.getLogger(ScreenerSkill::class.java)!!

fun writeKpi(user: User, phase: String) {
    log.info("writing to: $OUTPUT_FILE")
    try {
        bufferedWriter.append("time stamp: ${LocalDateTime.now()},")
        bufferedWriter.appendln("${user.asJson(phase)},")
        bufferedWriter.flush()
    } catch (e: IOException) {
        log.warn("KPI written to log instead of file (${OUTPUT_FILE.absolutePath}):\n${user.asJson(phase)},")
    }
}


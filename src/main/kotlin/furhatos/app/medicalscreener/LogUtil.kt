package furhatos.app.medicalscreener

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.statement.*

suspend fun customizedLog(content: String){
    HttpClient().use { client ->
        try {
//            val response: HttpResponse = client.post("http://localhost:5001") {
//            val postResponse: HttpResponse = client.post("http://130.238.16.96:5001/log") {
            val postResponse: HttpResponse = client.post("http://10.0.1.3:5001/log") {
                    contentType(ContentType.Application.Json)
                    setBody(content)

            }
//            val getResponse = client.get("http://localhost:5001/user") {
//            }
            log.info("Writing to the web logger:  Response status: ${postResponse.status}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

suspend fun getUsername(): String? {
    HttpClient().use { client ->
        try {
//Local run
//            val response: HttpResponse = client.post("http://localhost:5001") {
//Ethernet IP
//            val getResponse = client.get("http://130.238.16.96:5001/user") {
//Lab router
            val getResponse = client.get("http://10.0.1.3:5001/user") {
            }
            userName = getResponse.bodyAsText()
            log.info("Web: Got User Name: $userName")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    return userName
}

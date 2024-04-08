package furhatos.app.medicalscreener

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.statement.*

suspend fun test_IP(IP_array: Array<String> ): String? {
    val client = HttpClient() // Consider reusing the client or providing it externally for efficiency
    IP_array.forEach { ip ->
        try {
            val url = "http://$ip/log" // Ensure your IP array does not contain protocol part
            val postResponse: HttpResponse = client.post(url) {
                contentType(ContentType.Application.Json)
                setBody("testing IP")
            }
            if (postResponse.status == HttpStatusCode.OK) {
                log.info("Connected to $ip")
                client.close()
                return ip // Return the working IP
            }
        } catch (e: Exception) {
        }
    }
    client.close()
    return null // Return null or throw if no IP worked
}

suspend fun customizedLog(content: String){
    HttpClient().use { client ->
        try {
            val postResponse: HttpResponse = client.post("http://$IP/log") {
                    contentType(ContentType.Application.Json)
                    setBody(content)
            }
            log.info("Writing to the web logger:  Response status: ${postResponse.status}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

suspend fun getUsername(): String? {
    HttpClient().use { client ->
        try {
            val getResponse = client.get("http://$IP/user") {
            }
            userName = getResponse.bodyAsText()
            log.info("Web: Got User Name: $userName")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    return userName
}

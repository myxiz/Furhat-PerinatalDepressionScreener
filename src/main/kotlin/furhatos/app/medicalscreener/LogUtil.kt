package furhatos.app.medicalscreener

import io.ktor.client.*
import io.ktor.client.request.*

suspend fun customizedLog(content: String){
    val client = HttpClient()
    client.post("http://localhost:5001"){
        setBody(content)
    }
}
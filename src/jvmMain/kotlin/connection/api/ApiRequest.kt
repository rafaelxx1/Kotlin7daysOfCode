package connection.api

import com.google.gson.Gson
import model.Adress
import okhttp3.*


fun main(){

    val http = "https://viacep.com.br/ws/13052634/json/"
    val json = getJsonObj(httpConnectionApi(http))

    println(json?.toString())

}
fun httpConnectionApi(urlApi: String): String? {
    val client = OkHttpClient()

    //create http get request with url
    val request = Request.Builder()
        .url(urlApi)
        .build()

    val response = client.newCall(request).execute()

    if (response.isSuccessful) {
        val responseBody = response.body?.string()
        return responseBody
    } else {
        println("error response: ${response.code}")
        return null
    }
}

fun getJsonObj(json: String?): Adress? {
    val gson = Gson()
    return gson.fromJson(json, Adress::class.java)
}
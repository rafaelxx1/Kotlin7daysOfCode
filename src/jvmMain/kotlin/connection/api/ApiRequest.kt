package connection.api

import okhttp3.*

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
package com.example.celebrity.model.api

import com.example.celebrity.model.entity.Celebrity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CelebrityApi {
    @Headers("X-Api-Key: Dbhkflwz0zPbL8UfR7Y45w==5BJ3irJQzQU0XR8I")
    @GET("celebrity?name=michael")
    fun fetchCelebrityList(@Query("name") name: String): Call<List<Celebrity>>
}
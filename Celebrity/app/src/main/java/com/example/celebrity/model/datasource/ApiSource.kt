package com.example.celebrity.model.datasource

import com.example.celebrity.model.api.CelebrityApi
import com.example.celebrity.model.entity.Celebrity
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiSource {

    private val gson = Gson()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val instance: CelebrityApi = retrofit.create(CelebrityApi::class.java)
}
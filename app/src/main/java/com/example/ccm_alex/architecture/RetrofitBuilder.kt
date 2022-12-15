package com.example.ccm_alex.architecture

import com.example.ccm_alex.memes.data.remote.MemesEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.imgflip.com/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getMemes(): MemesEndpoint = retrofit.create(MemesEndpoint::class.java)
}

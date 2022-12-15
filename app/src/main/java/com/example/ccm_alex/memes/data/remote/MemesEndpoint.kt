package com.example.ccm_alex.memes.data.remote

import com.example.ccm_alex.memes.data.model.JsonFull
import retrofit2.http.GET

interface MemesEndpoint {
    @GET("get_memes")
    suspend fun getMemes() : JsonFull
}
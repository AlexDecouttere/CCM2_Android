package com.example.ccm_alex.memes.domaine.repository

import androidx.lifecycle.LiveData
import com.example.ccm_alex.memes.domaine.model.MemesDomain

interface MemesRepository {

    // Get all ChuckNorris quote from database
    fun selectAllMemes(): LiveData<List<MemesDomain>>

    // Delete all content in the table
    suspend fun deleteMemes()

    // Fetch a new quote randomly and add it inside database
    suspend fun fetchData()
}
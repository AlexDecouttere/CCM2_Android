package com.example.ccm_alex.memes.domaine.useCase

import androidx.lifecycle.LiveData
import com.example.ccm_alex.memes.data.repository.MemesRepositoryImpl
import com.example.ccm_alex.memes.domaine.model.MemesDomain
import com.example.ccm_alex.memes.domaine.repository.MemesRepository

class UseCase {

    private val memesRepository: MemesRepository by lazy { MemesRepositoryImpl() }

    suspend fun deleteMemes() {
        memesRepository.deleteMemes()
    }
    suspend fun fetchData() {
        memesRepository.fetchData()
    }
    fun selectAllMemes(): LiveData<List<MemesDomain>> {
        return memesRepository.selectAllMemes()
    }
}
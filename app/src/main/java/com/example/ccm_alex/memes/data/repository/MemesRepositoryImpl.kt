package com.example.ccm_alex.memes.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.ccm_alex.architecture.CustomApplication
import com.example.ccm_alex.architecture.RetrofitBuilder
import com.example.ccm_alex.memes.data.mapper.fromRoomToDomain
import com.example.ccm_alex.memes.data.mapper.toRoom
import com.example.ccm_alex.memes.data.model.MemesRoom
import com.example.ccm_alex.memes.domaine.model.MemesDomain
import com.example.ccm_alex.memes.domaine.repository.MemesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MemesRepositoryImpl: MemesRepository {

    private val mMemesDao = CustomApplication.instance.mApplicationDatabase.mMemesDao()

    override fun selectAllMemes(): LiveData<List<MemesDomain>> {
        return mMemesDao.selectAll().map {
            it.fromRoomToDomain()
        }
    }
    
    private suspend fun insertMeme(meme: MemesRoom) =
        withContext(Dispatchers.IO) {
            mMemesDao.insert(meme)
        }
    
    override suspend fun deleteMemes() = withContext(Dispatchers.IO) {
        mMemesDao.deleteAll()
    }

    override suspend fun fetchData() {
        insertMeme(RetrofitBuilder.getMemes().getMemes().data.memes[ Random.nextInt(0, 99)].toRoom())
    }
}


package com.example.ccm_alex.memes.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.ccm_alex.architecture.CustomApplication
import com.example.ccm_alex.architecture.CustomRoomDatabase
import com.example.ccm_alex.architecture.RetrofitBuilder
import com.example.ccm_alex.memes.model.Memes
import com.example.ccm_alex.memes.model.MemesRetrofit
import com.example.ccm_alex.memes.model.MemesRoom
import com.example.ccm_alex.memes.model.MemesSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.log
import kotlin.random.Random

class MemesRepository {

    private val mMemesDao = CustomApplication.instance.mApplicationDatabase.mMemesDao()



    fun selectAllMemes(): LiveData<List<MemesSample>> {
        return mMemesDao.selectAll().map {
            it.map {
                MemesSample(
                    name = it.name,
                    url = it.image
                )
            }
        }
    }


    private suspend fun insertMeme(meme: MemesRoom) =
        withContext(Dispatchers.IO) {
            mMemesDao.insert(meme)
        }


    suspend fun deleteMemes() = withContext(Dispatchers.IO) {
        mMemesDao.deleteAll()
    }

    suspend fun fetchData() {
        val a = RetrofitBuilder.getMemes()
        Log.d("memes: ","memes: " + a)

        insertMeme(RetrofitBuilder.getMemes().getMemes().data.memes[ Random.nextInt(0, 99)].toRoom())
    }
}


private fun Memes.toRoom(): MemesRoom {
    return MemesRoom(
        name = name,
        image = url
    )
}

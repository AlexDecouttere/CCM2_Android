package com.example.ccm_alex.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ccm_alex.memes.model.MemesRoom

@Dao
interface MemesDao {
    @Query("SELECT * FROM meme_object_table")
    fun selectAll() : LiveData<List<MemesRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memesRoom: MemesRoom)

    @Query("DELETE FROM meme_object_table")
    fun deleteAll()
}
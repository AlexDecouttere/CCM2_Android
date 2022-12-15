package com.example.ccm_alex.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccm_alex.dao.MemesDao
import com.example.ccm_alex.dao.PhoneDataDao
import com.example.ccm_alex.memes.data.model.MemesRoom
import com.example.ccm_alex.androidVersion.view.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class,
        MemesRoom::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mPhoneDataDao() : PhoneDataDao
    abstract fun mMemesDao() : MemesDao
}

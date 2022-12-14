package com.example.ccm_alex.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ccm_alex.Dao.MemesDao
import com.example.ccm_alex.Dao.PhoneDataDao
import com.example.ccm_alex.memes.model.MemesRoom
import com.example.ccm_alex.view.LocalDataSourceSample

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

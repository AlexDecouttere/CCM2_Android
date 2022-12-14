package com.example.ccm_alex.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccm_alex.Dao.PhoneDataDao
import com.example.ccm_alex.view.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mPhoneDataDao() : PhoneDataDao
}

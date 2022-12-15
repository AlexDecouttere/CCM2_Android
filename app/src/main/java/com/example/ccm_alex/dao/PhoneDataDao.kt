package com.example.ccm_alex.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ccm_alex.androidVersion.view.LocalDataSourceSample

@Dao
interface PhoneDataDao {

    @Query("SELECT * FROM phone_object_table ORDER BY phoneName ASC")
    fun selectAll(): LiveData<List<LocalDataSourceSample>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(phoneData: LocalDataSourceSample)

    @Query("DELETE FROM phone_object_table")
    fun deleteAll()
}

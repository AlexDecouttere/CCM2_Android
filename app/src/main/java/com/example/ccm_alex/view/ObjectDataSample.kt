package com.example.ccm_alex.view

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class MyObjectForRecyclerView()

data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView()

data class ObjectDataFooterSample(
    val footer: String
) : MyObjectForRecyclerView()

data class ObjectDataSample(
    val drawable: String,
    val phoneName: String,
    val osName: String
):MyObjectForRecyclerView()

@Entity(tableName = "phone_object_table")
data class LocalDataSourceSample(
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "phoneName")
    val name: String,
    @ColumnInfo(name = "osName")
    val os: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


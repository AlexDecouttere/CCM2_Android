package com.example.ccm_alex.memes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/** Object use for retrofit */
data class JsonFull(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data: Data = Data(),
)

@Entity(tableName = "meme_object_table")
data class MemesRoom(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image")
    val image: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

data class Data(
    @SerializedName("memes")
    val memes : ArrayList<Memes> = arrayListOf()
)

data class Memes(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
)
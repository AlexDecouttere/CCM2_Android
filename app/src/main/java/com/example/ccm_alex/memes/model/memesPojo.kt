package com.example.ccm_alex.memes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ccm_alex.view.MyObjectForRecyclerView
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for retrofit */
data class MemesRetrofit(
    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("url")
    val iconUrl: String
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

data class JsonFull(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data: Data = Data(),
)

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

data class MemesSample(
    val name: String,
    val url: String,
)

data class MemesUi(
    val name: String,
    val iconUrl: String
) : MemeItemsUi()

data class MemesHeader(
    val header: String
) : MemeItemsUi()

sealed class MemeItemsUi()
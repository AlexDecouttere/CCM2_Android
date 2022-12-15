package com.example.ccm_alex.memes.view.model

data class MemesUi(
    val name: String,
    val iconUrl: String
) : MemeItemsUi()

data class MemesHeader(
    val header: String
) : MemeItemsUi()

sealed class MemeItemsUi()
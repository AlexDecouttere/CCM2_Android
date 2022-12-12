package com.example.ccm_alex.view


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

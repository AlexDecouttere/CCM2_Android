package com.example.ccm_alex.memes.data.mapper

import com.example.ccm_alex.memes.data.model.Memes
import com.example.ccm_alex.memes.data.model.MemesRoom
import com.example.ccm_alex.memes.domaine.model.MemesDomain

 fun Memes.toRoom(): MemesRoom {
    return MemesRoom(
        name = name,
        image = url
    )
}

 fun List<MemesRoom>.fromRoomToDomain(): List<MemesDomain> {
    return map {
        MemesDomain(
            name = it.name,
            url = it.image
        )
    }
}
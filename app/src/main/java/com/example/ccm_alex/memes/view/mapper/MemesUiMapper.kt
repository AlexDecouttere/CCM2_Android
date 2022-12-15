package com.example.ccm_alex.memes.view.mapper

import com.example.ccm_alex.memes.domaine.model.MemesDomain
import com.example.ccm_alex.memes.view.model.MemeItemsUi
import com.example.ccm_alex.memes.view.model.MemesHeader
import com.example.ccm_alex.memes.view.model.MemesUi

fun List<MemesDomain>.fromDomainToUi(): List<MemeItemsUi> {
        val result = mutableListOf<MemeItemsUi>()
        map {
            MemesUi(
                name = it.name,
                iconUrl = it.url
            )
        }.groupBy {
            // Split in 2 list, modulo and not
            it.name
        }.forEach { (name, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            result.add(MemesHeader(name))
            result.addAll(items)
        }
        return result
    }

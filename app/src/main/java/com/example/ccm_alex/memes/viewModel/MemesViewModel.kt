package com.example.ccm_alex.memes.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.ccm_alex.memes.Repository.MemesRepository
import com.example.ccm_alex.memes.model.*
import com.example.ccm_alex.view.MyObjectForRecyclerView
import com.example.ccm_alex.view.ObjectDataFooterSample
import com.example.ccm_alex.view.ObjectDataHeaderSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel : ViewModel() {

    private val mMemesRepository: MemesRepository by lazy { MemesRepository() }
    var mMemesLiveData: LiveData<List<MemeItemsUi>> = mMemesRepository.selectAllMemes().map {
        it.toUi()
    }

    fun fetchNewMeme() {
        viewModelScope.launch(Dispatchers.IO) {
            mMemesRepository.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mMemesRepository.deleteMemes()
        }
    }
}

 fun List<MemesSample>.toUi(): List<MemeItemsUi> {
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
package com.example.ccm_alex.memes.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.ccm_alex.memes.domaine.useCase.UseCase
import com.example.ccm_alex.memes.view.mapper.fromDomainToUi
import com.example.ccm_alex.memes.view.model.MemeItemsUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel : ViewModel() {

    private val mUseCase: UseCase by lazy { UseCase() }
    var mMemesLiveData: LiveData<List<MemeItemsUi>> =
        mUseCase.selectAllMemes().map {
        it.fromDomainToUi()
    }

    fun fetchNewMeme() {
        viewModelScope.launch(Dispatchers.IO) {
            mUseCase.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mUseCase.deleteMemes()
        }
    }
}
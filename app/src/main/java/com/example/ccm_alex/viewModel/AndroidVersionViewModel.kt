package com.example.ccm_alex.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ccm_alex.AndroidVersionRepository
import com.example.ccm_alex.view.MyObjectForRecyclerView
import com.example.ccm_alex.view.ObjectDataFooterSample
import com.example.ccm_alex.view.ObjectDataHeaderSample
import com.example.ccm_alex.view.ObjectDataSample

class AndroidVersionViewModel : ViewModel()  {
    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }
    private val _androidVersionList = MutableLiveData<List<MyObjectForRecyclerView>>()
    val androidVersionList: LiveData<List<MyObjectForRecyclerView>> get() = _androidVersionList

    init {
        _androidVersionList.postValue(androidVersionRepository.generateFakeData())
    }
}
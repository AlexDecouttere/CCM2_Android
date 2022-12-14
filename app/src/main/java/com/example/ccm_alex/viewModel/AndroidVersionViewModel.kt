package com.example.ccm_alex.viewModel

import androidx.lifecycle.*
import com.example.ccm_alex.AndroidVersionRepository
import com.example.ccm_alex.view.MyObjectForRecyclerView
import com.example.ccm_alex.view.ObjectDataFooterSample
import com.example.ccm_alex.view.ObjectDataHeaderSample
import com.example.ccm_alex.view.ObjectDataSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AndroidVersionViewModel : ViewModel()  {
    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }
    val androidVersionList: LiveData<List<MyObjectForRecyclerView>> =
        androidVersionRepository.selectAllAndroidVersion().map { list ->
        list.toMyObjectForRecyclerView()
    }

    fun insertPhoneData(androidName: String, osName: String, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.insertPhoneData(
                ObjectDataSample(url, androidName, osName)
            )
        }
    }

    fun deleteAllPhoneData() {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.deleteAllPhoneData()
        }
    }

    private fun List<ObjectDataSample>.toMyObjectForRecyclerView(): List<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()

        groupBy {
            // Split in 2 list, modulo and not
            it.osName
        }.forEach { (osName, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            result.add(ObjectDataHeaderSample(osName))
            result.addAll(items)
            result.add(ObjectDataFooterSample("$osName connus: ${items.size}"))
        }
        return result
    }

}
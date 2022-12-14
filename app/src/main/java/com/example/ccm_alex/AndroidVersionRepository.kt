package com.example.ccm_alex

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.ccm_alex.architecture.CustomApplication
import com.example.ccm_alex.view.*

class AndroidVersionRepository {
    private val mPhoneDataDao =
        CustomApplication.instance.mApplicationDatabase.mPhoneDataDao()


    fun selectAllAndroidVersion(): LiveData<List<ObjectDataSample>> {
        return mPhoneDataDao.selectAll().map { list ->
            list.toObjectDataSample()
        }
    }


    fun insertPhoneData(objectDataSample: ObjectDataSample) {
        mPhoneDataDao.insert(objectDataSample.toRoomObject())
    }


    fun deleteAllPhoneData() {
        mPhoneDataDao.deleteAll()
    }

    private fun ObjectDataSample.toRoomObject(): LocalDataSourceSample {
        return LocalDataSourceSample(
            image = drawable,
            name = phoneName,
            os = osName
        )
    }

    private fun List<LocalDataSourceSample>.toObjectDataSample(): List<ObjectDataSample> {
        return map { eachItem ->
            ObjectDataSample(
                osName = eachItem.os,
                phoneName = eachItem.name,
                drawable = eachItem.image
            )
        }
    }
}
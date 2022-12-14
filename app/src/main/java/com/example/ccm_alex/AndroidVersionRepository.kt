package com.example.ccm_alex

import com.example.ccm_alex.view.MyObjectForRecyclerView
import com.example.ccm_alex.view.ObjectDataFooterSample
import com.example.ccm_alex.view.ObjectDataHeaderSample
import com.example.ccm_alex.view.ObjectDataSample

class AndroidVersionRepository {
    fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()
        // Create data raw
        mutableListOf(
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/c/c7/Windows_logo_-_2012.png","Nokia Lumia 930", "Window"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/c/c7/Windows_logo_-_2012.png","Microsoft Lumia 550", "Window"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/c/c7/Windows_logo_-_2012.png" ,"Nokia Lumia 1020T", "Window"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png" ,"One Plus 6T", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png" ,"One Plus 6", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png" ,"One Plus 7", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png", "Galaxy S10", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png", "Galaxy S20", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png", "Galaxy S21", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Apple-logo.png/640px-Apple-logo.png", "Iphone 10", "Ios"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Apple-logo.png/640px-Apple-logo.png", "Iphone 11", "Ios"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png", "Galaxy S20 Plus", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png", "Galaxy S20 Ultra", "Android"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Apple-logo.png/640px-Apple-logo.png", "Iphone SE", "Ios"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Apple-logo.png/640px-Apple-logo.png", "Iphone 12", "Ios"),
            ObjectDataSample("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Apple-logo.png/640px-Apple-logo.png", "Iphone 13", "Ios"),
        ).groupBy {
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
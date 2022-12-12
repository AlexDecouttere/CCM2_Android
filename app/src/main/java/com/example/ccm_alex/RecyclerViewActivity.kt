package com.example.ccm_alex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ccm_alex.databinding.ActivityRecyclerBinding
import com.example.ccm_alex.view.*

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private lateinit var adapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Create the instance of adapter
        adapter = AndroidVersionAdapter { item, view ->
            onItemClick(item, view)
        }


        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter


        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())

    }

    private fun onItemClick(objectDataSample: ObjectDataSample, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, objectDataSample.phoneName, Toast.LENGTH_LONG).show()
    }


    private fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
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

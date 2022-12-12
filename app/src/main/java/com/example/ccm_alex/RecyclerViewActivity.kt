package com.example.ccm_alex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            ObjectDataSample(R.drawable.wintermist_2080a_euna ,"One Plus 6T", "Android"),
            ObjectDataSample(R.drawable.wintermist_2080a_euna ,"One Plus 6", "Android"),
            ObjectDataSample(R.drawable.wintermist_2080a_euna ,"One Plus 7", "Android"),
            ObjectDataSample(R.drawable.wintermist_2080a_euna, "Galaxy S10", "Android"),
            ObjectDataSample(R.drawable.wintermist_2080a_euna, "Galaxy S20", "Android"),
            ObjectDataSample(R.drawable.wintermist_2080a_euna, "Galaxy S21", "Android"),
            ObjectDataSample(R.drawable.iphone_13_pink_select_2021, "Iphone 10", "Ios"),
            ObjectDataSample(R.drawable.iphone_13_pink_select_2021, "Iphone 11", "Ios"),
            ObjectDataSample(R.drawable.wintermist_2080a_euna, "Galaxy S20 Plus", "Android"),
            ObjectDataSample(R.drawable.wintermist_2080a_euna, "Galaxy S20 Ultra", "Android"),
            ObjectDataSample(R.drawable.iphone_13_pink_select_2021, "Iphone SE", "Ios"),
            ObjectDataSample(R.drawable.iphone_13_pink_select_2021, "Iphone 12", "Ios"),
            ObjectDataSample(R.drawable.iphone_13_pink_select_2021, "Iphone 13", "Ios"),
        ).groupBy {
            // Split in 2 list, modulo and not
            it.osName == "Android"
        }.forEach { (isAndroid, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            val nbAndroid = items.filter { it.osName == "Android" }.size
            val nbIphone = items.filter { it.osName == "Ios" }.size

            if (isAndroid){
                result.add(ObjectDataHeaderSample("Android"))
            }else{
                result.add(ObjectDataHeaderSample("Ios"))
            }
            result.addAll(items)
            if (isAndroid){
                result.add(ObjectDataFooterSample("total d'android connus: $nbAndroid"))
            }else{
                Log.d(result.size.toString(),"test")
                result.add(ObjectDataFooterSample("total d'iphone connus: $nbIphone"))
            }
        }
        return result
    }
}

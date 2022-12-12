package com.example.ccm_alex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ccm_alex.databinding.ActivityRecyclerBinding
import com.example.ccm_alex.view.AndroidVersionAdapter
import com.example.ccm_alex.view.ObjectDataSample

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private lateinit var adapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Create the instance of adapter
        adapter = AndroidVersionAdapter()


        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter


        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())


    }

    private fun generateFakeData(): ArrayList<ObjectDataSample> {
        return arrayListOf(
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

            )
    }
}

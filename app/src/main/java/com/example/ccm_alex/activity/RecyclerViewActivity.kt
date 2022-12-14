package com.example.ccm_alex.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ccm_alex.androidVersion.view.AndroidVersionAdapter
import com.example.ccm_alex.androidVersion.view.MyObjectForRecyclerView
import com.example.ccm_alex.androidVersion.view.ObjectDataSample
import com.example.ccm_alex.databinding.ActivityRecyclerBinding
import com.example.ccm_alex.androidVersion.viewModel.AndroidVersionViewModel

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var viewModel: AndroidVersionViewModel
    private val androidVersionListObserver = Observer<List<MyObjectForRecyclerView>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AndroidVersionViewModel::class.java]

        // Create the instance of adapter
        adapter = AndroidVersionAdapter { item, view ->
            onItemClick(item, view)
        }
        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        binding.buttonAddItem.setOnClickListener { addRandomPhoneData() }
        binding.deleteAllItemButton.setOnClickListener { deletePhoneData() }

        // Generate data and give it to adapter

    }
    override fun onStart() {
        super.onStart()
        viewModel.androidVersionList.observe(this, androidVersionListObserver)
    }

    override fun onStop() {
        super.onStop()
        viewModel.androidVersionList.observe(this, androidVersionListObserver)
    }

    private fun onItemClick(objectDataSample: ObjectDataSample, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, objectDataSample.phoneName, Toast.LENGTH_LONG).show()
    }

    private fun addRandomPhoneData() {
        viewModel.insertPhoneData("one plus 6t", "android", "https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png")
    }

    private fun deletePhoneData() {
        viewModel.deleteAllPhoneData()
    }

}

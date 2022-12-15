package com.example.ccm_alex.memes.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ccm_alex.databinding.ActivityMemesBinding
import com.example.ccm_alex.memes.view.adapter.MemesAdapter
import com.example.ccm_alex.memes.view.model.MemeItemsUi
import com.example.ccm_alex.memes.view.viewModel.MemesViewModel

class MemesActivity : AppCompatActivity() {

    private lateinit var viewModel: MemesViewModel
    private lateinit var binding : ActivityMemesBinding
    private val adapter : MemesAdapter = MemesAdapter()

    private val observer = Observer<List<MemeItemsUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MemesViewModel::class.java]

        binding.chuckNorrisActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.chuckNorrisActivityRv.adapter = adapter

        binding.chuckNorrisActivityAdd.setOnClickListener {
            viewModel.fetchNewMeme()
        }

        binding.chuckNorrisActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.mMemesLiveData.observe(this, observer)
    }

    override fun onStop() {
        viewModel.mMemesLiveData.removeObserver(observer)
        super.onStop()
    }
}
package com.example.ccm_alex.memes.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ccm_alex.databinding.ItemCustomRecyclerHeaderBinding
import com.example.ccm_alex.databinding.ItemMemeBinding
import com.example.ccm_alex.memes.view.model.MemeItemsUi
import com.example.ccm_alex.memes.view.model.MemesHeader
import com.example.ccm_alex.memes.view.model.MemesUi

val diffUtils = object : DiffUtil.ItemCallback<MemeItemsUi>() {
    override fun areItemsTheSame(oldItem: MemeItemsUi, newItem: MemeItemsUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MemeItemsUi, newItem: MemeItemsUi): Boolean {
        return oldItem == newItem
    }

}

class MemesAdapter : ListAdapter<MemeItemsUi, RecyclerView.ViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        when (viewType) {
            MyItemType.ROW.type -> {
            MemesViewHolder(
                ItemMemeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
            MyItemType.HEADER.type -> {
            MemesHeaderViewHolder(
                ItemCustomRecyclerHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
            else -> throw RuntimeException("Wrong view type received $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as MemesViewHolder).bind(getItem(position) as MemesUi)
            MyItemType.HEADER.type -> (holder as MemesHeaderViewHolder).bind(getItem(position) as MemesHeader)


            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MemesUi -> MyItemType.ROW.type
            is MemesHeader -> MyItemType.HEADER.type

        }
    }
}

class MemesViewHolder(
    val binding: ItemMemeBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: MemesUi

    fun bind(memesUi: MemesUi) {
        ui = memesUi
        Glide.with(itemView.context)
            .load(memesUi.iconUrl)
            .into(binding.itemChuckNorrisIcon)

    }
}

class MemesHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(memesHeader: MemesHeader) {
        binding.itemRecyclerViewHeader.text = memesHeader.header
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1),
}
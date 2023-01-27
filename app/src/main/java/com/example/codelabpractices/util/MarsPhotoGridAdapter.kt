package com.example.codelabpractices.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.codelabpractices.data.MarsPhoto
import com.example.codelabpractices.databinding.MarsPhotoGridViewItemBinding

class MarsPhotoGridAdapter : ListAdapter<MarsPhoto, MarsPhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {
    companion object {
        object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
            override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
                return oldItem.imgSrcUrl == newItem.imgSrcUrl
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        return MarsPhotoViewHolder(MarsPhotoGridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    class MarsPhotoViewHolder(private var binding: MarsPhotoGridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: MarsPhoto) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }
}
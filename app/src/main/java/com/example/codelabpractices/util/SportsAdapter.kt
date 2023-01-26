package com.example.codelabpractices.util

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codelabpractices.CodeLab5Dot2Detail
import com.example.codelabpractices.R
import com.example.codelabpractices.data.Sport

class SportsAdapter(private var mSportsData: List<Sport>, private val mContext: Context) : RecyclerView.Adapter<SportsAdapter.SportViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        return SportViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sport_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        holder.bindTo(mSportsData[position])
    }

    override fun getItemCount(): Int =  mSportsData.size

    fun moveItem(from: Int, to: Int) {
        val list = mSportsData.toMutableList()
        val fromLocation = list[from]
        list.removeAt(from)
        if (to < from) {
            list.add(to + 1, fromLocation)
        } else {
            list.add(to - 1, fromLocation)
        }
        mSportsData = list
    }

    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val mTitleText: TextView = itemView.findViewById(R.id.sport_title)
        private val mInfoText: TextView = itemView.findViewById(R.id.sport_sub_title)
        private val mSportImage: ImageView = itemView.findViewById(R.id.sport_image)

        init {
            itemView.setOnClickListener(this)
        }

        fun bindTo(currentSport: Sport) {
            mTitleText.text = currentSport.title
            mInfoText.text = currentSport.info
            Glide.with(mContext).load(currentSport.imageResource).into(mSportImage)
        }

        override fun onClick(v: View?) {
            val currentSport = mSportsData[adapterPosition]
            val intent = Intent(mContext, CodeLab5Dot2Detail::class.java)
            intent.putExtra("title", currentSport.title)
            intent.putExtra("image_resource", currentSport.imageResource)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            mContext.startActivity(intent)
        }
    }
}

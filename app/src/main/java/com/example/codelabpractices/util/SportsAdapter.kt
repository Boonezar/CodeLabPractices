package com.example.codelabpractices.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codelabpractices.R
import com.example.codelabpractices.data.Sport

class SportsAdapter(private val mSportsData: List<Sport>, private val mContext: Context) : RecyclerView.Adapter<SportsAdapter.SportViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        return SportViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sport_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        holder.bindTo(mSportsData[position])
    }

    override fun getItemCount(): Int =  mSportsData.size

    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mTitleText: TextView = itemView.findViewById(R.id.sport_title)
        private val mInfoText: TextView = itemView.findViewById(R.id.sport_sub_title)
        private val mSportImage: ImageView = itemView.findViewById(R.id.sport_image)

        fun bindTo(currentSport: Sport) {
            mTitleText.text = currentSport.title
            mInfoText.text = currentSport.info
            Glide.with(mContext).load(currentSport.imageResource).into(mSportImage)
        }
    }
}
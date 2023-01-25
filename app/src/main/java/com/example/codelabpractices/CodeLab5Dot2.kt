package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codelabpractices.data.Sport
import com.example.codelabpractices.util.SportsAdapter

class CodeLab5Dot2 : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: SportsAdapter
    private val mSportsData = mutableListOf<Sport>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab5_dot2)

        mRecyclerView = findViewById(R.id.sport_recycler_view)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = SportsAdapter(mSportsData, applicationContext)
        mRecyclerView.adapter = mAdapter

        initializeData()
    }

    private fun initializeData() {
        val sportsTitles = resources.getStringArray(R.array.sports_titles)
        val sportsInfos = resources.getStringArray(R.array.sports_info)
        val sportsImages = resources.obtainTypedArray(R.array.sports_images)

        for (i in sportsTitles.indices) {
            mSportsData.add(Sport(sportsTitles[i], sportsInfos[i], sportsImages.getResourceId(i, 0)))
        }

        sportsImages.recycle()
        mAdapter.notifyDataSetChanged()
    }
}
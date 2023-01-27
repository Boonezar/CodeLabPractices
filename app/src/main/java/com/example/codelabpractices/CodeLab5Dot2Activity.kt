package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codelabpractices.data.Sport
import com.example.codelabpractices.util.SportsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CodeLab5Dot2Activity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: SportsAdapter
    private val mSportsData = mutableListOf<Sport>()
    private val mItemTouchHelper by lazy {
        val simpleItemTouchHelper = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                mAdapter.moveItem(from, to)
                mAdapter.notifyItemMoved(from, to)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                mSportsData.removeAt(viewHolder.adapterPosition)
                mAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }

            override fun onSelectedChanged(
                viewHolder: RecyclerView.ViewHolder?,
                actionState: Int
            ) {
                super.onSelectedChanged(viewHolder, actionState)
                if(actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                    viewHolder?.itemView?.alpha = 0.5f
                }
            }

            override fun clearView(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ) {
                super.clearView(recyclerView, viewHolder)
                viewHolder.itemView.alpha = 1.0f
            }
        }
        ItemTouchHelper(simpleItemTouchHelper)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab5_dot2)

        mRecyclerView = findViewById(R.id.sport_recycler_view)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = SportsAdapter(mSportsData, applicationContext)
        mRecyclerView.adapter = mAdapter

        initializeData()
        mItemTouchHelper.attachToRecyclerView(mRecyclerView)

        findViewById<FloatingActionButton>(R.id.refresh_fab).setOnClickListener {
            initializeData()
        }
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
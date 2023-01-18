package com.example.codelabpractices

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codelabpractices.databinding.ActivityCodeLab4Dot5Binding
import com.example.codelabpractices.util.WordListAdapter
import java.util.LinkedList

class CodeLab4Dot5 : AppCompatActivity() {

    private lateinit var binding: ActivityCodeLab4Dot5Binding
    private lateinit var mWordList: LinkedList<String>
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCodeLab4Dot5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val size = mWordList.size
            mWordList.addLast("New Word ${size + 1}")
            mRecyclerView.adapter?.notifyItemInserted(size)
            mRecyclerView.smoothScrollToPosition(size)
        }
        mWordList = LinkedList<String>()
        for (i in 1..20) {
            mWordList.addLast("Word $i")
        }
        mRecyclerView = findViewById(R.id.word_list_recycler_view)
        mAdapter = WordListAdapter(mWordList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
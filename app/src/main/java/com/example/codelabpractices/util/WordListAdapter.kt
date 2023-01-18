package com.example.codelabpractices.util

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codelabpractices.R
import java.util.LinkedList

class WordListAdapter(private val dataSet: LinkedList<String>): RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    inner class WordViewHolder(view: View) : RecyclerView.ViewHolder(view), OnClickListener {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.word)
            textView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            textView.text = "${dataSet[layoutPosition]} Clicked!"
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.wordlist_item, viewGroup, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: WordViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}
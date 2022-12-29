package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class CodeLab1Dot2 : AppCompatActivity() {
    private var mCount: Int = 0
    private lateinit var mShowCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab1dot2)
        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }
    fun countUp(view: View) {
        mCount++
        mShowCount.text = mCount.toString()
    }
}
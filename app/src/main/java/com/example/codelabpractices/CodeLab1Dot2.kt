package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CodeLab1Dot2 : AppCompatActivity() {
    private var mCount: Int = 0
    private lateinit var mShowCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab1_dot2)
        mShowCount = findViewById(R.id.show_count)

        findViewById<Button>(R.id.button_toast).setOnClickListener { showToast() }
        findViewById<Button>(R.id.button_count).setOnClickListener { countUp() }
    }

    private fun showToast() {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }
    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }
}
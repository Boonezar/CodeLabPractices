package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.random.Random

class CodeLab3Dot3Activity : AppCompatActivity() {
    private lateinit var mHelloTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab3_dot3)

        mHelloTextView = findViewById(R.id.hello_textview)
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"))
        }
        findViewById<Button>(R.id.color_button).setOnClickListener { changeColor() }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("color", mHelloTextView.currentTextColor)
    }

    private fun changeColor() {
        val colorName = colorArray[Random.nextInt(20)]
        val colorId = resources.getIdentifier(colorName, "color", applicationContext.packageName)
        val colorRes = ContextCompat.getColor(this, colorId)
        mHelloTextView.setTextColor(colorRes)
    }

    companion object {
        val colorArray = listOf(
            "red",
            "pink",
            "purple",
            "deep_purple",
            "indigo",
            "blue",
            "light_blue",
            "cyan",
            "teal",
            "green",
            "light_green",
            "lime",
            "yellow",
            "amber",
            "orange",
            "deep_orange",
            "brown",
            "grey",
            "blue_grey",
            "black"
        )
    }
}
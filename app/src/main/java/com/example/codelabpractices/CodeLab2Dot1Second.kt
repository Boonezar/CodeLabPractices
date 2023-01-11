package com.example.codelabpractices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CodeLab2Dot1Second : AppCompatActivity() {
    companion object {
        const val LOG_TAG = "SecondActivity"
        const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }
    private lateinit var mReply: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "--------")
        Log.d(LOG_TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab2_dot1_second)
        mReply = findViewById(R.id.editText_second)
        findViewById<Button>(R.id.button_second).setOnClickListener { returnReply() }
        val message: String = intent.extras?.get(CodeLab2Dot1.EXTRA_MESSAGE).toString()
        Log.d(LOG_TAG, "Received Message: $message")
        findViewById<TextView>(R.id.text_message).text = message
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    private fun returnReply() {
        val reply =  mReply.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End SecondActivity")
        finish()
    }
}
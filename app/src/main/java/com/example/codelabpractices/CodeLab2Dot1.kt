package com.example.codelabpractices

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class CodeLab2Dot1 : AppCompatActivity() {
    companion object {
        const val LOG_TAG = "MainActivity"
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    }
    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "--------")
        Log.d(LOG_TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab2_dot1)

        // Initialize views
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
        findViewById<Button>(R.id.button_main).setOnClickListener { launchSecondActivity() }

        // Restore the state
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("reply_visible")) {
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getString("reply_text")
                mReplyTextView.visibility = View.VISIBLE
            }
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(LOG_TAG, "onSaveInstanceState start")
        super.onSaveInstanceState(outState)
        if (mReplyTextView.visibility == View.VISIBLE) {
            Log.d(LOG_TAG, "onSaveInstanceState in if")
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", mReplyTextView.text.toString())
        }
    }

    private fun launchSecondActivity() {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, CodeLab2Dot1Second::class.java)
        intent.putExtra(EXTRA_MESSAGE, mMessageEditText.text)
        getResult.launch(intent)
    }

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode == Activity.RESULT_OK) {
            val reply = it.data?.getStringExtra(CodeLab2Dot1Second.EXTRA_REPLY)
            Log.d(LOG_TAG, "Received Reply, reply: $reply")
            mReplyHeadTextView.visibility = View.VISIBLE
            mReplyTextView.visibility = View.VISIBLE
            mReplyTextView.text = reply
        }
    }

}
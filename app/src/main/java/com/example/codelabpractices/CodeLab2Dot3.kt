package com.example.codelabpractices

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.app.ShareCompat

class CodeLab2Dot3 : AppCompatActivity() {
    companion object {
        const val LOG_TAG = "ImplicitIntents"
    }

    private lateinit var mWebsiteEditText: EditText
    private lateinit var mLocationEditText: EditText
    private lateinit var mShareTextEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab2_dot3)
        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)
    }

    fun openWebsite(view: View) {
        val webpage = Uri.parse(mWebsiteEditText.text.toString())
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(LOG_TAG, "Can't handle this in openWebsite.")
        }
    }

    fun openLocation(view: View) {
        val addressUri = Uri.parse("geo:0,0?q=${mLocationEditText.text}")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(LOG_TAG, "Can't handle this in openLocation.")
        }
    }

    fun shareText(view: View) {
        ShareCompat.IntentBuilder(this)
            .setType("text/plain")
            .setChooserTitle("Share this text with: ")
            .setText(mShareTextEditText.text.toString())
            .startChooser()
    }
}
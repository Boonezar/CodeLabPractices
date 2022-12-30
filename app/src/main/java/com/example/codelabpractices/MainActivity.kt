package com.example.codelabpractices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchOneDotTwo(view: View) {
        val intent = Intent(this, CodeLab1Dot2::class.java)
        startActivity(intent)
    }

    fun launchOneDotThree(view: View) {
        val intent = Intent(this, CodeLab1Dot3::class.java)
        startActivity(intent)
    }

    fun launchTwoDotOne(view: View) {
        val intent = Intent(this, CodeLab2Dot1::class.java)
        startActivity(intent)
    }

    fun launchTwoDotThree(view: View) {
        val intent = Intent(this, CodeLab2Dot3::class.java)
        startActivity(intent)
    }

    fun launchComposeList(view: View) {
        val intent = Intent(this, ComposeDynamicList::class.java)
        startActivity(intent)
    }

    fun launchThreeDotOne(view: View) {
        val intent = Intent(this, CodeLab3Dot1::class.java)
        startActivity(intent)
    }

}

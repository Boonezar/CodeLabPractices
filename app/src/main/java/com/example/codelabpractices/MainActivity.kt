package com.example.codelabpractices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.codeLab1Dot2).setOnClickListener { startActivity(Intent(this, CodeLab1Dot2::class.java)) }
        findViewById<TextView>(R.id.codeLab1Dot3).setOnClickListener { startActivity(Intent(this, CodeLab1Dot3::class.java)) }
        findViewById<TextView>(R.id.codeLab2Dot1).setOnClickListener { startActivity(Intent(this, CodeLab2Dot1::class.java)) }
        findViewById<TextView>(R.id.codeLab2Dot3).setOnClickListener { startActivity(Intent(this, CodeLab2Dot3::class.java)) }
        findViewById<TextView>(R.id.codeLab3Dot1).setOnClickListener { startActivity(Intent(this, CodeLab3Dot1::class.java)) }
        findViewById<TextView>(R.id.codeLab3Dot3).setOnClickListener { startActivity(Intent(this, CodeLab3Dot3::class.java)) }
        findViewById<TextView>(R.id.codeLab4Dot1).setOnClickListener { startActivity(Intent(this, CodeLab4Dot1::class.java)) }
        findViewById<TextView>(R.id.codeLab4Dot3).setOnClickListener { startActivity(Intent(this, CodeLab4Dot3::class.java)) }
        findViewById<TextView>(R.id.codeLab4Dot5).setOnClickListener { startActivity(Intent(this, CodeLab4Dot5::class.java)) }
        findViewById<TextView>(R.id.codeLabComposeBasics).setOnClickListener { startActivity(Intent(this, CodeLabComposeBasics::class.java)) }
        findViewById<TextView>(R.id.composeList).setOnClickListener { startActivity(Intent(this, ComposeDynamicList::class.java)) }
    }
}

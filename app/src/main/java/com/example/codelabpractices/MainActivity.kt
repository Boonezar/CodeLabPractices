package com.example.codelabpractices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.codeLab1Dot2).setOnClickListener { startActivity(Intent(this, CodeLab1Dot2Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab1Dot3).setOnClickListener { startActivity(Intent(this, CodeLab1Dot3Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab2Dot1).setOnClickListener { startActivity(Intent(this, CodeLab2Dot1Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab2Dot3).setOnClickListener { startActivity(Intent(this, CodeLab2Dot3Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab3Dot1).setOnClickListener { startActivity(Intent(this, CodeLab3Dot1Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab3Dot3).setOnClickListener { startActivity(Intent(this, CodeLab3Dot3Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab4Dot1).setOnClickListener { startActivity(Intent(this, CodeLab4Dot1Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab4Dot4).setOnClickListener { startActivity(Intent(this, CodeLab4Dot4Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab4Dot5).setOnClickListener { startActivity(Intent(this, CodeLab4Dot5Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab5Dot1).setOnClickListener { startActivity(Intent(this, CodeLab5Dot1Activity::class.java)) }
        findViewById<TextView>(R.id.codeLab5Dot2).setOnClickListener { startActivity(Intent(this, CodeLab5Dot2Activity::class.java)) }
        findViewById<TextView>(R.id.codeLabMarsPhotos).setOnClickListener { startActivity(Intent(this, CodeLabMarsPhotosActivity::class.java)) }
        findViewById<TextView>(R.id.codeLabComposeBasics).setOnClickListener { startActivity(Intent(this, CodeLabComposeBasics::class.java)) }
        findViewById<TextView>(R.id.composeList).setOnClickListener { startActivity(Intent(this, ComposeDynamicList::class.java)) }
    }
}

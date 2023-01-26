package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CodeLab5Dot2Detail : AppCompatActivity() {
    private lateinit var sportsTitle: TextView
    private lateinit var sportsImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab5_dot2_detail)

        sportsTitle = findViewById(R.id.detail_sport_title)
        sportsTitle.text = intent.getStringExtra("title")
        sportsImage = findViewById(R.id.detail_sport_image)
        Glide.with(this).load(intent.getIntExtra("image_resource", 0)).into(sportsImage)
    }
}

package com.example.codelabpractices

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.codelabpractices.ui.main.SectionsPagerAdapter
import com.example.codelabpractices.databinding.ActivityCodeLab4Dot4Binding

class CodeLab4Dot4 : AppCompatActivity() {

    private lateinit var binding: ActivityCodeLab4Dot4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCodeLab4Dot4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        val dateMessage = "${(month + 1)}/$day/$year"
        Toast.makeText(applicationContext, dateMessage, Toast.LENGTH_SHORT).show()
    }
}
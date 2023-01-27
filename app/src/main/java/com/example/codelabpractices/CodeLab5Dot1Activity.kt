package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class CodeLab5Dot1Activity : AppCompatActivity() {
    companion object {
        const val STATE_SCORE_1 = "Team 1 Score:"
        const val STATE_SCORE_2 = "Team 2 Score:"
    }

    private var mScore1: Int = 0
    private var mScore2: Int = 0
    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab5_dot1)

        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)
        setupIncreaseClickListener(listOf<View>(findViewById(R.id.increase_team_1), findViewById(R.id.increase_team_2)))
        setupDecreaseClickListener(listOf<View>(findViewById(R.id.decrease_team_1), findViewById(R.id.decrease_team_2)))
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            mScoreText1.text = mScore1.toString()
            mScoreText2.text = mScore2.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dark_mode_menu, menu)

        val nightMode = AppCompatDelegate.getDefaultNightMode()
        println("SAM nightMode: $nightMode")
        if (nightMode == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED) {
            menu?.findItem(R.id.day_mode)?.setTitle(R.string.day_mode)
            println("SAM in setting to day mode")
        } else {
            menu?.findItem(R.id.day_mode)?.setTitle(R.string.night_mode)
            println("SAM in setting to night mode")
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.day_mode) {
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED || nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }

    private fun setupIncreaseClickListener(views: List<View>) {
        for (view in views) {
            view.setOnClickListener { increaseScore(view) }
        }
    }

    private fun setupDecreaseClickListener(views: List<View>) {
        for (view in views) {
            view.setOnClickListener { decreaseScore(view) }
        }
    }

    private fun increaseScore(view: View) {
        when (view.id) {
            R.id.increase_team_1 -> {
                mScore1++
                mScoreText1.text = mScore1.toString()
            }
            R.id.increase_team_2 -> {
                mScore2++
                mScoreText2.text = mScore2.toString()
            }
            else -> { /* no-op */ }
        }
    }
    private fun decreaseScore(view: View) {
        when (view.id) {
            R.id.decrease_team_1 -> {
                mScore1--
                mScoreText1.text = mScore1.toString()
            }
            R.id.decrease_team_2 -> {
                mScore2--
                mScoreText2.text = mScore2.toString()
            }
            else -> { /* no-op */ }
        }
    }
}
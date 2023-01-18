package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class CodeLab4Dot3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab4_dot3)

        findViewById<Button?>(R.id.alert_button).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.alert_title))
                .setMessage(getString(R.string.alert_dialog))
                .setPositiveButton(getString(R.string.ok)) { _, _ -> showToast("Pressed OK") }
                .setNegativeButton(getString(R.string.cancel)) { _, _ -> showToast("Pressed Cancel") }
                .show()

        }
        findViewById<Button>(R.id.date_picker_button).setOnClickListener {
            val pickerFragment = CodeLab4Dot3DatePickerFragment()
            pickerFragment.show(supportFragmentManager, getString(R.string.datepicker))
        }
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        val dateMessage = "${(month + 1)}/$day/$year"
        showToast(dateMessage)
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
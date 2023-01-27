package com.example.codelabpractices

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.DatePicker
import androidx.annotation.NonNull
import androidx.fragment.app.DialogFragment
import java.util.Calendar

/**
 * A simple [Fragment] subclass.
 * Use the [CodeLab4Dot3DatePickerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CodeLab4Dot3DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        return DatePickerDialog(
            requireContext(),
            this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        (activity as CodeLab4Dot4Activity).processDatePickerResult(year, month, dayOfMonth)
    }
}
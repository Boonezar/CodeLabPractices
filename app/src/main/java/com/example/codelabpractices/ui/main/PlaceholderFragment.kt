package com.example.codelabpractices.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.codelabpractices.CodeLab4Dot3DatePickerFragment
import com.example.codelabpractices.R
import com.example.codelabpractices.databinding.FragmentCodeLab4Dot4Binding

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentCodeLab4Dot4Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            val arg = arguments?.getInt(ARG_SECTION_NUMBER) ?: 0
            setType(context?.getString(TAB_TITLES[arg]) ?: "Alert Dialog")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCodeLab4Dot4Binding.inflate(inflater, container, false)
        val root = binding.root

        val textView: TextView = binding.sectionLabel
        val button: Button = binding.tabButtonText
        button.setOnClickListener { pageViewModel.buttonClick() }
        pageViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        pageViewModel.buttonText.observe(viewLifecycleOwner) {
            button.text = it
        }
        pageViewModel.buttonEvents.observe(viewLifecycleOwner) {
            when(it) {
                TabNavigationButtonEvent.OPEN_ALERT_DIALOG -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle(getString(R.string.alert_title))
                        .setMessage(getString(R.string.alert_dialog))
                        .setPositiveButton(getString(R.string.ok)) { _, _ -> showToast("Pressed OK") }
                        .setNegativeButton(getString(R.string.cancel)) { _, _ -> showToast("Pressed Cancel") }
                        .show()
                }
                TabNavigationButtonEvent.OPEN_DATE_PICKER -> {
                    val pickerFragment = CodeLab4Dot3DatePickerFragment()
                    pickerFragment.show(parentFragmentManager, getString(R.string.datepicker))
                }
                else -> { /* no-op */ }
            }
        }

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
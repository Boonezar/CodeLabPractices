package com.example.codelabpractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.codelabpractices.databinding.FragmentCodeLab4Dot1SecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CodeLab4Dot1SecondFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentCodeLab4Dot1SecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCodeLab4Dot1SecondBinding.inflate(inflater, container, false)
        binding.labelSpinner.onItemSelectedListener = this
        val adapter = ArrayAdapter.createFromResource(this.requireContext(), R.array.labels_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.labelSpinner.adapter = adapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("Not yet implemented")
    }
}
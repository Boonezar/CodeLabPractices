package com.example.codelabpractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.codelabpractices.databinding.FragmentCodeLab4Dot1FirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CodeLab4Dot1FirstFragment : Fragment() {

    private var _binding: FragmentCodeLab4Dot1FirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCodeLab4Dot1FirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.donut.setOnClickListener { displayToast(getString(R.string.donut_order_message)) }
        binding.iceCream.setOnClickListener { displayToast(getString(R.string.ice_cream_order_message)) }
        binding.froyo.setOnClickListener { displayToast(getString(R.string.froyo_order_message)) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun displayToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
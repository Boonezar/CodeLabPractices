package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.codelabpractices.databinding.ActivityCodeLabMarsPhotosBinding
import com.example.codelabpractices.util.MarsPhotoGridAdapter

class CodeLabMarsPhotosActivity : AppCompatActivity() {

    private val viewModel: CodeLabMarsPhotosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityCodeLabMarsPhotosBinding>(this, R.layout.activity_code_lab_mars_photos)
        val adapter = MarsPhotoGridAdapter()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = adapter
    }
}
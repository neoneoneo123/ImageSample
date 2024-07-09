package com.example.imagetest

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.imagetest.databinding.ActivityResultApiactivityBinding

class ActivityResultAPIActivity : AppCompatActivity() {

    private val binding: ActivityResultApiactivityBinding by lazy {
        ActivityResultApiactivityBinding.inflate(layoutInflater)
    }

    // Activity Result 등록
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            // Uri 이미지 view에 표시
            binding.imageView.setImageURI(uri)
        } ?: run {
            Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // 갤러리 열기
            getContent.launch("image/*")
        }
    }
}
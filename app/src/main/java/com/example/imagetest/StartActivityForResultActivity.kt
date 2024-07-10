package com.example.imagetest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.imagetest.databinding.ActivityStartForResultBinding

class StartActivityForResultActivity : AppCompatActivity() {

    private val binding: ActivityStartForResultBinding by lazy {
        ActivityStartForResultBinding.inflate(layoutInflater)
    }

    private val PICK_IMAGE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, PICK_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && resultCode == PICK_IMAGE) {
            binding.imageView.setImageURI(data?.data)
        }
    }
}
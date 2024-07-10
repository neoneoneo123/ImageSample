package com.example.imagetest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imagetest.databinding.ActivityActionOpenDocumentBinding

class ActionOpenDocumentActivity : AppCompatActivity() {

    private val binding: ActivityActionOpenDocumentBinding by lazy {
        ActivityActionOpenDocumentBinding.inflate(layoutInflater)
    }

    private val PICK_IMAGE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            binding.imageView.setImageURI(data?.data)
        }
    }
}
package com.example.imagetest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imagetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            startActivity(Intent(this, ActivityResultAPIActivity::class.java))
        }

        binding.btn2.setOnClickListener {
            startActivity(Intent(this, StartActivityForResultActivity::class.java))
        }

        binding.btn3.setOnClickListener {
            startActivity(Intent(this, ActionPickActivity::class.java))
        }

        binding.btn4.setOnClickListener {
            startActivity(Intent(this, ActionOpenDocumentActivity::class.java))
        }

        binding.btn5.setOnClickListener {
            startActivity(Intent(this, StorageAccessFrameworkActivity::class.java))
        }

        binding.btn6.setOnClickListener {
            startActivity(Intent(this, MediaStoreAPIActivity::class.java))
        }
    }
}
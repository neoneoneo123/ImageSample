package com.example.imagetest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.DocumentsContract
import androidx.appcompat.app.AppCompatActivity
import com.example.imagetest.databinding.ActivityStorageAccessFrameworkBinding

class StorageAccessFrameworkActivity : AppCompatActivity() {

    private val binding: ActivityStorageAccessFrameworkBinding by lazy {
        ActivityStorageAccessFrameworkBinding.inflate(layoutInflater)
    }

    private val PICK_DIRECTORY = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
            startActivityForResult(intent, PICK_DIRECTORY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == PICK_DIRECTORY) {
            val directoryUri = data?.data
            directoryUri?.let {
                val documentUri = DocumentsContract.buildDocumentUriUsingTree(it , DocumentsContract.getTreeDocumentId(it))
                binding.imageView.setImageURI(documentUri)
            }
        }
    }
}
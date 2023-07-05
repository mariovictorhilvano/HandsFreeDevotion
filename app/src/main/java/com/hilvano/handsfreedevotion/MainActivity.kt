package com.hilvano.handsfreedevotion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hilvano.handsfreedevotion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        proceedButton()
    }
    private fun proceedButton() {
        binding.btnMainProceed.setOnClickListener {
            val intent = Intent(this, BooksActivity::class.java)
            startActivity(intent)
        }
    }
}


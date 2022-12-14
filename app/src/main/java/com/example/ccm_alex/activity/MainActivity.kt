package com.example.ccm_alex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ccm_alex.databinding.ActivityMainBinding
import com.example.ccm_alex.memes.view.activity.MemesActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            generateIntentAndGoTo()
        }
        binding.buttonMeme.setOnClickListener{
            generateIntentAndGoToMemes()
        }

    }

    private fun generateIntentAndGoTo() {
        // Kotlin style
        val intentKotlin = Intent(this, RecyclerViewActivity::class.java)
        // Start activity
        startActivity(intentKotlin)
    }

    private fun generateIntentAndGoToMemes() {
        // Kotlin style
        val intentKotlin = Intent(this, MemesActivity::class.java)
        // Start activity
        startActivity(intentKotlin)
    }
}

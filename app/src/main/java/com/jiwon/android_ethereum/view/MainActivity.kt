package com.jiwon.android_ethereum.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jiwon.android_ethereum.R
import com.jiwon.android_ethereum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
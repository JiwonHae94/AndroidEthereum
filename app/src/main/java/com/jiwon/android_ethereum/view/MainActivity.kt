package com.jiwon.android_ethereum.view

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.jiwon.android_ethereum.R
import com.jiwon.android_ethereum.databinding.ActivityMainBinding
import com.jiwon.android_ethereum.helper.hasAllPermissions
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // check whether application has all permissions required
        val hasPermission = hasAllPermissions(REQUIRED_PERMISSIONS)
        if(!hasPermission){
            // request permission
            requestPermissions(REQUIRED_PERMISSIONS, PERMISSION_PERMISSION_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_PERMISSION_CODE && hasAllPermissions(REQUIRED_PERMISSIONS)) {
            // FIXME
        } else {
            finish() // If we don't have the required permissions, we can't run
        }
    }


    companion object{
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        private val PERMISSION_PERMISSION_CODE = Random.nextInt(0, 10000)
    }
}
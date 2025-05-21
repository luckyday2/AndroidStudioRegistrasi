package com.sandria.regis

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sandria.regis.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ambil data
        val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val fullName = sharedPref.getString("fullname", "User") //default "user" jika kosong

        //untuk tampilkan nama
        binding.tvWelcome.text = "WELCOME $fullName"
    }
}

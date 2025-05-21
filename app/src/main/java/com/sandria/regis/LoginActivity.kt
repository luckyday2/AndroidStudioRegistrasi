package com.sandria.regis

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sandria.regis.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inisial banding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener {
            //ambil inputan
            val inputUsername = binding.etUsernameLogin.text.toString().trim()
            val inputPassword = binding.etPasswordLogin.text.toString().trim()

            //dicek atau validasi
            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Harus diisi ya sayangg!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //get data yg udah disimpan
            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", null)
            val savedPassword = sharedPref.getString("password", null)
            val fullName = sharedPref.getString("fullname", inputUsername)

            //cocokan data login dengan regis
            if (inputUsername == savedUsername && inputPassword == savedPassword) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("nama", fullName)
                startActivity(intent)
                Toast.makeText(this, "Login berhasil! Selamat datang $fullName", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Username atau Password ada yang salah bos!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

package com.sandria.regis

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.sandria.regis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //inisialisasi binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //connect binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvLoginHere.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        binding.btnRegis.setOnClickListener {
            val fullName = binding.FullName.text.toString().trim()
            val username = binding.Username.text.toString().trim()
            val password = binding.Password.text.toString()
            val confirmPassword = binding.ConfirmPassword.text.toString()


            if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Di isi semua dulu sayang", Toast.LENGTH_LONG).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Oops! Password salah nih", Toast.LENGTH_LONG).show()
            } else {
                //save data
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("fullname", fullName)
                editor.putString("username", username)
                editor.putString("password", password)
                editor.apply() //save perubahan


                Toast.makeText(this, "Register Sukses!\nWelcome Home, $fullName!", Toast.LENGTH_LONG).show()

                //bisa langsung pindah ke login
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // tutup halaman register agar user tidak bisa kembali dengan tombol back
            }
        }
    }
}

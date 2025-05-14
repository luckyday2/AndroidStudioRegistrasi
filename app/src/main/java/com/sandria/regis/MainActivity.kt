package com.sandria.regis

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sandria.regis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //install viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //memastikan register & ambil inputan
        binding.btnRegis.setOnClickListener{
            val fullName = binding.FullName.text.toString().trim()
            val username = binding.Username.text.toString().trim()
            val password = binding.Password.text.toString()
            val confirmPassword = binding.ConfirmPassword.text.toString()

            //validasi
            if(fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this,"Di isi semua dulu sayang", Toast.LENGTH_LONG).show()
            }else if (password != confirmPassword){
                Toast.makeText(this, "Oops! Password salah nih", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Register Sukses!\nWelcome Home, $fullName!", Toast.LENGTH_LONG).show()
            }
        }

    }
}
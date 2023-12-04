package com.example.mobileapk.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapk.R
import com.example.mobileapk.helper.SharedPref

class MasukActivity : AppCompatActivity() {

    lateinit var myButton: Button
    lateinit var s:SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        // Inisialisasi tombol di dalam onCreate setelah setContentView
        myButton = findViewById(R.id.btn_register)
        s = SharedPref(this)

        // Menggunakan satu onClickListener untuk menangani keduanya

        myButton.setOnClickListener {
            // Menggunakan Intent untuk pindah ke LoginActivity
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Mengganti tombol dan sharedPref untuk proses login
        val loginButton = findViewById<Button>(R.id.btn_prosesLogin)
        val sharedPref = SharedPref(this)

        loginButton.setOnClickListener {
            // Menggunakan Intent untuk pindah ke RegisterActivity
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

}
package com.example.mobileapk.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapk.MainActivity
import com.example.mobileapk.R
import com.example.mobileapk.app.ApiConfig
import com.example.mobileapk.helper.SharedPref
import com.example.mobileapk.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    lateinit var myButton: Button
    lateinit var s:SharedPref
    lateinit var edt_email: EditText // Deklarasi EditText
    lateinit var edt_password: EditText // Deklarasi EditText
    lateinit var pb: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        myButton = findViewById(R.id.btn_login)
        s = SharedPref(this)
        edt_email = findViewById(R.id.edt_email) // Pastikan ID EditText diisi dengan benar
        edt_password = findViewById(R.id.edt_password) // Pastikan ID EditText diisi dengan benar
        pb = findViewById(R.id.pb) // Pastikan ID ProgressBar diisi dengan benar

        myButton.setOnClickListener {
            login()
        }
    }

    fun login() {
        // Cek validitas input email dan password
        if (edt_email.text.isEmpty()) {
            edt_email.error = "Kolom Email tidak boleh kosong"
            edt_email.requestFocus()
            return
        } else if (edt_password.text.isEmpty()) {
            edt_password.error = "Kolom Password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }

        // Set ProgressBar menjadi visible sebelum memulai request
        pb.visibility = View.VISIBLE

        // Melakukan request login
        ApiConfig.instanceRetrofit.login(edt_email.text.toString(), edt_password.text.toString()).enqueue(object : Callback<ResponModel> {
                override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                    pb.visibility = View.GONE // Sembunyikan ProgressBar setelah mendapatkan respons
                    val respon = response.body()!!
                    if (respon.success == 1) {
                        s.setStatusLogin(true)
                        s.setUser(respon.user)
                        //s.setString(s.nama, respon.user.name)
                        //s.setString(s.phone, respon.user.phone)
                        //s.setString(s.email, respon.user.email)

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()

                        // Jika login berhasil
                        Toast.makeText(
                            this@LoginActivity,
                            "Selamat Datang " + respon.user.name,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // Jika login gagal
                        Toast.makeText(
                            this@LoginActivity,
                            "Error:" + respon.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                    pb.visibility = View.GONE // Sembunyikan ProgressBar jika request gagal
                    Toast.makeText(
                        this@LoginActivity,
                        "Error: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}


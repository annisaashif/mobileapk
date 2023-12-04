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
import com.example.mobileapk.R.layout
import com.example.mobileapk.app.ApiConfig
import com.example.mobileapk.helper.SharedPref
import com.example.mobileapk.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var myButton: Button
    lateinit var s: SharedPref
    lateinit var edt_nama: EditText // Deklarasi EditText
    lateinit var edt_email: EditText // Deklarasi EditText
    lateinit var edt_phone: EditText // Deklarasi EditText
    lateinit var edt_password: EditText // Deklarasi EditText
    lateinit var pb: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_register)

        myButton = findViewById(R.id.btn_register)
        s = SharedPref(this)
        edt_nama = findViewById(R.id.edt_nama)
        edt_email = findViewById(R.id.edt_email)
        edt_phone = findViewById(R.id.edt_phone)
        edt_password = findViewById(R.id.edt_password)
        pb = findViewById(R.id.pb)

        myButton.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val nama = edt_nama.text.toString().trim()
        val email = edt_email.text.toString().trim()
        val phone = edt_phone.text.toString().trim()
        val password = edt_password.text.toString().trim()

        // Validasi kolom input
        if (nama.isEmpty()) {
            edt_nama.error = "Kolom Nama tidak boleh kosong"
            edt_nama.requestFocus()
            return
        } else if (email.isEmpty()) {
            edt_email.error = "Kolom Email tidak boleh kosong"
            edt_email.requestFocus()
            return
        } else if (phone.isEmpty()) {
            edt_phone.error = "Kolom Nomor Telepon tidak boleh kosong"
            edt_phone.requestFocus()
            return
        } else if (password.isEmpty()) {
            edt_password.error = "Kolom Password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }

        // Menampilkan ProgressBar saat proses register dimulai
        pb.visibility = View.VISIBLE

        // Lakukan permintaan register ke server atau API
        ApiConfig.instanceRetrofit.register(nama, email, password, phone).enqueue(object : Callback<ResponModel> {
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                // Sembunyikan ProgressBar saat respons diterima
                pb.visibility = View.GONE

                val respon = response.body()
                if (respon != null && respon.success == 1) {
                    // Register berhasil
                    s.setStatusLogin(true)
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@RegisterActivity, "Selamat Datang ${respon.user.name}", Toast.LENGTH_SHORT).show()
                    // Lakukan tindakan setelah register berhasil, seperti pindah ke layar berikutnya
                } else {
                    // Register gagal
                    val errorMessage = respon?.message ?: "Gagal melakukan register"
                    Toast.makeText(this@RegisterActivity, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                // Sembunyikan ProgressBar jika permintaan gagal
                pb.visibility = View.GONE
                Toast.makeText(this@RegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}





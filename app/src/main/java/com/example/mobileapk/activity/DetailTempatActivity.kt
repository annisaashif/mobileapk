package com.example.mobileapk.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapk.R
import com.example.mobileapk.model.Tempat
import com.google.gson.Gson
import com.squareup.picasso.Picasso


class DetailTempatActivity : AppCompatActivity() {

    private lateinit var tvNama: TextView
    private lateinit var tvJudul: TextView
    private lateinit var imageView: ImageView
    private lateinit var tvDeskripsi: TextView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tempat)

        // Inisialisasi TextView
        tvNama = findViewById(R.id.tv_nama)
        tvJudul = findViewById(R.id.tv_judul)
        imageView = findViewById(R.id.image)
        tvDeskripsi = findViewById(R.id.tv_deskripsi)

        // Inisialisasi Toolbar
        toolbar = findViewById(R.id.toolbar)



        getInfo()
    }

    fun getInfo(){
        val data = intent.getStringExtra("extra")
        val tempat = Gson().fromJson<Tempat>(data, Tempat::class.java)

        //set value
        tvNama.text = tempat.name
        tvJudul.text = tempat.judul
        tvDeskripsi.text = tempat.deskripsi

        val img = "http://192.168.69.83/projek2/public/storage/tempat/"+ tempat.image
        Picasso.get()
            .load(img)
            .placeholder(R.drawable.img_2)
            .error(R.drawable.img_2)
            .resize(400, 400)
            .into(imageView)


        //setToolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = tempat.name
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
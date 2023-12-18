package com.example.mobileapk.adapter.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapk.R
import com.example.mobileapk.activity.DetailTempatActivity
import com.example.mobileapk.model.Tempat
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class AdapterTempat(var activity: Activity, var data:ArrayList<Tempat>):RecyclerView.Adapter<AdapterTempat.Holder>(){

    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvJudul = view.findViewById<TextView>(R.id.tv_judul)
        val imgTempat = view.findViewById<ImageView>(R.id.img_tempat)
        val layout = view.findViewById<CardView>(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_tempat, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].name
        holder.tvJudul.text = data[position].judul
       //holder.imgTempat.setImageResource(data[position].image)

        val image = "http://192.168.69.83/projek2/public/storage/tempat/"+ data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.img_2)
            .error(R.drawable.img_2)
            .into(holder.imgTempat)

        holder.layout.setOnClickListener {
            val activiti = Intent(activity, DetailTempatActivity::class.java)
            val str = Gson().toJson(data[position], Tempat::class.java)
            activiti.putExtra("extra", str)

            activity.startActivity(activiti)
        }


    }


}
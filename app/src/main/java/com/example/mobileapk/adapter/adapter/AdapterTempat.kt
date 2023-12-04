package com.example.mobileapk.adapter.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mobileapk.R
import com.example.mobileapk.model.Tempat

class AdapterTempat(var data:ArrayList<Tempat>):RecyclerView.Adapter<AdapterTempat.Holder>(){

    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvAlamat = view.findViewById<TextView>(R.id.tv_alamat)
        val imgTempat = view.findViewById<ImageView>(R.id.img_tempat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_tempat, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].nama
        holder.tvAlamat.text = data[position].alamat
        holder.imgTempat.setImageResource(data[position].gambar)



    }


}
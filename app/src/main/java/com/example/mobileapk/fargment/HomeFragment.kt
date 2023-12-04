package com.example.mobileapk.fargment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.mobileapk.R
import com.example.mobileapk.adapter.adapter.AdapterTempat
import com.example.mobileapk.model.Tempat
import com.inyongtisto.tutorial.adapter.AdapterSlider

class HomeFragment : Fragment() {

    lateinit var vpSlider : ViewPager
    lateinit var rvTempat:RecyclerView
    lateinit var rvBerenang:RecyclerView
    lateinit var rvBadminton:RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvTempat = view.findViewById(R.id.rv_tempat)
        rvBadminton = view.findViewById(R.id.rv_badminton)
        rvBerenang = view.findViewById(R.id.rv_berenang)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.gambar2)
        arrSlider.add(R.drawable.gambar1)
        arrSlider.add(R.drawable.gambar3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvTempat.adapter = AdapterTempat(arrTempat)
        rvTempat.layoutManager = layoutManager

        rvBerenang.adapter = AdapterTempat(arrBerenang)
        rvBerenang.layoutManager = layoutManager2

        rvBadminton.adapter = AdapterTempat(arrBadminton)
        rvBadminton.layoutManager = layoutManager3


        return view
    }

    val arrTempat: ArrayList<Tempat>get() {
        val arr = ArrayList<Tempat>()
        val t1 =  Tempat()
        t1.nama = "ReFIT Gym Padang"
        t1.alamat = "Jl.Olo Ladang No.12 Olo,Kecamatan Padang Barat,Kota Padang"
        t1.gambar = R.drawable.g1

        val t2 =  Tempat()
        t2.nama = "HardCore Fitness"
        t2.alamat = "Jl.Raya Lubuk Begalung No.5,Kota Padang"
        t2.gambar = R.drawable.g2

        val t3 =  Tempat()
        t3.nama = "G Sports Center"
        t3.alamat = "Jl. Gajah Mada Kelurahan No.105 B, Gn. Pangilun, Kec. Padang Utara,,Kota Padang"
        t3.gambar = R.drawable.g3

        arr.add(t1)
        arr.add(t2)
        arr.add(t3)


        return arr
    }

    val arrBerenang: ArrayList<Tempat>get() {
        val arr = ArrayList<Tempat>()
        val t1 =  Tempat()
        t1.nama = "ReFIT Gym Padang"
        t1.alamat = "Jl.Olo Ladang No.12 Olo,Kecamatan Padang Barat,Kota Padang"
        t1.gambar = R.drawable.g1

        val t2 =  Tempat()
        t2.nama = "HardCore Fitness"
        t2.alamat = "Jl.Raya Lubuk Begalung No.5,Kota Padang"
        t2.gambar = R.drawable.g2

        val t3 =  Tempat()
        t3.nama = "G Sports Center"
        t3.alamat = "Jl. Gajah Mada Kelurahan No.105 B, Gn. Pangilun, Kec. Padang Utara,,Kota Padang"
        t3.gambar = R.drawable.g3

        arr.add(t1)
        arr.add(t2)
        arr.add(t3)


        return arr
    }

    val arrBadminton: ArrayList<Tempat>get() {
        val arr = ArrayList<Tempat>()
        val t1 =  Tempat()
        t1.nama = "ReFIT Gym Padang"
        t1.alamat = "Jl.Olo Ladang No.12 Olo,Kecamatan Padang Barat,Kota Padang"
        t1.gambar = R.drawable.g1

        val t2 =  Tempat()
        t2.nama = "HardCore Fitness"
        t2.alamat = "Jl.Raya Lubuk Begalung No.5,Kota Padang"
        t2.gambar = R.drawable.g2

        val t3 =  Tempat()
        t3.nama = "G Sports Center"
        t3.alamat = "Jl. Gajah Mada Kelurahan No.105 B, Gn. Pangilun, Kec. Padang Utara,,Kota Padang"
        t3.gambar = R.drawable.g3

        arr.add(t1)
        arr.add(t2)
        arr.add(t3)


        return arr
    }


}
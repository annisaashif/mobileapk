package com.example.mobileapk.fargment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.mobileapk.R
//import kotlinx.android.synthetic.main.fragment_kategori.*

class KategoriFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val badminton = view.findViewById<CardView>(R.id.badminton)
        val renang = view.findViewById<CardView>(R.id.renang)
        val gym = view.findViewById<CardView>(R.id.gym)
        val futsal= view.findViewById<CardView>(R.id.futsal)


        badminton.setOnClickListener {
            val fragment = HomeFragment() // Ganti HomeFragment dengan kelas fragment yang sebenarnya
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        renang.setOnClickListener {
            val fragment = KategoriFragment() // Ganti DetailBarangFragment dengan kelas fragment yang sebenarnya
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        gym.setOnClickListener {
            val fragment = KategoriFragment() // Ganti HomeFragment dengan kelas fragment yang sebenarnya
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        futsal.setOnClickListener {
            val fragment = KategoriFragment() // Ganti HomeFragment dengan kelas fragment yang sebenarnya
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}

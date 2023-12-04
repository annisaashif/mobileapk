package com.example.mobileapk.fargment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mobileapk.R
import com.example.mobileapk.helper.SharedPref


class AkunFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btnLogout:TextView
    lateinit var tvNama:TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone:TextView






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)
        //menampung inisialisasi
        init(view)

        s = SharedPref(requireActivity())

        btnLogout.setOnClickListener{
            s.setStatusLogin(false)
        }

        setData()
        return view
    }

    fun setData(){
        tvNama.text = s.getString(s.nama)
        tvEmail.text = s.getString(s.email)
        tvPhone.text = s.getString(s.phone)

    }

    private fun init(view: View) {
        btnLogout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)

    }

}
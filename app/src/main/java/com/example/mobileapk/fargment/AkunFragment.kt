package com.example.mobileapk.fargment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mobileapk.R
import com.example.mobileapk.activity.LoginActivity
import com.example.mobileapk.helper.SharedPref


class AkunFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btnLogout:TextView
    lateinit var tvNama:TextView
    lateinit var tvEmail: TextView
   // lateinit var tvPhone:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
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
        val user = s.getUser()

        if (user == null){
           val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            return
        }

        if (::tvNama.isInitialized) {
            tvNama.text = user.name
        }

        if (::tvEmail.isInitialized) {
            tvEmail.text = user.email
        }

        //val user = s.getUser()!!

      //  tvNama.text = user.name
     //   tvEmail.text = user.email
     //   tvPhone.text = user.phone

    }

    private fun init(view: View) {
        btnLogout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)


    }

}
package com.example.mobileapk

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mobileapk.activity.MasukActivity
import com.example.mobileapk.fargment.AkunFragment
import com.example.mobileapk.fargment.HomeFragment
import com.example.mobileapk.fargment.KategoriFragment
import com.example.mobileapk.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

     private val fargmentHome : Fragment = HomeFragment()
     private val fargmentAkun : Fragment = AkunFragment()
     private val fargmentKategori : Fragment = KategoriFragment()
     private val fm: FragmentManager = supportFragmentManager
     private var active: Fragment = fargmentHome


    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private val statusLogin = false

    private lateinit var s:SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       s = SharedPref(this)


        setUpBottomNav()
    }


    fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.container, fargmentHome).show(fargmentHome).commit()
        fm.beginTransaction().add(R.id.container, fargmentAkun).hide(fargmentAkun).commit()
        fm.beginTransaction().add(R.id.container, fargmentKategori).hide(fargmentKategori).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true



        bottomNavigationView.setOnNavigationItemSelectedListener{ item ->

            when(item.itemId) {
                R.id.navigation_home ->{
                    callFargment(0, fargmentHome)
                }
                R.id.navigation_kategori ->{
                    callFargment(1, fargmentKategori)
                }
                R.id.navigation_akun ->{
                    if (s.getStatusLogin()) {
                        callFargment(2, fargmentAkun)
                    } else{
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
            }

            false
        }
    }

    fun callFargment(int: Int, fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}
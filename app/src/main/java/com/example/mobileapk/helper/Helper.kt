package com.example.mobileapk.helper

import java.text.NumberFormat
import java.util.Locale

class Helper {
    fun gantiRupiah(string: String) :String{
        return NumberFormat.getCurrencyInstance(Locale("indonesia", "ID")).format(Integer.valueOf(string)) +"/jam"
    }
}
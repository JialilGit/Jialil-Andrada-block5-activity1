package com.andrada.jialil.block5.p1.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val loginFragment = LoginFragment()
        fragmentTransaction.replace(R.id.fragment_container, loginFragment)
        fragmentTransaction.commit()
    }
}

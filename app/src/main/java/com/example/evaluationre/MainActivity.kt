package com.example.evaluationre


import android.os.Bundle
import androidx.fragment.app.FragmentActivity


class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FirstFragment())
            .addToBackStack(null)
            .commit()
    }
}

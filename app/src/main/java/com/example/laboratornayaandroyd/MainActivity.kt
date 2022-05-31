package com.example.laboratornayaandroyd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratornayaandroyd.databinding.ActivityMainBinding
import com.example.laboratornayaandroyd.views.PersonalAccountFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = PersonalAccountFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }
    }

}
package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, secondFragment)
                add(R.id.fragmentContainerView, firstFragment)
                setPrimaryNavigationFragment(firstFragment)
                commit()
            }
            binding.firstButton.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    hide(secondFragment)
                    show(firstFragment)
                    setPrimaryNavigationFragment(firstFragment)
                    commit()
                }
            }
            binding.secondButton.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    hide(firstFragment)
                    show(secondFragment)
                    setPrimaryNavigationFragment(secondFragment)
                    commit()
                }
            }
        }
    }

}
package com.example.fragments

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.databinding.FragmentFirstBinding
import com.example.fragments.databinding.FragmentSecondBinding
import com.example.fragments.utils.ArgumentManager


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
                add(R.id.fragmentContainerView, firstFragment)
                add(R.id.fragmentContainerView, secondFragment)
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
package com.example.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.FragmentSecondChildBinding
import com.example.fragments.utils.ArgumentManager

class SecondFragmentChild : Fragment(R.layout.fragment_second_child) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSecondChildBinding.bind(view)
        val counterManager = ArgumentManager()
        val countValue = counterManager.getCounter(arguments)
        binding.counterSecond.text = "$countValue"
        binding.root.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.fragmentContainerViewSecondParent, SecondFragmentChild::class.java,
                    counterManager.createArgs(countValue + 1)
                )
                addToBackStack(null)
                commit()
            }
        }
    }


}
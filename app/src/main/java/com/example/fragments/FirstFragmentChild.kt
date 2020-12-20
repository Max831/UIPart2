package com.example.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.FragmentFirstChildBinding
import com.example.fragments.utils.ArgumentManager

class FirstFragmentChild : Fragment(R.layout.fragment_first_child) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentFirstChildBinding.bind(view)
        val counterManager = ArgumentManager()
        val countValue = counterManager.getCounter(arguments)
        binding.counterFirst.text = "$countValue"
        binding.root.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.fragmentContainerViewFirstParent, FirstFragmentChild::class.java,
                    counterManager.createArgs(countValue + 1)
                )
                addToBackStack(null)
                commit()
            }
        }
    }


}
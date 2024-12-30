package com.example.myapplicationcars

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplicationcars.databinding.FragmentCarBinding
import com.example.myapplicationcars.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val cakes = DetailFragmentArgs.fromBundle(requireArguments())
            val drinks = DetailFragmentArgs.fromBundle(requireArguments())

            setDataToUI(cakes.name, cakes.desc, cakes.prise, cakes.image)

            setDataToUI(drinks.name, drinks.desc, drinks.prise, drinks.image)

        } else {
            throw IllegalArgumentException("Arguments are missing")
        }
    }
    private fun setDataToUI(name: String, desc: String, prise: String, image: String) {
        binding.tvName.text = name
        binding.tvDescription.text = desc
        binding.tvPrise.text = prise
        Glide.with(requireContext()).load(image).into(binding.ivCar)

        setupBackButton()
    }

    private fun setupBackButton(){
        binding.backButton.setOnClickListener(){
            findNavController().navigateUp()
        }
    }
}


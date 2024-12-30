package com.example.myapplicationcars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationcars.databinding.FragmentCarBinding

class CarFragment : Fragment() {
    private lateinit var binding: FragmentCarBinding
    private val carsList = arrayListOf<Cars>()
    private lateinit var carsAdapter: CarsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        carsAdapter = CarsAdapter(carsList) {
            findNavController().navigate(
                CarFragmentDirections.actionCarFragmentToDetailFragment(
                    image = carsList[it].image,
                    name = carsList[it].name,
                    desc = carsList[it].desc,
                    prise = carsList[it].prise,
                    menu = carsList[it].manu
                )
            )
        }
        binding.rvCars.adapter = carsAdapter
    }

    private fun onLoad() {
        carsList.add(Cars(image1,"Chevrolet Corvette",
            "The 2025 Chevrolet Corvette's #1 ranking is based on its score within the Luxury Sports Cars category. Currently the Chevrolet Corvette has a score of 9.7 out of 10, which is based on our evaluation of 25 pieces of research and data elements using various sources.",
            "$68,300 - 132,650","2025"))
        carsList.add(Cars(image2,"Porsche Boxster",
            "The 2024 Porsche Boxster's #2 ranking is based on its score within the Luxury Sports Cars category. Currently the Porsche Boxster has a score of 9.4 out of 10, which is based on our evaluation of 34 pieces of research and data elements using various sources.",
            "$68,300 - 132,650","2024"))
        carsList.add(Cars(image3, "BMW M2",
            "The 2024 BMW M2's #3 ranking is based on its score within the Luxury Sports Cars category. Currently the BMW M2 has a score of 9.3 out of 10, which is based on our evaluation of 9 pieces of research and data elements using various sources.",
            "$63,200 - 63,200","2024"))
    }

}
val image1 = "https://www.usnews.com/object/image/00000191-d821-d8b8-adf7-f97944b10000/chevrolet-corvette-zr1-coupe-001.jpg?update-time=1725907944302&size=responsiveGallery"
val image2 = "https://cars.usnews.com/pics/size/390x290/images/Auto/izmo/i159616055/2024_porsche_718_boxster_angularfront.jpg"
val image3 = "https://www.usnews.com/object/image/0000018d-7b48-d541-a18d-7b4ce9210001/24-bmw-m2-ext1.jpg?update-time=1707170494765&size=responsive640"



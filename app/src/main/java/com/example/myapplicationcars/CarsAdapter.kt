package com.example.myapplicationcars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionListenerAdapter
import com.bumptech.glide.Glide
import com.example.myapplicationcars.databinding.ItemCarsBinding

class CarsAdapter(val carsList: List<Cars>, val listener: (position: Int)-> Unit) :
    RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    inner class CarsViewHolder(val binding: ItemCarsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(cars: Cars){
            binding.apply {
                tvName.text = cars.name
                tvManufacture.text = cars.manu
                tvPrise.text = cars.prise
                Glide.with(itemView).load(cars.image).into(ivCar)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val binding = CarsViewHolder(ItemCarsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return  binding
    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind(carsList[position])
        holder.itemView.setOnClickListener{
            listener(position)
        }
    }
}



package com.example.recyclerviewexercise

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexercise.databinding.ItemRecyclerBinding

class CustomAdapter : RecyclerView.Adapter<Holder>() {
    
    var restaurantListData = mutableListOf<RestaurantList>()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val restaurantList = restaurantListData.get(position)
        holder.setRestaurantListMemo(restaurantList)
    }

    override fun getItemCount(): Int {
        return restaurantListData.size
    }

}

class Holder(val binding : ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener{
            Toast.makeText(binding.root.context,"클릭된 아이템 = ${binding.textRestaurantName.text}",Toast.LENGTH_LONG).show()
        }
    }

    fun setRestaurantListMemo(restaurantList : RestaurantList){
        binding.textRestaurantName.text = "${restaurantList.restaurantListName}"
        binding.textRestaurantSimpleInfo.text = "${restaurantList.restaurantListSimpleInfo}"
        binding.textRestaurantAvailable.text = "${restaurantList.restaurantListAvailable}"

    }
}
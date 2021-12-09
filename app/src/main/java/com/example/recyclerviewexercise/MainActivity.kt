package com.example.recyclerviewexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data: MutableList<RestaurantList> = loadData()
        var adapter = CustomAdapter()
        adapter.restaurantListData = data
        binding.myRecyclerView.adapter = adapter

        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
    }



    fun loadData() : MutableList<RestaurantList> {
        val data:MutableList<RestaurantList> = mutableListOf()
            for (no in 1..100) {
                val restaurantName = "This is Restaurant${no}"
                val restaurantSimpleInfo = "이곳의 트러플 파스타는 최고급 소고기를 사용하고 이탈리아 전통방식으로 만든 면을 사용하며 최고급 트러플오일로 고급스러운 향을 냅니다."
                val restaurantAvailable = "open / close / meal right now"
                var restaurantList = RestaurantList(restaurantName, restaurantSimpleInfo, restaurantAvailable)
                data.add(restaurantList)
            }

        return data;
    }

}
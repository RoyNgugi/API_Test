package com.example.apitest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apitest.adapater.PostsAdapter
import com.example.apitest.dataClass.Posts
import com.example.apitest.databinding.ActivityMainBinding
import com.example.apitest.retrofit.RetrofitClientInstance
import com.example.apitest.retrofit.getdata
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postsApi = RetrofitClientInstance.retrofitInstance!!.create(getdata::class.java)
        val call = postsApi.getPostsList()


        call.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful) {
                    val postsList = response.body()
                    if (postsList != null) {
                        val recyclerView = binding.rvView
                        val postsAdapter = PostsAdapter(postsList)
                        recyclerView.adapter = postsAdapter
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "API request failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
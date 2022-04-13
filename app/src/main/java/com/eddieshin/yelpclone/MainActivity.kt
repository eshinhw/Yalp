package com.eddieshin.yelpclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        private const val BASE_URL = "https://api.yelp.com/v3/"
        private const val TAG = "MainActivity"
        private const val API_KEY = "1FYi7amTINE1hNX5WxUHNPKccObFViutuMrpj-8gOFOTB73iT0CgduIUqF73AsyZlPTHZabFY9P_yKl-TX1UUaXZxKN8LVtgWPPE6hxbaNLrMZQTIq_EN8hqCEdOYnYx"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Define an end point for APi
        val yelpService = retrofit.create(YelpService::class.java)

        val restaurants = yelpService
            .searchRestaurants("Bearer $API_KEY","Avocado Toast", "New York")
            .enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    Log.i(TAG, "onResponse $response")
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    Log.i(TAG, "onFailure $t")
                }

            })



        /*
        Synchronized vs Insynchronized

         */
    }
}
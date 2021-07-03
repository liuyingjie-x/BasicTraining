package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.model.Repo
import com.example.retrofit.model.WanAndroid
import com.example.retrofit.request.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_hello).setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }
        request()
    }

    private fun request() {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://wanandroid.com")
            .build()
        val api = retrofit.create(Api::class.java)
        val test = Test()
        test.request()
//        val repos:Call<Repo> = api.test
        api.requestTest().enqueue(object : Callback<WanAndroid?> {
            override fun onResponse(call: Call<WanAndroid?>, response: Response<WanAndroid?>) {
                Log.e("response", response.body().toString())
            }

            override fun onFailure(call: Call<WanAndroid?>, t: Throwable) {
                Log.e("response", t.toString())
            }
        })


//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.github.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
    }
}
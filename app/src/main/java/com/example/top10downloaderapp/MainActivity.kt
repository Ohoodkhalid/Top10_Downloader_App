package com.example.top10downloaderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  val TAG = "app"
    private lateinit var recView: RecyclerView
    private lateinit var rvAdapter: RecyclerViewAdapter
    var  apps =  ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView = findViewById(R.id.recView)
     rvAdapter = RecyclerViewAdapter(apps)
        recView.adapter = rvAdapter
        recView.layoutManager = LinearLayoutManager(this)
        getData()
//        withContext(Dispatchers.Main){
//
//
//        }

}

    fun getData(){


        val feedAPI = APIClient().getClient()?.create(FeedAPI::class.java)
        feedAPI?.feed?.enqueue(object : Callback<Feed?> {


            override fun onResponse(call: Call<Feed?>, response: Response<Feed?>) {

                Log.d(TAG, "onResponse: feed: " + response.body().toString())
                Log.d(TAG, "onResponse: Server Response: $response")
                val xmlresponse = response.errorBody()
                Log.d(TAG, "onResponse: feed: $xmlresponse")
                for(data in response.body()!!.entry!!){
                    apps.add(data.title.toString())



                }
                rvAdapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<Feed?>, t: Throwable) {
                Log.d(TAG, "onFailure: "+t.message+"")
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }

}

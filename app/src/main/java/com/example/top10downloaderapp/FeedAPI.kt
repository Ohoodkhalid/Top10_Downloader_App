package com.example.top10downloaderapp

import retrofit2.Call
import retrofit2.http.GET

interface  FeedAPI {

    @get:GET("/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml")
    val feed: Call<Feed?>?

}
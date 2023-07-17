package com.example.news_app.Api

import com.example.news_app.model.NewsResponse
import com.example.news_app.model.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("v2/top-headlines/sources")
    fun getNewssources(
        @Query("apiKey") apikey:String,
        @Query("category") category:String
    ):Call<SourcesResponse>

    @GET("v2/everything")
    fun getNewsFromSources(
        @Query ("apiKey") apikey: String?,
        @Query ("sources")source:String,
        @Query("q") query: String?=null
    ) :Call<NewsResponse>
}
package com.guleryigitcan.beerexpert.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerRetrofitFactory private constructor() {

    var service:BeerService?=null

    init {
        val client=okhttp3.OkHttpClient.Builder()
            .build()

        val retrofit=Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service= retrofit.create(BeerService::class.java)
    }

    companion object {
        private var INSTANCE: BeerRetrofitFactory?=null

        val instance: BeerRetrofitFactory
            get() {
                if(INSTANCE==null){
                    INSTANCE= BeerRetrofitFactory()
                }
                return INSTANCE!!
            }
    }
}
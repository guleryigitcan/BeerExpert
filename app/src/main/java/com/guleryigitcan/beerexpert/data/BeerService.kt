package com.guleryigitcan.beerexpert.data

import com.guleryigitcan.beerexpert.model.BeerListModel
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.Path

interface BeerService {

    //Get beers from first page
    @GET("beers?page=1&per_page=20")
    fun getBeers():Call<BeerListModel>

    //Get beer by id for detail page
    @GET("beers/{id}")
    fun getById(
        @Path("id")beerId:Int):Call<BeerListModel>
}
package com.guleryigitcan.beerexpert.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guleryigitcan.beerexpert.data.BeerRetrofitFactory
import com.guleryigitcan.beerexpert.model.BeerListModel
import com.guleryigitcan.beerexpert.model.BeerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeerViewModel:ViewModel() {

    private val _beerList=MutableLiveData<List<BeerModel>>()
    val beerList get() =_beerList
    private val _beerDetailList=MutableLiveData<List<BeerModel>>()
    val beerDetailList get()=_beerDetailList


    fun getData(){
        BeerRetrofitFactory.instance.service?.getBeers()?.enqueue(object :Callback<BeerListModel>{
            override fun onResponse(
                call: Call<BeerListModel>?,
                response: Response<BeerListModel>?
            ) {
                val listOfBeers=response?.body()
                _beerList.value=listOfBeers
            }

            override fun onFailure(call: Call<BeerListModel>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getById(beerId:Int){
        BeerRetrofitFactory.instance.service?.getById(beerId)?.enqueue((object :Callback<BeerListModel>{
            override fun onResponse(
                call: Call<BeerListModel>?,
                response: Response<BeerListModel>?
            ) {
                val detailed=response?.body()
                _beerDetailList.value=detailed

            }

            override fun onFailure(call: Call<BeerListModel>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        }))
    }
}
package com.guleryigitcan.beerexpert.model

data class BeerModel(
    val id:Int?=null,
    val name:String?=null,
    val tagline:String?=null,
    val image_url:String?=null,
    val description:String?=null,
    val brewers_tips:String?=null,
    val contributed_by: String?=null

)

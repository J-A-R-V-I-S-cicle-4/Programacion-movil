package com.jarvis.poi.data

class PlacesofinterestRepository {

   suspend fun getPlacesofinterest() = ApiFactory.retrofit.getPlacesofinterest()

}
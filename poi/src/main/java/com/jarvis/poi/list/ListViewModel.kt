package com.jarvis.poi.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jarvis.poi.model.Placesofinterest
import com.jarvis.poi.model.PlacesofinterestItem
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var poiLoad: MutableLiveData<ArrayList<PlacesofinterestItem>> = MutableLiveData()
    val onPoiLoaded: LiveData<ArrayList<PlacesofinterestItem>> = poiLoad

    fun loadMockPLaceOfinterestFromJson(poiString: InputStream?) {

        val poiString = poiString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        poiLoad.value = gson.fromJson(poiString, Placesofinterest::class.java)

    }
}
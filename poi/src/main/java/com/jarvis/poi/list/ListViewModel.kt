package com.jarvis.poi.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jarvis.poi.data.PlacesofinterestRepository
import com.jarvis.poi.model.Placesofinterest
import com.jarvis.poi.model.PlacesofinterestItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private  var placesofinterestLoad : MutableLiveData<ArrayList<PlacesofinterestItem>> = MutableLiveData()
    val onPlacesofinterestLoaded: LiveData<ArrayList<PlacesofinterestItem>> = placesofinterestLoad

    private val repository = PlacesofinterestRepository()

    fun getPlacesofinterestFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            placesofinterestLoad.postValue(repository.getPlacesofinterest())
        }
    }

    fun loadMockPLaceOfinterestFromJson(poiString: InputStream?) {
        val poiString = poiString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        placesofinterestLoad.value = gson.fromJson(poiString, Placesofinterest::class.java)
    }
}
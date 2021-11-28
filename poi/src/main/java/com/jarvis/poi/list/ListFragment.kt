package com.jarvis.poi.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.jarvis.poi.databinding.FragmentListBinding
import com.jarvis.poi.main.MainActivity
import com.jarvis.poi.model.Placesofinterest
import com.jarvis.poi.model.PlacesofinterestItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var listPoi: ArrayList<PlacesofinterestItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listPoi = loadMockPLaceOfinterestFromJson()
        poiAdapter = PoiAdapter(listPoi, onItemClicked = {onPoiClicked(it) })
        listBinding.poiRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }


    private fun onPoiClicked(placeofinterest: PlacesofinterestItem) {
        //findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment()
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = placeofinterest))
    }

    private fun loadMockPLaceOfinterestFromJson(): ArrayList<PlacesofinterestItem> {

        val poiString: String = context?.assets?.open("poi.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Placesofinterest::class.java)

        return poiList

    }
}
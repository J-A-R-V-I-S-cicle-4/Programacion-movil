package com.jarvis.poi.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jarvis.poi.databinding.FragmentListBinding
import com.jarvis.poi.main.MainActivity
import com.jarvis.poi.model.PlacesofinterestItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var poiAdapter: PoiAdapter
    private var listPoi: ArrayList<PlacesofinterestItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        // listViewModel.loadMockPLaceOfinterestFromJson(context?.assets?.open("poi.json"))

        listViewModel.getPlacesofinterestFromServer()

        listViewModel.onPlacesofinterestLoaded.observe(viewLifecycleOwner, { result ->
            onPlacesofinterestLoadedSuscrube(result)

        })

        poiAdapter = PoiAdapter(listPoi, onItemClicked = {onPoiClicked(it) })

        listBinding.poiRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPlacesofinterestLoadedSuscrube(result: ArrayList<PlacesofinterestItem>?) {
        result?.let { listPoi ->
            poiAdapter.appendItems(listPoi)
            //this.listPoi = listPoi
            //poiAdapter.notifyDataSetChanged()
        }
    }


    private fun onPoiClicked(placeofinterest: PlacesofinterestItem) {
        //findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment()
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = placeofinterest))
    }
}
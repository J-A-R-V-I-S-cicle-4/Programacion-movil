package com.jarvis.poi.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jarvis.poi.databinding.FragmentDetailBinding
import com.jarvis.poi.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val placeofinterest = args.poi

        with(detailBinding) {
            nameTextView.text = placeofinterest.nombre
            informationTextView.text = placeofinterest.informacion
            locationTextView.text = placeofinterest.ubicacion
            temperatureTextView.text = placeofinterest.temperatura
            placesTextView.text = placeofinterest.sitios
            Picasso.get().load(placeofinterest.urlPicture2).into(pictureImageView)
        }
    }
}
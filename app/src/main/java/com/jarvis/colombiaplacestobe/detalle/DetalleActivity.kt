package com.jarvis.colombiaplacestobe.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jarvis.colombiaplacestobe.databinding.ActivityDetalleBinding
import com.jarvis.colombiaplacestobe.model.PlacesofinterestItem

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val placeofinterest: PlacesofinterestItem = intent.extras?.getSerializable("placeofinterest") as PlacesofinterestItem

        with(detalleBinding) {
            nameTextView!!.text = placeofinterest.nombre
            informationTextView!!.text = placeofinterest.informacion
            locationTextView!!.text = placeofinterest.ubicacion
            temperatureTextView!!.text = placeofinterest.temperatura
            placesTextView!!.text = placeofinterest.sitios
        }
    }
}


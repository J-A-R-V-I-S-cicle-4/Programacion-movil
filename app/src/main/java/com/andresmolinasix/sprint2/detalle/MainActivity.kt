package com.andresmolinasix.sprint2.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andresmolinasix.sprint2.R
import com.andresmolinasix.sprint2.databinding.ActivityMainBinding
import com.andresmolinasix.sprint2.model.TurismoItem
import com.squareup.picasso.Picasso
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)


        val turismo : TurismoItem = intent.extras?.getSerializable("turismo") as TurismoItem
        with (detalleBinding){
            nameTextView?.text  = turismo.name
            descriptionTextView?.text = turismo.description
            informationTextView?.text = turismo.information
            scoreTextView?.text = turismo.score.toString()
            Picasso.get().load(turismo.url).into(pictureImageView)
        }
    }
}
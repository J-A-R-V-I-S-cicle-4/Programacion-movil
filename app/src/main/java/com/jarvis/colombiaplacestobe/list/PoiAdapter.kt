package com.jarvis.colombiaplacestobe.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jarvis.colombiaplacestobe.R
import com.jarvis.colombiaplacestobe.model.PlacesofinterestItem
import com.squareup.picasso.Picasso

class PoiAdapter(
    private val poiList: ArrayList<PlacesofinterestItem>,
    private val onItemClicked: (PlacesofinterestItem) -> Unit
) : RecyclerView.Adapter<PoiAdapter.PlaceofinterestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceofinterestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item, parent, false)
        return PlaceofinterestViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceofinterestViewHolder, position: Int) {
        val placesofinterest = poiList[position]
        holder.itemView.setOnClickListener { onItemClicked(poiList[position]) }
        holder.bind(placesofinterest)

    }

    override fun getItemCount(): Int = poiList.size

    class PlaceofinterestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        private var informationTextView: TextView = itemView.findViewById(R.id.information_text_view)
        private var locationTextView: TextView = itemView.findViewById(R.id.location_text_view)
        private var temperatureTextView: TextView = itemView.findViewById(R.id.temperature_text_view)
        private var placesTextView: TextView = itemView.findViewById(R.id.places_text_view)
        private var scoreTextView: TextView = itemView.findViewById(R.id.score_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(placesofinterest: PlacesofinterestItem){
            nameTextView.text = placesofinterest.nombre
            descriptionTextView.text = placesofinterest.descripcion
            informationTextView.text = placesofinterest.informacion
            locationTextView.text = placesofinterest.ubicacion
            temperatureTextView.text = placesofinterest.temperatura
            placesTextView.text = placesofinterest.sitios
            scoreTextView.text = placesofinterest.calificacion.toString()
            Picasso.get().load(placesofinterest.urlPicture).into(pictureImageView)

        }
    }
}
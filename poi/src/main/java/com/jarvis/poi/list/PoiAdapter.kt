package com.jarvis.poi.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jarvis.poi.R
import com.jarvis.poi.model.PlacesofinterestItem
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
        private var scoreTextView: TextView = itemView.findViewById(R.id.score_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
        private var pictureListImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(placesofinterest: PlacesofinterestItem){
            nameTextView.text = placesofinterest.nombre
            descriptionTextView.text = placesofinterest.descripcion
            scoreTextView.text = placesofinterest.calificacion.toString()
            Picasso.get().load(placesofinterest.urlPicture).into(pictureImageView)

        }
    }
}


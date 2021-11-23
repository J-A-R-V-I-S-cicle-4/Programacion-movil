package com.andresmolinasix.sprint2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TurismoAdapter (private val turismoList: ArrayList<Turismo>): RecyclerView.Adapter <TurismoAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.card_view_turismo, parent, false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitio = turismoList[position]
        holder.bind(sitio)

    }

    override fun getItemCount(): Int =turismoList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val nameTextView : TextView = itemView.findViewById(R.id.name_text_view)
        private val descripTextView: TextView = itemView.findViewById(R.id.descrip_text_view)
        private val imagenPictureView : ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(turismo: Turismo){
            nameTextView.text = turismo.name
            descripTextView.text = turismo.information
            Picasso.get().load(turismo.url).into(imagenPictureView);

        }

    }
}
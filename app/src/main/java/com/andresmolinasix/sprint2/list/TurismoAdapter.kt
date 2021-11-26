package com.andresmolinasix.sprint2.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andresmolinasix.sprint2.R
import com.andresmolinasix.sprint2.model.TurismoItem
import com.squareup.picasso.Picasso

class TurismoAdapter (
    private val turismoList: ArrayList<TurismoItem>,
    private val onItemClicked : (TurismoItem) -> Unit
): RecyclerView.Adapter <TurismoAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.card_view_turismo, parent, false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitio = turismoList[position]
        holder.itemView.setOnClickListener{onItemClicked(turismoList[position])}
        holder.bind(sitio)

    }

    override fun getItemCount(): Int =turismoList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val nameTextView : TextView = itemView.findViewById(R.id.name_text_view)
        private val descripTextView: TextView = itemView.findViewById(R.id.descrip_text_view)
        private val imagenPictureView : ImageView = itemView.findViewById(R.id.picture_image_view)
        private val imagenListPictureView : ImageView = itemView.findViewById(R.id.picture_image_view)
        private val scoreTextView : TextView =itemView.findViewById(R.id.score_text_view)

        fun bind(turismo: TurismoItem){
            nameTextView.text = turismo.name
            descripTextView.text = turismo.information
            Picasso.get().load(turismo.url).into(imagenPictureView);
            scoreTextView.text = turismo.score.toString()

        }

    }
}
package com.jarvis.colombiaplacestobe.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jarvis.colombiaplacestobe.R
import com.jarvis.colombiaplacestobe.detalle.DetalleActivity
import com.jarvis.colombiaplacestobe.model.Placesofinterest
import com.jarvis.colombiaplacestobe.model.PlacesofinterestItem

class ListPlaceOfInterest : AppCompatActivity() {

    private lateinit var listPoi: ArrayList<PlacesofinterestItem>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var poiRecycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_place_of_interest)

        poiRecycleView = findViewById(R.id.poi_recycle_view)

        //listPoi = createMockPlaceofinterest()
        listPoi = loadMockPLaceOfinterestFromJson()
        poiAdapter = PoiAdapter(listPoi, onItemClicked = {onPoiClicked(it) })

        poiRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiClicked(placeofinterest: PlacesofinterestItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("placeofinterest", placeofinterest)
        startActivity(intent)
    }

    private fun loadMockPLaceOfinterestFromJson(): ArrayList<PlacesofinterestItem> {

        val poiString: String = applicationContext.assets.open("poi.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(poiString, Placesofinterest::class.java)

        return data

    }

    /*private fun createMockPlaceofinterest() : ArrayList<Placesofinterest>{
        return arrayListOf(
            Placesofinterest(
                nombre = "Bogotá",
                descripcion = "Capital de Colombia, sitio turístico, conocida por su variada cultura y multiples lugares.",
                calificacion = 5.0,
                urlPicture = "https://primiciadiario.com/wp-content/uploads/2018/09/Bogota-1024x522.jpg"
            ),
            Placesofinterest(
                nombre = "Girardot",
                descripcion = "Municipio conocido por sus fiestas, bares y piscinas.",
                calificacion = 4.5,
                urlPicture = "https://3.bp.blogspot.com/-ohoHkojbYrw/Tl18IE_bNII/AAAAAAAAJ9I/osSjWhesBPI/s320/DSC07022.JPG"
            ),
            Placesofinterest(
                nombre = "Guatavita",
                descripcion = "Conocida por la leyenda del Dorado, esta laguna es un lugar sagrado y de muchos misterios.",
                calificacion = 4.8,
                urlPicture = "https://seecolombia.travel/blog/wp-content/uploads/2011/06/IMG_0485-1024x682.jpg"
            ),
            Placesofinterest(
                nombre = "Villa de Leyva",
                descripcion = "Municipio conocido por su arquitectura colonial, los varios paisajes que lo conforman y sus reconocidos festivales.",
                calificacion = 4.9,
                urlPicture = "https://primiciadiario.com/wp-content/uploads/2017/03/Villa-de-Leyva-1024x685.jpg"
            ),
            Placesofinterest(
                nombre = "Zipaquirá",
                descripcion = "Conocida por su Catedral de Sal  y su cultura indígena.",
                calificacion = 4.0,
                urlPicture = "https://zipaquira.in/wp-content/uploads/2015/01/zipaturistica.jpg"
            )
        )
    }*/
}
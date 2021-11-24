package com.andresmolinasix.sprint2.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andresmolinasix.sprint2.R
import com.andresmolinasix.sprint2.model.Turismo
import com.andresmolinasix.sprint2.model.TurismoItem
import com.google.gson.Gson

class ListTurismoActivity : AppCompatActivity() {

    // declarar que la no se incializará el la clase de inmediato
    private lateinit var listSitios: ArrayList<TurismoItem>
    private lateinit var turismoAdapter: TurismoAdapter
    private lateinit var turismoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_turismo)

        turismoRecyclerView = findViewById(R.id.turismo_recycler_view)

        //listSitios = craeteMockTurismo()
        listSitios = loadMockTurismoFromJson()

        turismoAdapter = TurismoAdapter(listSitios)

        turismoRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = turismoAdapter
            setHasFixedSize(false)
        }


    }

    private fun loadMockTurismoFromJson(): ArrayList<TurismoItem> {

        val sitioString : String = applicationContext.assets.open("Turismo.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        return gson.fromJson(sitioString, Turismo::class.java)

    }

  /*  private fun craeteMockTurismo(): ArrayList<Turismo> {
        return arrayListOf(
            Turismo(
                name = "San Cipriano.",
                information = "Reserva natural.",
                url = "https://res.cloudinary.com/dai1kxhb3/image/upload/v1637381037/sanciprianoescalar_b90e6f.jpg",
                score = 4.3f
            ),
            Turismo(
                name = "Pico del Loro.",
                information = "Montaña a 2.300 metros.",
                url = "https://res.cloudinary.com/dai1kxhb3/image/upload/v1637381012/picodelloroescalar_eoeivh.jpg",
                score = 4.0f
            ),
            Turismo(
                name = "Gorgona.",
                information = "Antigua prisión.",
                url =  "https://res.cloudinary.com/dai1kxhb3/image/upload/v1637380998/islagorgonaescalar_gccgfl.jpg",
                score = 4.5f

            ),
            Turismo(
                name= "Tatacoa",
                information = "Desierto.",
                url = "https://res.cloudinary.com/dai1kxhb3/image/upload/v1637547358/desiertoescalar_lnr3tw.jpg",
                score =5.0f
            )


        )
    }*/
}
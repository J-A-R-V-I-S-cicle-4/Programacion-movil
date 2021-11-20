package com.jarvis.colombiaplacestobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegistroPoi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_registro_poi)

        val registrarButton: Button = findViewById(R.id.registrar_button)
        val nombreEditText: EditText = findViewById(R.id.nombre_edit_text)
        val infoTextView: TextView = findViewById(R.id.info_text_view)
        val descripcionEditText: EditText = findViewById(R.id.descripcion_edit_text)
        val infoDescripcionTextView: TextView = findViewById(R.id.info_descripcion_text_view)

        registrarButton.setOnClickListener {
            val nombre : String = nombreEditText.text.toString()
            val descripcion : String = descripcionEditText.text.toString()
            infoTextView.text = nombre
            infoDescripcionTextView.text = descripcion

            //val placeofinterest = Placesofinterest(nombre, descripcion)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nombre", nombre)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Metodo", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Metodo", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Metodo", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Metodo", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Metodo", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Metodo", "onRestart")
    }
}


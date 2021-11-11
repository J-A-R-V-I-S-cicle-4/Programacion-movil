package com.example.myprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val registrarButton: Button = findViewById(R.id.registrar_button)
        val nombreEditText: EditText = findViewById(R.id.nombre_edit_texto)
        var inforTextView: TextView = findViewById(R.id.info_text_view)

        registrarButton.setOnClickListener {
            val nombre = nombreEditText.text
            inforTextView.text = nombre
        }
    }
}
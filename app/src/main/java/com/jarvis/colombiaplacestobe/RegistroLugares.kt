package com.jarvis.colombiaplacestobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistroLugares : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regitro_lugares)

        val registrarButton: Button = findViewById(R.id.registrar_button)
        val lugarEditText: EditText = findViewById(R.id.lugar_edit_text)
        val infoTextView: TextView = findViewById(R.id.info_text_view)
        val elevacionEditText: TextInputEditText = findViewById(R.id.elevacion_edit_text)

        registrarButton.setOnClickListener{
            val lugar: String = lugarEditText.text.toString()
            val elevacion: Float = elevacionEditText.text.toString().toFloat()

            infoTextView.text = getString(R.string.place, lugar, elevacion)
        }

    }
}
package com.example.promediodenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombreEstudiante = findViewById<EditText>(R.id.etNombre)
        val nota1 = findViewById<EditText>(R.id.etNota1)
        val nota2 = findViewById<EditText>(R.id.etNota2)
        val nota3 = findViewById<EditText>(R.id.etNota3)
        val nota4 = findViewById<EditText>(R.id.etNota4)
        val nota5 = findViewById<EditText>(R.id.etNota5)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val calcular = findViewById<Button>(R.id.btnCalcular)

        calcular.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val nota1Value = nota1.text.toString().toFloatOrNull()
            val nota2Value = nota2.text.toString().toFloatOrNull()
            val nota3Value = nota3.text.toString().toFloatOrNull()
            val nota4Value = nota4.text.toString().toFloatOrNull()
            val nota5Value = nota5.text.toString().toFloatOrNull()

            if (nota1Value == null || nota2Value == null || nota3Value == null || nota4Value == null || nota5Value == null ||
                nota1Value < 0 || nota1Value > 10 ||
                nota2Value < 0 || nota2Value > 10 ||
                nota3Value < 0 || nota3Value > 10 ||
                nota4Value < 0 || nota4Value > 10 ||
                nota5Value < 0 || nota5Value > 10) {

                Toast.makeText(this, "Ingresar valores entre 0 - 10", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val promedio = (nota1Value * 0.15f) +
                    (nota2Value * 0.15f) +
                    (nota3Value * 0.20f) +
                    (nota4Value * 0.25f) +
                    (nota5Value * 0.25f)

            resultado.text = if (promedio >= 6) {
                "El estudiante $nombre aprobado con un promedio de ${"%.2f".format(promedio)}"
            } else {
                "El estudiante $nombre reprobo con un promedio de ${"%.2f".format(promedio)}"
            }
        }
    }
}

/**
 * Integrantes
 * - Gabriel Henrique - 8640
 * - Hericlis Ventura - 85587
 */
package com.example.checkpoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val btnContaTelefonica = findViewById<Button>(R.id.buttonContaTelefonica)
        val btnIntegrantes = findViewById<Button>(R.id.buttonIntegrantes)

        btnCalculadora.setOnClickListener{
            var intentCalculadora = Intent(this, CalculadoraActivity::class.java)
            intentCalculadora.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentCalculadora)
        }
        btnContaTelefonica.setOnClickListener{
            var intentContaTelefonica = Intent(this, ContaTelefonicaActivity::class.java)
            intentContaTelefonica.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentContaTelefonica)
        }
        btnIntegrantes.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Desenvolvido por")
            builder.setMessage("Gabriel Henrique\nHericlis Ventura")
            builder.setPositiveButton("OK", null)
            builder.create().show()
        }
    }
}
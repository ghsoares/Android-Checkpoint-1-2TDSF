/**
 * Integrantes
 * - Gabriel Henrique - 8640
 * - Hericlis Ventura - 85587
 */
package com.example.checkpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ContaTelefonicaResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica_resultado)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Aparece o botão para retornar para a activity anterior

        mostrarResultados() // Coloca nos labels os valores dos resultados
    }

    // Tbm nn entendi kkkkk mas é usado para poder retornar para a activity anterior
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    fun mostrarResultados() {
        val valorAssinatura = intent.getDoubleExtra("resultadoValorAssinatura", 0.0)
        val valorChamadaLocal = intent.getDoubleExtra("resultadoValorChamadaLocal", 0.0)
        val valorChamadaCelular = intent.getDoubleExtra("resultadoValorChamadaCelular", 0.0)
        val valorTotal = intent.getDoubleExtra("resultadoValorTotal", 0.0)

        val textAssinaturaValor = findViewById<TextView>(R.id.textAssinaturaValor)
        val textChamadaLocalValor = findViewById<TextView>(R.id.textChamadaLocalValor)
        val textChamadaCelularValor = findViewById<TextView>(R.id.textChamadaCelularValor)
        val textValorTotalValor = findViewById<TextView>(R.id.textValorTotalValor)

        textAssinaturaValor.text = ": R$$valorAssinatura"
        textChamadaLocalValor.text = ": R$$valorChamadaLocal"
        textChamadaCelularValor.text = ": R$$valorChamadaCelular"
        textValorTotalValor.text = ": R$$valorTotal"
    }
}
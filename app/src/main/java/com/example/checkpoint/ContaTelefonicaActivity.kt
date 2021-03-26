/**
 * Integrantes
 * - Gabriel Henrique - 8640
 * - Hericlis Ventura - 85587
 */
package com.example.checkpoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContaTelefonicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Aparece o botão para retornar para a activity anterior
        calcularContaTelefonicaEventos() // Inicia os listeners e eventos da activity
    }

    // Tbm nn entendi kkkkk mas é usado para poder retornar para a activity anterior
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    fun calcularContaTelefonicaEventos() {
        // Valores pré-definidos (pelo documento do ck) por minuto
        val valorChamadaLocal = 0.04
        val valorChamadaCelular = 0.20

        // Pega o EditText do valor da assinatura
        val editAssinatura = findViewById<EditText>(R.id.editAssinatura)
        // Pega o EditText da quantidade de minutos de chamada local
        val editMinutosChamadaLocal = findViewById<EditText>(R.id.editMinutosChamadaLocal)
        // Pega o EditText da quantidade de minutos de chamada celular
        val editMinutosChamadaCelular = findViewById<EditText>(R.id.editMinutosChamadaCelular)

        // Botão que quando pressionado, deve ser calculado o valor da conta
        val btnCalcular = findViewById<Button>(R.id.buttonCalcularTelefone)

        btnCalcular.setOnClickListener {
            // Essas três variáveis pega o texto (string) dos campos:
            // - Valor assinatura
            // - Quantidade de minutos de chamada celular
            // - Quantidade de minutos de chamada celular
            var assinaturaText = editAssinatura.text.toString()
            var minutosLocalText = editMinutosChamadaLocal.text.toString()
            var minutosCelularText = editMinutosChamadaCelular.text.toString()

            // Checa se todos os campos estão preenchidos com algum valor (caso não, encerra o listener)
            if (assinaturaText == "" || minutosLocalText == "" || minutosCelularText == "") {
                // Mensagem de feedback
                Toast.makeText(this, "Nenhum dos valores pode ser vazio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Texto dos inputs transformados em doubles
            var valorAssinatura = assinaturaText.toDouble()
            var qtdMinutosLocal = minutosLocalText.toDouble()
            var qtdMinutosCelular = minutosCelularText.toDouble()

            // Converte usando os valores pré-definidos
            var valorTotalMinutosLocal = qtdMinutosLocal * valorChamadaLocal
            var valorTotalMinutosCelular = qtdMinutosCelular * valorChamadaCelular

            var valorTotal = valorAssinatura + valorTotalMinutosLocal + valorTotalMinutosCelular

            // Transfere para o activity resultado
            var intentResultado = Intent(this, ContaTelefonicaResultadoActivity::class.java)
            // Insere os resultados para o intent da activity
            intentResultado.putExtra("resultadoValorAssinatura", valorAssinatura)
            intentResultado.putExtra("resultadoValorChamadaLocal", valorTotalMinutosLocal)
            intentResultado.putExtra("resultadoValorChamadaCelular", valorTotalMinutosCelular)
            intentResultado.putExtra("resultadoValorTotal", valorTotal)
            startActivity(intentResultado)
        }
    }
}







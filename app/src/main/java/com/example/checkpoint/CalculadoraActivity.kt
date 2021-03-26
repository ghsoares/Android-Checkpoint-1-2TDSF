/**
 * Integrantes
 * - Gabriel Henrique - 8640
 * - Hericlis Ventura - 85587
 */
package com.example.checkpoint

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        calculadoraEventos()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    fun calculadoraEventos() {
        val editValor1 = findViewById<EditText>(R.id.editNumberValor1)
        val editValor2 = findViewById<EditText>(R.id.editNumberValor2)

        val operacaoGroup = findViewById<RadioGroup>(R.id.operacoesGroup)

        val btnCalcular = findViewById<Button>(R.id.buttonCalcular)

        btnCalcular.setOnClickListener {
            var valorText1 = editValor1.text.toString()
            var valorText2 = editValor2.text.toString()

            if (valorText1 == "" || valorText2 == "") {
                Toast.makeText(this, "Nenhum dos valores pode ser vazio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var valor1 = Integer.parseInt(valorText1)
            var valor2 = Integer.parseInt(valorText2)
            var msg = ""

            when (operacaoGroup.checkedRadioButtonId) {
                R.id.operacaoSoma -> {
                    var res = valor1 + valor2
                    msg = "Resultado da soma: " + valor1 + " + " + valor2 + " = " + res
                }
                R.id.operacaoSubtracao -> {
                    var res = valor1 - valor2
                    msg = "Resultado da subtração: " + valor1 + " - " + valor2 + " = " + res
                }
                R.id.operacaoMultiplicacao -> {
                    var res = valor1 * valor2
                    msg = "Resultado da multiplicação: " + valor1 + " * " + valor2 + " = " + res
                }
                R.id.operacaoDivisao -> {
                    var res = valor1 / valor2
                    msg = "Resultado da divisão: " + valor1 + " / " + valor2 + " = " + res
                }
            }

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
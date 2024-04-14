package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

        fun onNumberClick(view: View) {
            val button = view as Button
            val currentNumber = resultTextView.text.toString()

            resultTextView.text = if (currentNumber == operator || currentNumber == "Error") {
                button.text
            } else {
                currentNumber + button.text
            }
        }

        fun onOperatorClick(view: View) {
            val button = view as Button
            operator = button.text.toString()
            operand1 = resultTextView.text.toString().toDouble()
            resultTextView.text = operator;
        }

        fun onClearClick(view: View) {
            resultTextView.text = "0"
            operand1 = 0.0
            operator = null
        }

        fun onEqualClick(view: View) {
            val operand2 = resultTextView.text.toString().toDouble()
            var result = 0.0

            when (operator) {
                "+" -> result = operand1 + operand2
                "-" -> result = operand1 - operand2
                "*" -> result = operand1 * operand2
                "/" -> {
                    if (operand2 != 0.0) {
                        result = operand1 / operand2
                    } else {
                        resultTextView.text = "Error"
                        return
                    }
                }
            }

            resultTextView.text = result.toString()
            Toast.makeText(applicationContext,resultTextView.text,Toast.LENGTH_LONG).show();
            operator = null
        }
    }

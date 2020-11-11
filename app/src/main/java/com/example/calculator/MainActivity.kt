package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.TextureView
import android.view.View
import android.widget.TextView

abstract class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView

    private var operatnt: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(view: View) {

        if (view is TextView) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {

                operatnt = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }

    }

    fun equalsClick(view: View) {

        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }

        when (operation) {

            "+" ->resultTextView.text = (secOperand + secOperand).toString()
            "-" ->resultTextView.text = (secOperand - secOperand).toString()
            "*" ->resultTextView.text = (secOperand * secOperand).toString()
            "/" ->resultTextView.text = (secOperand / secOperand).toString()
        }

    }

    fun clearClick(view: View) {
        resultTextView.text = ""

    }

}
package com.example.codelabpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.codelabpractices.util.Calculator

class CodeLab3Dot1Activity : AppCompatActivity() {
    companion object {
        const val LOG_TAG = "CalculatorActivity"
    }
    private val  mCalculator = Calculator()
    private lateinit var mOperandOneEditText: EditText
    private lateinit var mOperandTwoEditText: EditText
    private lateinit var mResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_lab3_dot1)

        mResultTextView = findViewById(R.id.operation_result_text_view)
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text)
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text)

        findViewById<Button>(R.id.operation_add_btn).setOnClickListener { compute(Calculator.Operator.ADD) }
        findViewById<Button>(R.id.operation_sub_btn).setOnClickListener { compute(Calculator.Operator.SUB) }
        findViewById<Button>(R.id.operation_mul_btn).setOnClickListener { compute(Calculator.Operator.MUL) }
        findViewById<Button>(R.id.operation_div_btn).setOnClickListener { computeDiv() }
    }

    private fun computeDiv() {
        try {
            compute(Calculator.Operator.DIV)
        } catch (e: java.lang.IllegalArgumentException) {
            Log.e(LOG_TAG, "IllegalArgumentException: $e")
            mResultTextView.text = getString(R.string.computationError)
        }
    }

    private fun compute(operator: Calculator.Operator) {
        val a: Double
        val b: Double
        try {
            a = getOperand(mOperandOneEditText)
            b = getOperand(mOperandTwoEditText)
        } catch (e: java.lang.NumberFormatException) {
            Log.e(LOG_TAG, "NumberFormatException: $e")
            mResultTextView.text = getString(R.string.computationError)
            return
        }

        val result = when(operator) {
            Calculator.Operator.ADD -> mCalculator.add(a, b)
            Calculator.Operator.SUB -> mCalculator.sub(a, b)
            Calculator.Operator.DIV -> mCalculator.div(a, b)
            Calculator.Operator.MUL -> mCalculator.mul(a, b)
        }
        mResultTextView.text = result.toString()
    }

    private fun getOperand(operandEditText: EditText): Double {
        return operandEditText.text.toString().toDouble()
    }
}
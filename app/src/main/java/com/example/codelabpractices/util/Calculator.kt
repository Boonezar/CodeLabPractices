package com.example.codelabpractices.util

class Calculator {
    enum class Operator {
        ADD,
        SUB,
        DIV,
        MUL
    }

    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun sub(a: Double, b: Double): Double {
        return a - b
    }

    fun div(a: Double, b: Double): Double {
        return a / b
    }

    fun mul(a: Double, b: Double): Double {
        return a * b
    }
}
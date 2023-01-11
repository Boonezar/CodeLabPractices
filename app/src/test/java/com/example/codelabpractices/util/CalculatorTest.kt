package com.example.codelabpractices.util

import io.kotest.matchers.doubles.shouldBeZero
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest {
    private lateinit var mCalculator: Calculator

    @BeforeEach
    fun setup() {
        mCalculator = Calculator()
    }

    @Test
    fun addTwoNumbers() {
        // Given
        // When
        val result = mCalculator.add(1.0, 1.0)

        // Then
        result.shouldBe(2.0)
    }

    @Test
    fun addTwoNumbersNegative() {
        // Given
        // When
        val result = mCalculator.add(-1.0, 2.0)

        // Then
        result.shouldBe(1.0)
    }

    @Test
    fun subTwoNumbers() {
        // Given
        // When
        val result = mCalculator.sub(1.0, 1.0)

        // Then
        result.shouldBeZero()
    }

    @Test
    fun subWorksWithNegativeResult() {
        // Given
        // When
        val result = mCalculator.sub(1.0, 17.0)

        // Then
        result.shouldBe(-16.0)
    }

    @Test
    fun mulTwoNumbers() {
        // Given
        // When
        val result = mCalculator.mul(32.0, 2.0)

        // Then
        result.shouldBe(64.0)
    }

    @Test
    fun divTwoNumbers() {
        // Given
        // When
        val result = mCalculator.div(32.0, 2.0)

        // Then
        result.shouldBe(16.0)
    }

    @Test
    fun divTwoNumbersZero() {
        // Given
        // When
        val result = mCalculator.div(32.0, 0.0)

        // Then
        result.shouldBe(Double.POSITIVE_INFINITY)
    }
}
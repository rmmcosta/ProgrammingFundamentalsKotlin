package week3_SpecialClasses

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

val fibonacciNumbers = listOf(0, 1, 2, 3, 5, 8, 13, 21, 34, 55)
val triangleNumbers = listOf(0, 1, 3, 6, 10, 15, 21, 28, 36, 45)
val powerOf10 = listOf(1, 10, 100, 1000, 10000, 100000)

private fun getBelongingSetLetter(inputted: Int?): String {
    val result: String = when {
        fibonacciNumbers.contains(inputted) -> "F"
        triangleNumbers.contains(inputted) -> "T"
        powerOf10.contains(inputted) -> "P"
        else -> "N"
    }
    return result
}

fun main() {
    val inputted = readln().toIntOrNull()
    val result: String = getBelongingSetLetter(inputted)
    println(result)
}

class TestCenas {

    @Test
    fun shouldReturnFWhenFibonacci() {
        assertEquals("F", getBelongingSetLetter(1))
    }

    @Test
    fun shouldReturnTWhenTriangle() {
        assertEquals("T", getBelongingSetLetter(15))
    }

    @Test
    fun shouldReturnPWhenPowerOf10() {
        assertEquals("P", getBelongingSetLetter(1000))
    }

    @Test
    fun shouldReturnNWhenNoSetFound() {
        assertEquals("N", getBelongingSetLetter(89))
    }
}



package week2_ClassesAndObjects

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PlayerTest {
    @Test
    fun shouldPresentTheFullNameOk() {
        val player = Player("Ana", "Ramos")
        assertEquals("Ana Ramos", player.fullName())
    }
}
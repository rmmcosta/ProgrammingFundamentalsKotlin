package week2_ClassesAndObjects

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScoreTest {
    @Test
    fun shouldFindTheCorrectWinner() {
        val p1 = Player("Ricardo", "Costa")
        val p2 = Player("Ana", "Ramos")
        val score = Score()
        score.addScore(p1, 1, 35.0)
        score.addScore(p1, 1, 25.0)
        score.addScore(p1, 2, 75.0)
        score.addScore(p1, 2, 55.0)
        score.addScore(p2, 1, 95.0)
        score.addScore(p2, 1, 85.0)
        score.addScore(p2, 2, 15.0)
        score.addScore(p2, 2, 25.0)
        assertEquals(p2, score.getWinner())
    }
}
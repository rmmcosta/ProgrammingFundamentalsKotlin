package week2_ClassesAndObjects

class Score {
    private val scores = mutableMapOf<Pair<Player, Int>, Double>()
    fun addScore(player: Player, level: Int, score: Double) {
        player.totalScore += score
        val bestScore = player.personalBestScore
        if (score > bestScore) {
            player.personalBestScore = score
        }
        scores += ((player to level) to score)
    }

    fun getWinner(): Player = scores.map { it.key.first to it.value }.maxBy { it.second }.first
}
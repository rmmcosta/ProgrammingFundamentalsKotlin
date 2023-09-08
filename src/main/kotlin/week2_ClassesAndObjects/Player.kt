package week2_ClassesAndObjects

data class Player(val name: String, val surName: String) {
    var totalScore:Double = 0.0
    var personalBestScore:Double = 0.0

    fun fullName(): String = "$name $surName"
}
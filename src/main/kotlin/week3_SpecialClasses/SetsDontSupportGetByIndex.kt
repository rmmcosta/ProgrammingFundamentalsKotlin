package week3_SpecialClasses

fun main() {
    val theSet = setOf(1, 3, 4)
//    println(theSet[1])//not supported
    println(1 in theSet)
    println(5 in theSet)
    for (i in theSet) {
        println(i)
    }
}
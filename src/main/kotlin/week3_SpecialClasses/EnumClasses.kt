package week3_SpecialClasses

import java.util.*

enum class WeekDay {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

enum class Difficulty {
    EASY,
    MEDIUM,
    HIGH
}

enum class PizzaSize(val sizeInCm: Int) {
    SMALL(15),
    MEDIUM(20),
    LARGE(25),
    EXTRALARGE(30)
}

fun doSomethingWithWeekDay(weekDay: WeekDay) {
    println(weekDay)
}

fun printPizzaSizeInCm(pizzaSize: PizzaSize) = println("pizza size in cm: ${pizzaSize.sizeInCm}")

fun main() {
    printPizzaSizeInCm(PizzaSize.MEDIUM)
    printPizzaSizeInCm(PizzaSize.EXTRALARGE)
    println(PizzaSize.SMALL)
    println(PizzaSize.LARGE.ordinal)

    for (i in PizzaSize.entries) {
        print(i)
    }
    println()
    println(PizzaSize.entries.joinToString(", "))
    println(PizzaSize.valueOf("small".uppercase(Locale.getDefault())))
    //doSomethingWithWeekDay("TUESDAY")//doesn't compile
}
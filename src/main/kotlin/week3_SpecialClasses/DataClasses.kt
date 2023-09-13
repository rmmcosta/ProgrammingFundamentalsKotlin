package week3_SpecialClasses

data class Dog(val name: String, val age: Int)

fun main() {
    val dog1 = Dog("Cacao", 7)
    val dog2 = Dog("Freddy", 5)
    val dog3 = Dog("Cacao", 7)

    println(dog1 == dog3)//true
    println(dog1 == dog2)//false
    println(dog1 === dog2)//false
    println(dog1 === dog3)//false

    //properties destructuring
    val (x, y) = dog2
    println("name: $x, age:$y")

    //copy function
    val youngerDog1 = dog1.copy(age = 3)
    println("younger dog1: $youngerDog1, older dog1: $dog1")
    val doubleTheAgeDog1 = dog1.copy(age = dog1.age*2)
    println("double the age dog1: $doubleTheAgeDog1, older dog1: $dog1")
}
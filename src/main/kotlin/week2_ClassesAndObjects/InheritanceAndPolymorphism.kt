package week2_ClassesAndObjects

open class Mammal {
    fun feedChildren() {
        println("feed children")
    }
}

open class Dog(val breed:String) : Mammal() {
    fun fetchStick() {
        println("fetch stick")
    }
}

open class Labrador(
    val name: String,
    val color: String
) : Dog("Labrador Retriever")

class LabradorBlack(name:String):Labrador(name, "Black")


fun feed(mammal: Mammal) {
    mammal.feedChildren()
}

fun main() {
    val dog = Dog("Unknown")
    dog.feedChildren()
    dog.fetchStick()
    feed(dog)
    val lab = Labrador("Coco", "Gray")
    println(lab.name) // Coco
    println(lab.breed) // Labrador Retriever
    println(lab.color)
    val labB = LabradorBlack("All black")
    println(labB.name)
    println(labB.breed)
    println(labB.color)

    val lab2:Labrador = LabradorBlack("1")
    //val labB2:LabradorBlack = Labrador("2","Black")
}

private val a = 0

fun xpto() {
    a
}
package week3_SpecialClasses

class MyError : Throwable("Some message")

fun someFunction() {
    throw MyError()
    println("Will not be printed")
}

fun throwsSomeMessage() {
    throw Throwable("Some Message")
}

fun main() {
    try {
        someFunction()
        println("Will not be printed")
    } catch (e: Throwable) {
        println("Caught $e") // Caught MyError: Some message
    } finally {
        println("Finally block was called") // Finally block was called
    }
//    throw Exception("xpto")
//    throw Throwable("coiso")
    try {
        print("A")
        throwsSomeMessage()
    } finally {
        print("F")
    }
}

/*
There are a few kinds of exceptions defined in Kotlin that are used in certain situations. The most important ones are:

IllegalArgumentException - used when an argument has an incorrect value. For example, when you expect your argument value to be bigger than 0, and it is not.

IllegalStateException - used when the state of our system is incorrect. That means the values of properties have values that are not accepted by our function call.
 */

private fun findClusters(number: Int) {
    if (number < 1) throw IllegalArgumentException("The number of clusters cannot be smaller than 1, it is $number")
    // ...
}

var userName = ""

fun printUserName() {
    if (userName == "") throw IllegalStateException("User name must not be empty")
    // ...
}
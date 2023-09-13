package week2_ClassesAndObjects

abstract class SomeAbstractClass {
    abstract fun abstractMethod()
    fun callAbstractTwice() {
        abstractMethod() // You can use abstract methods inside the class, because it is assumed they
        // will be overridden in the child class.
        abstractMethod()
    }
}

class SomeRegularClass : SomeAbstractClass() {
    override fun abstractMethod() {
        println("Calling abstract method")
    }
}

fun main() {
    val regular = SomeRegularClass()
    regular.abstractMethod() // Calling abstract method
    regular.callAbstractTwice()
    // Calling abstract method
    // Calling abstract method
}

abstract class A {
    abstract fun a()
}

class B : A() {
    override fun a() {
        println("Hello")
    }
}

val xpto = 25L

val xoiso = 20.0

open class Parent {
    protected fun xpto()=println("xpto")
}

class Child:Parent() {
    fun childXpto() {
        xpto()
    }
}

fun xptofun() {
    //Child().xpto()//can't call directly the parent protected function
    Child().childXpto()
}
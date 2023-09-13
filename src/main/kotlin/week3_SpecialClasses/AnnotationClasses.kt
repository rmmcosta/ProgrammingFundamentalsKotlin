package week3_SpecialClasses

/*
 Annotations are classes used to describe your code.
 - allows a programmer to embed supplemental information into a source file
 For example, let's say that your function throws an exception.
 To inform other coders that may use our class about such a possibility, you can add annotation Throws with an exception class.
 */

@Throws(ArithmeticException::class)
fun divide(a: Int, b: Int): Int {
    return a / b
}

@Throws(IllegalArgumentException::class)
private fun findClusters(number: Int) {
    if (number < 1) throw IllegalArgumentException("The number of clusters cannot be smaller than 1, it is $number")
    // ...
}

fun main() {
    findClusters(5)
}

/*
It is important to understand that an annotation by itself does absolutely nothing.
However, annotations are often defined by libraries that analyze your code and change its behavior based on an annotation.
Some annotations are also used by Kotlin itself. For instance, let's say that you defined a class with certain methods,
but over time you decide to introduce an alternative method for doing the same operation.
The problem is that the old method is still used by other parts of your program. What should you do?
The answer is using Deprecated annotation before the old method.
Such annotation is interpreted by the Kotlin compiler and IntelliJ, and results in old functions usages being presented as crossed out and a warning with the message specified in the annotation.
This is a good mechanism to inform users of your class that the old method should not be used anymore, and what they should replace it with.
When enough time has passed (typically a period of least a year is acceptable),
then you might assume that all the users adjusted their code to stop using the deprecated method, and you can finally remove it.
 */

annotation class MyAnnotation(val someDescription: String)

@MyAnnotation("Class annotation")
class A(
    @MyAnnotation("Constructor property annotation")
    val a: Int
) {
    @MyAnnotation("Method annotation")
    fun b() {
    }
}

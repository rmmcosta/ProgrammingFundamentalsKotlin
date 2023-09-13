package week3_SpecialClasses

private fun xpto() {
    var message: String = "Hello World"
//    message = null // compilation error
    val length = message.length // This always works
    var nullableMessage: String? = "Hello World"
    nullableMessage = null // this is ok
//    val length2 = nullableMessage.length//this not always works
    val nullableLength = nullableMessage?.length //safe call - this returns the length or null and the inferred type is Int? (nullable int)
}
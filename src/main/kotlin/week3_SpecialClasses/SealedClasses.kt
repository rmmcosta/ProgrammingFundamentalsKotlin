package week3_SpecialClasses

abstract class Animal
class Turtle : Animal()
class Cat : Animal()

sealed class Result//You do not want to allow anyone to define any other subclasses
class Success(val data: String) : Result()
class Failure(val exception: Throwable) : Result()

/*
sealed classes are classes with restrict hierarchies
A sealed modifier used in front of a class behaves just like abstract, but it also introduces some limitations.

Officially subclasses of a sealed class need to be defined in the same package.
What is more important is that a sealed modifier is information to the developer who reads the code
    - it informs them that this class has a limited number of subclasses known in advance during compilation.
 */

/*
There is one important consequence of using sealed classes.
You might remember that using when as an expression, you need to specify an else block so that there is always something returned.
 */


fun constructLabel(role: String, name: String): String {
    return when (role) {
        "ceo" -> "The boss"
        "manager" -> "Manager $name"
        "worker" -> name
        else -> "Unknown role"
    }
}

/*
There are exceptions to this rule.
As demonstrated previously, you do not need to specify else if you when expression with an enum class, and you cover all the possible values.
 */

enum class Role {
    CEO,
    MANAGER,
    WORKER
}

fun constructLabel(role: Role, name: String): String {
    return when (role) {
        Role.CEO -> "The boss"
        Role.MANAGER -> "Manager $name"
        Role.WORKER -> name
    }
}

/*
Another such exception is when you use when with a sealed class value, and you cover all the possible subtypes.
Take a look at the code below.
Since it covers all the possible subtypes of Role in a when expression, you do not need to specify an else block.
It is possible thanks to the sealed modifier.
*/

sealed class SRole
class CeoRole() : SRole()
class ManagerRole(val name: String) : SRole()
class WorkerRole(val name: String) : SRole()

fun constructLabel(role: SRole): String {
    return when (role) {
        is CeoRole -> "The boss"
        is ManagerRole -> "Manager ${role.name}"
        is WorkerRole -> role.name
    }
}

fun main() {
    val label = constructLabel("manager", "Leonard")
    println(label) // Manager Leonard
    val labelWithEnum = constructLabel(Role.MANAGER, "Leonard")
    println(labelWithEnum) // Manager Leonard
    val labelWithSealedClass = constructLabel(ManagerRole("Leonard"))
    println(labelWithSealedClass) // Manager Leonard
}
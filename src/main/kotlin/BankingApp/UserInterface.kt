package BankingApp

enum class AccountTypes(val id: Int, val label: String) {
    DEBIT(1, "Debit Account"),
    CREDIT(2, "Credit Account"),
    CHECKING(3, "Checking Account"),
}

fun showMenu() {
    println("Welcome to your Banking System.")
    println("What type of Account would you like to create?")
    showAccountsMenu()
}

private fun showAccountsMenu() {
    AccountTypes.entries.forEach { println("${it.id}. ${it.label}") }
    println("Choose an option (${AccountTypes.entries.map { it.id }.joinToString(", ")})")
}

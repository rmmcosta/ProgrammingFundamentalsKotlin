package BankingProject

import kotlin.random.Random

var accountBalance = (0..1000).random()
val money = (0..1000).random()

fun showMenu() {
    println("Welcome to your Banking System.")
    println("What type of Account would you like to create?")
    println("1. Debit Account")
    println("2. Credit Account")
    println("3. Checking Account")
    println("Choose an option (1, 2 or 3)")
}

fun showAccountMenu() {
    println("What would you like to do?")
    println("1.Check bank account balance")
    println("2.Withdraw money")
    println("3.Deposit money")
    println("4.Close the app")
    println("Which option do you choose? (1, 2, 3 or 4)")
}

fun withdraw(amount: Int): Int {
    accountBalance -= amount
    println("You successfully withdrew $amount dollars.")
    println("The current balance is $accountBalance dollars.")
    return amount
}

fun debitWithdraw(amount: Int): Int =
    if (accountBalance == 0) {
        println("Can't withdraw, no money on this account!")
        accountBalance
    } else if (accountBalance - amount < 0) {
        println("Not enough money on this account! The current balance is $accountBalance dollars.")
        0
    } else {
        withdraw(amount)
    }

fun deposit(amount: Int): Int {
    accountBalance += amount
    println("You successfully deposited $amount dollars. The current balance is $accountBalance dollars.")
    return amount
}

fun creditDeposit(amount: Int): Int =
    when {
        accountBalance == 0 -> {
            println("You don't need to deposit anything in order to pay off the account since it has already been paid off")
            accountBalance
        }

        accountBalance + amount > 0 -> {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is $accountBalance dollars.")
            0
        }

        amount == -accountBalance -> {
            accountBalance = 0
            println("You have paid off this account!")
            amount
        }

        else -> {
            deposit(amount)
        }
    }

fun main() {
    showMenu()
    var userChoice = 0
    var accountType = ""
    while (accountType == "") {
        userChoice = (1..5).random()
        println("The selected option is $userChoice")
        accountType = when (userChoice) {
            1 -> "debit"
            2 -> "credit"
            3 -> "checking"
            else -> {
                println("Choose an option (1, 2 or 3)")
                ""
            }
        }
    }
    println("You have created a $accountType account.")
    println("The current balance is $accountBalance dollars.")
    println("The amount you transferred is $money dollars.")
    var output = withdraw(money)
    println("The amount you withdrew is $output dollars.")
    output = debitWithdraw(money)
    println("The amount you withdrew is $output dollars.")
    output = deposit(money)
    println("The amount you deposited is $output dollars.")
    output = creditDeposit(money)
    println("The amount you deposited is $output dollars.")

    fun transfer(mode: String) {
        val transferAmount: Int = when (mode) {
            "withdraw" -> {
                if (accountType == "debit") {
                    debitWithdraw(money)
                } else {
                    withdraw(money)
                }
            }

            "deposit" -> {
                if (accountType == "credit") {
                    creditDeposit(money)
                } else {
                    deposit(money)
                }
            }

            else -> return
        }
        println("The amount you $mode is $transferAmount dollars.")
    }

    var isSystemOpen = true
    while (isSystemOpen) {
        showAccountMenu()
        val option = (1..5).random()
        println("You selected the option $option")
        when (option) {
            1 -> {
                println("The current balance is $accountBalance dollars.")
            }

            2 -> {
                transfer("withdraw")
            }

            3 -> {
                transfer("deposit")
            }

            4 -> {
                isSystemOpen = false
                println("The System is closed")
            }

            else -> continue

        }
    }
}

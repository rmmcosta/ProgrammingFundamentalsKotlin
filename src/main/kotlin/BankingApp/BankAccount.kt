package BankingApp

abstract class BankAccount(open val id: String) {
    var balance: Double = 0.0
        protected set(value) {
            movements += (value - field)
            field = value
        }
    private val movements = mutableListOf<Double>()
    abstract fun deposit(amount: Double): Double
    abstract fun withdraw(amount: Double): Double
    fun showMovements() = movements
}

data class DebitAccount(override val id: String) : BankAccount(id) {
    override fun deposit(amount: Double): Double {
        if (amount < 0) {
            throw IllegalArgumentException("Deposit amount shouldn't be negative")
        }
        balance += amount
        return balance
    }

    override fun withdraw(amount: Double): Double {
        if (amount < 0) {
            throw IllegalArgumentException("Withdraw amount shouldn't be negative")
        }
        if (balance - amount < 0) {
            throw IllegalArgumentException("Insufficient balance for withdrawal")
        }
        balance -= amount
        return balance
    }
}

data class CreditAccount(override val id: String) : BankAccount(id) {
    override fun deposit(amount: Double): Double {
        if (amount < 0) {
            throw IllegalArgumentException("Deposit amount shouldn't be negative")
        }
        if (amount > 10000) {
            throw IllegalArgumentException("You can't deposit more than 10000 Euros on a Credit Account")
        }
        balance += amount
        return balance
    }

    override fun withdraw(amount: Double): Double {
        if (amount < 0) {
            throw IllegalArgumentException("Withdraw amount shouldn't be negative")
        }
        balance -= amount
        return balance
    }
}
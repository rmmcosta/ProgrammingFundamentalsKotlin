package BankingApp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BankAccountTest {
    @Test
    fun shouldDepositValidValueInDebitAccount() {
        val debitAccount = DebitAccount("db1")
        assertEquals(0.0, debitAccount.balance)
        debitAccount.deposit(10.0)
        assertEquals(10.0, debitAccount.balance)
    }

    @Test
    fun shouldDepositValidValueInCreditAccount() {
        val creditAccount = CreditAccount("cr1")
        assertEquals(0.0, creditAccount.balance)
        creditAccount.deposit(10.0)
        assertEquals(10.0, creditAccount.balance)
    }

    @Test
    fun shouldThrowExceptionWhenDepositInvalidValueInDebitAccount() {
        val debitAccount = DebitAccount("db1")
        assertThrowsExactly(IllegalArgumentException::class.java) { debitAccount.deposit(-5.0) }
    }

    @Test
    fun shouldThrowExceptionWhenDepositInvalidValueInCreditAccount() {
        val creditAccount = CreditAccount("cr1")
        assertThrowsExactly(IllegalArgumentException::class.java) { creditAccount.deposit(-5.0) }
    }

    @Test
    fun shouldThrowExceptionWhenWithdrawMoreThanBalanceInDebitAccount() {
        val debitAccount = DebitAccount("db1")
        val initialBalance = debitAccount.balance
        assertThrowsExactly(IllegalArgumentException::class.java) { debitAccount.withdraw(5.0) }
        assertEquals(initialBalance, debitAccount.balance)
    }

    @Test
    fun shouldNotThrowExceptionWhenWithdrawMoreThanBalanceInCreditAccount() {
        val creditAccount = CreditAccount("cr1")
        assertDoesNotThrow { creditAccount.withdraw(100.0) }
        assertEquals(-100.0, creditAccount.balance)
    }

    @Test
    fun shouldThrowExceptionWhenDepositIsAbove10000ForCreditAccount() {
        val creditAccount = CreditAccount("cr1")
        assertDoesNotThrow { creditAccount.deposit(10000.0) }
        assertThrowsExactly(IllegalArgumentException::class.java) { creditAccount.deposit(10000.1) }
    }

    @Test
    fun shouldRecordDepositsForDebitAccounts() {
        val debitAccount = DebitAccount("db1")
        val deposits = listOf(10.0, 5.0, 3.0)
        for (deposit in deposits) {
            debitAccount.deposit(deposit)
        }
        assertEquals(deposits, debitAccount.showMovements())
    }

    @Test
    fun shouldRecordDepositsForCreditAccounts() {
        val creditAccount = CreditAccount("cr1")
        val deposits = listOf(10.0, 5.0, 3.0)
        for (deposit in deposits) {
            creditAccount.deposit(deposit)
        }
        assertEquals(deposits, creditAccount.showMovements())
    }

    @Test
    fun shouldRecordWithdrawsForDebitAccounts() {
        val debitAccount = DebitAccount("db1")
        debitAccount.deposit(1000.0)
        val withdraws = listOf(-10.0, -5.0, -3.0)
        for (withdraw in withdraws) {
            debitAccount.withdraw(-withdraw)
        }
        assertEquals(listOf(1000.0) + withdraws, debitAccount.showMovements())
    }

    @Test
    fun shouldRecordWithdrawsForCreditAccounts() {
        val creditAccount = CreditAccount("cr1")
        creditAccount.deposit(1000.0)
        val withdraws = listOf(-10.0, -5.0, -3.0)
        for (withdraw in withdraws) {
            creditAccount.withdraw(-withdraw)
        }
        assertEquals(listOf(1000.0) + withdraws, creditAccount.showMovements())
    }

    @Test
    fun shouldNotAllowToWithdrawNegativeValuesFromDebitAccount() {
        val debitAccount = DebitAccount("db1")
        debitAccount.deposit(1000.0)
        assertThrowsExactly(IllegalArgumentException::class.java) { debitAccount.withdraw(-10.0) }
    }

    @Test
    fun shouldNotAllowToWithdrawNegativeValuesFromCreditAccount() {
        val creditAccount = CreditAccount("cr1")
        creditAccount.deposit(1000.0)
        assertThrowsExactly(IllegalArgumentException::class.java) { creditAccount.withdraw(-10.0) }
    }
}
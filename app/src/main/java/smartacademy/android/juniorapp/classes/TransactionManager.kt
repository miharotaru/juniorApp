package smartacademy.android.juniorapp.classes

import smartacademy.android.juniorapp.enum.LogoTransaction
import smartacademy.android.juniorapp.enum.StatusTransaction


object TransactionManager {

    private var transactionList: ArrayList<Transaction> = arrayListOf(
        Transaction(
            LogoTransaction.MEGA_IMAGE,
            "Mega-Image",
            "RO49 Mega 1B31 0075 9384 0000",
            "Ai efectuat o plata in valoare de 200 de lei la Mega-Image",
            StatusTransaction.DONE
        ),
        Transaction(
            LogoTransaction.DEDEMAN,
            "Dedeman",
            "RO49 Dema 1B31 0075 9384 0000",
            "Ai efectuat o plata in valoare de 700 de lei la Dedeman",
            StatusTransaction.PENDING
        ),
        Transaction(
            LogoTransaction.EMAG,
            "Emag",
            "RO49 Emag 1B31 0075 9384 0000",
            "Ai efectuat o plata in valoare de 300 de lei la Emag",
            StatusTransaction.DONE
        ),
        Transaction(
            LogoTransaction.MEGA_IMAGE,
            "Mega-Image",
            "RO49 Mega 1B31 0075 9384 0000",
            "Ai efectuat o plata in valoare de 300 de lei la Mega-Image in care ai cumparat: 10 kg mere, 10 kg pere si 10 kg gutui",
            StatusTransaction.CANCELED
        )
    )

    fun addTransaction(transactionItem: Transaction) {
        transactionList.add(transactionItem)
    }

    fun changeTransactionStatus() {
        val statusList = arrayListOf(StatusTransaction.DONE, StatusTransaction.CANCELED)
        transactionList.last().status = statusList.random()
    }

    fun getTransactionsList(): ArrayList<Transaction> {
        return transactionList.reversed() as ArrayList<Transaction>
    }

    fun getRecentTransactions(): ArrayList<Transaction> {
        return transactionList.takeLast(3).reversed() as ArrayList<Transaction>
    }
}
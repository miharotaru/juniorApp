package smartacademy.android.juniorapp.classes

import smartacademy.android.juniorapp.enum.LogoTransaction
import smartacademy.android.juniorapp.enum.StatusTransaction

data class Transaction(
    var logo: LogoTransaction,
    var name: String,
    var iban: String,
    var details: String,
    var status: StatusTransaction
) {
}
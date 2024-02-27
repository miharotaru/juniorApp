package smartacademy.android.juniorapp.enum

import smartacademy.android.juniorapp.classes.Transaction

enum class StatusTransaction { DONE, CANCELED, PENDING }
enum class LogoTransaction { DEDEMAN, EMAG, MEGA_IMAGE }
enum class Gender { MALE, FEMALE }

enum class Vendor(
    val logoVendor: LogoTransaction,
    val nameVendor: String,
    val ibanVendor: String,
    var detailsVendor: String,
    var statusVendor: StatusTransaction
) {
    EMAG(
        LogoTransaction.MEGA_IMAGE,
        "Mega-Image",
        "RO49 Mega 1B31 0075 9384 0000",
        "",
        StatusTransaction.PENDING
    ) {
        override fun getTransaction(): Transaction =
            Transaction(logoVendor, nameVendor, ibanVendor, detailsVendor, statusVendor)

    },
    DEDEMAN(
        LogoTransaction.DEDEMAN,
        "Dedeman",
        "RO49 Dema 1B31 0075 9384 0000",
        "",
        StatusTransaction.PENDING
    ) {
        override fun getTransaction(): Transaction =
            Transaction(logoVendor, nameVendor, ibanVendor, detailsVendor, statusVendor)

    },
    MEGA_IMAGE(
        LogoTransaction.EMAG,
        "Emag",
        "RO49 Emag 1B31 0075 9384 0000",
        "",
        StatusTransaction.PENDING
    ) {
        override fun getTransaction(): Transaction =
            Transaction(logoVendor, nameVendor, ibanVendor, detailsVendor, statusVendor)

    };

    abstract fun getTransaction(): Transaction

}

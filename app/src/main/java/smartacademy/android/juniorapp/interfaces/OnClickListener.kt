package smartacademy.android.juniorapp.interfaces

import smartacademy.android.juniorapp.classes.Transaction

interface OnClickListener {
    fun onClickListenerAdd(transactionItem: Transaction)
    fun onClickListenerDetails(pos: Int)
}
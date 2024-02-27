package smartacademy.android.juniorapp

import android.widget.ImageView
import smartacademy.android.juniorapp.classes.Transaction
import smartacademy.android.juniorapp.enum.LogoTransaction
import smartacademy.android.juniorapp.enum.StatusTransaction

fun setStatusImage(transactionItem: Transaction, statusImageView: ImageView) {
    when (transactionItem.status) {
        StatusTransaction.PENDING -> {
            statusImageView.setImageResource(R.drawable.pending)
        }
        StatusTransaction.DONE -> {
            statusImageView.setImageResource(R.drawable.approved)
        }
        StatusTransaction.CANCELED -> {
            statusImageView.setImageResource(R.drawable.rejected)
        }
    }
}

fun setLogoImage(transactionItem: Transaction, imageLogoAlertDialog: ImageView) {
    when (transactionItem.logo) {
        LogoTransaction.EMAG -> {
            imageLogoAlertDialog.setImageResource(R.drawable.emag)
        }
        LogoTransaction.DEDEMAN -> {
            imageLogoAlertDialog.setImageResource(R.drawable.dedeman)
        }
        LogoTransaction.MEGA_IMAGE -> {
            imageLogoAlertDialog.setImageResource(R.drawable.mega)
        }
    }
}



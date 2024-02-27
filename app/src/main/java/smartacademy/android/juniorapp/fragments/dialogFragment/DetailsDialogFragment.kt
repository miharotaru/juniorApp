package smartacademy.android.juniorapp.fragments.dialogFragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import smartacademy.android.juniorapp.classes.TransactionManager
import smartacademy.android.juniorapp.databinding.AlertDialogTransactionDetailsBinding
import smartacademy.android.juniorapp.setStatusImage
import smartacademy.android.juniorapp.setLogoImage

class DetailsDialogFragment(pos: Int) : DialogFragment() {

    private lateinit var binding: AlertDialogTransactionDetailsBinding
    private val transactionItem = TransactionManager.getTransactionsList()[pos]

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = AlertDialogTransactionDetailsBinding.inflate(layoutInflater)
        val builder = Dialog(binding.root.context)
        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder.setContentView(binding.root)

        setTransactionDetails()

        return builder
    }

    private fun setTransactionDetails() {
        binding.tvDetailsAlertDialog.text = transactionItem.details
        binding.tvNameCompanyAlertDialog.text = transactionItem.name
        binding.tvIbanAlertDialog.text = transactionItem.iban

        setStatusImage(transactionItem,binding.imageStatusAlertDialog)
        setLogoImage(transactionItem,binding.imageLogoAlertDialog)
    }

}
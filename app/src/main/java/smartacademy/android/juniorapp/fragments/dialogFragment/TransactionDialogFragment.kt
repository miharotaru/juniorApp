package smartacademy.android.juniorapp.fragments.dialogFragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import smartacademy.android.juniorapp.R
import smartacademy.android.juniorapp.classes.Transaction
import smartacademy.android.juniorapp.databinding.AlertDialogTransactionItemBinding
import smartacademy.android.juniorapp.enum.Vendor
import smartacademy.android.juniorapp.setLogoImage
import smartacademy.android.juniorapp.interfaces.OnClickListener

class TransactionDialogFragment(
    private val onClickListenerAdd: OnClickListener
    ) : DialogFragment() {

    private lateinit var binding: AlertDialogTransactionItemBinding
    private lateinit var selectedCompany : String
    private lateinit var transactionItem: Transaction

    companion object {
        const val IBAN = "iban"
        const val NULL_ITEM = "Vendor"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding= AlertDialogTransactionItemBinding.inflate(layoutInflater)
        val builder= Dialog(binding.root.context)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder.setContentView(binding.root)

        setSpinnerWithData()
        onClickItemSpinner()
        clickDoneButton()
        return builder
    }

    private fun clickDoneButton() {
        binding.btDoneAlertDialog.setOnClickListener {
            transactionItem.details=binding.etDetailsAlertDialog.text.toString()
            onClickListenerAdd.onClickListenerAdd(transactionItem)
            dialog?.dismiss()
        }
    }

    private fun onClickItemSpinner() {
        binding.spinnerCompany.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCompany= parent?.getItemAtPosition(position) as String

                if (selectedCompany != NULL_ITEM) {
                    setTransactionItem()
                    setData(transactionItem)
                } else {
                    setBlankAlertDialog()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setTransactionItem() {
        when(selectedCompany){
            Vendor.EMAG.nameVendor->{
                transactionItem=Vendor.EMAG.getTransaction()
            }
            Vendor.DEDEMAN.nameVendor->{
                transactionItem=Vendor.DEDEMAN.getTransaction()
            }
            Vendor.MEGA_IMAGE.nameVendor->{
                transactionItem=Vendor.MEGA_IMAGE.getTransaction()
            }
        }
    }

    private fun setData(transactionItem: Transaction) {

        binding.tvIbanAlertDialog.isVisible=true
        binding.tvIbanAlertDialog.text=transactionItem.iban

        binding.etDetailsAlertDialog.isVisible=true
        binding.etDetailsAlertDialog.text= Editable.Factory.getInstance().newEditable("")

        binding.btDoneAlertDialog.isEnabled=true
        binding.btDoneAlertDialog.setBackgroundResource(R.drawable.bt_done_alert_dialog_true)

        setLogoImage(transactionItem, binding.imageLogoAlertDialog)
    }

    private fun setBlankAlertDialog() {

        binding.tvIbanAlertDialog.isVisible=false
        binding.tvIbanAlertDialog.text= IBAN

        binding.etDetailsAlertDialog.isVisible=false
        binding.etDetailsAlertDialog.text= Editable.Factory.getInstance().newEditable("")

        binding.btDoneAlertDialog.setBackgroundResource(R.drawable.bt_done_alert_dialog_false)
        binding.btDoneAlertDialog.isEnabled=false

        binding.imageLogoAlertDialog.setImageResource(R.drawable.empty)
    }

    private fun setSpinnerWithData() {
        ArrayAdapter.createFromResource(
            binding.root.context,
            R.array.company,
            android.R.layout.simple_spinner_item
        ).also {
            adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            binding.spinnerCompany.adapter=adapter
        }
    }
}
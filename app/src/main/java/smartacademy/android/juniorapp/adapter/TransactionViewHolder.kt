package smartacademy.android.juniorapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.transaction_item.view.*
import smartacademy.android.juniorapp.classes.Transaction
import smartacademy.android.juniorapp.setStatusImage
import smartacademy.android.juniorapp.setLogoImage

class TransactionViewHolder
    ( private val transactionView: View)
    : RecyclerView.ViewHolder(transactionView) {
    fun bind(item:Transaction){
        transactionView.tv_name_logo.text=item.name
        transactionView.tv_iban.text=item.iban
        setStatusImage(item, transactionView.image_status)
        setLogoImage(item,transactionView.image_logo)
    }
}
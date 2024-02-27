package smartacademy.android.juniorapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.transaction_item.view.*
import smartacademy.android.juniorapp.R
import smartacademy.android.juniorapp.classes.Transaction
import smartacademy.android.juniorapp.interfaces.OnClickListener

class TransactionAdapter(
    private var transactions:ArrayList<Transaction>,
    private var onClickListener: OnClickListener
): RecyclerView.Adapter<TransactionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.transaction_item,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(transactions[position])
        holder.itemView.card_transaction.setOnClickListener {
            onClickListener.onClickListenerDetails(position)
        }
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}
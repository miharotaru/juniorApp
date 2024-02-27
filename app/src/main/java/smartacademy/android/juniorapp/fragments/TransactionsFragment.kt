package smartacademy.android.juniorapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.recycleview_dashboard_list_user
import kotlinx.android.synthetic.main.fragment_transactions.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import smartacademy.android.juniorapp.R
import smartacademy.android.juniorapp.adapter.TransactionAdapter
import smartacademy.android.juniorapp.classes.Transaction
import smartacademy.android.juniorapp.classes.TransactionManager
import smartacademy.android.juniorapp.fragments.dialogFragment.DetailsDialogFragment
import smartacademy.android.juniorapp.fragments.dialogFragment.TransactionDialogFragment
import smartacademy.android.juniorapp.enum.StatusTransaction
import smartacademy.android.juniorapp.interfaces.OnClickListener

class TransactionsFragment : Fragment(), OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeAdapter()
        addTransactions()
    }

    private fun addTransactions() {
        bt_plus_item_transactions.setOnClickListener {
            val dialog = TransactionDialogFragment(this)
            dialog.show(parentFragmentManager, "toDialogFragment")
        }
    }

    private fun initializeAdapter() {
        recycleview_dashboard_list_user.layoutManager = LinearLayoutManager(context)
        recycleview_dashboard_list_user.adapter =
            TransactionAdapter(TransactionManager.getTransactionsList(), this)
    }

    override fun onClickListenerAdd(transactionItem: Transaction) {

        transactionItem.status = StatusTransaction.PENDING
        TransactionManager.addTransaction(transactionItem)
        recycleview_dashboard_list_user.adapter?.notifyItemChanged(TransactionManager.getTransactionsList().size)
        initializeAdapter()
        changeStatus()
    }

    private fun changeStatus() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            TransactionManager.changeTransactionStatus()
            initializeAdapter()
        }
    }

    override fun onClickListenerDetails(pos: Int) {
        val dialog = DetailsDialogFragment(pos)
        dialog.show(parentFragmentManager, "toDialogFragment")
    }
}
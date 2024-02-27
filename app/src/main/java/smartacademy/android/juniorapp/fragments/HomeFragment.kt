package smartacademy.android.juniorapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import smartacademy.android.juniorapp.R
import smartacademy.android.juniorapp.adapter.TransactionAdapter
import smartacademy.android.juniorapp.classes.TransactionManager
import smartacademy.android.juniorapp.classes.Transaction
import smartacademy.android.juniorapp.fragments.dialogFragment.DetailsDialogFragment
import smartacademy.android.juniorapp.interfaces.OnClickListener


class HomeFragment : Fragment(),OnClickListener {

    private lateinit var transactionList: ArrayList<Transaction>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setList()
        initializeAdapter()
        setOnCheckedSwitchButton()

    }

    private fun setList() {
        transactionList=TransactionManager.getRecentTransactions()
    }

    private fun initializeAdapter() {
        recycleview_dashboard_list_user.layoutManager=LinearLayoutManager(context)
        recycleview_dashboard_list_user.adapter=TransactionAdapter(transactionList,this)
    }

    private fun setOnCheckedSwitchButton() {
        bt_switch_currency.setOnCheckedChangeListener { _, onSwitch ->
            if(onSwitch){
                tv_number_currency.text="€30.000"
            }else  tv_number_currency.text="$30.000"
        }
    }

    override fun onClickListenerDetails(pos: Int) {
        val dialog = DetailsDialogFragment(pos)
        dialog.show(parentFragmentManager, "toDialogFragment")
    }

    override fun onClickListenerAdd(transactionItem: Transaction) {}

}
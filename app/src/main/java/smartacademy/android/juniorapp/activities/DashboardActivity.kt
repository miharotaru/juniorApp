package smartacademy.android.juniorapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.activity_dashboard.*
import smartacademy.android.juniorapp.fragments.FragmentViewModel
import smartacademy.android.juniorapp.R
import smartacademy.android.juniorapp.enum.Gender

class DashboardActivity : AppCompatActivity() {

    private lateinit var navController:NavController
    private val fragmentViewModel: FragmentViewModel by viewModels()

    companion object {
        const val GENDER = "GENDER"
        const val HOLDER_NAME = "HOLDER_NAME"
        const val CARD_NUMBER = "CARD_NUMBER"
        const val BANK = "BANK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setTabBar()
        getDataAndSendToFragment()
    }

    private fun getDataAndSendToFragment() {
        val gender= intent.getSerializableExtra(GENDER) as Gender
        val holderName= intent.getStringExtra(HOLDER_NAME).toString()
        val cardNumber= intent.getStringExtra(CARD_NUMBER).toString()
        val bank= intent.getStringExtra(BANK).toString()
        fragmentViewModel.setData(gender,holderName,cardNumber,bank)
    }

    private fun setTabBar() {
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.navController
        setupWithNavController(bottomNavigationView, navController)
    }
}
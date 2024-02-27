package smartacademy.android.juniorapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import smartacademy.android.juniorapp.R
import smartacademy.android.juniorapp.classes.PersonalData
import smartacademy.android.juniorapp.databinding.ActivityLoginBinding
import smartacademy.android.juniorapp.enum.Gender


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var isSwitchButtonInitialize = false
    private var isEditTextInitialize = false

    private lateinit var malePerson: PersonalData
    private lateinit var femalePerson: PersonalData

    companion object {
        const val GENDER = "GENDER"
        const val HOLDER_NAME = "HOLDER_NAME"
        const val CARD_NUMBER = "CARD_NUMBER"
        const val BANK = "BANK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setPersonalData()
        changedListener()
        clickLoginButton()
    }

    private fun clickLoginButton() {
        binding.btLogin.setOnClickListener {
            if (toastErrorMessage()) {
                val intent = Intent(this, DashboardActivity::class.java)
                setIntentToSend(intent)
                startActivity(intent)
            }
        }
    }

    private fun setIntentToSend(intent: Intent) {
        if (et_username.text.toString() == malePerson.username) {
            intent.putExtra(GENDER, malePerson.gender)
            intent.putExtra(HOLDER_NAME, malePerson.holderName)
            intent.putExtra(CARD_NUMBER, malePerson.cardNumber)
            intent.putExtra(BANK, malePerson.bank)
        } else {
            intent.putExtra(GENDER, femalePerson.gender)
            intent.putExtra(HOLDER_NAME, femalePerson.holderName)
            intent.putExtra(CARD_NUMBER, femalePerson.cardNumber)
            intent.putExtra(BANK, femalePerson.bank)
        }

    }

    private fun setPersonalData() {
        malePerson = PersonalData("Bogdan Stroe", "5105105105105100", "ING", Gender.MALE, "bogdan", "123")
        femalePerson = PersonalData("Ana Munteanu", "1235105105105100", "BCR", Gender.FEMALE, "ana", "123")
    }

    private fun changedListener() {

        binding.etUsername.addTextChangedListener(loginTextWatcher)
        binding.etPassword.addTextChangedListener(loginTextWatcher)

        binding.btSwitch.setOnCheckedChangeListener { _, onSwitch ->
            isSwitchButtonInitialize = onSwitch
            areSwitchButtonAndTextViewChange(isSwitchButtonInitialize, isEditTextInitialize)
        }
    }

    private fun areSwitchButtonAndTextViewChange(
        isSwitchButtonCheck: Boolean,
        isEditTextCheck: Boolean
    ) {
        if (isSwitchButtonCheck and isEditTextCheck) {
            binding.btLogin.setBackgroundResource(R.drawable.bt_round_true)
        } else {
            binding.btLogin.setBackgroundResource(R.drawable.bt_round_false)
        }
    }

    private fun toastErrorMessage(): Boolean {
        return when {
            et_username.text.toString().isEmpty() -> {
                Toast.makeText(this, "Insert username", Toast.LENGTH_SHORT).show()
                false
            }
            et_password.text.toString().isEmpty() -> {
                Toast.makeText(this, "Insert password", Toast.LENGTH_SHORT).show()
                false
            }
            !bt_switch.isChecked -> {
                Toast.makeText(
                    this,
                    "You have to agree with the terms and conditions.",
                    Toast.LENGTH_SHORT
                ).show()
                false
            }
            arePasswordAndUsernameCorrect(malePerson) && arePasswordAndUsernameCorrect(femalePerson) -> {
                Toast.makeText(this, "Incorrect password or username", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun arePasswordAndUsernameCorrect(item: PersonalData): Boolean {
        return et_password.text.toString() != item.password || et_username.text.toString() != item.username
    }

    private val loginTextWatcher = object : TextWatcher {
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            isEditTextInitialize =
                et_password.text.toString().isNotEmpty() && et_username.text.toString().isNotEmpty()
            areSwitchButtonAndTextViewChange(isSwitchButtonInitialize, isEditTextInitialize)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {}
    }
}


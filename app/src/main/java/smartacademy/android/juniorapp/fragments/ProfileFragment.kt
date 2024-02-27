package smartacademy.android.juniorapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_profile.*
import smartacademy.android.juniorapp.R
import smartacademy.android.juniorapp.enum.Gender


class ProfileFragment : Fragment() {

    private val viewModel: FragmentViewModel by activityViewModels()
    private lateinit var gender:Gender

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProfile()
    }

    private fun setProfile() {
        viewModel.genderData.observe(viewLifecycleOwner, {
            gender=it
            setImage()
        })
        viewModel.holderNameData.observe(viewLifecycleOwner, {
            tv_holder_name_profile.text=it
        })
        viewModel.cardNumberData.observe(viewLifecycleOwner, {
            tv_card_number_profile.text=it
        })
        viewModel.bankData.observe(viewLifecycleOwner, {
            tv_bank_profile.text = it
        })

    }

    private fun setImage() {
        if(gender== Gender.MALE){
            image_profile.setImageResource(R.drawable.male_avatar)
        }else {
            image_profile.setImageResource(R.drawable.femaleavatar)
        }
    }
}


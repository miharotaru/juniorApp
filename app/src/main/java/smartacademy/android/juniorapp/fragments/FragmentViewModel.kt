package smartacademy.android.juniorapp.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import smartacademy.android.juniorapp.enum.Gender

class FragmentViewModel:ViewModel() {
    val genderData=MutableLiveData<Gender>()
    val holderNameData=MutableLiveData<String>()
    val cardNumberData=MutableLiveData<String>()
    val bankData=MutableLiveData<String>()

    fun setData(gender:Gender, holderName:String, cardNumber:String,bank:String){
        genderData.value=gender
        holderNameData.value=holderName
        cardNumberData.value=cardNumber
        bankData.value=bank
    }
}
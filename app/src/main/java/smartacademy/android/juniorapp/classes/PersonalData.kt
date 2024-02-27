package smartacademy.android.juniorapp.classes

import smartacademy.android.juniorapp.enum.Gender

data class PersonalData(
    val holderName:String,
    val cardNumber:String,
    val bank:String,
    val gender:Gender,
    val username:String,
    val password:String
)
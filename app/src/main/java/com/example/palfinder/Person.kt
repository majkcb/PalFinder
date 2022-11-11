package com.example.palfinder

class Person(var name: String? = null,
             var socialSecurityNumber : Int? = null,
             var city :String? = null,
             var phoneNumber : String? = null,
             var email : String? = null,
             var interests : String? =null,
             var description : String? = null)


//"firstName" to et_name.text.toString(),
//"lastName" to et_email.text.toString(),
//"age" to et_age.text.toString().toIntOrNull(),
//"email" to et_email.text.toString(),
//"interests" to et_interest.text.toString()

/*
<TextView
android:id="@+id/following_age"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:ems="10"
android:hint="following age"
android:inputType="textPersonName"
android:textColor="@color/common_google_signin_btn_text_dark_focused"
android:textSize="15sp"
app:layout_constraintStart_toStartOf="@+id/following_name"
app:layout_constraintTop_toBottomOf="@+id/following_city
" />

 */
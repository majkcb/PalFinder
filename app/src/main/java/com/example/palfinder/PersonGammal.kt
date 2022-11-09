package com.example.palfinder

import android.widget.EditText

class PersonGammal (var photo : Int, var name: String, var city : String, var phoneNumber: String/*, var interests: MutableList<PossibleInterests>*/) {


    var interests = mutableListOf<PossibleInterests>()
    private var followersList = mutableListOf<PersonGammal>()
    private var followingList = mutableListOf<PersonGammal>()

    lateinit var emailAddress : String
    lateinit var description : String
    private lateinit var descriptionEditText: EditText

    fun editPhoto(photo : Int){
        this.photo = photo
    }

    fun editEmailAddress(emailAddress : String){
        this.emailAddress = emailAddress
    }

    fun editName(name:String){
        this.name = name
    }

    fun editPhoneNumber(phoneNumber:String){
        this.phoneNumber = phoneNumber
    }

    fun editCity(city:String){
        this.city = city
    }

    fun editDescription(text:String){
        description = text
    }

   /*fun addInterest(interest: PossibleInterests){
        interests.add(interest)
    }

    fun removeInterest(interest: PossibleInterests){
        interests.remove(interest)
    }

    */

    fun addfollower(follower: PersonGammal){
        followersList.add(follower)
    }

    fun removefollower(follower: PersonGammal){
        followersList.remove(follower)
    }

    fun addfollows(follows: PersonGammal){
        followingList.add(follows)
    }

    fun removefollows(follows: PersonGammal){
        followingList.remove(follows)
    }

    /*  fun editPhoto (photo:Int) {
        this.photo = photo
    }   */

    //var geographicPositionCurrent: MapPosition?????

}
package com.example.palfinder

import android.widget.EditText

class Person (var photo : Int, var name: String, var city : String, var phoneNumber: String,  /*, var interest : PossibleInterests*/) {

    var interestList = mutableListOf<PossibleInterests>(PossibleInterests.ART, PossibleInterests.ARCHITECTURE, PossibleInterests.ASTRONOMY, PossibleInterests.BIKES)

    private var followersList = mutableListOf<Person>()
    private var followingList = mutableListOf<Person>()

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

    fun addInterest(interest: PossibleInterests){
        interestList.add(interest)
    }

    fun removeInterest(interest: PossibleInterests){
        interestList.remove(interest)
    }

    fun addfollower(follower: Person){
        followersList.add(follower)
    }

    fun removefollower(follower: Person){
        followersList.remove(follower)
    }

    fun addfollows(follows: Person){
        followingList.add(follows)
    }

    fun removefollows(follows: Person){
        followingList.remove(follows)
    }

    /*  fun editPhoto (photo:Int) {
        this.photo = photo
    }   */

    //var geographicPositionCurrent: MapPosition?????

}
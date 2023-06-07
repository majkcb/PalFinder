package com.example.palfinder.Person

import android.widget.EditText

class PersonOldClass (var photo : Int, var name: String, var city : String, var phoneNumber: String) {


    var interests = mutableListOf<PossibleInterests>()
    private var followersList = mutableListOf<PersonOldClass>()
    private var followingList = mutableListOf<PersonOldClass>()

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

    fun addfollower(follower: PersonOldClass){
        followersList.add(follower)
    }

    fun removefollower(follower: PersonOldClass){
        followersList.remove(follower)
    }

    fun addfollows(follows: PersonOldClass){
        followingList.add(follows)
    }

    fun removefollows(follows: PersonOldClass){
        followingList.remove(follows)
    }

}
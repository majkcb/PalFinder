package com.example.palfinder

import android.widget.EditText

class Person ( var name: String, var city : String/*, var socialSecurityNumber : List<MutableList<Int>>, var interest : PossibleInterests, var photo : Int*/) {

    var interestList = mutableListOf<PossibleInterests>(PossibleInterests.ART, PossibleInterests.ARCHITECTURE, PossibleInterests.ASTRONOMY, PossibleInterests.BIKES)
    private var followerList = mutableListOf<Person>()
    private var followsList = mutableListOf<Person>()
    lateinit var description : String
    private lateinit var descriptionEditText: EditText
    var birthYear = mutableListOf<Int>(0,0,0,0)
    var birthMonth = mutableListOf<Int>(0,0)
    var birthDay = mutableListOf<Int>(0,0)
    var identityNumber = mutableListOf<Int>(0,0,0,0)

    /*fun editSocialSecurityNumber(year: MutableList<Int>, month: MutableList<Int>, day: MutableList<Int>, number: MutableList<Int>) {
        socialSecurityNumber = listOf(birthYear, birthMonth, birthDay, identityNumber)
        birthYear = year
        birthMonth = month
        birthDay = day
        identityNumber = number
    }

     */

    fun editName(name:String){
        this.name = name
    }

    fun editCity(city:String){
        this.city = city
    }

    fun editDescription (text:String){
        description = text
    }

    fun addInterest(interest: PossibleInterests){
        interestList.add(interest)
    }

    fun removeInterest(interest: PossibleInterests){
        interestList.remove(interest)
    }

    fun addfollower(follower: Person){
        followerList.add(follower)
    }

    fun removefollower(follower: Person){
        followerList.remove(follower)
    }

    fun addfollows(follows: Person){
        followsList.add(follows)
    }

    fun removefollows(follows: Person){
        followsList.remove(follows)
    }

    /*fun editPhoto (photo:Int) {
        this.photo = photo
    }
     */

    //var geographicPositionCurrent: MapPosition?????

}
package com.example.palfinder.Person

class Person(var name: String? = null,
             var socialSecurityNumber : Long? = null,
             var city :String? = null,
             var phoneNumber : String? = null,
             var email : String? = null,
             var interests : String? =null,
             var description : String? = null){

    override fun toString(): String{
        return "User(name=$name,socialSecurityNumber=$socialSecurityNumber, city=$city, phoneNumber=$phoneNumber, interests=$interests, description=$description)"
    }

}


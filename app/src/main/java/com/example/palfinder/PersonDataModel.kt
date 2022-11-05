package com.example.palfinder

object PersonDataModel {
    val persons = mutableListOf<Person>()

    init {
        createMockData()
    }

    fun createMockData() {

        persons.add(Person(R.drawable.playing_card_heart_ace,"Apert","Ankeborg", "012-345 67 01"))
        persons.add(Person(R.drawable.playing_card_club_2,"Bolop","Långtbortistan", "012-345 67 02"))
        persons.add(Person(R.drawable.playing_card_club_3,"Cabem","Gåseby", "012-345 67 03"))
        persons.add(Person(R.drawable.playing_card_club_4,"Dålot","GothamCity", "012-345 67 04"))
        persons.add(Person(R.drawable.playing_card_club_5,"Elfot","Smallville", "012-345 67 05"))
        persons.add(Person(R.drawable.playing_card_club_6,"Fepot","Utkanten", "012-345 67 06"))
        persons.add(Person(R.drawable.playing_card_club_7,"Giplo","Campus", "012-345 67 07"))
        persons.add(Person(R.drawable.playing_card_club_8,"Hutep","UrbanSprawl", "012-345 67 08"))
        persons.add(Person(R.drawable.playing_card_club_9,"Ilfet","Vartunda", "012-345 67 09"))
        persons.add(Person(R.drawable.playing_card_club_10,"Jafot","Varsätra", "012-345 67 10"))
        persons.add(Person(R.drawable.playing_card_club_jack,"Kepot","Kakariko", "012-345 67 11"))
        persons.add(Person(R.drawable.playing_card_club_queen,"Larib","Huryle", "012-345 67 12"))
        persons.add(Person(R.drawable.playing_card_club_king,"Menop","Skotorp", "012-345 67 13"))
        persons.add(Person(R.drawable.playing_card_club_ace,"Nifet","Ankeborg", "012-345 67 14"))
        persons.add(Person(R.drawable.playing_card_diamond_2,"Opeth","Långtbortistan", "012-345 67 15"))
        persons.add(Person(R.drawable.playing_card_diamond_3,"Plret","Jämmerdalen", "012-345 67 16"))
        persons.add(Person(R.drawable.playing_card_diamond_4,"Qirop","GothamCity", "012-345 67 17"))
        persons.add(Person(R.drawable.playing_card_diamond_5,"Rotyp","Utkanten", "012-345 67 18"))
        persons.add(Person(R.drawable.playing_card_diamond_6,"Surep","Gåseby", "012-345 67 19"))
        persons.add(Person(R.drawable.playing_card_diamond_7,"Togor","Smallville", "012-345 67 20"))
        persons.add(Person(R.drawable.playing_card_diamond_8,"Unipe","UrbanSprawl", "012-345 67 21"))
        persons.add(Person(R.drawable.playing_card_diamond_9,"Voloj","Varsätra", "012-345 67 22"))
        persons.add(Person(R.drawable.playing_card_diamond_10,"Wipos","Campus", "012-345 67 23"))
        persons.add(Person(R.drawable.playing_card_diamond_jack,"Xumph","Hyrule", "012-345 67 24"))
        persons.add(Person(R.drawable.playing_card_diamond_queen,"Ypmot","Kakariko", "012-345 67 25"))
        persons.add(Person(R.drawable.playing_card_diamond_king,"Zurep","Utkanten", "012-345 67 26"))
        persons.add(Person(R.drawable.playing_card_diamond_ace,"Åplam","Gåseby", "012-345 67 27"))
        persons.add(Person(R.drawable.playing_card_heart_2,"Äplum","Vartunda", "012-345 67 28"))
        persons.add(Person(R.drawable.playing_card_heart_3,"Öfult","Utkanten", "012-345 67 29"))
    }

}
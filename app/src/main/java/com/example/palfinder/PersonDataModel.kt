package com.example.palfinder

object PersonDataModel {
    val persons = mutableListOf<Person>()

    init {
        createMockData()
    }

    fun createMockData() {

        val person01 = Person(R.drawable.playing_card_heart_ace,"Appert","Ankeborg", "012-345 67 01")
        val person02 = Person(R.drawable.playing_card_club_2,"Boloph","Långtbortistan", "012-345 67 02")
        val person03 = Person(R.drawable.playing_card_club_3,"Cabemu","Gåseby", "012-345 67 03")
        val person04 = Person(R.drawable.playing_card_club_4,"Dålott","GothamCity", "012-345 67 04")
        val person05 = Person(R.drawable.playing_card_club_5,"Elifot","Smallville", "012-345 67 05")
        val person06 = Person(R.drawable.playing_card_club_6,"Fepotp","Utkanten", "012-345 67 06")
        val person07 = Person(R.drawable.playing_card_club_7,"Giplop","Campus", "012-345 67 07")
        val person08 = Person(R.drawable.playing_card_club_8,"Hutmep","UrbanSprawl", "012-345 67 08")
        val person09 = Person(R.drawable.playing_card_club_9,"Ilfemt","Vartunda", "012-345 67 09")
        val person10 = Person(R.drawable.playing_card_club_10,"Jafoot","Varsätra", "012-345 67 10")
        val person11 = Person(R.drawable.playing_card_club_jack,"Keplot","Kakariko", "012-345 67 11")
        val person12 = Person(R.drawable.playing_card_club_queen,"Lariib","Hyrule", "012-345 67 12")
        val person13 = Person(R.drawable.playing_card_club_king,"Metnop","Skotorp", "012-345 67 13")
        val person14 = Person(R.drawable.playing_card_club_ace,"Nifmet","Ankeborg", "012-345 67 14")
        val person15 = Person(R.drawable.playing_card_diamond_2,"Opeth","Långtbortistan", "012-345 67 15")
        val person16 = Person(R.drawable.playing_card_diamond_3,"Pnuref","Jämmerdalen", "012-345 67 16")
        val person17 = Person(R.drawable.playing_card_diamond_4,"Qitrop","GothamCity", "012-345 67 17")
        val person18 = Person(R.drawable.playing_card_diamond_5,"Rotyph","Utkanten", "012-345 67 18")
        val person19 = Person(R.drawable.playing_card_diamond_6,"Surtep","Gåseby", "012-345 67 19")
        val person20 = Person(R.drawable.playing_card_diamond_7,"Tognor","Smallville", "012-345 67 20")
        val person21 = Person(R.drawable.playing_card_diamond_8,"Unipem","UrbanSprawl", "012-345 67 21")
        val person22 = Person(R.drawable.playing_card_diamond_9,"Volroj","Varsätra", "012-345 67 22")
        val person23 = Person(R.drawable.playing_card_diamond_10,"Wiptos","Campus", "012-345 67 23")
        val person24 = Person(R.drawable.playing_card_diamond_jack,"Xumoph","Hyrule", "012-345 67 24")
        val person25 = Person(R.drawable.playing_card_diamond_queen,"Ypmoth","Kakariko", "012-345 67 25")
        val person26 = Person(R.drawable.playing_card_diamond_king,"Zurept","Utkanten", "012-345 67 26")
        val person27 = Person(R.drawable.playing_card_diamond_ace,"Åplamk","Gåseby", "012-345 67 27")
        val person28 = Person(R.drawable.playing_card_heart_2,"Äpalum","Vartunda", "012-345 67 28")
        val person29 = Person(R.drawable.playing_card_heart_3,"Öfnult","Utkanten", "012-345 67 29")

        person01.interests.plusAssign(arrayOf(PossibleInterests.POLITICS, PossibleInterests.PHOTOGRAPHY, PossibleInterests.ARCHITECTURE))
        person02.interests.plusAssign(arrayOf(PossibleInterests.BIKES,PossibleInterests.ASTRONOMY,PossibleInterests.CHESS))
        person03.interests.plusAssign(arrayOf(PossibleInterests.DIRT_BIKE, PossibleInterests.DISC_GOLF, PossibleInterests.MARTIAL_ARTS,PossibleInterests.GO_GAME))
        person04.interests.plusAssign(arrayOf(PossibleInterests.GO_GAME,PossibleInterests.WILD_LIFE,PossibleInterests.BIKES,PossibleInterests.POLITICS))
        person05.interests.plusAssign(arrayOf(PossibleInterests.COOKING, PossibleInterests.BOXING,PossibleInterests.DIRT_BIKE,PossibleInterests.DISC_GOLF))
        person06.interests.plusAssign(arrayOf(PossibleInterests.GO_GAME, PossibleInterests.PHOTOGRAPHY))
        person07.interests.plusAssign(arrayOf(PossibleInterests.WILD_LIFE,PossibleInterests.ART,PossibleInterests.DISC_GOLF,PossibleInterests.DANCE,PossibleInterests.FAST_CARS))
        person08.interests.plusAssign(arrayOf(PossibleInterests.WILD_LIFE, PossibleInterests.FASHION_DESIGN,PossibleInterests.FISHING))
        person09.interests.plusAssign(arrayOf(PossibleInterests.BIKES,PossibleInterests.GOLF,PossibleInterests.SKATING))
        person10.interests.plusAssign(arrayOf(PossibleInterests.BIKES,PossibleInterests.DISC_GOLF,PossibleInterests.ART,PossibleInterests.HUNTING))
        person11.interests.plusAssign(arrayOf(PossibleInterests.PROGRAMMING,PossibleInterests.MOTORCYCLES,PossibleInterests.MARTIAL_ARTS))
        person12.interests.plusAssign(arrayOf(PossibleInterests.SPORTS,PossibleInterests.UNUSUAL_LANGUAGES, PossibleInterests.ART, PossibleInterests.SAILING))
        person13.interests.plusAssign(arrayOf(PossibleInterests.WHINE,PossibleInterests.ART,PossibleInterests.DISC_GOLF,PossibleInterests.MOVIE_MAKING,PossibleInterests.MARTIAL_ARTS))
        person14.interests.plusAssign(arrayOf(PossibleInterests.MUSIC_COMPOSING, PossibleInterests.SAILING,PossibleInterests.POLITICS,PossibleInterests.SPORTS))
        person15.interests.plusAssign(arrayOf(PossibleInterests.ART,PossibleInterests.UNUSUAL_LANGUAGES,PossibleInterests.WHINE,PossibleInterests.PROGRAMMING))
        person16.interests.plusAssign(arrayOf(PossibleInterests.MOVIE_MAKING,PossibleInterests.ART,PossibleInterests.POLITICS,PossibleInterests.ARCHITECTURE,PossibleInterests.READING))
        person17.interests.plusAssign(arrayOf(PossibleInterests.BIKES,PossibleInterests.MOVIE_MAKING,PossibleInterests.SAILING,PossibleInterests.GOLF))
        person18.interests.plusAssign(arrayOf(PossibleInterests.UNUSUAL_LANGUAGES,PossibleInterests.DANCE,PossibleInterests.BIKES,PossibleInterests.FASHION_DESIGN,PossibleInterests.WILD_LIFE))
        person19.interests.plusAssign(arrayOf(PossibleInterests.BIKES,PossibleInterests.DANCE,PossibleInterests.WILD_LIFE,PossibleInterests.GOLF,PossibleInterests.MOTORCYCLES))
        person20.interests.plusAssign(arrayOf(PossibleInterests.SAILING,PossibleInterests.FASHION_DESIGN,PossibleInterests.PROGRAMMING,PossibleInterests.READING))
        person21.interests.plusAssign(arrayOf(PossibleInterests.SPORTS,PossibleInterests.DISC_GOLF,PossibleInterests.WHINE,PossibleInterests.CHESS))
        person22.interests.plusAssign(arrayOf(PossibleInterests.PHOTOGRAPHY,PossibleInterests.MOVIE_MAKING,PossibleInterests.SAILING,PossibleInterests.FASHION_DESIGN))
        person23.interests.plusAssign(arrayOf(PossibleInterests.ART,PossibleInterests.FISHING))
        person24.interests.plusAssign(arrayOf(PossibleInterests.PHOTOGRAPHY,PossibleInterests.ASTRONOMY))
        person25.interests.plusAssign(arrayOf(PossibleInterests.MUSIC_COMPOSING,PossibleInterests.HUNTING,PossibleInterests.GOLF))
        person26.interests.plusAssign(arrayOf(PossibleInterests.MUSIC_COMPOSING,PossibleInterests.FASHION_DESIGN))
        person27.interests.plusAssign(arrayOf(PossibleInterests.HUNTING,PossibleInterests.WHINE))
        person28.interests.plusAssign(arrayOf(PossibleInterests.SPORTS,PossibleInterests.WILD_LIFE))
        person29.interests.plusAssign(arrayOf(PossibleInterests.ART,PossibleInterests.DANCE,PossibleInterests.BIKES,PossibleInterests.FISHING))

persons.plusAssign(arrayOf(person01,person02,person03,person04,person05,person06,person07,person08,person09,person10,person11,person12,
    person13,person14,person15,person16,person17,person18,person19,person20,person21,person22,person23,person24,person25,person26,person27,
    person28,person29))



    }

}
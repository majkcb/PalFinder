package com.example.palfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.palfinder.Fragments.AboutPalfinderFragment
import com.example.palfinder.Fragments.FollowsRecycleViewFragment
import com.example.palfinder.Fragments.MapViewFragment
import com.example.palfinder.Fragments.PersonProfileEditFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {

    // Input for all fragments

    //Settings, not necessary for now.
    private val AboutPalfinderFragment = AboutPalfinderFragment()
    //Profile, edit and what shows.
    private val PersonProfileEditFragment = PersonProfileEditFragment()
    //Map-fragment, map of you and friends.
    private val MapViewFragment = MapViewFragment()
    //List of friends, followers and those you follow.
    private val FollowsRecycleViewFragment = FollowsRecycleViewFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_layout)


        replaceFragment(MapViewFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.map -> replaceFragment(MapViewFragment)

                R.id.profile -> replaceFragment(PersonProfileEditFragment)

                R.id.friendList -> replaceFragment(FollowsRecycleViewFragment)

                R.id.setting -> replaceFragment(AboutPalfinderFragment)

            }
            true
        }


    }


    private fun replaceFragment(fragment: Fragment){
        if (fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }




}
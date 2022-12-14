package com.example.palfinder

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.palfinder.Fragments.*
import com.example.palfinder.Profile.PersonProfileEditFragment
import com.example.palfinder.Profile.PersonProfileRegisterFragment
import com.example.palfinder.Profile.PersonProfileViewFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {

    // Input for all fragments

    //Settings, not necessary for now.
    private val aboutPalfinderFragment = AboutPalfinderFragment()
    //Profile, edit and what shows.
    private val personProfileEditFragment = PersonProfileEditFragment()
    private val personProfileViewFragment = PersonProfileViewFragment()
    //Map-fragment, map of you and friends.
    private val mapViewFragment = MapViewFragment()
    //List of friends, followers and those you follow.
    private val allUsersRecyclerViewFragment = AllUsersRecyclerViewFragment()
    private val followingRecyclerViewFragment = FollowingRecyclerViewFragment()
    private val followersRecyclerViewFragment = FollowersRecyclerViewFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_layout)

        replaceFragment(personProfileEditFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.map -> replaceFragment(mapViewFragment)

                R.id.profile -> replaceFragment(personProfileViewFragment)

                R.id.allUsers -> replaceFragment(allUsersRecyclerViewFragment)

                R.id.followers -> replaceFragment(followersRecyclerViewFragment)

                R.id.following -> replaceFragment(followingRecyclerViewFragment)

                //R.id.settings -> replaceFragment(allUsersRecyclerViewFragment)

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
package com.binar.cc_intent_fragment_permission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var landingPage1: LandingPage1
    lateinit var landingPage2: LandingPage2
    lateinit var landingPage3: LandingPage3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        // default landing page
            landingPage1 = LandingPage1()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, landingPage1)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

        // for landing page fragment
        bottomNavigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                // Bundle fragment
                R.id.itemNavigationBundle -> {
                    landingPage1 = LandingPage1()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, landingPage1)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                // serializable Fragment
                R.id.itemNavigationSerializable -> {
                    landingPage2 = LandingPage2()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, landingPage2)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                // parcelable Fragment
                R.id.itemNavigationParcelable -> {
                    landingPage3 = LandingPage3()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, landingPage3)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                else -> false
            }
        }

    }
}
package com.example.meowbottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.meowbottomnavigation.fragments.*

class MainActivity : AppCompatActivity() {

    private val ID_HOME = 1
    private val ID_SEARCH = 2
    private val ID_MESSAGE = 3
    private val ID_FAVORITE = 4
    private val ID_PROFILE = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottomNavigation)

        bottomNavigation.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_SEARCH, R.drawable.ic_search))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_FAVORITE, R.drawable.ic_favorite))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_PROFILE, R.drawable.ic_person))

        bottomNavigation.setOnClickMenuListener { item -> }
        bottomNavigation.setOnShowListener { item ->
            when (item.id) {
                ID_HOME -> {
                    replace(HomeFragment())
                }
                ID_SEARCH -> {
                    replace(SearchFragment())
                }
                ID_MESSAGE -> {
                    replace(MessageFragment())
                }
                ID_FAVORITE -> {
                    replace(FavoriteFragment())
                }
                ID_PROFILE -> {
                    replace(PersonFragment())
                }
            }
        }
        bottomNavigation.show(ID_HOME, true)
    }

    private fun replace(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}

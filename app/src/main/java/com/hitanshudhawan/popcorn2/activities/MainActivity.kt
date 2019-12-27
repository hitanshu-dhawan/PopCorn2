package com.hitanshudhawan.popcorn2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.hitanshudhawan.popcorn2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hitanshu : use view binding when it is stable
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
			R.id.movies_destination,
			R.id.tv_shows_destination,
			R.id.favorites_destination
		), findViewById(R.id.drawer_layout))
        findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)
        findViewById<NavigationView>(R.id.navigation_view).setupWithNavController(navController)
    }
}

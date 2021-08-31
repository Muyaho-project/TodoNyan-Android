package org.muyaho.todonyan.presentation

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import org.muyaho.todonyan.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setStatusBarColor()

        val navController = Navigation.findNavController(this, R.id.nav_host)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.todoHomeFragment, R.id.todoCatFragment, R.id.todoProfileFragment
            )
        )

        val mainBottomNavigation: BottomNavigationView = findViewById(R.id.main_bottom_navigation)
        NavigationUI.setupWithNavController(mainBottomNavigation, navController)
        mainBottomNavigation.itemIconTintList = null
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        }
    }
}

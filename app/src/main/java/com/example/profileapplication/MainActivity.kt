package com.example.profileapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navProfile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.profileFragmentContainer, ProfileFragment())
                        .commit()
                    true
                }
                R.id.navFriendRequests -> {
                    navigateToDetail("Friend Requests")
                    true
                }
                R.id.navNotifications -> {
                    navigateToDetail("Notifications")
                    true
                }
                R.id.navHome -> {
                    navigateToDetail("Home")
                    true
                }
                else -> false
            }
        }
    }

    fun praise() {
        Toast.makeText(this, "Praise the Fool!", Toast.LENGTH_SHORT).show()
    }

    fun navigateToDetail(textToPass: String) {
        val detailFrag = DetailFragment()
        val bundle = Bundle()
        bundle.putString("EXTRA_TEXT", textToPass)
        detailFrag.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.profileFragmentContainer, detailFrag)
            .addToBackStack(null)
            .commit()
    }
}
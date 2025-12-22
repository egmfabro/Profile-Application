package com.example.profileapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast



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
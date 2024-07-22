package com.example.potterhead

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.potterhead.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var nav : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentLayout)
        if(navHostFragment!=null) nav = navHostFragment.findNavController()

    }

    override fun onSupportNavigateUp(): Boolean {
        return nav.navigateUp() || super.onSupportNavigateUp()
    }
}
package com.example.trainfinalproject

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.graphics.toColor
import androidx.fragment.app.Fragment
import com.example.trainfinalproject.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            setCurrentFragment(when(it.itemId) {
                R.id.home -> Home()
                R.id.profile -> Profile()
                R.id.setting -> Setting()
                R.id.map -> Map()
                else -> Error()
            })
            true
        }

        //var thisONe = findViewById<LinearLayout>(R.id.map_panel).setBackgroundColor(Color.RED)

        // Default State
        setCurrentFragment(Home())
        binding.bottomNavigationView.selectedItemId = R.id.home

    }

    override fun onResume() {
        super.onResume()
        // mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        // mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        // mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // mapView.onSaveInstanceState(outState)
    }

    override fun onMapReady(googleMap: GoogleMap) {

    }

    // Navigational Function
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}
package com.example.trainfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.trainfinalproject.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    // private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(Home())
                R.id.profile -> setCurrentFragment(Profile())
                R.id.setting -> setCurrentFragment(Setting())
                R.id.map -> setCurrentFragment(Map())
                else -> setCurrentFragment(Error())
            }
            true
        }

        // Default State
        setCurrentFragment(Home())
        binding.bottomNavigationView.selectedItemId = R.id.home

        // mapView = findViewById(R.id.mapView)
        // mapView.onCreate(savedInstanceState)
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
package com.example.trainfinalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Setting.newInstance] factory method to
 * create an instance of this fragment.
 */
class Setting : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        findPreference<Preference>("feedback")?.setOnPreferenceClickListener {
            Log.d("Preferences", "Feedback was clicked")
            true // Return true if the click is handled.
        }

        findPreference<Preference>("account")?.setOnPreferenceClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, AccountPreference())
                commit()
            }
            true
        }

        findPreference<Preference>("sign-out")?.setOnPreferenceClickListener {
            startActivity(Intent(activity, Login::class.java))
            true
        }

    }
}
package com.jarvis.poi.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.jarvis.poi.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}
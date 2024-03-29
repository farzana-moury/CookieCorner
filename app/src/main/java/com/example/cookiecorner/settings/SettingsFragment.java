package com.example.cookiecorner.settings;
import android.os.Bundle;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.cookiecorner.R;

/**
 * The Settings Fragment
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Dec 6th 2020
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    /**
     *
     * @param savedInstanceState savedInstanceState
     * @param rootKey the key that gives you access to the preference value
     */
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

    }
}
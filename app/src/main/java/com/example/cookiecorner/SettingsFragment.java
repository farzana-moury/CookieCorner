package com.example.cookiecorner;

import android.os.Bundle;

import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

import static com.example.cookiecorner.Credentials.credentials;

public class SettingsFragment extends PreferenceFragmentCompat {
    public static EditTextPreference namePreference;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        namePreference = findPreference("name"); //referencing a given preference




    }
}
package com.shashankbhat.notesapp.ui;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.shashankbhat.notesapp.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    public static final String KEY_TABLE_MODE = "tablet_mode";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

    }
}
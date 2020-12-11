package com.example.cookiecorner;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The Settings Activity
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Dec 6th 2020
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * This method is called when the Activity is first created. Here we put initialization code.
     *
     * @param savedInstanceState the saved Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }
}
package com.example.cookiecorner;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.cookiecorner.settings.SettingsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

/**
 * The Main class to contain the configuration for navigating between all fragments
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 8th 2020
 */
public class MainActivity extends AppCompatActivity {

    // properties
    private AppBarConfiguration mAppBarConfiguration;
    public static FloatingActionButton fab;
    public static SharedPreferences preferences;

    /**
     * This method is called when the Fragment is first created. Here we put initialization code.
     *
     * @param savedInstanceState the saved Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        // setting an action on the fab to take us to the customize fragment once it is clicked
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // look for the nav host fragment
                NavHostFragment navHost = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

                // grab its nav controller
                NavController controller = navHost.getNavController();

                // use the controller to navigate to the customize fragment
                controller.navigate(R.id.action_nav_orders_to_nav_customize);
            }
        });

        // accessing the shared preferences to transfer data to and from settings
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_menu, R.id.nav_bakery, R.id.nav_recipes, R.id.nav_account, R.id.nav_orders,
                R.id.nav_contact, R.id.nav_customize, R.id.activity_settings, R.id.nav_settings, R.id.nav_credits)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     * The initialization method to upon creating the options menu
     *
     * @param menu menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * When the settings option gets selected
     *
     * @param item menu item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings: {
                //Launch the settings activity
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * @return NavigationUI.navigateUp()
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
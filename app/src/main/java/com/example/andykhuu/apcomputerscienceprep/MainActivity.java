package com.example.andykhuu.apcomputerscienceprep;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Message button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //Initializes the items listed in the list when navigation scroll is open
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    /**
     * Closes nav view if back key is pressed from phone
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Creates the content that is displayed when top right key is pressed
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Handles what happens when things within action bar is pressed
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Currently mapped when selected to settings activity page
        if (id == R.id.action_settings) {
            launchSettings(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method to open up settings activity page
     * @param c
     */
     public static void launchSettings(Context c){
                Intent i = new Intent(c,SettingsActivity.class);
                c.startActivity(i);
            }
    /**
     * Handles what happens when each item in nav view is pressed
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent i = new Intent(this,UnitActivity.class);

        //Depending on what unit was pressed, start the UnitActivity and pass it a UNITID in order
        //to have it differentiate what to actuate
        switch (id) {
            case R.id.nav_unit0:
                i.putExtra("UNITID", 0);
                break;
            case R.id.nav_unit1:
                i.putExtra("UNITID", 1);
                break;
            case R.id.nav_unit2:
                i.putExtra("UNITID", 2);
                break;
            case R.id.nav_unit3:
                i.putExtra("UNITID", 3);
                break;
            case R.id.nav_unit4:
                i.putExtra("UNITID", 4);
                break;
            case R.id.nav_unit5:
                i.putExtra("UNITID", 5);
                break;
            case R.id.nav_unit6:
                i.putExtra("UNITID", 6);
                break;
        }
        startActivity(i);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

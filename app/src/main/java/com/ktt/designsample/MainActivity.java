package com.ktt.designsample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.drawer);

        Fragment fragment = Fragment.instantiate(this, MainFragment.class.getName(), null);
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit();

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    public void setupActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE
                | ActionBar.DISPLAY_SHOW_HOME
                | ActionBar.DISPLAY_HOME_AS_UP);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
            mDrawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);

        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_item_1:
            case R.id.navigation_item_2:
            case R.id.navigation_sub_item_1:
            case R.id.navigation_sub_item_2:
                item.setChecked(true);
                Toast.makeText(this, "Navigation item", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}

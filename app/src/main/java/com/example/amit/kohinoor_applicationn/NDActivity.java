package com.example.amit.kohinoor_applicationn;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.amit.kohinoor_applicationn.FRAGMENT.FragmentFive;
import com.example.amit.kohinoor_applicationn.FRAGMENT.FragmentFour;
import com.example.amit.kohinoor_applicationn.FRAGMENT.FragmentOne;
import com.example.amit.kohinoor_applicationn.FRAGMENT.FragmentSeven;
import com.example.amit.kohinoor_applicationn.FRAGMENT.FragmentSix;
import com.example.amit.kohinoor_applicationn.FRAGMENT.FragmentThree;
import com.example.amit.kohinoor_applicationn.FRAGMENT.FragmentTwo;

public class NDActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private View navHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nd);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            Fragment newFragment = new FragmentOne();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.content_frame, newFragment);
            ft.addToBackStack(null);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;
        Bundle bundle = new Bundle();
        if (id == R.id.Dashboard) {
            fragmentClass = FragmentOne.class;
        } else if (id == R.id.Masters) {
            fragmentClass = FragmentTwo.class;
        } else if (id == R.id.Orders) {
            fragmentClass = FragmentThree.class;
        } else if (id == R.id.Challan) {
            fragmentClass = FragmentFour.class;
        } else if (id == R.id.Accounts) {
            fragmentClass = FragmentFive.class;
        } else if (id == R.id.Daily_Task) {
            fragmentClass = FragmentSix.class;
        } else if (id == R.id.Budget) {
            fragmentClass = FragmentSeven.class;
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

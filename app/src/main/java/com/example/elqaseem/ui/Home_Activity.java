package com.example.elqaseem.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.elqaseem.R;
import com.example.elqaseem.ui.fragments.DatePickerFragment;
import com.example.elqaseem.ui.fragments.ExtraServicesFragment;
import com.example.elqaseem.ui.fragments.FavouriteFragments;
import com.example.elqaseem.ui.fragments.HomeFragment;
import com.example.elqaseem.ui.fragments.MoreFragment;
import com.example.elqaseem.ui.fragments.OffersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class Home_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        String languageToLoad  = "ar";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(itemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, new HomeFragment()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    String mFragmentTag = null;
                    switch (menuItem.getItemId()) {
                        case R.id.bottom_nav_home:
                            selectedFragment = new HomeFragment();
                            mFragmentTag = "HomeFragment";
                            break;
                        case R.id.bottom_nav_extra:
                            selectedFragment = new ExtraServicesFragment();
                            mFragmentTag = "ExtraServicesFragment";
                            break;
                        case R.id.bottom_nav_fav:
                            selectedFragment = new FavouriteFragments();
                            mFragmentTag = "FavouriteFragments";
                            break;
                        case R.id.bottom_nav_offers:
                            selectedFragment = new OffersFragment();
                            mFragmentTag = "OffersFragment";
                            break;
                        case R.id.bottom_nav_more:
                            selectedFragment = new MoreFragment();
                            mFragmentTag = "MoreFragment";
                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout_home, selectedFragment, mFragmentTag)
                            .commit();
                    return true;
                }
            };

}

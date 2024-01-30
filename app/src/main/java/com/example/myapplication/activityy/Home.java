package com.example.myapplication.activityy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.fragment.CaiDatFragment;
import com.example.myapplication.fragment.CalendarFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.ThongkeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        setupBottomNavigationView();
        showInitialFragment();
    }

    private void setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private void showInitialFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.trangchu) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.calendar) {
                    selectedFragment = new CalendarFragment();
                } else if (item.getItemId() == R.id.thongke) {
                    selectedFragment = new ThongkeFragment();
                } else if (item.getItemId() == R.id.caidat) {
                    selectedFragment = new CaiDatFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        selectedFragment).commit();

                return true;
            };
}
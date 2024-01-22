package com.example.myapplication.activityy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.fragment.CaiDatFragment;
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

                int itemId = item.getItemId(); // Lưu lại giá trị R.id để sử dụng trong lambda


                if (item.getItemId() == R.id.trangchu) {

                    HomeFragment fragment = new HomeFragment();

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
                if (item.getItemId() == R.id.thongke) {
                    ThongkeFragment fragment = new ThongkeFragment();

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();

                } else if (item.getItemId() == R.id.caidat) {


                    CaiDatFragment fragment = new CaiDatFragment();

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();


                }


                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                }

                return true;
            };

}
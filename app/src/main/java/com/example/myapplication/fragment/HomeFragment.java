package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.HomeSliderAdapter;

import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeSliderAdapter sliderAdapter;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;



    ViewPager2 viewPagerSlide;
    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPagerSlide = (ViewPager2) view.findViewById(R.id.viewPagerSlide);

        setupSlider();
    }
    private void setupSlider() {
        List<Integer> imageList = Arrays.asList(


                R.drawable.quytac1,
                R.drawable.quytac4,
                R.drawable.quytac3,
                R.drawable.quytac4,
                R.drawable.quytac6,
                R.drawable.quytac7,
                R.drawable.quytac8,
                R.drawable.quytac9,
                R.drawable.quytac10

        );

        sliderAdapter = new HomeSliderAdapter(imageList);
        viewPagerSlide.setAdapter(sliderAdapter);

        // Auto chuyển đổi slide mỗi 3 giây
        runnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPagerSlide.getCurrentItem();
                int totalItems = imageList.size();
                int nextItem = (currentItem + 1) % totalItems;
                viewPagerSlide.setCurrentItem(nextItem);
                handler.postDelayed(this, 3000); // 3000 milliseconds = 3 seconds
            }
        };
        // Khởi động auto chuyển đổi
        handler.postDelayed(runnable, 3000); // 3000 milliseconds = 3 seconds
    }
}
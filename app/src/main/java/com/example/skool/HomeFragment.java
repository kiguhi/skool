package com.example.skool;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private static final long SLIDER_TIMER = 2000; // change slider interval
    private int currentPage = 0; // this will tell us the current page available on the view pager
    // please see ViewPager Listener on the onPageSelected method to see how we are updating
    // currentPage variable

    private boolean isCountDownTimerActive = false; // let the timer start if and only if it has completed previous task


    private Handler handler;
    private ViewPager mviewPager;

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (!isCountDownTimerActive) {
                automateSlider();
            }

            handler.postDelayed(runnable, 1000);
            // our runnable should keep running for every 1000 milliseconds (1 seconds)
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main, container, false);
        handler = new Handler();

        handler.postDelayed(runnable, 1000);
        runnable.run();

        mviewPager =view.findViewById(R.id.view_pager_slider);

        CustomViewPagerAdapter viewPagerAdapter = new CustomViewPagerAdapter(getFragmentManager());
        mviewPager.setAdapter(viewPagerAdapter);

        // now it's time to think about our sliders


        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    currentPage = 0;
                } else if (position == 1) {
                    currentPage = 1;
                } else {
                    currentPage = 2;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }
    private void automateSlider() {
        isCountDownTimerActive = true;
        new CountDownTimer(SLIDER_TIMER, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                int nextSlider = currentPage + 1;

                // remember view pager pages, starts from 0
                // our maximum page is: 2 because we have 3 sliders

                if (nextSlider == 3) {
                    nextSlider = 0; // if it's last Image, let it go to the first image
                }

                mviewPager.setCurrentItem(nextSlider);
                isCountDownTimerActive = false;
            }
        }.start();
    }
    @Override
    public void onStop() {
        super.onStop();
        // Kill this background task once the activity has been killed
        handler.removeCallbacks(runnable);
    }
}

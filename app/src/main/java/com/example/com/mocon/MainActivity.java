package com.example.com.mocon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.OnImageClickedListener{
    ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nickname = "닉네임 없음";
        Boolean isMale = true;
        Intent prevIntent = getIntent();
        if (prevIntent.getExtras() != null) {
            nickname = prevIntent.getStringExtra("nickname");
            isMale = prevIntent.getBooleanExtra("gender", true);
        }

        mainViewPager = (ViewPager) findViewById(R.id.main_view_pager);




        final PagerAdapter mainPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), nickname, isMale);
        mainViewPager.setAdapter(mainPagerAdapter);


        findViewById(R.id.mainNavButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(0);
            }
        });

        findViewById(R.id.foodNavButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(1);
            }
        });

        findViewById(R.id.calendarNavButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(2);
            }
        });

        findViewById(R.id.groupNavButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(3);
            }
        });

        findViewById(R.id.alermNavButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(4);
            }
        });


    }

    @Override
    public void OnImageClicked(int position) {
        mainViewPager.setCurrentItem(position);
    }
}

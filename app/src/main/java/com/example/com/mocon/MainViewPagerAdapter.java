package com.example.com.mocon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    String nickname;
    Boolean gender;
    public MainViewPagerAdapter(FragmentManager fm, String nickname, Boolean gender) {
        super(fm);
        this.nickname = nickname;
        this.gender = gender;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment mFragment = new MainFragment();
        switch(position) {
            case 0:
                Bundle bundle = new Bundle();
                bundle.putString("nickname", nickname);
                bundle.putBoolean("gender", gender);
                mFragment.setArguments(bundle);
                break;
            case 1: mFragment = new FoodFragment(); break;
            case 2: mFragment = new CalendarFragment(); break;
            case 3: mFragment = new GroupFragment(); break;
            case 4: mFragment = new AlarmFragment();
        }
        return mFragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}

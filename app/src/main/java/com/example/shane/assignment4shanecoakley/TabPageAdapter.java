package com.example.shane.assignment4shanecoakley;

/**
 * Created by shane on 06/01/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPageAdapter extends FragmentPagerAdapter {

    public TabPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new InfoFragment();
            case 1:
                return new MenuFragment();
            case 2:
                return new OrderFragment();
            case 3:
                return new AccountFragment();
        }

        return null;
    }


    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "INFO";
            case 1:
                return "MENU";
            case 2:
                return "ORDER";
            case 3:
                return "ACCOUNT";
        }
        return null;
    }
}
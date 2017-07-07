package com.example.danielojea.srapp;

/**
 * Created by User on 07.07.2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                AbilityPickerTabSingle tab1 = new AbilityPickerTabSingle();
                return tab1;
            case 1:
                AbilityPickerTabPackage tab2 = new AbilityPickerTabPackage();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

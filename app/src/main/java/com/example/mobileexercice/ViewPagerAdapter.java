package com.example.mobileexercice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragments= new ArrayList<Fragment>();
    private final ArrayList<String> fragmentsTitles= new ArrayList<String>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsTitles.size();
    }

    @Override
    public String getPageTitle(int position) {
        return fragmentsTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        fragmentsTitles.add(title);
    }
}

package com.example.mobileexercice;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ActivityPrincipal extends AppCompatActivity {

    TabLayout tabLayout;
    AppBarLayout appBarLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentAgendar(), "Agendar");
        adapter.addFragment(new FragmentLocais(), "Locais");
        adapter.addFragment(new FragmentInicio(), "Inicio");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
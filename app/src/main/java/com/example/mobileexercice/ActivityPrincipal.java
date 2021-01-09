package com.example.mobileexercice;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ActivityPrincipal extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentInicio(), "Inicio");
        adapter.addFragment(new FragmentLocais(), "Locais");
        adapter.addFragment(new FragmentAgendar(), "Agendar");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        addListenerSound();
        mediaPlayer.start();
    }

    private void addListenerSound(){
        mediaPlayer = MediaPlayer.create(this, R.raw.windowsstartup);
    }
}
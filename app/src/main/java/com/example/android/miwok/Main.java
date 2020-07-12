package com.example.android.miwok;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.miwok.models.Hat;
import com.example.android.miwok.resources.Hats;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    // widgets
    private ViewPager mMyViewPager;
    private TabLayout mTabLayout;


    public void init(int i) {
        setContentView(R.layout.main);
        mTabLayout = findViewById(R.id.tab_layout);
        mMyViewPager = findViewById(R.id.view_pager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        Hat[] hats = Hats.getHats();
        for (Hat hat : hats) {
            com.example.android.miwok.ViewPagerItemFragment fragment = com.example.android.miwok.ViewPagerItemFragment.getInstance(hat);
            fragments.add(fragment);
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager() , fragments);
        mMyViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mMyViewPager);
        mMyViewPager.setCurrentItem(i);
    }

}

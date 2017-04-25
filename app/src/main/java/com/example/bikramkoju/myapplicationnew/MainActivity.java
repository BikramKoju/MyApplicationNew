package com.example.bikramkoju.myapplicationnew;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

    PagerSlidingTabStrip pagerSlidingTabStrip;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerSlidingTabStrip=(PagerSlidingTabStrip)findViewById(R.id.pager_tabs);
        viewPager =(ViewPager)findViewById(R.id.viewpager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new TypeA(), "Type A");
        viewPagerAdapter.addFragments(new TypeB(),"Type B");
        viewPager.setAdapter(viewPagerAdapter);
        pagerSlidingTabStrip.setViewPager(viewPager);
    }
}

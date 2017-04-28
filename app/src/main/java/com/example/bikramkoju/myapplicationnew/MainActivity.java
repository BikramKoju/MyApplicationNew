package com.example.bikramkoju.myapplicationnew;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import static com.example.bikramkoju.myapplicationnew.R.attr.title;

public class MainActivity extends AppCompatActivity {

    PagerSlidingTabStrip pagerSlidingTabStrip;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.result);

       /* SharedPreferences sharedPreferences =getSharedPreferences("values",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        long sum=sharedPreferences.getLong("sum",0);*/

                String title = getIntent().getStringExtra("title");
                if(title!=null) {
                   /* long value = Long.parseLong(title);
                    sum =sum + value;


                    //minus=minus+value;
                    //  sum=value;

                    editor.putLong("sum",sum);
                    // editor.putLong("minus",minus);
                    editor.commit();*/



                    // Bitmap bitmap = getIntent().getParcelableExtra("image");

                    textView.setText(title);
                    //textView.setText(String.valueOf(minus));
                }
                else {
                    textView.setText("result");

                }

        pagerSlidingTabStrip=(PagerSlidingTabStrip)findViewById(R.id.pager_tabs);
        viewPager =(ViewPager)findViewById(R.id.viewpager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new TypeA(),"Type A");
        viewPagerAdapter.addFragments(new TypeB(),"Type B");
        viewPager.setAdapter(viewPagerAdapter);
        pagerSlidingTabStrip.setViewPager(viewPager);
    }
    /*public void setNumber(int position){

        Toast.makeText(this,"clicked" ,Toast.LENGTH_LONG).show();
    }*/
}

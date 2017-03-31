package com.gaih.weibotab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gaih.weibotab.fragment.MyFragmentPagerAdapter;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ViewPager viewPager = (ViewPager) findViewById(R.id.mViewPager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                this);
        viewPager.setAdapter(adapter);
        TabLayout tableLayout = (TabLayout) findViewById(R.id.mTab);
        tableLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tableLayout.setTabMode(TabLayout.MODE_FIXED);
        tableLayout.setupWithViewPager(viewPager);
    }
}



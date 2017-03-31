package com.gaih.weibotab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gaih.weibotab.fragment.MyFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.mViewPager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                this);
        viewPager.setAdapter(adapter);
        TabLayout tableLayout = (TabLayout) findViewById(R.id.mTab);
        tableLayout.setupWithViewPager(viewPager);
    }
}

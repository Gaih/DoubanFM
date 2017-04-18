package com.gaih.weibotab.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaih.weibotab.R;

/**
 * Created by gaih on 17-3-31.
 */

public class Fragment01 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mNews = inflater.inflate(R.layout.activity_news,container,false);

        ViewPager viewPager = (ViewPager) mNews.findViewById(R.id.mViewPager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(),
                getActivity());
        TabLayout tableLayout = (TabLayout) mNews.findViewById(R.id.mTab);
        //tab充满
        tableLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tableLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);
        return mNews;
    }
}

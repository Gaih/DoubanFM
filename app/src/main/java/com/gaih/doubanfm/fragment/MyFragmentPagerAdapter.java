package com.gaih.doubanfm.fragment;

import android.content.Context;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.gaih.doubanfm.FirstTab.FragmentFm;
import com.gaih.doubanfm.FirstTab.FragmentLike;
import com.gaih.doubanfm.FirstTab.FragmentList;
import com.gaih.doubanfm.FirstTab.FragmentMe;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/3/30.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private static final String[] mTitles = {"豆瓣FM", "歌单", "红心","我的"};
    private ArrayList<android.app.Fragment> datas;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        datas = new ArrayList<>();
        FragmentFm tab01 = new FragmentFm();
        FragmentLike tab02 = new FragmentLike();
        FragmentList tab03 = new FragmentList();
        FragmentMe tab04 = new FragmentMe();
        datas.add(tab01);
        datas.add(tab02);
        datas.add(tab03);
        datas.add(tab04);
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }


    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}

package com.gaih.weibotab;

import android.app.ProgressDialog;
import android.content.Context;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gaih.weibotab.DoubanFM.GetFmList;
import com.gaih.weibotab.FirstTab.FragmentFm;
import com.gaih.weibotab.fragment.Fragment01;
import com.gaih.weibotab.fragment.Fragment02;
import com.gaih.weibotab.fragment.MyFragmentPagerAdapter;

/**
 * Created by gaih on 17-3-31.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBut_main;
    private Button mBut_news;
    private Button mBut_squ;
    private Button mBut_set;
    public static Context mContext;
    public ProgressDialog mDialog;

    Fragment01 mDouban;
    Fragment02 mFriend;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBut_main = (Button) findViewById(R.id.mBtn_main);
        mBut_news = (Button) findViewById(R.id.mBtn_news);
        mBut_squ = (Button) findViewById(R.id.mBtn_squ);
        mBut_set = (Button) findViewById(R.id.mBtn_set);

        mBut_squ.setOnClickListener(this);
        mBut_set.setOnClickListener(this);
        mBut_main.setOnClickListener(this);
        mBut_news.setOnClickListener(this);
        mContext = MainActivity.this;
        setDefaultFragment();

    }
    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mDouban = new Fragment01();
        transaction.replace(R.id.id_content, mDouban);
        transaction.commit();

//        FragmentFm Fm = new FragmentFm();
//        GetFmList fmList = new GetFmList();
//        fmList.getMainList(mContext,Fm.mHandler);
//        mDialog = new ProgressDialog(mContext);
//        mDialog.setTitle("正在登录");
//        mDialog.setMessage("正在登陆服务器，请稍后...");
//        mDialog.show();
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (v.getId()){
            case R.id.mBtn_main:
                if (mDouban == null)
                {
                    mDouban = new Fragment01();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, mDouban);
                break;
            case R.id.mBtn_news:
                if (mFriend == null)
                {
                    mFriend = new Fragment02();
                }
                transaction.replace(R.id.id_content, mFriend);
                break;
        }
        transaction.commit();

    }
}

package com.gaih.doubanfm;

import android.app.ProgressDialog;
import android.content.Context;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.gaih.doubanfm.fragment.Fragment01;
import com.gaih.doubanfm.fragment.Fragment02;

/**
 * Created by gaih on 17-3-31.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static Context mContext;

    Fragment01 mDouban;
    Fragment02 mFriend;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolBar = (Toolbar) findViewById(R.id.mToolbar);
//        setSupportActionBar(toolBar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
    }

    @Override
    public void onClick(View v) {

    }
}

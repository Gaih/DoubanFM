package com.gaih.weibotab.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
        View mNews = inflater.inflate(R.layout.fragment01,container,false);
        return mNews;
    }
}

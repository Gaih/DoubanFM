package com.gaih.doubanfm.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gaih.doubanfm.R;


/**
 * Created by gaih on 17-3-31.
 */

public class Fragment02 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mNews = inflater.inflate(R.layout.fragment02,container,false);
        return mNews;
    }
}

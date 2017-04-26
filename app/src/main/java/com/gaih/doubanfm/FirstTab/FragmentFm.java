package com.gaih.doubanfm.FirstTab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaih.doubanfm.Adapter.MainPageAdapter;
import com.gaih.doubanfm.Adapter.MainPager;
import com.gaih.doubanfm.DoubanFM.GetFmList;
import com.gaih.doubanfm.DoubanFM.GetMusicList;
import com.gaih.doubanfm.R;

import java.util.ArrayList;

import static com.gaih.doubanfm.MainActivity.mContext;

/**
 * Created by gaih on 2016/8/20.
 */

public class FragmentFm extends Fragment {

    private View view;
    private ArrayList<MainPager> musicList = new ArrayList<MainPager>();

    private MainPageAdapter mainAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout mSwipe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("oncreate","oncreate");
        GetFmList fmList = new GetFmList();
        fmList.getMainList(mContext,mHandler);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab01, container, false);
        initView();
        Log.d("oncreateview","oncreateview");
        return view;
    }

    private void initView() {
        mSwipe = (SwipeRefreshLayout) view.findViewById(R.id.mSwipe);
        mSwipe.setColorSchemeResources(R.color.google_blue, R.color.google_green, R.color.google_red, R.color.google_yellow);
        mSwipe.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                musicList.clear();
                GetFmList fmList = new GetFmList();
                fmList.getMainList(mContext,mHandler);
            }
        });

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter = new MainPageAdapter(musicList);
        mRecyclerView.setAdapter(mainAdapter);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(
//                this.getContext(), DividerItemDecoration.VERTICAL_LIST
//        ));
        mainAdapter.setOnItemClickListener(new MainPageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.animate()
                            .translationZ(15f)
                            .setDuration(300)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                        view.animate()
                                                .translationZ(1f)
                                                .setDuration(500)
                                                .start();
                                    }
                                }
                            }).start();
                }
                TextView tx = (TextView) view.findViewById(R.id.itemId);
                String  id = tx.getText().toString();
                GetMusicList music = new GetMusicList();
                music.getMainList(id, mHandler);            }
        });

    }


    private Handler mHandler = new Handler(mContext.getMainLooper()) {
        public void handleMessage(Message msg) {//此方法在ui线程运行
            switch (msg.what) {
                case 0:
                    ArrayList<MainPager> arrayList = msg.getData().getParcelableArrayList("json");
                    for (MainPager page :
                            arrayList) {
                        musicList.add(page);
                    }
//                    Log.d("11111", "2222" + name + intro + bmp);

                    initView();

                    break;
                case 1:
                    String url = msg.getData().getString("url");
                    String name = msg.getData().getString("name");
                    Bitmap pic = msg.getData().getParcelable("bmp");
                    Log.d("11111", "case1:" + url+name+pic);

                    break;
                case 2:

                    break;
            }
        }
    };

}

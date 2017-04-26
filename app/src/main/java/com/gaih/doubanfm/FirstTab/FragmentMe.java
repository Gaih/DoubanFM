package com.gaih.doubanfm.FirstTab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gaih.doubanfm.R;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by gaih on 17-3-31.
 */

public class FragmentMe extends Fragment {
    private Button mLogin;
    private EditText mUser;
    private EditText mPassword;
    private String username;
    private String password;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mMe = inflater.inflate(R.layout.fragmentme, container, false);
        mLogin = (Button) mMe.findViewById(R.id.mLogin);
        mUser = (EditText) mMe.findViewById(R.id.mUsername);
        mPassword = (EditText) mMe.findViewById(R.id.mPassword);

        username = mUser.getText().toString();
        password = mPassword.getText().toString();
        Log.d("11111", 11111+username+password);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(getRunnable).start();
            }
        });

        return mMe;
    }

    Runnable getRunnable = new Runnable() {
        @Override
        public void run() {
            //创建okHttpClient对象 get方法
            OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
            RequestBody formBody = new FormBody.Builder()
                    .add("apikey", "02646d3fb69a52ff072d47bf23cef8fd")
                    .add("client_id", "02646d3fb69a52ff072d47bf23cef8fd")
                    .add("client_secret", "cde5d61429abcd7c")
                    .add("udid", "b88146214e19b8a8244c9bc0e2789da68955234d")
                    .add("douban_udid", "b635779c65b816b13b330b68921c0f8edc049590")
                    .add("device_id", "b88146214e19b8a8244c9bc0e2789da68955234d")
                    .add("grant_type", "password")
                    .add("redirect_uri", "http://www.douban.com/mobile/fm")
                    .add("username", mUser.getText().toString())
                    .add("password", mPassword.getText().toString())
                    .build();

            Log.d("11111", 11111+username+password);

            final Request request = new Request.Builder()
                    .url("https://www.douban.com/service/auth2/token")
                    .post(formBody)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
//new call
            Call call = mOkHttpClient.newCall(request);
//请求加入调度
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d("22222", "22222");

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    // 输出返回结果
                    InputStream input = response.body().byteStream();
                    int resLen = 0;
                    byte[] res = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while ((resLen = input.read(res)) != -1) {
                        sb.append(new String(res, 0, resLen));
                    }
                    Log.d("11111", "11111" + sb.toString());

                }
            });
        }
    };
}

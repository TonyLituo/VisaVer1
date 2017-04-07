package com.dhcc.visa.model.network;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.visa.common.utils.LogUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Lituo on 2017/4/5 0005. 16:08 .
 * Mail：tony1994_vip@163.com
 * 方法能在主线程中运行的CallBack
 */


public abstract class UICallBack implements Callback {

    //拿到主线程的handler
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
        //通过主线程的handler.post方法，发送一个可以在主线程中运行的run方法
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailureUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {

        LogUtils.e("" + response.code());

        //判断是否响应成功
        if (!response.isSuccessful()) {
            LogUtils.e(response.code() + "");
            //访问错误  根据不同的响应码做出判断
            onError(response.code());

        }


        //拿到json字符串
        String body = response.body().string();
        final JSONObject jsonObject = JSON.parseObject(body);

        handler.post(new Runnable() {
            @Override
            public void run() {
                onResponseUI(call, jsonObject);
            }
        });

    }


    //抽象三个方法（运行在主线程）


    public abstract void onResponseUI(Call call, JSONObject jsonResponseBody);

    public abstract void onFailureUI(Call call, IOException e);

    public abstract void onError(int responseCode);

}

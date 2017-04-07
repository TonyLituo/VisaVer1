package com.dhcc.visa.persenter;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.visa.common.utils.OkHttpUtils;
import com.dhcc.visa.model.bean.Bean;
import com.dhcc.visa.model.network.UICallBack;
import com.dhcc.visa.persenter.base.BaseNetPersenter;
import com.dhcc.visa.ui.base.IBaseNetView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Lituo on 2017/4/5 0005. 16:15 .
 * Mail：tony1994_vip@163.com
 * <p>
 * 登陆的逻辑实现
 */

public class LoginPersenter extends BaseNetPersenter<IBaseNetView> {
    // TODO: 2017/4/6 0006 测试用 不是正式版
//    private Call mCall;
//    private Handler mHandler = new Handler();

    /*登陆的逻辑实现*/
    public void login() {
        getView().showPrgbar();
        /*
        *登录逻辑*/
//        mCall = VisaClient.getInstance().login("annie", "123654");

//        mCall.enqueue(new Callback() {//CallBack运行在子线程中，不能更新视图,可以用UICallBack(自定义)
//            @Override
//            public void onFailure(Call call, IOException e) {
//                //调用视图接口的方法   这里是运行在子线程中
//
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        getView().onError();
//                    }
//                }, 1500);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                //模拟登录时间
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        getView().loadingEnd();
//                    }
//                }, 1500);
//
//            }
//        });


        json.put("busType", "XXXX");
        json.put("busType", "XXXX");


        OkHttpUtils.Builder().build().doPostJsonAsync(json, new UICallBack() {
            @Override
            public void onError(int responseCode) {
                getView().hidePrgbar();
                getView().error(responseCode);
            }

            @Override
            public void onFailureUI(Call call, IOException e) {
                getView().hidePrgbar();
                getView().failure();
            }

            @Override
            public void onResponseUI(Call call, JSONObject jsonResponseBody) {
                getView().hidePrgbar();

                Bean bean = new Gson().fromJson(jsonResponseBody.toString(), Bean.class);
                getView().succeed(bean);
            }
        });


    }

    @Override
    public void onSucceed(Bean bean) {

// TODO: 2017/4/7 0007 数据处理
    }
}

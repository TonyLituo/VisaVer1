package com.dhcc.visa.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.dhcc.visa.common.AppManager;
import com.dhcc.visa.common.utils.ActivityUtils;
import com.dhcc.visa.common.utils.LogUtils;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lituo on 2017/4/5 0005. 16:05 .
 * Mail：tony1994_vip@163.com
 * Activity的基类
 */

public abstract class BaseActivity<V extends IBaseView, P extends MvpPresenter<V>> extends MvpActivity<V, P> {

    protected ActivityUtils mActivityUtils;

    protected Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        LogUtils.d(getClass().getSimpleName());
        mActivityUtils = new ActivityUtils(this);
        //butterknife绑定
        mUnbinder = ButterKnife.bind(this);
        initView();
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
    }

    //布局ID
    @LayoutRes
    public abstract int getLayoutResID();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mUnbinder = null;
        mActivityUtils = null;
        // 结束Activity从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }
}

package com.dhcc.visa.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhcc.visa.common.utils.ActivityUtils;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lituo on 2017/4/5 0005. 16:05 .
 * Mail：tony1994_vi@163.com
 * Fragment的基类
 */

public abstract class BaseFragment<V extends IBaseView, P extends MvpPresenter<V>> extends MvpFragment<V, P> {
    protected Unbinder mUnbinder;
    protected ActivityUtils mActivityUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mActivityUtils = new ActivityUtils(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    protected abstract void initView();

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mUnbinder = null;
        mActivityUtils = null;
    }
}

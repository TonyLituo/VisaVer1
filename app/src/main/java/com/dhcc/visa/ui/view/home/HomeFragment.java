package com.dhcc.visa.ui.view.home;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.HomePresenter;
import com.dhcc.visa.ui.base.BaseFragment;

/**
 * Created by Lituo on 2017/4/6 0006. 13:02 .
 * Mail：tony1994_vip@163.com
 */

public class HomeFragment extends BaseFragment<IHomeView,HomePresenter> implements IHomeView{
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }
}

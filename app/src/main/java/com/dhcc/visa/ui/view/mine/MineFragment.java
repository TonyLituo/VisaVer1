package com.dhcc.visa.ui.view.mine;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.MinePresenter;
import com.dhcc.visa.ui.base.BaseFragment;

/**
 * Created by Lituo on 2017/4/6 0006. 13:03 .
 * Mail：tony1994_vip@163.com
 */

public class MineFragment extends BaseFragment<IMineView, MinePresenter> implements IMineView {

    @Override
    public MinePresenter createPresenter() {
        return new MinePresenter();
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }


}

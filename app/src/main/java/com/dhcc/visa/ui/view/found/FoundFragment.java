package com.dhcc.visa.ui.view.found;

import com.dhcc.visa.R;
import com.dhcc.visa.common.utils.LogUtils;
import com.dhcc.visa.persenter.FoundPresenter;
import com.dhcc.visa.ui.base.BaseFragment;

/**
 * Created by Lituo on 2017/4/6 0006. 11:53 .
 * Mail：tony1994_vip@163.com
 */

public class FoundFragment extends BaseFragment<IFoundView, FoundPresenter> implements IFoundView {


    @Override
    protected void initView() {
       LogUtils.e("===========");
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_found;
    }

    @Override
    public FoundPresenter createPresenter() {
        return new FoundPresenter();
    }
}

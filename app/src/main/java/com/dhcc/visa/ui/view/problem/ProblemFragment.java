package com.dhcc.visa.ui.view.problem;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.ProblemPresenter;
import com.dhcc.visa.ui.base.BaseFragment;

/**
 * Created by Lituo on 2017/4/6 0006. 15:52 .
 * Mail：tony1994_vip@163.com
 */

public class ProblemFragment extends BaseFragment<IProblemView, ProblemPresenter> implements IProblemView {
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_problem;
    }

    @Override
    public ProblemPresenter createPresenter() {
        return new ProblemPresenter();
    }
}

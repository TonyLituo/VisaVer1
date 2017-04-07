package com.dhcc.visa.ui.view.user.login;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dhcc.visa.R;
import com.dhcc.visa.model.bean.Bean;
import com.dhcc.visa.persenter.LoginPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseNetView;

import butterknife.BindView;
import butterknife.OnClick;

// TODO: 2017/4/6 0006 此页面不是正式版
public class LoginActivity extends BaseActivity<IBaseNetView, LoginPersenter> implements IBaseNetView {


    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.pgb)
    ProgressBar mPgb;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }


    @OnClick(R.id.btn)
    public void onViewClicked() {
        presenter.login();
    }

    @NonNull
    @Override
    public LoginPersenter createPresenter() {
        return new LoginPersenter();
    }


    @Override
    public void showPrgbar() {
        mPgb.setVisibility(View.VISIBLE);
        Toast.makeText(this, "开始加载！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hidePrgbar() {
        mPgb.setVisibility(View.GONE);
    }

    @Override
    public void succeed(Bean bean) {
        presenter.succeed(bean);
        mActivityUtils.showToast("连接成功");
    }




    @Override
    public void failure() {
        String err = presenter.connFailure();
        mActivityUtils.showToast(err);
    }

    @Override
    public void error(int responseCode) {

        String error = presenter.getNetError(responseCode);
        mActivityUtils.showToast(error);
    }
}

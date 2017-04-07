package com.dhcc.visa.ui.view;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.MainPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.BaseFragment;
import com.dhcc.visa.ui.view.found.FoundFragment;
import com.dhcc.visa.ui.view.home.HomeFragment;
import com.dhcc.visa.ui.view.mine.MineFragment;
import com.dhcc.visa.ui.view.problem.ProblemFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IMainView, MainPersenter> implements IMainView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rg_group)
    RadioGroup mRbtnGroup;
    @BindView(R.id.rbtn_home)
    RadioButton mRbtnHome;
    @BindView(R.id.rbtn_found)
    RadioButton mRbtnFound;
    @BindView(R.id.rbtn_problem)
    RadioButton mRbtnProblem;
    @BindView(R.id.rbtn_my_visa)
    RadioButton mRbtnMyVisa;
    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;
    @BindView(R.id.base_tool_right)
    ImageView mBaseToolRight;

    //判断是否登录
    private boolean isLogin;
    //当前显示的fragment
    private BaseFragment mCurrentFragment;

    private HomeFragment mHomeFragment;
    private FoundFragment mFoundFragment;
    private ProblemFragment mProblemFragment;
    private MineFragment mMineFragment;

    @NonNull
    @Override
    public MainPersenter createPresenter() {
        return new MainPersenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        mRbtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO: 2017/4/6 0006  交易完刷新页面

                isLogin = presenter.isLogin();

                switch (checkedId) {
                    case R.id.rbtn_home://主页
                        if (null == mHomeFragment) {
                            mHomeFragment = new HomeFragment();
                        }
                        setToolTitle(R.string.home);
                        showFragment(mHomeFragment);
                        mActivityUtils.showToast("待实现，替换为主页  页面");
                        break;
                    case R.id.rbtn_found://发现
                        if (null == mFoundFragment) {
                            mFoundFragment = new FoundFragment();
                        }
                        setToolTitle(R.string.found);
                        showFragment(mFoundFragment);
                        mActivityUtils.showToast("待实现，替换为发现  页面");
                        break;
                    case R.id.rbtn_problem://常见问题
                        if (null == mProblemFragment) {
                            mProblemFragment = new ProblemFragment();
                        }
                        setToolTitle(R.string.problem);
                        showFragment(mProblemFragment);
                        mActivityUtils.showToast("待实现，替换为常见问题  页面");
                        break;
                    case R.id.rbtn_my_visa://我的签证
                        if (null == mMineFragment) {
                            mMineFragment = new MineFragment();
                        }
                        setToolTitle(R.string.my_visa);
                        if (isLogin) {
                            showFragment(mMineFragment);
                        } else {
                            //// TODO: 2017/4/7 0007 显示未登录页面
                        }

                        mActivityUtils.showToast("待实现，替换为我的签证  页面");
                        break;
                    default:

                        throw new UnsupportedOperationException("未知错误");

                }
            }
        });
    }


    @Override
    public void showFragment(BaseFragment fragment) {


        //要显示的页面为当前页面，跳出方法不做操作
        if (fragment == mCurrentFragment) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (null != mCurrentFragment) {
            transaction.hide(mCurrentFragment);
        }
        if (fragment.isAdded()) {//添加过了直接显示
            transaction.show(fragment);
        } else {
            String tag = fragment.getClass().getSimpleName();
            // 添加Fragment并设置Tag
            transaction.add(R.id.layout_container, fragment, tag);
        }

        transaction.commit();
        mCurrentFragment = fragment;
    }


    @Override
    public void setToolTitle(int stringRes) {
        String s = getResources().getString(stringRes);
        mBaseToolbarTitle.setText(s);
    }


    @OnClick({R.id.base_img_left, R.id.base_toolbar_title, R.id.base_tool_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.base_img_left:
                break;
            case R.id.base_toolbar_title:
                break;
            case R.id.base_tool_right:
                break;
        }
    }
}

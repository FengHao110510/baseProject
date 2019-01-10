package com.base.baseproject.activity;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.base.baseproject.R;
import com.base.baseproject.base.BaseActivity;
import com.base.baseproject.base.BaseFragment;
import com.base.baseproject.fragment.FirstFragment;
import com.base.baseproject.fragment.MineFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.tv_main_first)
    TextView tvMainFirst;
    @BindView(R.id.ll_main_first)
    LinearLayout llMainFirst;
    @BindView(R.id.tv_main_mine)
    TextView tvMainMine;
    @BindView(R.id.ll_main_mine)
    LinearLayout llMainMine;
    @BindView(R.id.ll_main_bottom_bar)
    LinearLayout llMainBottomBar;
    @BindView(R.id.cl_main)
    ConstraintLayout clMain;


    //fragment列表
    private ArrayList<BaseFragment> fragmentList;
    //点击位置
    private int position;
    //当前fragment
    private BaseFragment tempFragment;


    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initData();
        initView();
    }

    /**
     * @date 2019/1/10 14:26
     * @desc： 初始化页面
     */
    private void initView() {
        initFragment();
    }

    @Override
    public void initData() {

    }

    /**
     * @date 2018/10/9 0009 下午 17:03
     * @desc 初始化fragment
     */
    private void initFragment() {
        fragmentList = new ArrayList<>();
        //首页
        fragmentList.add(new FirstFragment());
        //我的页面
        fragmentList.add(new MineFragment());
        //默认点击第一个
        llMainFirst.performClick();
    }


    @OnClick({R.id.ll_main_first, R.id.ll_main_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_main_first:
                position = 0;
                setColor(tvMainFirst, tvMainMine);
                break;
            case R.id.ll_main_mine:
                position = 1;
                setColor(tvMainMine, tvMainFirst);
                break;
            default:
        }
        BaseFragment nextFragment = getFragment(position);
        switchFragment(tempFragment, nextFragment);
    }

    //获取fragment
    private BaseFragment getFragment(int position) {
        if (fragmentList != null && fragmentList.size() > 0) {
            return fragmentList.get(position);
        }
        return null;
    }

    /**
     * @date 2018/10/9 0009 下午 18:10
     * @desc 设置底部颜色
     */
    private void setColor(TextView t1, TextView t2) {
        t1.setTextColor(ContextCompat.getColor(this, R.color.main_color));
        t2.setTextColor(ContextCompat.getColor(this, R.color.gray));
    }


    /**
     * @param fromFragment 上一个显示的fragment
     * @param nextFragment 当前要显示的fragment
     * @author fenghao
     * @date 2018/8/28 0028 上午 11:10
     * @desc 选择fragment
     */
    private void switchFragment(BaseFragment fromFragment, BaseFragment nextFragment) {
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;

            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.fl_main, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

    //==============================================================================================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

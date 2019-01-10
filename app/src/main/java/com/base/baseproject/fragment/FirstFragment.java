package com.base.baseproject.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.base.baseproject.R;
import com.base.baseproject.base.BaseFragment;
import com.base.baseproject.util.FontHelper;
import com.base.baseproject.util.Global;
import com.base.baseproject.util.ToastUtil;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 版权：鸿搜网络公司 版权所有
 * 作者：冯大鱼
 * 版本：1.0
 * 创建日期：2018/10/9 0009
 * 描述：首页fragment
 */


public class FirstFragment extends BaseFragment {


    @Override
    public int initLayout() {
        return R.layout.module_fragment_first;
    }

    @Override
    public void init() {
        initView();
        initData();
    }

    private void initView() {
    }


    private void initData() {

    }



}

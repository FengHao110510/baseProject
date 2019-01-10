package com.base.baseproject.base;


import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.base.baseproject.util.ToastUtil;
import com.base.baseproject.views.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 文件描述：new！！com.example.administrator.myapplication.app.base
 * 作者：fh
 * 创建时间：2018/6/13
 * 更改时间：2018/6/13
 * 版本号：1
 * 作用：fragment基类
 */


public abstract class BaseFragment extends Fragment implements BaseIView {
    public Typeface typeface;
    private Dialog mLoadingDialog;
    private static LoadingDialog loadingDialog;
    public final String TAG = this.getClass().getSimpleName();
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layoutView = inflater.inflate(initLayout(), container, false);
        unbinder = ButterKnife.bind(this, layoutView);
        init();
        return layoutView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    /**
     * 添加布局
     *
     * @return
     */
    public abstract int initLayout();

    public abstract void init();

    /**
     * 解除绑定、以免发生内存泄漏
     */
    public void onMyDestroy() {
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        onMyDestroy();
    }

    /**
     * 进度条
     */
    public void showLoadingDialog(String msg) {
        dismissLoadingDialog();
        loadingDialog = new LoadingDialog(getActivity());
        loadingDialog.setMessage(msg);
        loadingDialog.show();
    }

    /**
     *  @date    2018/12/22 14:32
     *  @desc   请求网络的加载框
     */
    @Override
    public void showLoadingDialog() {
        dismissLoadingDialog();
        loadingDialog = new LoadingDialog(getActivity());
        loadingDialog.setMessage("加载中");
        loadingDialog.show();
    }

    @Override
    public void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showError(String err) {
        ToastUtil.showToast(err);
    }

}
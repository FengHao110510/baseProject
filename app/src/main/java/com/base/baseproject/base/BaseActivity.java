package com.base.baseproject.base;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.base.baseproject.util.ToastUtil;
import com.base.baseproject.views.LoadingDialog;

import butterknife.ButterKnife;

/**
 * 文件描述：new！！com.example.administrator.myapplication.app.base  Activity基类
 * 作者：fh
 * 创建时间：2018/6/12
 * 更改时间：2018/6/12
 * 版本号：1
 */


public abstract class BaseActivity extends AppCompatActivity implements BaseIView {

    public Typeface typeface;
    private TextView finishBack;
    private static LoadingDialog loadingDialog;
    private TextView title;
    /***获取TAG的activity名称**/
    public final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 在调用Activity的setContentView()方法之前，如果是继承AppCompatActivity，
         * 则调用supportRequestWindowFeature(Window.FEATURE_NO_TITLE)，
         * 如果是继承Activity，则调用requestWindowFeature(Window.FEATURE_NO_TITLE))来隐藏导航栏。

         为Activity设置一个NoActionBar的Theme,如Theme.AppCompat.Light.NoActionBar
         */
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置布局
        setContentView(initLayout());
        BaseApplication.getInstance().pushTask(this);
        ButterKnife.bind(this);
        init();


    }

    /**
     * 设置布局
     */
    public abstract int initLayout();

    //初始化
    public abstract void init();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 关闭页面
     */
    public void finishActivity() {
        finish();
    }

    @Override
    public void finish() {
        BaseApplication.getInstance().removeTask(this);
        super.finish();
    }

    /**
     * 进度条
     */
    public void showLoadingDialog(String msg) {
        dismissLoadingDialog();
        loadingDialog = new LoadingDialog(this);
        loadingDialog.setMessage(msg);
        loadingDialog.show();
    }

    @Override
    public void showLoadingDialog() {
        dismissLoadingDialog();
        loadingDialog = new LoadingDialog(this);
        loadingDialog.setMessage("加载中...");
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
    }

}

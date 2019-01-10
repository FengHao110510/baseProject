package com.base.baseproject.presenter;


import com.base.baseproject.base.BaseIView;

/**
 * 版权：鸿搜网络公司 版权所有
 * 作者：冯大鱼
 * 版本：1.0
 * 创建日期：2018/8/16 0016
 * 描述：基础presenter
 */


public class BasePresenter<V extends BaseIView> {
    //与本presenter绑定的view
    private V mvpView;

    //与view绑定
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    //解绑
    public void detachView() {
        mvpView = null;
    }

    /**
     * @return 绑定true 未绑定false
     * @author fenghao
     * @date 2018/8/16 0016 下午 14:47
     * @desc 判断persenter 是否绑定
     * 一版在presenter的每个方法中都调用
     */
    public boolean isAttachView() {
        return mvpView != null;
    }

    //获取与之绑定的view 可执行view定义的方法
    public V getMvpView() {
        return mvpView;
    }

    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttach() {
        if (!isAttachView()) {
            throw new MvpViewNotAttachedException();
        }
    }

    /**
     * 自定义异常
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("请求数据前请先调用 attachView(MvpView) 方法与View建立连接");
        }
    }

}

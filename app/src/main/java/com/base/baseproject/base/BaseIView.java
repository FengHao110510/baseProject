package com.base.baseproject.base;

/**
 * 作者：冯大鱼
 * 版本：1.0
 * 创建日期：2018/8/16 0016
 * 描述：iview接口基类
 */


public interface BaseIView {
    /**
     * @author fenghao
     * @date 2018/8/16 0016 下午 14:27
     * @desc 弹出正在加载的框
     */
    void showLoadingDialog();

    /**
     * @author fenghao
     * @date 2018/8/16 0016 下午 14:28
     * @desc 取消加载框
     */
    void dismissLoadingDialog();


    /**
     * @param err 错误内容
     * @author fenghao
     * @date 2018/8/16 0016 下午 14:29
     * @desc 显示加载的错误内容
     */
    void showError(String err);


}

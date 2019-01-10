package com.base.baseproject.util;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 版权：鸿搜网络公司 版权所有
 * 作者：冯大鱼
 * 版本：1.0
 * 创建日期：2018/8/25 0025
 * 描述：typeface帮助类 以及设置字体颜色
 */


public class FontHelper {
    public static final String DEF_FONT = "iconfont.ttf";

    public static final void injectFont(View rootView) {
        injectFont(rootView, Typeface.createFromAsset(rootView.getContext().getAssets(), DEF_FONT));
    }

    /**
     * @date 2018/12/22 12:27
     * @desc 设置字体
     */
    public static final void injectFont(View rootView, Typeface tf) {
        if (rootView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) rootView;
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                injectFont(viewGroup.getChildAt(i), tf);
            }
        } else if (rootView instanceof TextView) {
            ((TextView) rootView).setTypeface(tf);
        }
    }

    /**
     * @date 2018/12/22 12:27
     * @desc 循环设置颜色
     */
    public static final void setColor(View rootView, int color, Context context) {
        if (rootView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) rootView;
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                setColor(viewGroup.getChildAt(i), color, context);
            }
        } else if (rootView instanceof TextView) {
            ((TextView) rootView).setTextColor(ContextCompat.getColor(context, color));
        }
    }


}

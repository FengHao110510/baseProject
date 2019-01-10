package com.base.baseproject.http;


import android.util.Log;

import com.base.baseproject.base.BaseApplication;
import com.base.baseproject.util.LoggingInterceptor;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 版权：鸿搜网络公司 版权所有
 * 作者：冯大鱼
 * 版本：1.0
 * 创建日期：2018/8/23 0023
 * 描述：retrofit简单封装
 */


public class fenghaoClient {
    private static final String HOST = "http://apk.51fenghao.com/";
    //        public static final String HOST = "http://apm.hongxiaosou.com/";
//    public static final String HOST = "http://192.168.1.120:801/";
    private static ApiService fenghaoRetrofit;
    private static final Object MONITOR = new Object();
    private static Retrofit retrofit;

    private fenghaoClient() {
    }

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .client(settingOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static ApiService getfenghaoRetrofitInstance() {
        synchronized (MONITOR) {
            if (fenghaoRetrofit == null) {
                fenghaoRetrofit = retrofit.create(ApiService.class);
            }
            return fenghaoRetrofit;
        }
    }

    private static OkHttpClient settingOkHttp() {
        //添加cookie
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(BaseApplication.getAppContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .writeTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                .build();
        OkHttpUtils.initClient(okHttpClient);
        Log.e("", "settingOkHttp: sadasdasd");
        return okHttpClient;
    }

}

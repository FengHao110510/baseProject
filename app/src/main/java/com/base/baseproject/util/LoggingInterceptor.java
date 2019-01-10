package com.base.baseproject.util;


import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 作者：冯大鱼
 * 版本：1.0
 * 创建日期：2018/10/9 0009
 * 描述：
 * 修订历史：
 * ┌─┐       ┌─┐
 * ┌──┘ ┴───────┘ ┴──┐
 * │                 │
 * │       ───       │
 * │  ─┬┘       └┬─  │
 * │                 │
 * │       ─┴─       │
 * │                 │
 * └───┐         ┌───┘
 * │         │
 * │         │
 * │         │
 * │         └──────────────┐
 * │                        │
 * │                        ├─┐
 * │                        ┌─┘
 * │                        │
 * └─┐  ┐  ┌───────┬──┐  ┌──┘
 * │ ─┤ ─┤       │ ─┤ ─┤
 * └──┴──┘       └──┴──┘
 * 神兽保佑
 * 代码无BUG!
 */


public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();//请求发起的时间

        String method = request.method();
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i))
                            .append("=")
                            .append(body.encodedValue(i))
                            .append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                Log.e("---POST---",
                        String.format("发送请求 %s on %s %n%s %nRequestParams:{%s}",
                                request.url(),
                                chain.connection(),
                                request.headers(),
                                sb.toString()));
            }
        } else {
            Log.e("---GET---", String.format("发送请求 %s on %s%n%s",
                    request.url(),
                    chain.connection(),
                    request.headers()));
        }

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();//收到响应事件

        ResponseBody responseBody = response.peekBody(1024 * 1024);
        Log.e("---response---",
                String.format("接收响应: [%s] %n返回json:【%s】 %.1fms %n%s",
                        response.request().url(),
                        responseBody.string(),
                        (t2 - t1) / 1e6d,
                        response.headers()
                ));
        if (!response.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : response.headers("Set-Cookie")) {
                cookies.add(header);
            }

            Global.getSpGlobalUtil().setConfig(cookies);
        }

        return response;
    }
}


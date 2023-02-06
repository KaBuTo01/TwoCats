package com.example.twocats.network;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName OkhttpUit
 * @Author name
 * @Date 2023/1/13
 * @Description
 */
public class OkhttpUit {
    private OkhttpUit(){};
    private static OkhttpUit instance ;
    private OkHttpClient okHttpClient=new OkHttpClient();
    public static OkhttpUit getInstance() {
        if (instance == null){
            synchronized (OkhttpUit.class){
                if (instance == null){
                    instance = new OkhttpUit();
                }
            }
        }
        return instance;
    }
    public void doGet(String url, Ok ok){
        Request request =new Request.Builder().url(url).build();
        Call call=okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ok.no(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.body().string();
                    ok.ok(str);
            }
        });
    }
}

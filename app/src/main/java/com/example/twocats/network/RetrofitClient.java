package com.example.twocats.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName RetrofitClient
 * @Author name
 * @Date 2023/1/10
 * @Description
 */
public class RetrofitClient {

    private static volatile  RetrofitClient mInstance;
    private Retrofit retrofit;
    private static String URL="https://kabuto01.github.io/";
    private RetrofitClient() {
    }
    public static RetrofitClient getInstance() {
        if (mInstance==null){
            synchronized (RetrofitClient.class){
                if (mInstance==null){
                    mInstance=new RetrofitClient();
                }
            }

        }
        return mInstance;
    }
    public <T> T getService(Class<T> cls){
        return getRetrofit().create(cls);
    }

    private synchronized Retrofit getRetrofit() {
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

package com.dotinfiny.tablesampleapp;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Clinet {

//    public static String BASE_URL = "http://128.0.0.19/kt_api/";//
    public static String BASE_URL = "http://www.blackvogue.com/kt_api/";//

    public static Retrofit getClient(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()/*.addInterceptor(interceptor)*/
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
//                .baseUrl(getApiType(context) == 0 ? BASE_LOCAL_URL : BASE_REMOTE_URL)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

}

package com.mrizkyyuhari.tugas12_gits.api;

import com.mrizkyyuhari.tugas12_gits.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {
    private static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }
}

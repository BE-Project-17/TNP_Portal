package com.example.tnpportal.repositories;

import com.example.tnpportal.apis.AuthenticateService;
import com.example.tnpportal.apis.CompanyService;
import com.example.tnpportal.apis.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryHelper {

    private static Retrofit instance;
    private static final String BASE_URL = "http://localhost:8000/";

    private static Retrofit getInstance(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        instance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return instance;
    }

    public static AuthenticateService getAuthenticateService(){
        return getInstance().create(AuthenticateService.class);
    }
    public static CompanyService getCompanyService(){
        return getInstance().create(CompanyService.class);
    }
    public static UserService getUserService(){
        return getInstance().create(UserService.class);
    }
}

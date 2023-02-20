package com.example.tnpportal.apis;

import com.example.tnpportal.models.auth.AuthRequest;
import com.example.tnpportal.models.auth.AuthResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticateService {

    @POST("endpoint")
    Observable<Response<AuthResponse>> login(@Body AuthRequest body);
}

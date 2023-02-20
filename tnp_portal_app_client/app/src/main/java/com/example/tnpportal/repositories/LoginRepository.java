package com.example.tnpportal.repositories;


import com.example.tnpportal.apis.AuthenticateService;
import com.example.tnpportal.models.auth.AuthRequest;
import com.example.tnpportal.models.auth.AuthResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;

public class LoginRepository {

    private AuthenticateService authenticateService;

    public   LoginRepository() {
        this.authenticateService = RepositoryHelper.getAuthenticateService();
    }

    public Observable<Response<AuthResponse>> login(String emailId, String password){
        AuthRequest authRequest = new AuthRequest(emailId,password);
        return authenticateService.login(authRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}

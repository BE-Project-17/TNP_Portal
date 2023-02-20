package com.example.tnpportal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tnpportal.models.auth.AuthResponse;
import com.example.tnpportal.repositories.LoginRepository;
import com.example.tnpportal.utils.Messages;
import com.example.tnpportal.utils.Resource;

public class LoginViewModel extends AndroidViewModel {
    private final LoginRepository loginRepository;
    private final MutableLiveData<Boolean> isLoadingLiveData;

    private final MutableLiveData<Resource<AuthResponse>> authResponseLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.loginRepository = new LoginRepository();
        this.authResponseLiveData = new MutableLiveData<>();
        isLoadingLiveData = new MutableLiveData<>(false);
    }

    public void login(String emailId, String password){
        loginRepository.login(emailId,password).subscribe(authResponseResponse -> {
            if(authResponseResponse.body()!=null && authResponseResponse.isSuccessful()){
                AuthResponse authResponse = authResponseResponse.body();
                authResponseLiveData.postValue(Resource.success(authResponse, Messages.USER_AUTHENTICATION_SUCCESS));
            }else{
                authResponseLiveData.postValue(Resource.success(null, Messages.USER_AUTHENTICATION_FAILURE));
            }
        });
    }

    public void setLoading(boolean isLoading){
        isLoadingLiveData.postValue(isLoading);
    }

    public LiveData<Boolean> getIsLoadingLiveData() {
        return isLoadingLiveData;
    }

    public LiveData<Resource<AuthResponse>> getAuthResponseLiveData() {
        return authResponseLiveData;
    }
}

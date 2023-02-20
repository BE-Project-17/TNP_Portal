package com.example.tnpportal.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.tnpportal.databinding.ActivityLoginBinding;
import com.example.tnpportal.viewmodels.LoginViewModel;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init(){

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(intent);
//            finish();

//            if(validate()){
//                viewModel.setLoading(true);
//                viewModel.login(binding.loginEmail.getText().toString(),binding.loginPassword.getText().toString());
//                viewModel.setLoading(false);
//            }else{
//                Toast.makeText(this, "Enter valid credentials", Toast.LENGTH_SHORT).show();
//            }
        });

        viewModel.getAuthResponseLiveData().observe(this,authResponseResource -> {
            if(authResponseResource.data != null){
                Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                startActivity(intent);
                finish();
            }else if(authResponseResource.message != null){
                Snackbar.make(binding.getRoot(),authResponseResource.message,Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validate(){
        return !(binding.loginEmail.getText().toString().equals("") || binding.loginPassword.getText().toString().equals(""));
    }
}
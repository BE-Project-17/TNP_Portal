package com.example.tnpportal.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.tnpportal.R;

import com.example.tnpportal.databinding.ActivitySplashScreenBinding;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        handle();
    }

    private void init(){
        Animation slideFromUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top);
        Animation slideFromBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_bottom);
        binding.logo.startAnimation(slideFromUp);
        binding.systemName.startAnimation(slideFromBottom);
    }

    private void handle(){
        new Handler().postDelayed(()->{
            Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        },3000);
    }
}
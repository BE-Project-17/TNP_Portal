package com.example.tnpportal.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tnpportal.R;
import com.example.tnpportal.adapters.DashboardFragmentAdapter;
import com.example.tnpportal.databinding.ActivityDashboardBinding;
import com.google.android.material.navigation.NavigationBarView;


public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    @SuppressLint("NonConstantResourceId")
    private void init(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DashboardFragmentAdapter adapter = new DashboardFragmentAdapter(fragmentManager,getLifecycle());

        binding.dashboardViewpager.setAdapter(adapter);

        binding.bottomNavigationMenu.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.home:
                    binding.dashboardViewpager.setCurrentItem(0);
                    break;
                case R.id.applied_companies:
                    binding.dashboardViewpager.setCurrentItem(1);
                    break;
                case R.id.analysis:
                    binding.dashboardViewpager.setCurrentItem(2);
                    break;
                case R.id.profile:
                    binding.dashboardViewpager.setCurrentItem(3);
                    break;
            }
            return true;
        });
    }
}
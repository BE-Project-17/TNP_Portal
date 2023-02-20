package com.example.tnpportal.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tnpportal.views.AnalysisFragment;
import com.example.tnpportal.views.HomeFragment;
import com.example.tnpportal.views.MyAppliedCompaniesFragment;
import com.example.tnpportal.views.ProfileFragment;

public class DashboardFragmentAdapter extends FragmentStateAdapter {

    public DashboardFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new HomeFragment();
        }else if(position == 1){
            return new MyAppliedCompaniesFragment();
        }else if(position == 2){
            return new AnalysisFragment();
        }
        return new ProfileFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

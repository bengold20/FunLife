package com.make.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.make.login.LoginTabFragment;
import com.make.login.SigupTabFragment;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public LoginAdapter(@NonNull FragmentManager fm,Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return loginTabFragment;
            case 1:
                SigupTabFragment sigupTabFragment = new SigupTabFragment();
                return sigupTabFragment;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

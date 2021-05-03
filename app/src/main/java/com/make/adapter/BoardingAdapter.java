package com.make.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.make.onBoardingScreen.OnBoardingFragment1;
import com.make.onBoardingScreen.OnBoardingFragment2;
import com.make.onBoardingScreen.OnBoardingFragment3;

public class BoardingAdapter extends FragmentStatePagerAdapter {
    public BoardingAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OnBoardingFragment1();

            case 1:
                return new OnBoardingFragment2();

            case 2:
                return new OnBoardingFragment3();

            default:
                return new OnBoardingFragment1();
        }
    }

    //so luong cua trang gioi thieu
    @Override
    public int getCount() {
        return 3;
    }
}

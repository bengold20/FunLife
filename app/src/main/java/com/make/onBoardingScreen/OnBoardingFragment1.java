package com.make.onBoardingScreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.make.main.R;

public class OnBoardingFragment1 extends Fragment {
    private ImageView imgBoarding1;
    private TextView titleBoarding1,contentBoarding1;

    public OnBoardingFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_boarding1, container, false);

        imgBoarding1 = view.findViewById(R.id.img_boarding1);
        titleBoarding1 = view.findViewById(R.id.txt_title_bd1);
        contentBoarding1 = view.findViewById(R.id.txt_content_bd1);

        imgBoarding1.setImageResource(R.drawable.img_welcome2);
        titleBoarding1.setText("FunLife");
        contentBoarding1.setText("Chào mừng bạn đến với ứng học học tiếng anh FunLife <3");

        return view;
    }
}
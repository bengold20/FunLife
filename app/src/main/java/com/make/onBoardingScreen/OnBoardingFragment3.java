package com.make.onBoardingScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.make.login.LoginActivity;
import com.make.main.R;

public class OnBoardingFragment3 extends Fragment {

    private ImageView imgBoarding3;
    private TextView titleBoarding3;

    private Button btn_start;
    private View mView;

    public OnBoardingFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_on_boarding3, container, false);

        imgBoarding3 = mView.findViewById(R.id.img_boarding3);
        titleBoarding3 = mView.findViewById(R.id.txt_title_bd3);

        imgBoarding3.setImageResource(R.drawable.img_letgo2);
        titleBoarding3.setText("FunLife");

        btn_start = mView.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return mView;
    }
}
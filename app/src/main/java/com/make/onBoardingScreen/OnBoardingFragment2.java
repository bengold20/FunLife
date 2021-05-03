package com.make.onBoardingScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.make.main.R;

public class OnBoardingFragment2 extends Fragment {

    private ImageView imgBoarding2;
    private TextView titleBoarding2,contentBoarding2;

    public OnBoardingFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_boarding2, container, false);

        imgBoarding2 = view.findViewById(R.id.img_boarding2);
        titleBoarding2 = view.findViewById(R.id.txt_title_bd2);
        contentBoarding2 = view.findViewById(R.id.txt_content_bd2);

        imgBoarding2.setImageResource(R.drawable.gif_coo);
        titleBoarding2.setText("FunLife");
        contentBoarding2.setText("Nội dung gần gũi, dễ dàng tiếp thu kiến thức...");

        return view;
    }
}
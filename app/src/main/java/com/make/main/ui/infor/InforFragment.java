package com.make.main.ui.infor;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.make.main.R;

public class InforFragment extends Fragment {

    private InforViewModel mViewModel;
    private TextView txt_inforAppEnglish;

    public static InforFragment newInstance() {
        return new InforFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.infor_fragment, container, false);

        txt_inforAppEnglish = view.findViewById(R.id.txt_inforAppEnglish);
        txt_inforAppEnglish.setText("Developer: DAM VAN BEN\n" +
                "Produce in: 2021\n" +
                "Function: Help people study english. When study can feel most comfortable <3\n");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InforViewModel.class);
        // TODO: Use the ViewModel
    }

}
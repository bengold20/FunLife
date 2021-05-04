package com.make.main.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.make.adapter.FunctionInHomeAdapter;
import com.make.main.R;
import com.make.model.FunctionInHomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rcv_functionInHome;
    private FunctionInHomeAdapter mfunctionInHomeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        rcv_functionInHome = root.findViewById(R.id.rcv_functionInHome);
        mfunctionInHomeAdapter = new FunctionInHomeAdapter(getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rcv_functionInHome.setLayoutManager(gridLayoutManager);

        mfunctionInHomeAdapter.setData(getListFunction());
        rcv_functionInHome.setAdapter(mfunctionInHomeAdapter);

        return root;
    }

    private List<FunctionInHomeModel> getListFunction() {
        List<FunctionInHomeModel> listFunction = new ArrayList<>();
        listFunction.add(new FunctionInHomeModel(R.drawable.img_vocaburary, "Từ vựng \n thông dụng"));
        listFunction.add(new FunctionInHomeModel(R.drawable.img_grammar, "Ngữ pháp \n tiếng Anh"));
        listFunction.add(new FunctionInHomeModel(R.drawable.img_table_dtbqt, "Bảng động từ bất quy tắc"));
        listFunction.add(new FunctionInHomeModel(R.drawable.img_exam2, "Ôn tập \n tiếng Anh"));
        listFunction.add(new FunctionInHomeModel(R.drawable.img_newword, "Tạo danh sách từ vựng"));

        return listFunction;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        super.onActivityCreated(savedInstanceState);
    }
}
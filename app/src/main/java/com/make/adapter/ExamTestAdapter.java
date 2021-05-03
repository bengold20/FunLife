package com.make.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.make.main.R;
import com.make.model.ExamTestModel;

import java.util.List;

public class ExamTestAdapter extends RecyclerView.Adapter<ExamTestAdapter.ExamTestViewHolder> {

    private List<ExamTestModel> listExamTest;
    private ExamTestAdapter.IfClickItemExamTest ifClickItemExamTest;

    public interface IfClickItemExamTest{
        void goToItent0();
        void goToItent1();
        void goToItent2();
        void goToItent3();
    }

    public ExamTestAdapter() {
    }

    public ExamTestAdapter(ExamTestAdapter.IfClickItemExamTest click){
        this.ifClickItemExamTest = click;
    }

    public void setData(List<ExamTestModel> list){
        this.listExamTest = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExamTestAdapter.ExamTestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_examtest,parent,false);
        return new ExamTestAdapter.ExamTestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamTestViewHolder holder, int position) {
        ExamTestModel examTestModel = listExamTest.get(position);
        if(examTestModel == null) {
            return;
        }

        holder.txtTitleExamTest.setText(examTestModel.getTitle());
        holder.txtNameFileEX.setText(examTestModel.getNameFileEX());
        holder.txtTimeFileEX.setText(examTestModel.getTimeFileEX());

        if(position == 0){
            holder.ll_ExamTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemExamTest.goToItent0();
                }
            });
        }else if(position == 1){
            holder.ll_ExamTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemExamTest.goToItent1();
                }
            });
        }else if(position == 2){
            holder.ll_ExamTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemExamTest.goToItent2();
                }
            });
        }else if(position == 3){
            holder.ll_ExamTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemExamTest.goToItent3();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listExamTest.size();
    }

    public class ExamTestViewHolder extends RecyclerView.ViewHolder{


        private TextView txtTitleExamTest;
        private TextView txtNameFileEX;
        private TextView txtTimeFileEX;
        private LinearLayout ll_ExamTest;

        public ExamTestViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitleExamTest = itemView.findViewById(R.id.txt_titleExamTest);
            txtNameFileEX = itemView.findViewById(R.id.txt_nameFileEX);
            txtTimeFileEX = itemView.findViewById(R.id.txt_timeFileEX);
            ll_ExamTest = itemView.findViewById(R.id.ll_ExamTest);

        }
    }
}

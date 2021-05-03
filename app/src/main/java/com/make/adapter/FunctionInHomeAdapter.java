package com.make.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.make.main.R;
import com.make.model.FunctionInHomeModel;
import com.make.sixFunction.examTest.ExamTest;
import com.make.sixFunction.listYourWord.AddNewYourWord;
import com.make.sixFunction.grammar.GrammarActivity;
import com.make.sixFunction.tableDTBQT.TableDTBQTActivity;
import com.make.sixFunction.wordPopular.WordActivity;

import java.util.List;

public class FunctionInHomeAdapter extends RecyclerView.Adapter<FunctionInHomeAdapter.FunctionInHomeViewHolder> {

    public Context mcontext;
    private List<FunctionInHomeModel> functionInHomeModelList;

    public FunctionInHomeAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setData(List<FunctionInHomeModel> list) {
        this.functionInHomeModelList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FunctionInHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_function_in_home, parent, false);

        return new FunctionInHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FunctionInHomeViewHolder holder, int position) {
        FunctionInHomeModel functionInHomeModel = functionInHomeModelList.get(position);
        if (functionInHomeModel == null) {
            return;
        }

        holder.imgFunctionInHome.setImageResource(functionInHomeModel.getResouceImage());
        holder.txtFunctionInHome.setText(functionInHomeModel.getNameFunction());

        if (position == 0) {
            holder.imgFunctionInHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext, WordActivity.class);
                    mcontext.startActivity(intent);
                }
            });
        } else if (position == 1) {
            holder.imgFunctionInHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext, GrammarActivity.class);
                    mcontext.startActivity(intent);
                }
            });
        } else if (position == 2) {
            holder.imgFunctionInHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext, TableDTBQTActivity.class);
                    mcontext.startActivity(intent);
                }
            });
        } else if (position == 3) {
            holder.imgFunctionInHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext, ExamTest.class);
                    mcontext.startActivity(intent);
                }
            });
        } else if (position == 4) {
            holder.imgFunctionInHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext, AddNewYourWord.class);
                    mcontext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (functionInHomeModelList != null) {
            return functionInHomeModelList.size();
        }
        return 0;
    }

    public class FunctionInHomeViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFunctionInHome;
        private TextView txtFunctionInHome;

        public FunctionInHomeViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFunctionInHome = itemView.findViewById(R.id.img_function_in_home);
            txtFunctionInHome = itemView.findViewById(R.id.txt_function_in_home);
        }
    }
}

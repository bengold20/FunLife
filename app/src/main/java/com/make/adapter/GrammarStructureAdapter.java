package com.make.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.make.main.R;
import com.make.model.GrammarStructureModel;

import java.util.List;

public class GrammarStructureAdapter extends RecyclerView.Adapter<GrammarStructureAdapter.GrammarStructureViewHolder>{


    private List<GrammarStructureModel> listGrammarStructure;
    private IfClickItemGrammarStructure ifClickItemGrammarStructure;

    public interface IfClickItemGrammarStructure{
        void goToItent0();
        void goToItent1();
        void goToItent2();
        void goToItent3();
        void goToItent4();
        void goToItent5();
        void goToItent6();
        void goToItent7();
        void goToItent8();
        void goToItent9();
        void goToItent10();
        void goToItent11();
    }

    public GrammarStructureAdapter() {
    }

    public GrammarStructureAdapter(IfClickItemGrammarStructure click){
        this.ifClickItemGrammarStructure = click;
    }

    public void setData(List<GrammarStructureModel> list){
        this.listGrammarStructure = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GrammarStructureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grammar_structure,parent,false);

        return new GrammarStructureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarStructureViewHolder holder, int position) {
        GrammarStructureModel grammarStructureModel = listGrammarStructure.get(position);
        if(grammarStructureModel == null) {
            return;
        }

        holder.txtTitleGrammarStructure.setText(grammarStructureModel.getTitleStructure());
        holder.txtDescriptionGrammarStructure.setText(grammarStructureModel.getDescriptionStructure());

        if(position == 0){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent0();
                }
            });
        }else if(position == 1){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent1();
                }
            });
        }else if(position == 2){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent2();
                }
            });
        }else if(position == 3){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent3();
                }
            });
        }else if(position == 4){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent4();
                }
            });
        }else if(position == 5){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent5();
                }
            });
        }else if(position == 6){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent6();
                }
            });
        }else if(position == 7){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent7();
                }
            });
        }else if(position == 8){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent8();
                }
            });
        }else if(position == 9){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent9();
                }
            });
        }else if(position == 10){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent10();
                }
            });
        }else if(position == 11){
            holder.ll_GrammarStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammarStructure.goToItent11();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listGrammarStructure.size();
    }

    public class GrammarStructureViewHolder extends RecyclerView.ViewHolder{


        private TextView txtTitleGrammarStructure;
        private TextView txtDescriptionGrammarStructure;
        private LinearLayout ll_GrammarStructure;

        public GrammarStructureViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitleGrammarStructure = itemView.findViewById(R.id.txt_titleGrammarStructure);
            txtDescriptionGrammarStructure = itemView.findViewById(R.id.txt_descriptionGrammarStructure);
            ll_GrammarStructure = itemView.findViewById(R.id.ll_GrammarStructure);

        }
    }
}

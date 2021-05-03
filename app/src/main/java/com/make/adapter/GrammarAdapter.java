package com.make.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.make.main.R;
import com.make.model.GrammarModel;

import java.util.List;

public class GrammarAdapter extends RecyclerView.Adapter<GrammarAdapter.GrammarViewHolder>{

    private List<GrammarModel> listGrammar;
    private IfClickItemGrammar ifClickItemGrammar;

    public interface IfClickItemGrammar{
        void goToItent0();
        void goToItent1();
    }

    public GrammarAdapter() {
    }

    public GrammarAdapter(IfClickItemGrammar click){
        this.ifClickItemGrammar = click;
    }

    public void setData(List<GrammarModel> list){
        this.listGrammar = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GrammarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grammar,parent,false);
        return new GrammarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarViewHolder holder, int position) {
        GrammarModel grammarModel = listGrammar.get(position);
        if(grammarModel == null) {
            return;
        }

        holder.txtTitleGrammar.setText(grammarModel.getTitle());
        holder.txtDescriptionGrammar.setText(grammarModel.getDescription());

        if(position == 0){
            holder.ll_Grammar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammar.goToItent0();
                }
            });
    }else if(position == 1){
            holder.ll_Grammar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemGrammar.goToItent1();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listGrammar.size();
    }

    public class GrammarViewHolder extends RecyclerView.ViewHolder{


        private TextView txtTitleGrammar;
        private TextView txtDescriptionGrammar;
        private LinearLayout ll_Grammar;

        public GrammarViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitleGrammar = itemView.findViewById(R.id.txt_titleGrammar);
            txtDescriptionGrammar = itemView.findViewById(R.id.txt_descriptionGrammar);
            ll_Grammar = itemView.findViewById(R.id.ll_Grammar);

        }
    }
}

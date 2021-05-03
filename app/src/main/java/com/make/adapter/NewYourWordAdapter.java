package com.make.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.make.main.R;
import com.make.model.NewYourWordModel;

import java.util.List;

public class NewYourWordAdapter extends RecyclerView.Adapter<NewYourWordAdapter.newWordViewHolder>{

    private List<NewYourWordModel> listNewWord;
    private IfClickItemNewWord ifClickItemNewWord;

    public interface IfClickItemNewWord{

        void updateNewYourWord(NewYourWordModel newYourWordModel);

        void deleteNewYourWord(NewYourWordModel newYourWordModel);
    }

    public NewYourWordAdapter() {
    }

    public NewYourWordAdapter(IfClickItemNewWord ifClick) {
        this.ifClickItemNewWord = ifClick;
    }

    public void setDaTa(List<NewYourWordModel> list){
        this.listNewWord = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public newWordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_your_word,parent,false);

        return new newWordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newWordViewHolder holder, int position) {
            NewYourWordModel newYourWordModel = listNewWord.get(position);
            if(newYourWordModel == null){
                return;
            }

            holder.txt_newYourWord.setText(newYourWordModel.getNewWord());
            holder.txt_translater.setText(newYourWordModel.getTranslater());
            holder.txt_meanning.setText(newYourWordModel.getMeanning());

            holder.imgbtn_UpdateNewYourWord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemNewWord.updateNewYourWord(newYourWordModel);
                }
            });

            holder.imgbtn_deleteNewYourWord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ifClickItemNewWord.deleteNewYourWord(newYourWordModel);
                }
            });
    }

    @Override
    public int getItemCount() {
        if(listNewWord != null) {
            return listNewWord.size();
        }
        return listNewWord.size();
    }

    public class newWordViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_newYourWord,txt_translater,txt_meanning;
        private ImageButton imgbtn_UpdateNewYourWord,imgbtn_deleteNewYourWord;

        public newWordViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_newYourWord = itemView.findViewById(R.id.txt_newYourWord);
            txt_translater = itemView.findViewById(R.id.txt_translater);
            txt_meanning = itemView.findViewById(R.id.txt_meanning);
            imgbtn_deleteNewYourWord = itemView.findViewById(R.id.imgbtn_deleteNewYourWord);
            imgbtn_UpdateNewYourWord = itemView.findViewById(R.id.imgbtn_UpdateNewYourWord);
        }
    }

}

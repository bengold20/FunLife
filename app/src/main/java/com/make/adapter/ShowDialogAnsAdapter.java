package com.make.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.make.main.R;
import com.make.model.QuestionModel;

import java.util.ArrayList;

public class ShowDialogAnsAdapter extends BaseAdapter {

    ArrayList listAns;
    LayoutInflater inflater;

    public ShowDialogAnsAdapter(ArrayList listAns, Context context) {
        this.listAns = listAns;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listAns.size();
    }

    @Override
    public Object getItem(int position) {
        return listAns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuestionModel data = (QuestionModel) getItem(position);
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_gridview_list_answer,null);
            holder.txtNumberAnswer = convertView.findViewById(R.id.txt_number_answer);
            holder.txtShowAnswer = convertView.findViewById(R.id.txt_show_answer);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        int i = position + 1;
        holder.txtNumberAnswer.setText("Câu " + i + ":");
        holder.txtShowAnswer.setText(data.getMy_ans());

        return convertView;
    }

    private static class ViewHolder {
        TextView txtNumberAnswer;
        TextView txtShowAnswer;
    }
}

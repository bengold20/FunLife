package com.make.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.make.main.R;
import com.make.model.TableDTBQTModel;

import java.util.List;

public class TableDTBQTAdapter extends RecyclerView.Adapter<TableDTBQTAdapter.tableDTBQTViewHolder> {

    Context context;
    private List<TableDTBQTModel> tableDTBQTModelList;


    public void setData(List<TableDTBQTModel> list) {

        this.tableDTBQTModelList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public tableDTBQTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_dtbqt, parent, false);
        return new tableDTBQTViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tableDTBQTViewHolder holder, int position) {
        TableDTBQTModel tableDTBQTModel = tableDTBQTModelList.get(position);
        if (tableDTBQTModel == null) {
            return;
        }
        holder.txtDongTuNguyenMau.setText(tableDTBQTModel.getDongTuNguyenMau());
        holder.txtTheQuaKhu.setText(tableDTBQTModel.getTheQuaKhu());
        holder.txtQuaKhuPhanTu.setText(tableDTBQTModel.getQuaKhuPhanTu());
        holder.txtNghiaDongTu.setText(tableDTBQTModel.getNghiaDongTu());
    }

    @Override
    public int getItemCount() {
        if (tableDTBQTModelList != null) {
            return tableDTBQTModelList.size();
        }
        return 0;
    }

    public class tableDTBQTViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDongTuNguyenMau;
        private TextView txtTheQuaKhu;
        private TextView txtQuaKhuPhanTu;
        private TextView txtNghiaDongTu;

        public tableDTBQTViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDongTuNguyenMau = itemView.findViewById(R.id.txt_dongTuNguyenMau);
            txtTheQuaKhu = itemView.findViewById(R.id.txt_theQuaKhu);
            txtQuaKhuPhanTu = itemView.findViewById(R.id.txt_quaKhuPhanTu);
            txtNghiaDongTu = itemView.findViewById(R.id.txt_nghiaDongTu);

        }
    }
}

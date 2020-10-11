package com.example.concertonline.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.concertonline.R;
import com.example.concertonline.api.BaseApiService;
import com.example.concertonline.model.Popular;
import com.example.concertonline.ui.transaksi.BuyActivity;

import java.util.ArrayList;
import java.util.List;

public class BulanIniAdapter extends RecyclerView.Adapter<BulanIniAdapter.UsersHolder> {

    private Context context;
    private List<Popular> list;

    public BulanIniAdapter(Context context, List<Popular> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.bulan_item_layout, parent, false);
        return new UsersHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final UsersHolder holder, final int position) {
        holder.txtTitle.setText(list.get(position).getJudul());
        holder.txtDate.setText(list.get(position).getTanggal());
        holder.txtPrice.setText("Rp. "+list.get(position).getMulai_harga_tiket());
        holder.txtTime.setText(list.get(position).getWaktu());
        Glide.with(context)
                .load(list.get(position).getFoto())
                .placeholder(R.drawable.noimg)
                .into(holder.imgCover);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BuyActivity.class);
                intent.putExtra("img", list.get(position).getFoto());
                intent.putExtra("title", list.get(position).getJudul());
                intent.putExtra("desc", list.get(position).getDesk());
                intent.putExtra("time", list.get(position).getWaktu());
                intent.putExtra("date", list.get(position).getTanggal());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class UsersHolder extends RecyclerView.ViewHolder {

        ImageView imgCover;
        TextView txtTitle, txtDate, txtTime,txtPrice;
        LinearLayout layout;

        public UsersHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            imgCover = itemView.findViewById(R.id.imgEvent);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}


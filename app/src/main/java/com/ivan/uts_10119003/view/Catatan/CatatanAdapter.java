package com.ivan.uts_10119003.view.Catatan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import com.ivan.uts_10119003.R;
import com.ivan.uts_10119003.model.CatatanModel;

import java.util.ArrayList;
import java.util.List;

//nim : 10119003
//nama : ivan faathirza
//kelas : IF1
public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.MyViewHolder>{
    private Activity activity;
    private List<CatatanModel> catatan_list = new ArrayList<CatatanModel>();

    public CatatanAdapter(Activity activity, List<CatatanModel> catatan_list) {
        this.activity = activity;
        this.catatan_list = catatan_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.catatan_judul_txt.setText(String.valueOf(catatan_list.get(position).getJudul()));
        holder.catatan_kategori_txt.setText(String.valueOf(catatan_list.get(position).getKategori()));
        holder.catatan_create_at_txt.setText(String.valueOf(catatan_list.get(position).getCreated_at()));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, UpdateCatatanActivity.class);
                intent.putExtra("id", String.valueOf(catatan_list.get(position).getId()));
                intent.putExtra("judul", String.valueOf(catatan_list.get(position).getJudul()));
                intent.putExtra("kategori", String.valueOf(catatan_list.get(position).getKategori()));
                intent.putExtra("konten", String.valueOf(catatan_list.get(position).getKonten()));
                intent.putExtra("created_at", String.valueOf(catatan_list.get(position).getCreated_at()));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (catatan_list != null) return catatan_list.size();
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView catatan_judul_txt,catatan_kategori_txt,catatan_create_at_txt;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            catatan_judul_txt = itemView.findViewById(R.id.catatan_judul_txt);
            catatan_kategori_txt = itemView.findViewById(R.id.catatan_kategori_txt);
            catatan_create_at_txt = itemView.findViewById(R.id.catatan_created_at);
            linearLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

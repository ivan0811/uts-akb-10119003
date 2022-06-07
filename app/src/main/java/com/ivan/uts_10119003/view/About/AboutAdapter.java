package com.ivan.uts_10119003.view.About;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivan.uts_10119003.R;
import com.ivan.uts_10119003.model.AboutModel;

import java.util.ArrayList;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder>{
    ArrayList<AboutModel> aboutModelArrayList;

    public AboutAdapter(ArrayList<AboutModel> aboutModelArrayList) {
        this.aboutModelArrayList = aboutModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpager_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AboutModel aboutModel = aboutModelArrayList.get(position);

        holder.imageView.setImageResource(aboutModel.imageID);
        holder.tcHeading.setText(aboutModel.heading);
        holder.tvDesc.setText(aboutModel.description);
    }

    @Override
    public int getItemCount() {
        if(aboutModelArrayList != null) return aboutModelArrayList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tcHeading, tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivimage);
            tcHeading = itemView.findViewById(R.id.tvHeading);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}

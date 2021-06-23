package com.skypan.wbse.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.skypan.wbse.R;

public class commentAdapter extends RecyclerView.Adapter<commentAdapter.viewHolder> {

    private Context mContext;


    public commentAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public commentAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new commentAdapter.viewHolder(LayoutInflater.from(mContext).inflate(R.layout.comment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class viewHolder extends RecyclerView.ViewHolder {


        public viewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}

package com.skypan.wbse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.skypan.wbse.R;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.viewHolder> {
    private Context mContext;


    public cardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public cardAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cardAdapter.viewHolder(LayoutInflater.from(mContext).inflate(R.layout.acticle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull cardAdapter.viewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private TextView tvSightCard, tvSightName, tvSightTel, tvSightAdd, tvSightTicketInfo, tvSightDescribe, tvSightNote, tvSightClass, tvSightLastUpdateTime, btnNavigation;
        private AlertDialog.Builder dialogBuilder;
        private AlertDialog alertDialog;
        private View layoutView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}

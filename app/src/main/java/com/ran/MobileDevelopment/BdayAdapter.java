package com.ran.MobileDevelopment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

class BdayAdapter extends RecyclerView.Adapter<BdayAdapter.ViewHolder> {

    List<BdayEntity> bDay;

    public BdayAdapter(List<BdayEntity> bDay){
        this.bDay = bDay;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.birthdayrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(bDay.get(position).getName());
        holder.date.setText(bDay.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return bDay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView date;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
        }
    }
}

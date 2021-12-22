package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BMIRecordsAdapter extends RecyclerView.Adapter<BMIRecordsAdapter.BMIViewHolder> {
    private
    ArrayList<BMIRecord> records=new ArrayList<BMIRecord>();

    public BMIRecordsAdapter(ArrayList<BMIRecord> records) {
        this.records = records;
    }

    class BMIViewHolder extends RecyclerView.ViewHolder{
        TextView tv_date;
        TextView tv_weight;
        TextView tv_status;
        TextView tv_length;


        public BMIViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_date=itemView.findViewById(R.id.oldstatus_date);
            tv_weight=itemView.findViewById(R.id.oldstatus_weight);
                    tv_status=itemView.findViewById(R.id.oldstatus_status);
            tv_length=itemView.findViewById(R.id.oldstatus_length);
        }
    }

    public BMIRecordsAdapter() {
    }

    @NonNull
    @Override
    public BMIViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.bmi_customitem, null, false);
        BMIViewHolder viewHolder = new BMIViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BMIViewHolder holder, int position) {
      BMIRecord bmi= records.get(position);
        holder.tv_date.setText(bmi.getDate());
        holder.tv_weight.setText(Double.toString(bmi.getWeight()));
        holder.tv_status.setText(bmi.getStatus());
        holder.tv_length.setText(bmi.getLength());

    }

    @Override
    public int getItemCount() {
        return records.size();

    }
}

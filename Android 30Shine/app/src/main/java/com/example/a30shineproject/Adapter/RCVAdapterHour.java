package com.example.a30shineproject.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a30shineproject.Interface.ItemClickAddressListener;
import com.example.a30shineproject.Interface.ItemClickHourListener;
import com.example.a30shineproject.Interface.ItemClickStylistListener;
import com.example.a30shineproject.Model.HourModel;
import com.example.a30shineproject.Model.StylistModel;
import com.example.a30shineproject.R;
import com.example.a30shineproject.SettingAll.SettingAll;

import java.util.List;

public class RCVAdapterHour extends RecyclerView.Adapter<RCVAdapterHour.MyViewHolder> {
    Context mContext;
    public static int id;
    public static int checkSelectedItem = 0;
    List<HourModel> mData;
    RCVAdapterHour.MyViewHolder myViewHolder;
    private ItemClickAddressListener onNotListener;

    public RCVAdapterHour(Context mContext, List<HourModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_time_stylist,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return new MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.txtHour.setText(mData.get(position).getHourStylist());
        if(mData.get(position).getCheckWork() == 1 ){
            holder.txtbackgroundborder.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_grey));
            holder.rlDay.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_greyfill));
            myViewHolder = holder;
        }
        else{
            holder.txtbackgroundborder.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_green));
            holder.rlDay.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_white));
        }
        if(holder == SettingAll.myViewHolderHour && position == id){
            holder.txtbackgroundborder.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_green));
            holder.rlDay.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_yellow));
            id = position;

        }
        holder.setItemClickListener(new ItemClickHourListener() {
            @Override
            public void onClick(View view, int position) {
                if(mData.get(position).getCheckWork() != 1){

                    checkSelectedItem = 1;
                    id = position;
                    holder.rlDay.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_yellow));
//                    holder.txtbackgroundborder.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_green));

                    if(SettingAll.myViewHolderHour == null ){
                        SettingAll.myViewHolderHour = null;
                        SettingAll.myViewHolderHour = holder ;
                    }
                    else{
                        SettingAll.myViewHolderHour.rlDay.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_white));
                        SettingAll.myViewHolderHour = null;
                        SettingAll.myViewHolderHour = holder ;
                    }
                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtHour,txtNoteHour,txtbackgroundborder;
        private RelativeLayout rlDay;
        private ItemClickHourListener itemClickListener;
        public MyViewHolder (View itemView, ItemClickStylistListener onNoteListener){
            super(itemView);
            txtHour = (TextView) itemView.findViewById(R.id.txtHour);
            txtNoteHour =  (TextView) itemView.findViewById(R.id.txtNoteHour);
            txtbackgroundborder = (TextView) itemView.findViewById(R.id.txtbackgroundborder);
            rlDay = (RelativeLayout) itemView.findViewById(R.id.rlDay);

            itemView.setOnClickListener(this);
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHour = (TextView) itemView.findViewById(R.id.txtHour);
            txtNoteHour =  (TextView) itemView.findViewById(R.id.txtNoteHour);
            txtbackgroundborder = (TextView) itemView.findViewById(R.id.txtbackgroundborder);
            rlDay = (RelativeLayout) itemView.findViewById(R.id.rlDay);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickHourListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
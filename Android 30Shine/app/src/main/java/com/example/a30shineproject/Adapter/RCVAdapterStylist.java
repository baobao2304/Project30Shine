package com.example.a30shineproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a30shineproject.Interface.ItemClickAddressListener;
import com.example.a30shineproject.Interface.ItemClickStylistListener;
import com.example.a30shineproject.Model.StylistModel;
import com.example.a30shineproject.R;
import com.example.a30shineproject.SettingAll.SettingAll;

import java.util.List;

public class RCVAdapterStylist extends RecyclerView.Adapter<RCVAdapterStylist.MyViewHolder> {
    Context mContext;
    int checkPosittion = 0;
    public static int id;
    List<StylistModel> mData;
    private ItemClickAddressListener onNotListener;

    public RCVAdapterStylist(Context mContext, List<StylistModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_stylist,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return new MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.txtName.setText(mData.get(position).getTenStylist());
        if(checkPosittion == position && position == 0){
            System.out.println("checkposition and position"+position);
            holder.imgPerson.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_none_radius_solid_yellow));
            SettingAll.myViewHolderStylist = holder;
        }
        if(holder == SettingAll.myViewHolderStylist && checkPosittion == position){
            System.out.println("holder = myholder"+position);
            holder.imgPerson.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_none_radius_solid_yellow));
        }
        else{
            System.out.println("holder != myholder"+position);
            holder.imgPerson.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_none_radius_solid_none));
        }

        if(mData.get(position).getChecked() == 0){
            holder.txtNote.setText("");
            System.out.println("check 0 đã chạy"+position);
        }
        else
            holder.txtNote.setText("Thợ lần trước"+position);


        holder.setItemClickListener(new ItemClickStylistListener() {
            @Override
            public void onClick(View view, int position) {
                holder.imgPerson.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_none_radius_solid_yellow));
                SettingAll.myViewHolderStylist.imgPerson.setBackground(ContextCompat.getDrawable(mContext,R.drawable._bg_none_radius_solid_none));
                SettingAll.myViewHolderStylist = null;
                SettingAll.myViewHolderStylist = holder;
                checkPosittion = position;
                System.out.println("click item"+position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtName,txtNote;
        private ImageView imgPerson;
        private ItemClickStylistListener itemClickListener;
        public MyViewHolder (View itemView, ItemClickStylistListener onNoteListener){
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtNote =  (TextView) itemView.findViewById(R.id.txtNote);
            imgPerson = (ImageView) itemView.findViewById(R.id.imgPerson);

            itemView.setOnClickListener(this);
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtNote =  (TextView) itemView.findViewById(R.id.txtNote);
            imgPerson = (ImageView) itemView.findViewById(R.id.imgPerson);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickStylistListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
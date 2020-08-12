package com.example.a30shineproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a30shineproject.Interface.ItemClickAddressListener;
import com.example.a30shineproject.Model.AddressModel;
import com.example.a30shineproject.R;
import com.example.a30shineproject.SettingAll.SettingAll;

import java.util.List;

public class RCVAdapterAddress extends RecyclerView.Adapter<RCVAdapterAddress.MyViewHolder> {
    Context mContext;

    public static int id;
    List<AddressModel> mData;
    private  ItemClickAddressListener onNotListener;

    public RCVAdapterAddress(Context mContext, List<AddressModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_address,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return new MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.txtTenDuong.setText(mData.get(position).getTxtTenDuong());
        holder.txtTenPhuongQuan.setText(mData.get(position).getTxtTenPhuongQuan());
        holder.txtSoKm.setText(String.valueOf(mData.get(position).getTxtsoKm()));

        holder.setItemClickListener(new ItemClickAddressListener() {
            @Override
            public void onClick(View view, int position) {
                if(SettingAll.myViewHolder != null){
                    SettingAll.myViewHolder.lnBgAddress.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                SettingAll.isSelectedChooseAddress = true;
                id = position;
                holder.lnBgAddress.setBackgroundColor(Color.parseColor("#FFBA00"));
                SettingAll.myViewHolder = holder;

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtTenDuong;
        private TextView txtTenPhuongQuan;
        private TextView txtSoKm;
        private LinearLayout lnBgAddress;
        private ItemClickAddressListener itemClickListener;
        public MyViewHolder (View itemView, ItemClickAddressListener onNoteListener){
            super(itemView);
            txtTenDuong = (TextView) itemView.findViewById(R.id.txtTenDuong);
            txtTenPhuongQuan = (TextView) itemView.findViewById(R.id.txtTenPhuongQuan);
            txtSoKm = (TextView) itemView.findViewById(R.id.txtSoKm);
            lnBgAddress = (LinearLayout) itemView.findViewById(R.id.lnBgAddress);
//            mOnNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenDuong = (TextView) itemView.findViewById(R.id.txtTenDuong);
            txtTenPhuongQuan = (TextView) itemView.findViewById(R.id.txtTenPhuongQuan);
            txtSoKm = (TextView) itemView.findViewById(R.id.txtSoKm);
            lnBgAddress = (LinearLayout) itemView.findViewById(R.id.lnBgAddress);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickAddressListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}

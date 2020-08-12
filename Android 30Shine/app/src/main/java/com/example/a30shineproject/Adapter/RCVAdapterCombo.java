package com.example.a30shineproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a30shineproject.Interface.ItemClickAddressListener;
import com.example.a30shineproject.Interface.ItemClickComboListener;
import com.example.a30shineproject.Interface.ItemClickHourListener;
import com.example.a30shineproject.Interface.ItemClickStylistListener;
import com.example.a30shineproject.Model.ComboModel;
import com.example.a30shineproject.Model.HourModel;
import com.example.a30shineproject.R;
import com.example.a30shineproject.SettingAll.SettingAll;

import java.util.List;

public class RCVAdapterCombo extends RecyclerView.Adapter<RCVAdapterCombo.MyViewHolder> {
    Context mContext;
    public static int id;
    public static int checkSelectedItem = 0;
    List<ComboModel> mData;
    RCVAdapterCombo.MyViewHolder myViewHolder;
    private ItemClickAddressListener onNotListener;

    public RCVAdapterCombo(Context mContext, List<ComboModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_combo,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return new MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
//        holder.rdoCombo.setChecked(false);

//        if(mData.get(position).getCheckCombo() == 1 && position == id && holder == myViewHolder && myViewHolder != null){
//            holder.rdoCombo.setChecked(true);
//            holder.imgCombo.setAlpha((float) 1.0);
//        }
//        else{
//            holder.rdoCombo.setChecked(false);
//            holder.imgCombo.setAlpha((float) 0.6);
//        }

        holder.imgCombo.setImageResource(mData.get(position).getImgCombo());
        holder.rdoCombo.setChecked(false);
        holder.imgCombo.setAlpha((float) 0.6);
//        if(position == id && holder == myViewHolder && myViewHolder != null){
//            holder.rdoCombo.setChecked(true);
//            holder.imgCombo.setAlpha((float) 0.6);
//        }


        holder.setItemClickListener(new ItemClickComboListener() {
            @Override
            public void onClick(View view, int position) {
                holder.rdoCombo.setChecked(true);
//                holder.imgCombo.setAlpha((float) 1.0);



//                myViewHolder.imgCombo.setAlpha(10);
                if(myViewHolder == null){
                    holder.rdoCombo.setChecked(true);
                    holder.imgCombo.setAlpha((float) 1.0);
                    mData.get(position).setCheckCombo(1);
                    myViewHolder = null;
                    myViewHolder = holder;
                }
                if(myViewHolder != null){

                    mData.get(position).setCheckCombo(1);
                    holder.imgCombo.setAlpha((float) 1.0);
                    holder.rdoCombo.setChecked(true);

                    mData.get(id).setCheckCombo(0);
                    if(myViewHolder != holder && id != position ){
                        myViewHolder.rdoCombo.setChecked(false);
                        myViewHolder.imgCombo.setAlpha((float) 0.6);
                        myViewHolder = null;
                        myViewHolder = holder;
                    }
                }
                id = position;
                checkSelectedItem = 1;

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RadioButton rdoCombo;
        private ImageView imgCombo;
        private ItemClickComboListener itemClickListener;
        public MyViewHolder (View itemView, ItemClickComboListener onNoteListener){
            super(itemView);
            rdoCombo = (RadioButton) itemView.findViewById(R.id.rboCombo);
            imgCombo =  (ImageView) itemView.findViewById(R.id.imgCombo);

            itemView.setOnClickListener(this);
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rdoCombo = (RadioButton) itemView.findViewById(R.id.rboCombo);
            imgCombo =  (ImageView) itemView.findViewById(R.id.imgCombo);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickComboListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
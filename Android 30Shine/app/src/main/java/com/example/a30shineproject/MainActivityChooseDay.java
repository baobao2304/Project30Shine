package com.example.a30shineproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a30shineproject.Adapter.RCVAdapterHour;
import com.example.a30shineproject.Adapter.RCVAdapterStylist;
import com.example.a30shineproject.Model.HourModel;
import com.example.a30shineproject.Model.StylistModel;
import com.example.a30shineproject.SettingAll.SettingAll;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivityChooseDay extends AppCompatActivity {
    private  Button btnArrowBack,btnArrowForward;
    private LinearLayout lnToday,lnTomorow,lnAfterTomorow;
    private TextView txtToday1,txtTomorow1,txtAfterTomorow1,txtToday2,txtTomorow2,txtAfterTomorow2,txtAddress;
    private RecyclerView myRCVStylist;
    private RCVAdapterStylist rcvAdapterStylist;

    private RecyclerView myRCVHour;
    private RCVAdapterHour rcvAdapterHour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choose_day);
        AnhXa();
        Handle();
    }
    private void AnhXa(){
        btnArrowBack = (Button) findViewById(R.id.btnArrowBack);
        btnArrowForward = (Button) findViewById(R.id.btnArrowForward);

        lnToday = (LinearLayout) findViewById(R.id.lnToday);
        lnTomorow = (LinearLayout) findViewById(R.id.lnTomorow);
        lnAfterTomorow = (LinearLayout) findViewById(R.id.lnAfterTomorow);

        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtToday1 = (TextView) findViewById(R.id.txtToday1);
        txtTomorow1 = (TextView) findViewById(R.id.txtTomorrow1);
        txtAfterTomorow1 = (TextView) findViewById(R.id.txtAfterTomorrow1);
        txtToday2 = (TextView) findViewById(R.id.txtToday2);
        txtTomorow2 = (TextView) findViewById(R.id.txtTomorrow2);
        txtAfterTomorow2 = (TextView) findViewById(R.id.txtAfterTomorrow2);



    }

    private void Handle(){
        HandleDefault();
        HandleRecycleViewStylist();
        HandleRecycleViewHour();

        HandleEvent();
    }
    private void HandleEvent(){
        btnArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingAll.isSelectedChooseAddress = false;
                SettingAll.myViewHolder = null;
                Intent intent = new Intent(MainActivityChooseDay.this,MainActivityChooseSalon.class);
                startActivity(intent);
                finish();
            }
        });
        btnArrowForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RCVAdapterHour.checkSelectedItem == 1){
                    Intent intent = new Intent(MainActivityChooseDay.this,MainActivityChooseService.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        lnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnToday.setBackground(getDrawable(R.drawable._bg_black_radius_solid_grey));
                lnTomorow.setBackground(getDrawable(R.drawable._bg_white_radius_solid_grey));
                lnAfterTomorow.setBackground(getDrawable(R.drawable._bg_white_radius_solid_grey));

                txtToday1.setTextColor(getResources().getColor(R.color.colorWhite));
                txtToday2.setTextColor(getResources().getColor(R.color.colorWhite));
                txtTomorow1.setTextColor(getResources().getColor(R.color.colorBlack));
                txtTomorow2.setTextColor(getResources().getColor(R.color.colorBlack));
                txtAfterTomorow1.setTextColor(getResources().getColor(R.color.colorBlack));
                txtAfterTomorow2.setTextColor(getResources().getColor(R.color.colorBlack));

            }
        });
        lnTomorow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnToday.setBackground(getDrawable(R.drawable._bg_white_radius_solid_grey));
                lnTomorow.setBackground(getDrawable(R.drawable._bg_black_radius_solid_grey));
                lnAfterTomorow.setBackground(getDrawable(R.drawable._bg_white_radius_solid_grey));

                txtToday1.setTextColor(getResources().getColor(R.color.colorBlack));
                txtToday2.setTextColor(getResources().getColor(R.color.colorBlack));
                txtTomorow1.setTextColor(getResources().getColor(R.color.colorWhite));
                txtTomorow2.setTextColor(getResources().getColor(R.color.colorWhite));
                txtAfterTomorow1.setTextColor(getResources().getColor(R.color.colorBlack));
                txtAfterTomorow2.setTextColor(getResources().getColor(R.color.colorBlack));
            }
        });
        lnAfterTomorow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnToday.setBackground(getDrawable(R.drawable._bg_white_radius_solid_grey));
                lnTomorow.setBackground(getDrawable(R.drawable._bg_white_radius_solid_grey));
                lnAfterTomorow.setBackground(getDrawable(R.drawable._bg_black_radius_solid_grey));

                txtToday1.setTextColor(getResources().getColor(R.color.colorBlack));
                txtToday2.setTextColor(getResources().getColor(R.color.colorBlack));
                txtTomorow1.setTextColor(getResources().getColor(R.color.colorBlack));
                txtTomorow2.setTextColor(getResources().getColor(R.color.colorBlack));
                txtAfterTomorow1.setTextColor(getResources().getColor(R.color.colorWhite));
                txtAfterTomorow2.setTextColor(getResources().getColor(R.color.colorWhite));
            }
        });
    }
    public List<StylistModel> lsItemStylist;
    public List<HourModel> lsItemHourlist;
    private void HandleRecycleViewStylist(){
        lsItemStylist = new ArrayList<>() ;
        lsItemStylist.add(new StylistModel(1,"Mặc định",0));
        lsItemStylist.add(new StylistModel(2,"Quốc Thành",1));
        lsItemStylist.add(new StylistModel(3,"Thái Công",1));
        lsItemStylist.add(new StylistModel(4,"Sơn Tùng",0));
        lsItemStylist.add(new StylistModel(5,"Hiệp Tân",0));
        lsItemStylist.add(new StylistModel(6,"Linh Trần",0));
        lsItemStylist.add(new StylistModel(7,"Lộc Trần",0));
        lsItemStylist.add(new StylistModel(8,"Công Sơn",0));
        lsItemStylist.add(new StylistModel(9,"Sơn Tùng",0));
        lsItemStylist.add(new StylistModel(10,"Hiệp Tân",0));
        lsItemStylist.add(new StylistModel(11,"Linh Trần",0));
        lsItemStylist.add(new StylistModel(12,"Lộc Trần",0));
        lsItemStylist.add(new StylistModel(13,"Công Sơn",0));

        myRCVStylist = (RecyclerView) findViewById(R.id.rcv_stylist);
        rcvAdapterStylist = new RCVAdapterStylist(MainActivityChooseDay.this,lsItemStylist);
        myRCVStylist.setLayoutManager(new LinearLayoutManager(MainActivityChooseDay.this,LinearLayoutManager.HORIZONTAL, false));
        myRCVStylist.setHasFixedSize(true);
        myRCVStylist.setAdapter(rcvAdapterStylist);
    }
    private void HandleRecycleViewHour(){
        lsItemHourlist = new ArrayList<>() ;
        lsItemHourlist.add(new HourModel("7h30",0));
        lsItemHourlist.add(new HourModel("7h50",1));
        lsItemHourlist.add(new HourModel("7h45",1));
        lsItemHourlist.add(new HourModel("8h00",0));
        lsItemHourlist.add(new HourModel("8h15",0));
        lsItemHourlist.add(new HourModel("8h20",0));
        lsItemHourlist.add(new HourModel("8h30",0));
        lsItemHourlist.add(new HourModel("8h40",0));
        lsItemHourlist.add(new HourModel("8h45",0));
        lsItemHourlist.add(new HourModel("9h00",0));
        lsItemHourlist.add(new HourModel("9h15",0));
        lsItemHourlist.add(new HourModel("9h20",0));
        lsItemHourlist.add(new HourModel("9h30",0));
        lsItemHourlist.add(new HourModel("9h40",0));
        lsItemHourlist.add(new HourModel("9h45",0));
        lsItemHourlist.add(new HourModel("10h00",0));
        lsItemHourlist.add(new HourModel("10h15",0));
        lsItemHourlist.add(new HourModel("10h20",0));
        lsItemHourlist.add(new HourModel("10h30",0));
        lsItemHourlist.add(new HourModel("10h40",0));
        lsItemHourlist.add(new HourModel("10h45",0));
        lsItemHourlist.add(new HourModel("11h00",0));
        lsItemHourlist.add(new HourModel("11h15",0));
        lsItemHourlist.add(new HourModel("11h20",0));
        lsItemHourlist.add(new HourModel("11h30",0));
        lsItemHourlist.add(new HourModel("11h40",0));
        lsItemHourlist.add(new HourModel("11h45",0));
        lsItemHourlist.add(new HourModel("12h00",0));
        lsItemHourlist.add(new HourModel("12h15",0));
        lsItemHourlist.add(new HourModel("12h20",0));
        lsItemHourlist.add(new HourModel("12h30",0));
        lsItemHourlist.add(new HourModel("12h40",0));
        lsItemHourlist.add(new HourModel("12h45",0));
        lsItemHourlist.add(new HourModel("13h00",0));
        lsItemHourlist.add(new HourModel("13h15",0));
        lsItemHourlist.add(new HourModel("13h20",0));
        lsItemHourlist.add(new HourModel("13h30",0));
        lsItemHourlist.add(new HourModel("13h40",0));
        lsItemHourlist.add(new HourModel("13h45",0));
        lsItemHourlist.add(new HourModel("14h00",0));
        lsItemHourlist.add(new HourModel("14h15",0));
        lsItemHourlist.add(new HourModel("14h20",0));
        lsItemHourlist.add(new HourModel("14h30",0));
        lsItemHourlist.add(new HourModel("14h40",0));
        lsItemHourlist.add(new HourModel("14h45",0));
        lsItemHourlist.add(new HourModel("15h00",0));
        lsItemHourlist.add(new HourModel("15h15",0));
        lsItemHourlist.add(new HourModel("15h20",0));
        lsItemHourlist.add(new HourModel("15h30",0));
        lsItemHourlist.add(new HourModel("15h40",0));
        lsItemHourlist.add(new HourModel("15h45",0));
        lsItemHourlist.add(new HourModel("16h00",0));
        lsItemHourlist.add(new HourModel("16h15",0));
        lsItemHourlist.add(new HourModel("16h20",0));
        lsItemHourlist.add(new HourModel("16h30",0));
        lsItemHourlist.add(new HourModel("16h40",0));
        lsItemHourlist.add(new HourModel("16h45",0));
        lsItemHourlist.add(new HourModel("17h00",0));
        lsItemHourlist.add(new HourModel("17h15",0));
        lsItemHourlist.add(new HourModel("17h20",0));
        lsItemHourlist.add(new HourModel("17h30",0));
        lsItemHourlist.add(new HourModel("17h40",0));
        lsItemHourlist.add(new HourModel("17h45",0));
        lsItemHourlist.add(new HourModel("18h00",0));
        lsItemHourlist.add(new HourModel("18h15",0));
        lsItemHourlist.add(new HourModel("18h20",0));
        lsItemHourlist.add(new HourModel("18h30",0));
        lsItemHourlist.add(new HourModel("18h40",0));
        lsItemHourlist.add(new HourModel("18h45",0));
        lsItemHourlist.add(new HourModel("19h00",0));
        lsItemHourlist.add(new HourModel("19h15",0));
        lsItemHourlist.add(new HourModel("19h20",0));
        lsItemHourlist.add(new HourModel("19h30",0));
        lsItemHourlist.add(new HourModel("19h40",0));
        lsItemHourlist.add(new HourModel("19h45",0));
        lsItemHourlist.add(new HourModel("20h00",0));
        lsItemHourlist.add(new HourModel("20h15",0));
        lsItemHourlist.add(new HourModel("20h20",0));
        lsItemHourlist.add(new HourModel("20h30",0));
        lsItemHourlist.add(new HourModel("20h40",0));
        lsItemHourlist.add(new HourModel("20h45",0));
        lsItemHourlist.add(new HourModel("21h00",0));
        lsItemHourlist.add(new HourModel("21h15",0));
        lsItemHourlist.add(new HourModel("21h20",0));
        lsItemHourlist.add(new HourModel("21h30",0));
        lsItemHourlist.add(new HourModel("21h40",0));
        lsItemHourlist.add(new HourModel("21h45",0));
        lsItemHourlist.add(new HourModel("22h00",0));
        lsItemHourlist.add(new HourModel("22h15",0));
        lsItemHourlist.add(new HourModel("22h20",0));
        lsItemHourlist.add(new HourModel("22h30",0));
        lsItemHourlist.add(new HourModel("22h40",0));
        lsItemHourlist.add(new HourModel("22h45",0));



        myRCVHour = (RecyclerView) findViewById(R.id.rcvHour);
        rcvAdapterHour = new RCVAdapterHour(MainActivityChooseDay.this,lsItemHourlist);
        myRCVHour.setLayoutManager(new GridLayoutManager(MainActivityChooseDay.this,24));
//        myRCVHour.setLayoutManager(new LinearLayoutManager(MainActivityChooseDay.this,LinearLayoutManager.HORIZONTAL, false));
        myRCVHour.setHasFixedSize(true);
        myRCVHour.setAdapter(rcvAdapterHour);



//        BlankFragmentHome.recyclerViewAdapterPR = new RecycleViewAdapterProduct(v.getContext(),SettingAll.lsProductHome );
//        BlankFragmentHome.myRecyclerViewPR.setLayoutManager(new GridLayoutManager(v.getContext(),3));
//
//        BlankFragmentHome.myRecyclerViewPR.setHasFixedSize(true);
//        BlankFragmentHome.myRecyclerViewPR.setAdapter(BlankFragmentHome.recyclerViewAdapterPR);
    }

    private void HandleDefault(){
//        txtAddress.setText("CHỌN NGÀY/GIỜ CẮT ("+SettingAll.myViewHolder.txtTenDuong.getText()+")");
//        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        Date currentTimeToday = Calendar.getInstance().getTime();
        Calendar c  = Calendar.getInstance();
        c.add(Calendar.DATE,1);
        Date currentTimeTomorow = c.getTime();
        c.add(Calendar.DATE,1);
        Date currentTimeAfterTomorow = c.getTime();

        txtToday2.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(currentTimeToday));
        txtTomorow2.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(currentTimeTomorow));
        txtAfterTomorow2.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(currentTimeAfterTomorow));

    }
}
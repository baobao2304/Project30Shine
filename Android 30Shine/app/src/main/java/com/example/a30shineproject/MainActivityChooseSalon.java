package com.example.a30shineproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.a30shineproject.Adapter.RCVAdapterAddress;
import com.example.a30shineproject.Model.AddressModel;
import com.example.a30shineproject.SettingAll.SettingAll;

import java.util.ArrayList;
import java.util.List;

public class MainActivityChooseSalon extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
    private Spinner spinnerTP,spinnerHuyen;
    private Button btnArrowBack,btnArrowForward;
    private RecyclerView myRCVAddress;
    private RCVAdapterAddress rcvAdapterAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choose_salon);
        AnhXa();
        Handle();
    }
    private void AnhXa(){
        spinnerTP = (Spinner) findViewById(R.id.spinnerTP);
        spinnerHuyen = (Spinner) findViewById(R.id.spinnerHuyen);

        btnArrowBack = (Button) findViewById(R.id.btnArrowBack);
        btnArrowForward = (Button) findViewById(R.id.btnArrowForward);
    }
    private void Handle(){
        HandleEvent();
        HandleSpinner();
        HandleRecycleView();
    }
    private void HandleEvent(){
        btnArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityChooseSalon.this,MainActivityHome.class);
                startActivity(intent);
                finish();
            }
        });
        btnArrowForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SettingAll.isSelectedChooseAddress == true){
                    SettingAll.isSelectedChooseAddress = false;
                    Intent intent = new Intent(MainActivityChooseSalon.this,MainActivityChooseDay.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public List<AddressModel> lsItemAddress;
    private void HandleRecycleView(){
        lsItemAddress = new ArrayList<>() ;
        lsItemAddress.add(new AddressModel("236 DƯƠNG BÁ TRẠC","Phường 1 , Quận 8", (float) 6.01));
        lsItemAddress.add(new AddressModel("758 ÂU CƠ","Phường 14 , Q.Tân Bình", (float) 6.01));
        lsItemAddress.add(new AddressModel("150 TRƯỜNG CHINH","Phường 12 , Quận Tân Bìn", (float) 6.01));
        lsItemAddress.add(new AddressModel("245 LÊ ĐẠI HÀNH","Phường 15 , Quận 11", (float) 6.01));
        lsItemAddress.add(new AddressModel("189 HÒA BÌNH","Phường Hiệp Tân , Quận Tân Phú", (float) 6.01));
        lsItemAddress.add(new AddressModel("193 TÔ HIẾN THÀNH","Phường 13 , Quận 10", (float) 6.01));
        lsItemAddress.add(new AddressModel("264 ĐỘC LẬP","Phường Tân Quý , Quận Tân Phú", (float) 6.01));
        lsItemAddress.add(new AddressModel("312 LÊ VĂN SỸ","Phường 1 , Quận Tân Bình", (float) 6.01));
        lsItemAddress.add(new AddressModel("236 DƯƠNG BÁ TRẠC","Phường 1 , Quận 8", (float) 6.01));
        lsItemAddress.add(new AddressModel("758 ÂU CƠ","Phường 14 , Q.Tân Bình", (float) 6.01));
        lsItemAddress.add(new AddressModel("150 TRƯỜNG CHINH","Phường 12 , Quận Tân Bìn", (float) 6.01));
        lsItemAddress.add(new AddressModel("245 LÊ ĐẠI HÀNH","Phường 15 , Quận 11", (float) 6.01));
        lsItemAddress.add(new AddressModel("189 HÒA BÌNH","Phường Hiệp Tân , Quận Tân Phú", (float) 6.01));
        lsItemAddress.add(new AddressModel("193 TÔ HIẾN THÀNH","Phường 13 , Quận 10", (float) 6.01));
        lsItemAddress.add(new AddressModel("264 ĐỘC LẬP","Phường Tân Quý , Quận Tân Phú", (float) 6.01));
        lsItemAddress.add(new AddressModel("312 LÊ VĂN SỸ","Phường 1 , Quận Tân Bình", (float) 6.01));

        myRCVAddress = (RecyclerView) findViewById(R.id.rcvAddress);
        rcvAdapterAddress = new RCVAdapterAddress(MainActivityChooseSalon.this,lsItemAddress);
        myRCVAddress.setLayoutManager(new GridLayoutManager(MainActivityChooseSalon.this,2));
        myRCVAddress.setHasFixedSize(true);
        myRCVAddress.setAdapter(rcvAdapterAddress);
    }
    private void HandleSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.thanhpho,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTP.setAdapter(adapter);
        spinnerTP.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
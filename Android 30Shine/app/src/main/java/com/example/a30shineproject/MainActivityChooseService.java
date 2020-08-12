package com.example.a30shineproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a30shineproject.Adapter.RCVAdapterAddress;
import com.example.a30shineproject.Adapter.RCVAdapterCombo;
import com.example.a30shineproject.Adapter.RCVAdapterHour;
import com.example.a30shineproject.Model.ComboModel;
import com.example.a30shineproject.SettingAll.SettingAll;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivityChooseService extends AppCompatActivity {
    TextView txtTimeEnd;
    CountDownTimer mCountDownTimer;
    Button btnArrowBack,btnArrowForward;
    public static final long START_TIME_IN_MILIS = 300000;

    private boolean mTimeRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choose_service);
        AnhXa();
        Handle();
    }

    private void AnhXa(){
        txtTimeEnd = (TextView) findViewById(R.id.txtTimeEnd);

        btnArrowBack = (Button) findViewById(R.id.btnArrowBack);
        btnArrowForward = (Button) findViewById(R.id.btnArrowForward);
    }
    private void Handle(){
        HandleEvent();
        HandleRCVCombo();
        // Write a message to the database
        HandleData();
    }
    private void HandleData(){
        DatabaseReference mData;
        mData = FirebaseDatabase.getInstance().getReference();

//        IMPORT DATA
//        //th1
//        mData.child("HoTen").setValue("Pham Van Le Bao");
//
//        //th2
////            public ComboModel(int checkCombo, int imgCombo) {
//        ComboModel cb = new ComboModel(11,22);
//        mData.child("Combobox").setValue(cb);
//
//        // th 3
//
//        Map<String,Integer> map = new HashMap<String,Integer>();
//        map.put("Xe May",2);
//        mData.child("Phuong Tien").setValue(map);
//
//        // th 4
//        ComboModel cb1 = new ComboModel(2,3);
//        mData.child("sinhvien").push().setValue(cb1);
//
//        // th 5
//        mData.child("Truong Hop 5 ").setValue("Bao Pham", new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable DatabaseError dberror, @NonNull DatabaseReference ref) {
//                if(dberror == null){
//                    Toast.makeText(MainActivityChooseService.this, "Luwu  thanh c ong",Toast.LENGTH_SHORT).show();
//                }
//                else
//                    Toast.makeText(MainActivityChooseService.this, "Luwu  That Bai",Toast.LENGTH_SHORT).show();
//            }
//        });


//        NHAN DATA


//        mData.child("HoTen").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Toast.makeText(MainActivityChooseService.this, snapshot.getValue().toString(),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

//        LOAD MORE DATA
//        mData.child("sinhvien").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Toast.makeText(MainActivityChooseService.this, snapshot.getValue().toString()+"\n",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }
    private void HandleEvent(){
        btnArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingAll.isSelectedChooseAddress = false;
                SettingAll.myViewHolder = null;
                Intent intent = new Intent(MainActivityChooseService.this,MainActivityChooseDay.class);
                startActivity(intent);
                finish();
            }
        });
        btnArrowForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RCVAdapterHour.checkSelectedItem == 1){
                    Intent intent = new Intent(MainActivityChooseService.this,MainActivityBill.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        mTimeRunning = true;

    }
    List<ComboModel> lsCombo = new ArrayList<>();
    RecyclerView myRCVCombo;
    RCVAdapterCombo rcvAdapterCombo;
    private void HandleRCVCombo(){
        myRCVCombo = (RecyclerView) findViewById(R.id.rcv_combo);

        lsCombo.add(new ComboModel(0,R.drawable._combo1));
        lsCombo.add(new ComboModel(0,R.drawable._combo2));
        lsCombo.add(new ComboModel(0,R.drawable._combo3));
        lsCombo.add(new ComboModel(0,R.drawable._combo4));
        lsCombo.add(new ComboModel(0,R.drawable._combo5));
        lsCombo.add(new ComboModel(0,R.drawable._combo6));
        lsCombo.add(new ComboModel(0,R.drawable._combo7));
        lsCombo.add(new ComboModel(0,R.drawable._combo8));

        rcvAdapterCombo = new RCVAdapterCombo(MainActivityChooseService.this,lsCombo);
        myRCVCombo.setLayoutManager(new LinearLayoutManager(MainActivityChooseService.this,LinearLayoutManager.VERTICAL, false));
        myRCVCombo.setHasFixedSize(true);
        myRCVCombo.setAdapter(rcvAdapterCombo);
    }
    private void updateCountDownText(){
        int minutes =  (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds =  (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d",minutes,seconds);
        txtTimeEnd.setText(timeLeftFormatted);
    }
}
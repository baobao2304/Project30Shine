package com.example.a30shineproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.a30shineproject.Adapter.RCVAdapterAddress;
import com.example.a30shineproject.Adapter.RCVAdapterCombo;
import com.example.a30shineproject.Model.ComboModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityChooseService extends AppCompatActivity {
    TextView txtTimeEnd;
    CountDownTimer mCountDownTimer;
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
    }
    private void Handle(){
        HandleEvent();
        HandleRCVCombo();
    }
    private void HandleEvent(){
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
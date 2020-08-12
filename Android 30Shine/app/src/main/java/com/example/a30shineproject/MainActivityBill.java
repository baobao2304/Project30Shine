package com.example.a30shineproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivityBill extends AppCompatActivity {
    private ImageView imgHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bill);
        AnhXa();
        Handle();
    }
    private void AnhXa(){
        imgHome = (ImageView) findViewById(R.id.imgHome);
    }
    private void Handle(){
        HandleEvent();
    }
    private void HandleEvent(){
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityBill.this , MainActivityHome.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
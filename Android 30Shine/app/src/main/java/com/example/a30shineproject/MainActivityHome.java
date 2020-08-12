package com.example.a30shineproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.a30shineproject.Adapter.OrdersPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivityHome extends AppCompatActivity {
    private ViewPager2 viewPager;
    public static TabLayout tabLayout;
    private TabLayout.Tab tab;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        AnhXa();
        Handle();
    }
    private void AnhXa(){
        viewPager = (ViewPager2) findViewById(R.id.viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }
    private  void Handle(){
        HandleTabLayout();
        HandleEvent();
    }
    private  void HandleEvent(){
//        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                if(viewPager.getCurrentItem() == 0){
//                    tabLayout.getTabAt(3).setText(getResources().getColor(R.color.colorWhiteFill));
//                    tabLayout.getTabAt(2).setText(getResources().getColor(R.color.colorWhiteFill));
//                    tabLayout.getTabAt(1).setText(getResources().getColor(R.color.colorWhiteFill));
//                    tabLayout.getTabAt(0).setText(getResources().getColor(R.color.colorWhite));
//                }
//                if(viewPager.getCurrentItem() == 1){
//
//                }
//                if(viewPager.getCurrentItem() == 2){
//
//                }
//                if(viewPager.getCurrentItem() == 3){
//                    tabLayout.getTabAt(3).setText(getResources().getColor(R.color.colorWhite));
//                    tabLayout.getTabAt(2).setText(getResources().getColor(R.color.colorWhiteFill));
//                    tabLayout.getTabAt(1).setText(getResources().getColor(R.color.colorWhiteFill));
//                    tabLayout.getTabAt(0).setText(getResources().getColor(R.color.colorWhiteFill));
//
//                }
//            }
//        } );

    }

    private void HandleTabLayout() {
        viewPager.setAdapter(new OrdersPagerAdapter(this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0: {
                        tab.setText("Home");
                        tab.setIcon(R.drawable.ic_round_home_24);
                        break;
                    }
                    case 1: {
                        tab.setText("Style Master");
                        tab.setIcon(R.drawable.ic_outline_shutter_speed_24);
                        break;
                    }
                    case 2: {
                        tab.setText("30Shine Store");
                        tab.setIcon(R.drawable.ic_outline_smoking_rooms_24);
                        break;
                    }
                    case 3: {
                        tab.setText("Menu");
                        tab.setIcon(R.drawable.ic_baseline_format_list_bulleted_24);
                        break;
                    }
                }

            }
        });

        tabLayoutMediator.attach();


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(viewPager.getCurrentItem() == 0 ){
                    tabLayout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(3).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(1).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(2).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                }
                if(viewPager.getCurrentItem() == 3 ){
                    tabLayout.getTabAt(3).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(0).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(1).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(2).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);

                }
                if(viewPager.getCurrentItem() == 1){
                    tabLayout.getTabAt(3).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(0).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(1).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(2).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                }
                if(viewPager.getCurrentItem() == 2){
                    tabLayout.getTabAt(3).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(0).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(1).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
                    tabLayout.getTabAt(2).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                }
                tabLayout.setTabTextColors(getResources().getColor(R.color.colorBlackFill),
                        getResources().getColor(R.color.colorWhite));
            }
        });
    }













}
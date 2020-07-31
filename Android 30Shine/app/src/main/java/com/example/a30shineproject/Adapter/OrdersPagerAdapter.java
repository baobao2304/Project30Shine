package com.example.a30shineproject.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.a30shineproject.TabHome.BlankFragmentHome;
import com.example.a30shineproject.TabHome.BlankFragmentMenu;

public class OrdersPagerAdapter extends FragmentStateAdapter {


    public OrdersPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BlankFragmentHome();
            case 3:
                return new BlankFragmentMenu();
//            case 2:
//                return new BlankFragmentTimKiem();
//            case 3:
//                return new BlankFragmentThongBao();
//            case 4:
//                return new BlankFragmentCaNhan();
            default:
                return new BlankFragmentMenu();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

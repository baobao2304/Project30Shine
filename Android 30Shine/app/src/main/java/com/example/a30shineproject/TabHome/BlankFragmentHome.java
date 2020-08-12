package com.example.a30shineproject.TabHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.a30shineproject.MainActivityChooseSalon;
import com.example.a30shineproject.MainActivityHome;
import com.example.a30shineproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentHome extends Fragment  {
    private View v;
    private ImageSlider imageSlider,imageSlider2;
    private LinearLayout lnOrderDay;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentHome newInstance(String param1, String param2) {
        BlankFragmentHome fragment = new BlankFragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_blank_home, container, false);
        // Inflate the layout for this fragment

        AnhXa();
        Handle();
//        MainActivityLoginAndRegister.txtLogin.setTextColor(Color.WHITE);
//        MainActivityLoginAndRegister.txtRegister.setTextColor(getResources().getColor(R.color.colorBlackFill));
        return v;
    }
    private void AnhXa(){
        imageSlider = (ImageSlider) v.findViewById(R.id.imageSlider);
        imageSlider2 = (ImageSlider) v.findViewById(R.id.imageSlider2);
        lnOrderDay = (LinearLayout) v.findViewById(R.id.lnOrderDay);


    }
    private void Handle(){
        HandleEvent();
        handleImageSlider();
    }
    private void HandleEvent(){
        lnOrderDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivityChooseSalon.class);
                startActivity(intent);
            }
        });
    }

    private void handleImageSlider(){
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable._imgpa1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._imgpa2,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._imgpa3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._imgpa4, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        List<SlideModel> slideModels2 = new ArrayList<>();
        slideModels2.add(new SlideModel(R.drawable._imgpa5, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable._imgpa5,ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable._imgpa5, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable._imgpa5, ScaleTypes.FIT));
        imageSlider2.setImageList(slideModels,ScaleTypes.FIT);
    }


}
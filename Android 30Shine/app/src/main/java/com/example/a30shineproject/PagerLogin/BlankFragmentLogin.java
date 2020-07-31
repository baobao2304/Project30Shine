package com.example.a30shineproject.PagerLogin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a30shineproject.MainActivityHome;
import com.example.a30shineproject.MainActivityLoginAndRegister;
import com.example.a30shineproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentLogin extends Fragment {
    private View v;
    private EditText txtID,txtPass;
    private Button btnLogin;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentLogin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentLogin.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentLogin newInstance(String param1, String param2) {
        BlankFragmentLogin fragment = new BlankFragmentLogin();
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

        v = inflater.inflate(R.layout.fragment_blank_login, container, false);
        // Inflate the layout for this fragment

        AnhXa();
        Handle();
//        MainActivityLoginAndRegister.txtLogin.setTextColor(Color.WHITE);
//        MainActivityLoginAndRegister.txtRegister.setTextColor(getResources().getColor(R.color.colorBlackFill));
        return v;
    }
    private void AnhXa(){
        txtID = (EditText)v.findViewById(R.id.txtID);
        txtPass = (EditText)v.findViewById(R.id.txtID);

        btnLogin = (Button) v.findViewById(R.id.btnLogin);
    }
    private void Handle(){
        HandleEvent();
    }
    private void HandleEvent(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivityHome.class);
                startActivity(intent);
            }
        });
    }
}
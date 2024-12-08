package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BlankFragment2 extends Fragment {


    public BlankFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blank2, container, false);

        dbHelper dbHelper = new dbHelper(getContext().getApplicationContext());

        TextView textView = view.findViewById(R.id.showdata);

        dbHelper.ShowData();

        int cr = dbHelper.ShowData().getCount() ;
        Log.d("TAG", "onCreateView:" +  cr);
    textView.setText(String.valueOf(cr));

        return view ;
    }
}
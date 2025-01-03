package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BlankFragment extends Fragment {
    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blank, container, false);

        dbHelper dbHelper = new dbHelper(getContext().getApplicationContext());


        EditText name = (EditText) view.findViewById(R.id.name);
        EditText age = (EditText) view.findViewById(R.id.age);

        Button add = (Button) view.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = "1";
                String nm = name.toString();
                String ag = age.toString() ;

                boolean data  = dbHelper.insertData(id,nm,ag);
                if(data)
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(), "Wwrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view ;
    }
}
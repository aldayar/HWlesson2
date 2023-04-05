package com.example.hwlesson2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {
    private Button add,sortBtn;
    private EditText mainEditText;
    private String inputtedText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_main, container, false);

        add=view.findViewById(R.id.add_btn);
        sortBtn=view.findViewById(R.id.sort_btn);
        mainEditText=view.findViewById(R.id.main_edit_text);

        add.setOnClickListener(view1 -> {
            AddFragment addFragment = new AddFragment();
            FragmentTransaction ft=getParentFragmentManager().beginTransaction();
            ft.replace(R.id.main_fragment,addFragment).commit();

        });

        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputtedText=mainEditText.getText().toString();

                AddFragment addFragment= new AddFragment();
                Bundle bundle= new Bundle();
                bundle.putString("key",inputtedText);
                AddFragment addFragment1=new AddFragment();
                addFragment1.setArguments(bundle);
                
                FragmentTransaction ft=getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,addFragment).commit();
            }
        });
        return view;
    }


}
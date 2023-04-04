package com.example.hwlesson2;

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

        add.setOnClickListener(view1 -> {
            AddFragment addFragment = new AddFragment();
            FragmentTransaction ft=getParentFragmentManager().beginTransaction();
            ft.replace(R.id.main_fragment,addFragment).commit();

        });

        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFragment addFragment= new AddFragment();
                inputtedText = searchingEditText();
                FragmentTransaction ft=getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,addFragment).commit();
            }
        });
        return view;
    }
    private String searchingEditText() {
     mainEditText=getView().findViewById(R.id.main_edit_text);
     return mainEditText.getText().toString();
    }

}
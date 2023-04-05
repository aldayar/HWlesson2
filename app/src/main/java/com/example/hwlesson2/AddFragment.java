package com.example.hwlesson2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.net.URISyntaxException;

public class AddFragment extends Fragment {
    private static final int GALLERY_REQUEST_CODE = 1;
    private CardView cardView;
    private EditText editTitle;
    private String textTitle;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardView=view.findViewById(R.id.card_view);
        editTitle=view.findViewById(R.id.edit_title);

        Bundle bundle=getArguments();
        textTitle = bundle.getString("key");
        editTitle.setText(textTitle);


        cardView.setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_REQUEST_CODE);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GALLERY_REQUEST_CODE && resultCode== Activity.RESULT_OK){
            Uri imageview =data.getData();
            cardView.setBackground(Drawable.createFromPath(imageview.toString()));
        }
    }

    }

package com.example.hwlesson2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddFragment extends Fragment {
    private static final int GALLERY_REQUEST_CODE = 1;
    private CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        cardView=view.findViewById(R.id.card_view);

        cardView.setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent,GALLERY_REQUEST_CODE);

        });
        return view;
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
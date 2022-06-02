package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton img1, img2, img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.imageButton);
        img2 = findViewById(R.id.imageButton2);
        img3 = findViewById(R.id.imageButton3);
        img4 = findViewById(R.id.imageButton4);

    }
    public void presion(View v){
        ImageButton bt = (ImageButton) v;
        bt.setVisibility(View.INVISIBLE);
    }
    public void mostrar(View v){
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
        img3.setVisibility(View.VISIBLE);
        img4.setVisibility(View.VISIBLE);
    }
}
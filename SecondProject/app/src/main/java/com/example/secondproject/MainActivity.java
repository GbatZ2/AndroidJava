package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int x;
    ImageView img;
    ImageButton imgBLeft;
    ImageButton imgBRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imv);
        imgBLeft = findViewById(R.id.imb1);
        imgBRight = findViewById(R.id.imb2);
    }
    public void rightButton(View v){
        if(x ==9 ){
            x=0;
        }else{
            x++;
        }
        switch (x){
            case 1:
                img.setImageResource(R.drawable.bg1);
                break;
            case 2:
                img.setImageResource(R.drawable.bg2);
                break;
            case 3:
                img.setImageResource(R.drawable.bg3);
                break;
            case 4:
                img.setImageResource(R.drawable.bg4);
                break;
            case 5:
                img.setImageResource(R.drawable.bg5);
                break;
            case 6:
                img.setImageResource(R.drawable.bg6);
                break;
            case 7:
                img.setImageResource(R.drawable.bg7);
                break;
            case 8:
                img.setImageResource(R.drawable.bg8);
                break;
            case 9:
                img.setImageResource(R.drawable.bg9);
                break;
        }
    }
    public void leftButton(View v){
        if(x==0){
            x=9;
        }else{
            x--;
        }
        switch (x){
            case 1:
                img.setImageResource(R.drawable.bg1);
                break;
            case 2:
                img.setImageResource(R.drawable.bg2);
                break;
            case 3:
                img.setImageResource(R.drawable.bg3);
                break;
            case 4:
                img.setImageResource(R.drawable.bg4);
                break;
            case 5:
                img.setImageResource(R.drawable.bg5);
                break;
            case 6:
                img.setImageResource(R.drawable.bg6);
                break;
            case 7:
                img.setImageResource(R.drawable.bg7);
                break;
            case 8:
                img.setImageResource(R.drawable.bg8);
                break;
            case 9:
                img.setImageResource(R.drawable.bg9);
                break;
        }



    }
}


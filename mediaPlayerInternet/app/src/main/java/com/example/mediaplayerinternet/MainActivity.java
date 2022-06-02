package com.example.mediaplayerinternet;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mp!=null){
            mp.release();
            mp = null;
        }
    }

    public void reproducir(View v){
        if(mp !=null){
            mp.release();
            mp = new MediaPlayer();
            try {
                mp.setDataSource("Ruta Archivo");
            } catch (IOException e) {
                e.printStackTrace();
            }
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
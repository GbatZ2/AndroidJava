package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    TextView tv1;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        sw = findViewById(R.id.switch1);
    }

    public void iniciar(View v){

        if(mp !=null){
            mp.release();
            mp =  MediaPlayer.create(this,R.raw.song);
            mp.start();
            tv1.setText("Estado: Reproduciendo");
            if(sw.isChecked()){
                mp.setLooping(true);
            }
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    tv1.setText("Estado: Finalizado");
                }
            });
        }else{
            mp = new MediaPlayer();
        }
    }

    public void pausar(View v){
            if(mp!=null && mp.isPlaying()){
                mp.pause();
                tv1.setText("Estado: Pausado");
            }
    }

    public void avanzar(View v){
        if(mp != null){
        int position = mp.getCurrentPosition();
        mp.seekTo(position+5000);
        }
    }

    public void circular(View v){

        if(sw.isChecked()){
            mp.setLooping(true);
        }else{
            mp.setLooping(false);
        }
    }

    public void retroceder(View v){
        if(mp != null){
            int position = mp.getCurrentPosition();
            mp.seekTo(position-5000);
        }
    }

    public void continuar(View v){
        if(mp!=null && mp.isPlaying()==false){
            mp.start();
            tv1.setText("Estado: Reproduciendo");
        }
    }



    @Override
    protected void onStop() {
        super.onStop();
        if(mp!=null){
            mp.release();
            mp=null;
        }
    }
}
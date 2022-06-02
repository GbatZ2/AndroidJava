package com.example.consumidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void entrar(View v){
        Intent inte = new Intent(Intent.ACTION_VIEW);
        inte.putExtra("direccion", "https://open.spotify.com/track/2289t09ANiZim5P2N0ykK5?si=f7c58cbc706d43de");
        startActivity(inte);
    }
}
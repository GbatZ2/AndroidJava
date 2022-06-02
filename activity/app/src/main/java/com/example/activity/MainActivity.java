package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable{

    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Ejecutando el onCreate", Toast.LENGTH_SHORT).show();
        tv1 = findViewById(R.id.tv1);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Ejecutando el onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "Ejecutando el onStart", Toast.LENGTH_SHORT).show();
        run();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "Ejecutando el onStop", Toast.LENGTH_SHORT).show();
        tv1.removeCallbacks(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "Ejecutando el onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "Ejecutando el onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "Ejecutando el onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void run() {
        int x = Integer.parseInt(tv1.getText().toString())+1;
        tv1.setText(String.valueOf(x));
        tv1.postDelayed(this, 1000);
    }
}
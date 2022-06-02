package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{

    private TextView tv1;
    private long suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
    }

    public void sumar(View v){
        tv1.setText("Calculando");
        Thread hilo = new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {
        suma=0;
        for(int i =1; i<=20000000;i++){
            suma+=i;
        }
        tv1.post(new Runnable() {
            @Override
            public void run() {
                tv1.setText("Resultado: "+suma);
            }
        });

    }
}
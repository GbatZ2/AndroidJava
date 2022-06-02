package com.example.runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable {

    private TextView tv1;
    private int resultado = 0;
    private boolean procesando = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
    }

    public void sumar(View v){
        if(procesando == false){
            procesando =true;
            tv1.setText("Calculando");
            Thread hilo = new Thread(this);
            hilo.start();
        }

    }

    @Override
    public void run() {
        resultado =0;
        for(int i =0; i<50000000; i++){
            resultado +=i;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv1.setText("La suma es: "+resultado);
                procesando = false;
            }
        });
    }
}
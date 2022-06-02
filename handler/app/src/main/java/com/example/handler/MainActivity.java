package com.example.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tv1,tv2;
    private EditText edt1;
    private Handler controlador = new Handler(Looper.getMainLooper());
    private Runnable tiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        edt1 = findViewById(R.id.editTextTextPassword);

        controlador.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv1.setText("Pasaron 3 segundos.");
            }
        },3000);
        controlador.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv1.setText("Pasaron 6 segundos.");
            }
        },6000);
        controlador.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv1.setText("Pasaron 9 segundos.");
            }
        },9000);
        tiempo = new Runnable() {
            @Override
            public void run() {
                int valor = Integer.parseInt(tv2.getText().toString());
                if(valor==0){
                    finish();
                }else{
                    valor-=1;
                    tv2.setText(String.valueOf(valor));
                    controlador.postDelayed(this, 1000);
                }
            }
        };
        controlador.postDelayed(tiempo, 0);
    }
    public void ingresar(View v){
        if(edt1.getText().toString().equals("123456")){
            controlador.removeCallbacks(tiempo);
        }
    }
}
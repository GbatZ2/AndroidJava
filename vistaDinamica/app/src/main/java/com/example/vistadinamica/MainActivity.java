package com.example.vistadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout= findViewById(R.id.layout);
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);



        for(int i = 1; i<=dia; i++){
            Button boton = new Button(this);
            boton.setText("Dia: "+i);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button bt = (Button) v;
                    Toast.makeText(MainActivity.this, bt.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(boton);
        }
    }
}
package com.example.stringxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edt1,edt2;
    private RadioButton rb1,rb2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.editTextTextPersonName);
        edt2 = findViewById(R.id.editTextTextPersonName2);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        tv1 = findViewById(R.id.textView);
    }
    public void operar(View v){
        int valor1 = Integer.parseInt(edt1.getText().toString()), valor2 = Integer.parseInt(edt2.getText().toString());
        int resultado=0;

        if(rb1.isChecked()){
            resultado = valor1 + valor2;
        }else if(rb2.isChecked()){
            resultado = valor1 - valor2;
        }
        tv1.setText("Resultado = " +resultado);

    }
}
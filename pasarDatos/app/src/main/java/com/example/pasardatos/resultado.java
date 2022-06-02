package com.example.pasardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultado extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        tv1 = findViewById(R.id.tvResultado);
        Bundle datos = getIntent().getExtras();
        int valor1 = datos.getInt("valor1");
        int valor2 = datos.getInt("valor2");
        int resultado = datos.getInt("resultado");
        String operacion = datos.getString("operacion");
        String signo="";
        if(operacion.equalsIgnoreCase("Sumar")){
            signo ="+";
        }else if(operacion.equalsIgnoreCase("Restar")){
            signo ="-";
        }else if(operacion.equalsIgnoreCase("Multiplicar")){
            signo ="*";
        }else if(operacion.equalsIgnoreCase("Dividir")){
            signo ="/";
        }
        tv1.setText("Operacion: "+valor1+" "+signo+" " +valor2+" = "+resultado);

    }
    public void retornar(View v){
        finish();
    }
}
package com.example.pasardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    EditText edt1, edt2;
    Spinner sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.editTextNumber2);
        edt2 = findViewById(R.id.editTextNumber3);
        sp = findViewById(R.id.spinner);
        String [] operaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        sp.setAdapter(adaptador);
    }

    public void resultado(View v){
        Intent inte = new Intent(this, resultado.class);
        int valor1 = Integer.parseInt(edt1.getText().toString());
        int valor2 = Integer.parseInt(edt2.getText().toString());
        int resultado=0;


        if(sp.getSelectedItem().equals("Sumar")){
            resultado = valor1 + valor2;
        }
        if(sp.getSelectedItem().equals("Restar")){
            resultado = valor1 - valor2;
        }
        if(sp.getSelectedItem().equals("Multiplicar")){
            resultado = valor1 * valor2;
        }
        if(sp.getSelectedItem().equals("Dividir")){
            resultado = valor1 / valor2;
        }
        inte.putExtra("valor1", valor1 );
        inte.putExtra("valor2", valor2 );
        inte.putExtra("resultado", resultado );
        inte.putExtra("operacion", sp.getSelectedItem().toString());

        startActivity(inte);

    }
}
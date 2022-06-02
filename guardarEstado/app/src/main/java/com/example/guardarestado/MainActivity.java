package com.example.guardarestado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    TextView tv1;
    int resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName2);
        tv1 = findViewById(R.id.tv);
    }

    public void sumar(View v){
        resultado = (Integer.parseInt(ed1.getText().toString() + Integer.parseInt(ed2.getText().toString())));
        tv1.setText(String.valueOf(resultado));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Valor", resultado);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultado = savedInstanceState.getInt("Valor");
        tv1.setText(String.valueOf(resultado));
    }
}
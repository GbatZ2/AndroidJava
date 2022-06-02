package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt1 ,edt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.editTextTextMultiLine);
    }

    public void guardar(View v) {
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String fecha = edt1.getText().toString();
        String actividad = edt2.getText().toString();
        editor.putString(fecha, actividad);
        editor.commit();
        edt1.setText("");
        edt2.setText("");
    }
    public void cargar(View v){
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = sp.getString(edt1.getText().toString(), "");
        if(datos.equals("")){
            Toast.makeText(this, "No hay actividades para dicha fecha.",Toast.LENGTH_SHORT).show();
        }else{
            edt2.setText(datos);
        }
    }
}
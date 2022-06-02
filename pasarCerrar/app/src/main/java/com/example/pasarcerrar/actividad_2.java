package com.example.pasarcerrar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class actividad_2 extends AppCompatActivity {

    EditText edt1,edt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);


    }
    public void confirmar(View v){
        Intent int1 = new Intent();
        int1.putExtra("nombre", edt1.getText().toString());
        int1.putExtra("contraseña", edt2.getText().toString());
        setResult(Activity.RESULT_OK, int1);
        finish();
    }
    public void cancerlar(View v){

        Intent int1 = new Intent();
        setResult(Activity.RESULT_CANCELED, int1);
        finish();
    }
}
package com.example.alert_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch sw1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw1 = findViewById(R.id.datos);
    }
    public void activarDatos(View v){
        if(sw1.isChecked()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Quieres activar los datos moviles?");
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Se activaron los datos moviles", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    sw1.setChecked(false);
                    Toast.makeText(MainActivity.this, "No se activaron los datos moviles", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        }
    }
}
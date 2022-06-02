package com.example.dialogs2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tvDia);
        tv2 = findViewById(R.id.tvMeses);
        tv3 = findViewById(R.id.tvHora);

    }
    public void seleccionarDia(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione el dia de la semana:");

        String [] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        builder.setItems(dias, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("Dias: "+ dias[which]);
            }
        });
        builder.create().show();
    }
    public void seleccionarMeses(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione un Mes:");
        String [] meses={"Enero", "Febrero" ,"Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre","Octubre" ,"Noviembre", "Diciembre"};
        boolean [] checks = new boolean[12];
        builder.setMultiChoiceItems(meses, checks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String todo ="";
                for(int i =0; i<checks.length; i++){
                    if(checks[i]==true){
                        todo += " "+meses[i];
                    }
                }
                tv2.setText("Meses: "+todo);
            }
        });
            builder.setPositiveButton("Confirmar" , null);
            builder.create().show();
    }

    public void seleccionarHora(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione una hora");
        String [] horas  ={"8:30", "9:30", "10:30", "11:30", "12:30", "13:30"};
        builder.setSingleChoiceItems(horas, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv3.setText("Hora: "+horas[which]);
            }
        });
        builder.setPositiveButton("Aceptar", null);
        builder.create().show();
    }

}
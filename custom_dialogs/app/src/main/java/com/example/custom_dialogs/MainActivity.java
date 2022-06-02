package com.example.custom_dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void seleccionarColor(View  v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Seleccione un color:");
        View selector = getLayoutInflater().inflate(R.layout.color_dialogo, null);
        builder.setView(selector);
        View vistaColor  = selector.findViewById(R.id.view2);
        SeekBar sb1 = selector.findViewById(R.id.seekBar1);
        SeekBar sb2 = selector.findViewById(R.id.seekBar2);
        SeekBar sb3 = selector.findViewById(R.id.seekBar3);
        TextView tv1 = selector.findViewById(R.id.tvRojo);
        TextView tv2 = selector.findViewById(R.id.tvAzul);
        TextView tv3 = selector.findViewById(R.id.tvVerde);
        vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(),sb2.getProgress(),sb3.getProgress()));
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
                tv1.setText("Rojo: "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
                tv2.setText("Verde: "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
               tv3.setText("Azul: "+progress);
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Button b1 = findViewById(R.id.btnColor);
                b1.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
            }
        });

        builder.create().show();
    }
}
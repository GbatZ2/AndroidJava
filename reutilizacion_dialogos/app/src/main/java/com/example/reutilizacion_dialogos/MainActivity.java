package com.example.reutilizacion_dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void borrar(View v){
        EditText edt1 = findViewById(R.id.edt1);
        dialogoMensaje dialogo = new dialogoMensaje("Desea borrar el mensaje introducido");
        dialogo.show(getSupportFragmentManager(),"dialogo 1");
        dialogo.procesarRespuesta(new dialogoMensaje.Respuestas() {
            @Override
            public void confirmar(DialogFragment dialog) {
                edt1.setText("");
            }

            @Override
            public void cancelar(DialogFragment dialog) {

            }
        });
    }
    public void salir(View v){
        dialogoMensaje dialogo = new dialogoMensaje("Desea Salir?");
        dialogo.show(getSupportFragmentManager(),"dialogo 2");
        dialogo.procesarRespuesta(new dialogoMensaje.Respuestas() {
            @Override
            public void confirmar(DialogFragment dialog) {
                finish();
            }

            @Override
            public void cancelar(DialogFragment dialog) {

            }
        });
    }
}


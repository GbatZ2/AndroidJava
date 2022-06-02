package com.example.grabar_texto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {


    EditText edt1, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.editTextTextMultiLine);
    }

    public void crear(View v){
        String nombreArchivo = edt1.getText().toString();
        String contenido = edt2.getText().toString();

        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombreArchivo, Context.MODE_PRIVATE));
            archivo.write(contenido);
            archivo.flush();
            archivo.close();
            edt1.setText("");
            edt2.setText("");
            Toast.makeText(this, "Archivo creado", Toast.LENGTH_SHORT).show();
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
    public void recuperar(View v){
        String nombreArchivo = edt1.getText().toString();
        try{
            InputStreamReader archivo = new InputStreamReader(openFileInput(nombreArchivo));
            BufferedReader reader =    new BufferedReader(archivo);
            String linea="";
            while((linea=reader.readLine())!=null){
                edt2.setText(linea);
            }
            reader.close();
            archivo.close();

        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
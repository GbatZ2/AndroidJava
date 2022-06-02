package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner sp1;
    private TextView tv3;
    private EditText edt1, edt2;
    private String[] operaciones = {"sumar", "dividir", "restar", "multiplicar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = findViewById(R.id.spinner1);
        tv3 = findViewById(R.id.tv3);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        ArrayAdapter<String> adapatador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        sp1.setAdapter(adapatador);
    }
    public void operar(View v){
        int val1 = Integer.parseInt(edt1.getText().toString());
        int val2 = Integer.parseInt(edt2.getText().toString());
        String operacion = sp1.getSelectedItem().toString();
       if(edt1.getText().length()>0 && edt2.getText().length()>0){
           if(operacion.equals("sumar")){

               tv3.setText(""+ (val1 +val2));

           }else if(operacion.equals("restar")){
               tv3.setText(""+ (val1 - val2));
           }else if(operacion.equals("multiplicar")){
               tv3.setText(""+ (val1 * val2));
           }else if(operacion.equals("dividir")){
               tv3.setText(""+ (val1 / val2));
           }

       }

    }
}
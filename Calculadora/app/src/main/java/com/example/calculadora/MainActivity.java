package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView tv1;
    private RadioButton rb1, rb2, rb3, rb4;
    private EditText edt1, edt2;
    private CheckBox cb1, cb2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);


    }

    public void addCb1(){
        if(edt1.getText().length()==0){
            edt1.setText(""+5);
        }else{
            int result;
            result = Integer.parseInt((edt1.getText().toString())) + 5;
            edt1.setText(""+result);
        }

    }
    public void addCb2(){
        if(edt2.getText().length()==0){
            edt2.setText(""+5);
        }else{
            int result;
            result = Integer.parseInt((edt2.getText().toString())) + 5;
            edt2.setText(""+result);
        }

    }

    public void operaciones(View v){

        if(cb1.isChecked() && cb2.isChecked()){
            addCb1();
            addCb2();
        }else if(cb1.isChecked()){
            addCb1();
        }else if(cb2.isChecked()){
            addCb2();
        }


        if(edt1.getText().length()>0 && edt2.getText().length()>0){
            if(rb1.isChecked()){
                sumar();
            }else if(rb2.isChecked()){
                restar();
            }else if(rb3.isChecked()){
                multiplicar();
            }else if(rb4.isChecked()){
                dividir();
            }else{
                Toast.makeText(this, "Seleccione una operación a realizar", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Introduzca dos valores correctos.", Toast.LENGTH_SHORT).show();
        }

}

    public void sumar(){
        int  res;
        res = Integer.parseInt(edt1.getText().toString()) + Integer.parseInt(edt2.getText().toString());
        tv1.setText("La suma es: "+res);


    }
    public void restar(){
        int  res;
        res = Integer.parseInt(edt1.getText().toString()) - Integer.parseInt(edt2.getText().toString());
        tv1.setText("La resta es: "+res);

    }
    public void multiplicar(){
        int  res;
        res = Integer.parseInt(edt1.getText().toString()) * Integer.parseInt(edt2.getText().toString());
        tv1.setText("La multiplicacion es: "+res);

    }
    public void dividir(){
        int  res;
        res = Integer.parseInt(edt1.getText().toString()) / Integer.parseInt(edt2.getText().toString());
        tv1.setText("La division es: "+res);

    }
}
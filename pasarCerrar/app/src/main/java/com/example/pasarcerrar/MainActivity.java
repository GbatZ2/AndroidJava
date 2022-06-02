package com.example.pasarcerrar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);



    }



    public void login(View v){

        Intent inten = new Intent(this, actividad_2.class);
        startActivityForResult(inten, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            if(resultCode == Activity.RESULT_OK){
                Bundle datos = data.getExtras();
                tv1.setText(datos.getString("nombre"));
            }

            if(resultCode == Activity.RESULT_CANCELED){
                tv1.setText("Actividad Cancelada");
            }
        }
    }
}
package com.example.activityprocesadorexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

     EditText edt1;
     WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.editTextTextPersonName2);
        wv1 = findViewById(R.id.wv1);

        Bundle datos = getIntent().getExtras();
        if(datos!=null){
            edt1.setText(datos.getString("direccion"));
        }

        wv1.loadUrl(edt1.getText().toString());

    }
}
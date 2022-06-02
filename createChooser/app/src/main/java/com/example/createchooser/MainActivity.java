package com.example.createchooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.editTextTextPersonName);
    }

    public void abrir(View v){
        Intent inte = new Intent(Intent.ACTION_VIEW);
        inte.setData(Uri.parse("https://www.google.es/?gfe_rd=cr&ei=HG8xU9CqIO7Q8geVh4GIDQ"));
        startActivity(inte);
    }
    public void compartir(View v){
        Intent inte = new Intent(Intent.ACTION_SEND);
        inte.setType("text/plain");
        inte.putExtra(Intent.EXTRA_TEXT, edt1.getText().toString());
        Intent eleccion = Intent.createChooser(inte, "¿Que desea utilizar?");
        startActivity(eleccion);
    }

}
package com.example.emailimplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText tv1, tv2, tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.editTextTextEmailAddress);
        tv2 = findViewById(R.id.editTextTextPersonName);
        tv3 = findViewById(R.id.editTextTextMultiLine);
    }

    public void enviar(View v){
        Intent inte = new Intent(Intent.ACTION_SENDTO);
        inte.setData(Uri.parse("mailto:"));
        inte.putExtra(Intent.EXTRA_EMAIL, new String[]{tv1.getText().toString()});
        inte.putExtra(Intent.EXTRA_SUBJECT,tv2.getText().toString());
        inte.putExtra(Intent.EXTRA_TEXT,tv3.getText().toString());
        startActivity(inte);

    }
}
package com.example.intentexplicitoeimplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abrirNavegador(View v){
        Intent inte = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.es/?gfe_rd=cr&ei=HG8xU9CqIO7Q8geVh4GIDQ"));
        startActivity(inte);
    }
    public void abrirMapa(View v){
        Intent inte = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:-31.417, -64.183"));
        startActivity(inte);
    }
    public void contactos(View v){
        Intent inte = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
        startActivity(inte);
    }
    public void camara(View v){
        Intent inte = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(inte);
    }
    public void marcador(View v){
        Intent inte = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:123456789"));
        startActivity(inte);
    }
    public void sms(View v){
        Intent inte = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:123456789"));
        startActivity(inte);
    }
}
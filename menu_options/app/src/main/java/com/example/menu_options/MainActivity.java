package com.example.menu_options;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_de_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int numero = item.getItemId();
        float valor;
        switch (numero){
            case R.id.mnt1:
                valor = tv1.getTextSize();
                valor +=20;
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX,valor);
                return true;

            case R.id.mnt2:
                valor = tv1.getTextSize();
                valor -=10;
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX,valor);
                return true;

            case R.id.mnt3:
                finish();
                return true;

            case R.id.subMenu:
                tv1.setTextColor(Color.RED);
                return true;

            case R.id.submenu2:
                tv1.setTextColor(Color.GREEN);
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }

    }
}
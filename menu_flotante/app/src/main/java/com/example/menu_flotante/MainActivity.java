package com.example.menu_flotante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        registerForContextMenu(edt1);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int numero = item.getItemId();
        switch(numero){
            case R.id.mayus:
                edt1.setText(edt1.getText().toString().toUpperCase(Locale.ROOT));
                return true;

            case R.id.minus:
                edt1.setText(edt1.getText().toString().toLowerCase(Locale.ROOT));
                return true;
        }

        return super.onContextItemSelected(item);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_flotante, menu);
    }
}
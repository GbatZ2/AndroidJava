package com.example.menu_popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.imageView);
    }

    public void mostrarPopUp(View v){
        PopupMenu pMenu = new PopupMenu(this, img1);
        pMenu.getMenuInflater().inflate(R.menu.menu_popup, pMenu.getMenu());
        pMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

             switch (item.getItemId()){
                 case R.id.help1:
                     Toast.makeText(MainActivity.this, "ayuda 1", Toast.LENGTH_SHORT).show();
                     return true;
                 case R.id.help2:
                     Toast.makeText(MainActivity.this, "Ayuda 2", Toast.LENGTH_SHORT).show();
                     return true;
             }
                return false;
            }
        });
        pMenu.show();
    }
}
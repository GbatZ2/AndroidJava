package com.example.fotointent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView);
    }

    final int CAPTURA_IMAGEN =1;
    public void tomar(View v){
        Intent inte = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(inte, CAPTURA_IMAGEN );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAPTURA_IMAGEN && resultCode==RESULT_OK ){
            Bundle extras = data.getExtras();
            Bitmap bt1 = (Bitmap) extras.get("data");
            img.setImageBitmap(bt1);
            try{
                FileOutputStream ouput = openFileOutput(crearNombreArchivo(), Context.MODE_PRIVATE);
                bt1.compress(Bitmap.CompressFormat.JPEG, 100, ouput);
                ouput.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {

            }
        }
    }

    private String crearNombreArchivo() {
        String fecha = new SimpleDateFormat("yyyymmdd_hhmmss").format(new Date());
        return fecha+".jpg";
    }
    public void verFotos(View v){
        Intent inte = new Intent(this,actividad2.class);
        startActivity(inte);
    }

}
package com.example.fotointent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class actividad2 extends AppCompatActivity {

    RecyclerView rcv;
    String[] archivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        archivos = fileList();
        rcv = findViewById(R.id.recyclerView);
        LinearLayoutManager lym = new LinearLayoutManager(this);
        rcv.setLayoutManager(lym);
        rcv.setAdapter(new adaptadorFotos());
    }

    private class adaptadorFotos extends RecyclerView.Adapter<adaptadorFotos.adaptadorFotosHolder> {

        @NonNull
        @Override
        public adaptadorFotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new adaptadorFotosHolder(getLayoutInflater().inflate(R.layout.layout_foto, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull adaptadorFotosHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return archivos.length;
        }

        public class adaptadorFotosHolder extends RecyclerView.ViewHolder  {
            ImageView img;
            TextView tv1;
            public adaptadorFotosHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.imageView2);
                tv1 = itemView.findViewById(R.id.textView);
            }

            public void imprimir(int position) {
                tv1.setText("Nombre del archivo: "+archivos[position]);
                try{
                    FileInputStream input = openFileInput(archivos[position]);
                    Bitmap btm = BitmapFactory.decodeStream(input);
                    img.setImageBitmap(btm);
                    input.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
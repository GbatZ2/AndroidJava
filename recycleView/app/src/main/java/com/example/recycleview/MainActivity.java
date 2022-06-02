package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


     String[] frutas = {"manzana", "banana", "melocoton", "naranja", "sandia"};
     double[] precio = {2.5,3.5, 1.25, 1.00, 2.00};
     int[] images = {R.drawable.apple, R.drawable.banana, R.drawable.melocoton, R.drawable.orange, R.drawable.sandia};
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rView);
        LinearLayoutManager linearLayour = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayour);
        rv.setAdapter(new AdaptadorFruta());
    }

    class AdaptadorFruta extends RecyclerView.Adapter<AdaptadorFruta.AdapatadorFrutaHolder>{


        @NonNull
        @Override
        public AdapatadorFrutaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapatadorFrutaHolder(getLayoutInflater().inflate(R.layout.fruits_layout, parent , false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdapatadorFrutaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return frutas.length;
        }

        private class AdapatadorFrutaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView tv1, tv2;
            ImageView imv1;
            public AdapatadorFrutaHolder(@NonNull View itemView) {
                super(itemView);
                tv1 = itemView.findViewById(R.id.textView);
                tv2 = itemView.findViewById(R.id.textView2);
                imv1 = itemView.findViewById(R.id.imageView);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                imv1.setImageResource(images[position]);
                tv1.setText("Nombre:" + frutas[position]);
                tv2.setText("Precio:" + precio[position]);
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Nombre: "+ frutas[getLayoutPosition()], Toast.LENGTH_SHORT
                ).show();
            }
        }

    }
}
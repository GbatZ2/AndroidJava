package com.example.cardview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;

    String [] nombres = {"Carlao","Carlao","Carlao","Carlao", "Carlao","Carlao"};
    int [] fotos = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
    String [] profesiones = {"Musico","Musico","Musico","Musico", "Musico","Musico"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);

        LinearLayoutManager lym = new LinearLayoutManager(this);
        rcv.setLayoutManager(lym);

        rcv.setAdapter(new AdaptadorPersona());
    }

    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {

        @NonNull
        @Override
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.layout_card, parent, false));
        }

        @Override
        public int getItemCount() {
            return fotos.length;
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {
                holder.imprimir(position);
        }

        private class AdaptadorPersonaHolder extends RecyclerView.ViewHolder {

            ImageView img;
            TextView tv1, tv2;
            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);

                img = itemView.findViewById(R.id.imageView7);
                tv1 = itemView.findViewById(R.id.textView3);
                tv2 = itemView.findViewById(R.id.textView4);


            }

            public void imprimir(int position) {
                img.setImageResource(fotos[position]);
                tv1.setText("Nombre: "+nombres[position]);
                tv2.setText("Profesion: "+profesiones[position]);

            }
        }


    }
}
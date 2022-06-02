package com.example.view_pager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String [] paises ={"Argentina", "Colombia", "España", "EEUU", "Peru"};
    private int [] imagenes = {R.drawable.argentina, R.drawable.colombia,R.drawable.espana, R.drawable.estados_unidos_de_america, R.drawable.peru};
    ViewPager2 vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        vp.setAdapter(new AdaptadorPaises());
    }

    private class AdaptadorPaises extends RecyclerView.Adapter<AdaptadorPaises.AdaptadorPaisHolder> {


        @NonNull
        @Override
        public AdaptadorPaisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPaisHolder(getLayoutInflater().inflate(R.layout.layout_flags, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPaisHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return paises.length;
        }

        class AdaptadorPaisHolder extends  RecyclerView.ViewHolder {
            ImageView img1;
            TextView tv1;

            public AdaptadorPaisHolder(@NonNull View itemView) {
                super(itemView);
                img1 = itemView.findViewById(R.id.ivPais);
                tv1 = itemView.findViewById(R.id.tvPais);
            }
            public void imprimir(int position){
                img1.setImageResource(imagenes[position]);
                tv1.setText(paises[position]);
            }
        }
    }
}
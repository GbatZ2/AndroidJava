package com.example.tablayout_viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves","Viernes","Sabado","Domingo"};
    private String[] actividades = {"","","","","","",""};

     ViewPager2 vp;
     TabLayout tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp  = findViewById(R.id.vp2);
        tb = findViewById(R.id.tbLayout);

        vp.setAdapter(new AdaptarAgenda());
        TabLayoutMediator tlm  = new TabLayoutMediator(tb, vp, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(dias[position]);
            }
        });
        tlm.attach();
    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("actividades", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        for(int i = 0; i< dias.length;i++){
                editor.putString(dias[i], actividades[i]);
        }
        editor.commit();
    }

    private class AdaptarAgenda extends RecyclerView.Adapter<AdaptarAgenda.AdaptarAgendaHolder> {

        @NonNull
        @Override
        public AdaptarAgendaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptarAgendaHolder(getLayoutInflater().inflate(R.layout.layout_days, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptarAgendaHolder holder, int position) {
                holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return dias.length;
        }

        public class AdaptarAgendaHolder extends  RecyclerView.ViewHolder {

            EditText edt2;

            public AdaptarAgendaHolder(@NonNull View itemView) {
                super(itemView);

                edt2 = itemView.findViewById(R.id.edtActividades);
                edt2.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        actividades[getLayoutPosition()] = edt2.getText().toString();
                        return false;
                    }
                });

            }

            public void imprimir(int position) {
                edt2.setText(actividades[position]);
            }
        }
    }
}
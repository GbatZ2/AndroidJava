package com.example.recyclerview2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ArrayList<Persona> personas ;

    RecyclerView rv;
    EditText etv1;
    EditText etv2;
    AdaptadorPersona ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyclerView);
        etv1 = findViewById(R.id.tv1);
        etv2 =  findViewById(R.id.tv2);
         personas = new ArrayList<Persona>();
         personas.add(new Persona("Carlao1","65874456"));
         personas.add(new Persona("Carlao2","65874456"));
         personas.add(new Persona("Carlao3","65874456"));
         personas.add(new Persona("Carlao4","65874456"));
         personas.add(new Persona("Carlao5","65874456"));
         personas.add(new Persona("Carlao6","65874456"));
         personas.add(new Persona("Carlao7","65874456"));
         personas.add(new Persona("Carlao8","65874456"));

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayout);
        ap = new AdaptadorPersona();
        rv.setAdapter(ap);

    }


    public void agregar(View v){
            personas.add(new Persona(etv1.getText().toString(), etv2.getText().toString()));
            etv1.setText("");
            etv2.setText("");
            ap.notifyDataSetChanged();
            rv.scrollToPosition(personas.size()-1);
    }
    public void eliminar(View v){
        int pos=-1;
        for(int i =0; i< personas.size(); i++){
            if(personas.get(i).getNombre().equals(etv1.getText().toString()) && personas.get(i).getTelefono().equals(etv2.getText().toString())){
                pos = i;
            }
        }
        if(pos!=-1){
            personas.remove(pos);
            ap.notifyDataSetChanged();
            etv1.setText("");
            etv2.setText("");
            Toast.makeText(MainActivity.this,
                    "Se elimino a la persona",
                    Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(MainActivity.this,
                    "No se pudo eliminar a la persona.",
                    Toast.LENGTH_SHORT).show();
        }



    }
    public void mostrar(int posicion){
        etv1.setText(personas.get(posicion).getNombre());
        etv2.setText(personas.get(posicion).getTelefono());
    }
    public class AdaptadorPersona  extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {
        @NonNull
        @Override
        public AdaptadorPersona.AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.persona_layout,parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersona.AdaptadorPersonaHolder holder, int position) {
            holder.imprimir(position);
        }



        @Override
        public int getItemCount() {
            return personas.size();
        }

        public class AdaptadorPersonaHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
            TextView tv1, tv2;

            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);
                tv1 = itemView.findViewById(R.id.tv1);
                tv2 = itemView.findViewById(R.id.tv2);
                itemView.setOnClickListener(this);
            }
            private void imprimir(int position) {
                Persona p1 = (Persona) personas.get(position);
                tv1.setText("Nombre: "+p1.getNombre());
                tv2.setText("Telefono: "+p1.getTelefono());
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Nombre: "+ personas.get(getLayoutPosition()).getNombre(),
                        Toast.LENGTH_SHORT).show();
                mostrar(getLayoutPosition());

            }
        }
    }
}
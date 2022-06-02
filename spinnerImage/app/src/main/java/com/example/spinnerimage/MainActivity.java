package com.example.spinnerimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String [] paises = {"España", "Brasil", "Estados Unidos", "Reino Unido"};
    int[] banderas = {R.drawable.espana,R.drawable.brasil,R.drawable.estados_unidos,R.drawable.reino_unido};
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = findViewById(R.id.spinner);
        PaisesAdapter adaptador = new PaisesAdapter();
        sp.setAdapter(adaptador);
    }

    public void recuperar(View v){
        Toast.makeText(this, sp.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    class PaisesAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return paises.length;
        }

        @Override
        public Object getItem(int position) {
            return paises[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertView = inflater.inflate(R.layout.layout, null);
            ImageView iv1 = convertView.findViewById(R.id.imageView);
            TextView tv1 = convertView.findViewById(R.id.tvPais);
            iv1.setImageResource(banderas[position]);
            tv1.setText(paises[position]);
            return convertView;
        }
    }
}
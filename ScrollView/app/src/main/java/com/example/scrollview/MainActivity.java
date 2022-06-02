package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton img1, img2, img3, img4, img5;
    private TextView v1;
     String pais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = findViewById(R.id.textView);

        img1 = findViewById(R.id.imageButton3);
        img2 = findViewById(R.id.imageButton4);
        img3 = findViewById(R.id.imageButton5);
        img4 = findViewById(R.id.imageButton6);
        img5 = findViewById(R.id.imageButton7);




        int numero = (int) (Math.random()*4);
        switch(numero){
            case 1:
                    pais = "Anguila";
                break;
            case 2:
                pais  = "Barbados";
                break;
            case 3:
                pais = "Bermudas";
                break;
            case 4:
                pais="Banglades";
                break;
            case 5:
                pais="Andorra";
                break;
        }
        v1.setText("Cual es la bandera de : "+pais);
    }
public void presion(View v){
    ImageButton Ib= (ImageButton) v;
    if(Ib.getTag().toString().equalsIgnoreCase(pais)){
        Toast.makeText(this, "Bandera Correcta " + pais, Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(this, "Bandera inCorrecta " + Ib.getTag().toString(), Toast.LENGTH_SHORT).show();
    }
}

}


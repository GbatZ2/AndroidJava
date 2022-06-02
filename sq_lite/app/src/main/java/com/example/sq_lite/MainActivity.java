package com.example.sq_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2,edt3,edt4;
    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        admin = new AdminSQLiteOpenHelper(this, "bd1",null,1);

    }
    public void agregar(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("patente",edt1.getText().toString());
        registro.put("marca",edt2.getText().toString());
        registro.put("modelo",edt3.getText().toString());
        registro.put("precio",edt4.getText().toString());
        bd.insert("vehiculos", null,registro);
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
        bd.close();
    }

    public void consultar(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patente = edt1.getText().toString();
        Cursor fila = bd.rawQuery("select marca,modelo,precio from vehiculos where patente ='"+patente+"'", null);
        if (fila.moveToFirst()) {
            edt2.setText(fila.getString(0 ));
            edt3.setText(fila.getString( 1));
            edt4.setText(fila.getString(2 ));
        }
        else{
            Toast.makeText(this, "No existe el vehiculo", Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void borrar(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patente = edt1.getText().toString();
        int cant = bd.delete("vehiculos", "patente='"+patente+"'", null);
        if(cant>0){
            Toast.makeText(this, "Se elimino el vehiculo"+patente, Toast.LENGTH_SHORT).show();
            edt1.setText("");
        }else{
            Toast.makeText(this, "No se pudo eliminar el vehiculo", Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }
    public void modificar(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patente = edt1.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("marca",edt2.getText().toString());
        registro.put("modelo",edt3.getText().toString());
        registro.put("precio",edt4.getText().toString());


        int ctd = bd.update("vehiculos", registro,"patente='"+patente+"'", null);

        if(ctd>0)
            Toast.makeText(this, "Se actualizo el vehiculo"+patente, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No se actualizo el vehiculo"+patente, Toast.LENGTH_SHORT).show();

        bd.close();
    }

}
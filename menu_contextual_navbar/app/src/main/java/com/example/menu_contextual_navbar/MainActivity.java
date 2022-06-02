package com.example.menu_contextual_navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    EditText edt1;
    ActionMode actMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.editTextTextPersonName);


        edt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(actMode!=null) {
                    return true;
                }
                actMode = startSupportActionMode(amc);
                return true;
            }
        });
    }
    ActionMode.Callback amc = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_flontate, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId()){
                case R.id.mayus:
                    edt1.setText(edt1.getText().toString().toUpperCase(Locale.ROOT));
                    mode.finish();
                    return true;

                case R.id.minus:
                    edt1.setText(edt1.getText().toString().toLowerCase(Locale.ROOT));
                    mode.finish();
                    return true;
            }


            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actMode = null;
        }
    };
}
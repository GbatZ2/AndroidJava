package com.example.grabarvideointent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final int CAPTURA_VIDEO = 1;
    private VideoView vv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vv1 = findViewById(R.id.videoView);
    }

    public void grabar(View v){
        Intent inte = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(inte,CAPTURA_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAPTURA_VIDEO && resultCode == RESULT_OK){

            Uri videoUri = data.getData();
            vv1.setVideoURI(videoUri);
            vv1.start();

        }
    }
}
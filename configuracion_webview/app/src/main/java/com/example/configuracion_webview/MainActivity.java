package com.example.configuracion_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView wv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv1 = findViewById(R.id.webView);
        wv1.setWebViewClient(new WebViewClient());
        WebSettings wSettings = wv1.getSettings();
        wSettings.setJavaScriptEnabled(true);
        wSettings.setDefaultFontSize(10);
       //* wv1.loadUrl("https://www.google.es/?gfe_rd=cr&ei=HG8xU9CqIO7Q8geVh4GIDQ");
        wv1.loadUrl("file:///android_asset/index.html");

    }
    public void retroceder(View v){
        wv1.goBack();
    }
    public void sumar(View v){
        wv1.zoomIn();
    }
    public void restar(View v){
        wv1.zoomOut();
    }
}
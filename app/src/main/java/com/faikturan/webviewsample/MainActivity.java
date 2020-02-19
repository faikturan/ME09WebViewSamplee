package com.faikturan.webviewsample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = findViewById(R.id.webView1);

        webView.getSettings().setJavaScriptEnabled(true);


        final ProgressDialog progressDialog = ProgressDialog.show(this, "JAVA & ANDROID",
                "Sayfa Yükleniyor...", true);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(getApplicationContext(),"Sayfa Yüklenemedi.",
                        Toast.LENGTH_LONG).show();
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });

        webView.loadUrl("http://faikturan.com/tr/");
        
    }
}

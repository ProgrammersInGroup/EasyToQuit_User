package com.easytoquit.easytoquit_user.Tips_Pdf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.easytoquit.easytoquit_user.R;

public class Tips_Pdf2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips__pdf2);

        WebView webview = (WebView) findViewById(R.id.t_pdf2_webview);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "https://drive.google.com/file/d/1YJpKlKPwWW3MexadATrKHby8t2xhwcPP/view";
        //https://drive.google.com/file/d/1YJpKlKPwWW3MexadATrKHby8t2xhwcPP/view
        webview.loadUrl(pdf);
        setTitle("戒菸方法介紹");
    }
}

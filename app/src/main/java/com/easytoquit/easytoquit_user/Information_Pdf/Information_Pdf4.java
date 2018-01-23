package com.easytoquit.easytoquit_user.Information_Pdf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.easytoquit.easytoquit_user.R;


public class Information_Pdf4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information__pdf4);

        WebView webview = (WebView) findViewById(R.id.i_pdf4_webview);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "https://drive.google.com/file/d/1ukk_pJWHe691qbGpBlfPM8mYDrivKlDe/view";
        //https://drive.google.com/file/d/1ukk_pJWHe691qbGpBlfPM8mYDrivKlDe/view
        webview.loadUrl(pdf);
        setTitle("二手菸、三手菸的危害");
        //finish();
    }

    /*@Override
    protected void onStart(){
        super.onStart();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.i_content_frame4, new Information())
                .commit();
    }*/
}

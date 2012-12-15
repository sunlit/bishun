package com.sunlitjiang.bishun;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    @SuppressLint("SetJavaScriptEnabled")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        WebView myWebView = (WebView) findViewById(R.id.webview);
        
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
        	if (ConnectivityManager.TYPE_WIFI == activeNetworkInfo.getType()) {
        		webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        	} else {
        		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        	}
        	
        	myWebView.loadUrl("http://dianzu.duapp.com/?app=app.bishun.index&bd_user=0&bd_sig=640ea90c87ff97c0aed636f568ae383c&canvas_pos=platform");

        } else {
        	//report can not use network
        }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

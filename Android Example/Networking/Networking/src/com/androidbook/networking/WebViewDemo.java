package com.androidbook.networking;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;

public class WebViewDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        
        final TextSwitcher pageTitle = (TextSwitcher)findViewById(R.id.pagetitle);
        pageTitle.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
               TextView tv = new TextView(WebViewDemo.this);
               tv.setLayoutParams(new TextSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
               
                return tv;
            }
            
        });
        
        final ImageSwitcher favImage = (ImageSwitcher)findViewById(R.id.favicon);
        favImage.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                ImageView iv = new ImageView(WebViewDemo.this);
                iv.setBackgroundColor(0xFF000000);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
                return iv;
            }
            
        });
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        favImage.setInAnimation(in);
        favImage.setOutAnimation(out);
        pageTitle.setInAnimation(in);
        pageTitle.setOutAnimation(out);
        
        
        
        final EditText et = (EditText) findViewById(R.id.url);
        final WebView wv = (WebView) findViewById(R.id.web_holder);
        wv.loadUrl("http://www.perlgurl.org/");

        Button go = (Button) findViewById(R.id.go_button);
        go.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                wv.loadUrl(et.getText().toString());
            }

        });

        WebViewClient webClient = new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {

                super.onPageFinished(view, url);
                
               String title = wv.getTitle();
               pageTitle.setText(title);
                
            }
            
        };
        
        
        
        // this doesn't currently work... not sure why
        WebChromeClient webChrome = new WebChromeClient() {

 
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                favImage.setImageDrawable(new BitmapDrawable(icon));
            }
        };
        
        wv.setWebViewClient(webClient);
        wv.setWebChromeClient(webChrome);
       wv.setInitialScale(30);
    }

}

package com.androidbook.networking;

import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ThirdNetwork extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        
        final TextSwitcher status = (TextSwitcher) findViewById(R.id.status);
        status.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView tv = new TextView(ThirdNetwork.this);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(24);
                return tv;
            }
            
        });
        
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        status.setInAnimation(in);
        status.setOutAnimation(out);
        
        status.setText("<no status>");
        Button go = (Button) findViewById(R.id.do_action);
        go.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    URL text = new URL("http://api.flickr.com/services/feeds/photos_public.gne?id=26648248@N04&amp;lang=en-us&amp;format=atom");
                    
                    
                    XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
                    XmlPullParser parser = parserCreator.newPullParser();
                    
                    parser.setInput(text.openStream(), null);
                    
                    status.setText("Parsing...");
                    int parserEvent = parser.getEventType();
                    while (parserEvent != XmlPullParser.END_DOCUMENT) {
                        switch(parserEvent) {
                        case XmlPullParser.START_TAG:
                            String tag = parser.getName();
                            if (tag.compareTo("link") == 0) {
                                String relType = parser.getAttributeValue(null, "rel");
                                if (relType.compareTo("enclosure") == 0 ) {
                                    String encType = parser.getAttributeValue(null, "type");
                                    if (encType.startsWith("image/")) {
                                        String imageSrc = parser.getAttributeValue(null, "href");
                                        Log.i("Net", "image source = " + imageSrc);
                                    }
                                }
                            }
                            break;
                        }
                        
                        parserEvent = parser.next();
                       
                    }
                    status.setText("Done...");
                                      
                   
                } catch (Exception e) {
                    Log.e("Net", "Error in network call", e);
                }

            }

        });
    }


}

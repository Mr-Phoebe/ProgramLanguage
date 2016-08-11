package com.androidbook.networking;

import java.net.MalformedURLException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.AsyncTask;
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

public class FourthNetworkAsync extends Activity {
    TextSwitcher mStatus = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        mStatus = (TextSwitcher) findViewById(R.id.status);
        mStatus.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView tv = new TextView(FourthNetworkAsync.this);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(24);
                return tv;
            }

        });

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        mStatus.setInAnimation(in);
        mStatus.setOutAnimation(out);

        mStatus.setText("<no status>");
        Button go = (Button) findViewById(R.id.do_action);
        go.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    new ImageLoader().execute(new URL("http://api.flickr.com/services/feeds/photos_public.gne?id=26648248@N04&amp;lang=en-us&amp;format=atom"));
                } catch (MalformedURLException e) {
                    Log.e("Net", "Failed to generate URL");
                }
            }

        });

    }

    private class ImageLoader extends AsyncTask<URL, String, String> {

        @Override
        protected String doInBackground(URL... params) {
            // although this pattern takes more than one param, we'll just use
            // the first
            try {
                URL text = params[0];

                XmlPullParserFactory parserCreator;

                parserCreator = XmlPullParserFactory.newInstance();

                XmlPullParser parser = parserCreator.newPullParser();

                parser.setInput(text.openStream(), null);

                publishProgress("Parsing...");

                int imgCount = 0;
                int parserEvent = parser.getEventType();
                while (parserEvent != XmlPullParser.END_DOCUMENT) {
                    switch (parserEvent) {
                    case XmlPullParser.START_TAG:
                        String tag = parser.getName();
                        if (tag.compareTo("link") == 0) {
                            String relType = parser.getAttributeValue(null, "rel");
                            if (relType.compareTo("enclosure") == 0) {
                                String encType = parser.getAttributeValue(null, "type");
                                if (encType.startsWith("image/")) {
                                    String imageSrc = parser.getAttributeValue(null, "href");
                                    Log.i("Net", "image source = " + imageSrc);
                                    final int curImageCount = ++imgCount;
                                    publishProgress("imgCount = " + curImageCount);

                                }
                            }
                        }
                        break;
                    }

                    parserEvent = parser.next();
                }

            } catch (Exception e) {
                Log.e("Net", "Failed in parsing XML", e);
                return "Finished with failure.";
            }

            return "Done...";
        }

        protected void onCancelled() {
            Log.e("Net", "Async task Cancelled");
        }

        protected void onPostExecute(String result) {
            mStatus.setText(result);
        }

        protected void onPreExecute() {
            mStatus.setText("About to load URL");
        }

        protected void onProgressUpdate(String... values) {
            // just one value, please
            mStatus.setText(values[0]);
            super.onProgressUpdate(values);
        }
    }
}

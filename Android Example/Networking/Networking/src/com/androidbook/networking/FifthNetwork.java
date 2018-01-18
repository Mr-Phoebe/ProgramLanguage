package com.androidbook.networking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;

public class FifthNetwork extends Activity {
    private static final int IO_BUFFER_SIZE = 4 * 1024;

    Handler mHandler = new Handler();
    DelayedLooperThread imageThread = new DelayedLooperThread();
    private String title = "non";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        final TextSwitcher status = (TextSwitcher) findViewById(R.id.status);
        status.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView tv = new TextView(FifthNetwork.this);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(12);
                return tv;
            }

        });

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        status.setInAnimation(in);
        status.setOutAnimation(out);

        final TextSwitcher info = (TextSwitcher) findViewById(R.id.info);
        info.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView tv = new TextView(FifthNetwork.this);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(24);
                return tv;
            }

        });
        info.setInAnimation(in);
        info.setOutAnimation(out);

        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.images);
        imageSwitcher.setFactory(new ImageSwitcher.ViewFactory() {

            public View makeView() {
                ImageView iv = new ImageView(FifthNetwork.this);
                iv.setBackgroundColor(0xFF000000);
                iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
                return iv;
            }

        });
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        status.setText("<no status>");

        imageThread.start();

        Button go = (Button) findViewById(R.id.do_action);
        go.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread() {
                    public void run() {

                        try {
                            URL text = new URL("http://api.flickr.com/services/feeds/photos_public.gne?id=26648248@N04&amp;lang=en-us&amp;format=atom");

                            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
                            XmlPullParser parser = parserCreator.newPullParser();

                            parser.setInput(text.openStream(), null);

                            mHandler.post(new Runnable() {
                                public void run() {
                                    status.setText("Parsing...");
                                }
                            });
                            String tag;
                            boolean inTitle = false;
                            int imgCount = 0;
                            int parserEvent = parser.getEventType();
                            while (parserEvent != XmlPullParser.END_DOCUMENT) {

                                switch (parserEvent) {
                                case XmlPullParser.TEXT:
                                    if (inTitle) {
                                        title = parser.getText();
                                    }
                                    break;
                                case XmlPullParser.END_TAG:
                                    tag = parser.getName();
                                    if (tag.compareTo("title") == 0) {
                                        inTitle = false;
                                    }
                                    break;
                                case XmlPullParser.START_TAG:
                                    tag = parser.getName();

                                    if (tag.compareTo("title") == 0) {
                                        inTitle = true;
                                    }
                                    if (tag.compareTo("link") == 0) {
                                        String relType = parser.getAttributeValue(null, "rel");
                                        if (relType.compareTo("enclosure") == 0) {
                                            String encType = parser.getAttributeValue(null, "type");
                                            if (encType.startsWith("image/")) {
                                                final String imageSrc = parser.getAttributeValue(null, "href");
                                                Log.i("Net", "image source = " + imageSrc);
                                                final int curImageCount = ++imgCount;

                                                mHandler.post(new Runnable() {

                                                    public void run() {
                                                        status.setText("imgCount = " + curImageCount);
                                                    }

                                                });
                                                final String currentTitle = new String(title);
                                                imageThread.queueEvent(new Runnable() {
                                                    public void run() {
                                                        //InputStream bmis;
                                                        BufferedInputStream in;
                                                        BufferedOutputStream out;
                                                        try {
                                                            /* This code has a currently known bug
                                                             * see http://groups.google.com/group/android-developers/browse_thread/thread/4ed17d7e48899b26/a15129024bb845bf?show_docid=a15129024bb845bf
                                                             * for more information
                                                            bmis = new URL(imageSrc).openStream();
                                                            final Drawable image = new BitmapDrawable(BitmapFactory.decodeStream(bmis));
                                                            */
                                                            
                                                            in = new BufferedInputStream(new URL(imageSrc).openStream(), IO_BUFFER_SIZE);
                                                            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
                                                            out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);
                                                            copy(in, out);
                                                            out.flush();

                                                            final byte[] data = dataStream.toByteArray();
                                                            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                                                            final Drawable image = new BitmapDrawable(bitmap);
                                                            mHandler.post(new Runnable() {
                                                                public void run() {
                                                                    imageSwitcher.setImageDrawable(image);

                                                                    info.setText(currentTitle);
                                                                }
                                                            });
                                                        } catch (Exception e) {
                                                            Log.e("Net", "Failed to grab image", e);
                                                        }
                                                    }
                                                });

                                            }
                                        }
                                    }
                                    break;
                                }

                                parserEvent = parser.next();

                            }
                            mHandler.post(new Runnable() {
                                public void run() {
                                    status.setText("Done...");
                                }
                            });

                        } catch (Exception e) {
                            Log.e("Net", "Error in network call", e);
                        }
                    }
                }.start();

            }

        });
    }

    class DelayedLooperThread extends Thread {

        private long lastTime = 0;
        private long waitTime = 5000;
        public void run() {

            while (!mDone) {
                synchronized (this) {
                    long thisTime = System.currentTimeMillis();
                    long dif = thisTime - lastTime;
                    Log.i("Net", "diff = " + dif);
                    if (dif < waitTime) {
                        try {
                            Log.i("Net", "Gotta wait...");
                            wait(waitTime - dif);
                        } catch (InterruptedException e) {
                            Log.e("Net", "Looper Error", e);

                        }
                    } else {
                        Runnable r = getEvent();
                        if (r != null) {
                            lastTime = thisTime;
                            r.run();
                        } else {
                            try {
                                Log.i("Net", "Wait for queued event...");
                                wait();
                            } catch (InterruptedException e) {

                            }
                        }

                    }
                }
                Log.i("Net", "Looping...");
            }
            Log.i("Net", "Loop over.");
        }

        public void queueEvent(Runnable r) {
            synchronized (this) {
                mEventQueue.add(r);
                    notify();
            }
        }

        private Runnable getEvent() {
            synchronized (this) {
                if (mEventQueue.size() > 0) {
                    return mEventQueue.remove(0);
                }

            }
            return null;
        }

        private void finish() {
            synchronized (this) {
                mDone = true;
                notify();
            }
            try {
                join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        private boolean mDone = false;
        private ArrayList<Runnable> mEventQueue = new ArrayList<Runnable>();
    }

    @Override
    protected void onPause() {
        super.onPause();
        imageThread.finish();
    }

    
    /**
     * Copy the content of the input stream into the output stream, using a
     * temporary byte array buffer whose size is defined by
     * {@link #IO_BUFFER_SIZE}.
     * 
     * @param in The input stream to copy from.
     * @param out The output stream to copy to.
     * @throws IOException If any error occurs during the copy.
     */
    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] b = new byte[IO_BUFFER_SIZE];
        int read;
        while ((read = in.read(b)) != -1) {
            out.write(b, 0, read);
        }
    }  
}

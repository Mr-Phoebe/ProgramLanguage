package com.androidbook.multimedia;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Moving extends Activity {
    private static final String MOVIE_URL = "http://www.archive.org/download/Unexpect2001/Unexpect2001_512kb.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moving);
        VideoView vv = (VideoView) findViewById(R.id.video);
        
        // must be activity context and not app context
        MediaController mc = new MediaController(this);
        //mc.setAnchorView(vv);
        Uri video = Uri.parse(MOVIE_URL);
        vv.setMediaController(mc);
        vv.setVideoURI(video);
        

    }

}

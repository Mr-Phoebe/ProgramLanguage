package com.androidbook.multimedia;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class Video extends Activity {
    final private static String RECORDED_FILE = "/video.mp4";
    MediaRecorder videoRecorder;
    MediaPlayer player;

    @Override
    protected void onPause() {
        if (videoRecorder != null) {
            videoRecorder.release();
            videoRecorder = null;
        }
        if (player != null) {
            player.release();
            player = null;
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoRecorder = new MediaRecorder();
        player = new MediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        final Button record = (Button) findViewById(R.id.record);
        final Button stop = (Button) findViewById(R.id.stop);
        final Button stopPlayback = (Button) findViewById(R.id.stop_playback);
        final Button play = (Button) findViewById(R.id.play);
        
        final SurfaceView surface = new SurfaceView(getApplicationContext());
        final SurfaceHolder surfaceHolder = surface.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    
        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        frame.addView(surface);

        record.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (videoRecorder == null) {
                    videoRecorder = new MediaRecorder();
                }

                // Fully qualified path name. In this case, we use the Files subdir
                String pathForAppFiles = getFilesDir().getAbsolutePath();
                pathForAppFiles += RECORDED_FILE;
                Log.d("Video filename:",pathForAppFiles );
                
           
                videoRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                videoRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                videoRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                videoRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                videoRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);

                videoRecorder.setPreviewDisplay(surfaceHolder.getSurface());
                
                
                videoRecorder.setOutputFile(pathForAppFiles);

                try {
                    videoRecorder.prepare();
                    videoRecorder.start();
                    stop.setVisibility(View.VISIBLE);
                    record.setVisibility(View.GONE);
                    play.setVisibility(View.GONE);
                } catch (Exception e) {
                    Log.e("Video", "Failed to prepare and start video recording", e);
                    videoRecorder.release();
                    videoRecorder = null;
                } 
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (videoRecorder == null)
                    return;
                videoRecorder.stop();
                videoRecorder.reset();
                videoRecorder.release();
                videoRecorder = null;
                
                String pathForAppFiles = getFilesDir().getAbsolutePath();
                pathForAppFiles += RECORDED_FILE;
                Log.d("Audio filename:", pathForAppFiles);

                ContentValues values = new ContentValues(10);

                values.put(MediaStore.MediaColumns.TITLE, "RecordedVideo");
                values.put(MediaStore.Video.Media.ALBUM, "Your Groundbreaking Movie");
                values.put(MediaStore.Video.Media.ARTIST, "Your Name");
                values.put(MediaStore.Video.Media.DISPLAY_NAME, "The Video File You Recorded In Media App");

                values.put(MediaStore.MediaColumns.TITLE, "RecordedVideo");
                values.put(MediaStore.MediaColumns.DATE_ADDED, System.currentTimeMillis() / 1000);
                values.put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4");
                values.put(MediaStore.Video.Media.DATA, pathForAppFiles);

                Uri videoUri = getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values);
                if (videoUri == null) {
                    Log.d("Video", "Content resolver failed");
                    return;
                }

                // Force Media scanner to refresh now. Technically, this is
                // unnecessary, as the media scanner will run periodically but
                // helpful for testing.
                Log.d("Video URI", "Path = " + videoUri.getPath());
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, videoUri));


                stop.setVisibility(View.GONE);
                record.setVisibility(View.VISIBLE);
                //play.setVisibility(View.VISIBLE);

            }

        });
        

        
        
        play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (player == null) {
                    player = new MediaPlayer ();
                }
                try {
                        
                    // Fully qualified path name. In this case, we use the Files subdir
                    String audioFilePath = getFilesDir().getAbsolutePath();
                    audioFilePath += RECORDED_FILE;
                    Log.d("Video filename:",audioFilePath );
                    
                    player.setDataSource(audioFilePath);
                    player.prepare();
                    player.start();
                } catch (Exception e) {
                    Log.e("Video", "Playback failed.", e);
                }

                stopPlayback.setVisibility(View.VISIBLE);
                record.setVisibility(View.GONE);
                play.setVisibility(View.GONE);

            }

        });
        
        
        stopPlayback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (player == null)return;
                player.stop();
                player.release();
                player = null;
                stopPlayback.setVisibility(View.GONE);
                record.setVisibility(View.VISIBLE);
                play.setVisibility(View.VISIBLE);
                
            }
            
        });
    }

}

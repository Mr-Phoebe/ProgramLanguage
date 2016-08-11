package com.androidbook.multimedia;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class Still extends Activity {
    final private static String STILL_IMAGE_FILE = "capture.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.still);

        final CameraSurfaceView cameraView = new CameraSurfaceView(getApplicationContext());
        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        frame.addView(cameraView);

        Button shared = (Button) findViewById(R.id.shared);
        shared.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                cameraView.capture(new Camera.PictureCallback() {

                    public void onPictureTaken(byte[] data, Camera camera) {
                        Log.v("Still", "Image data received from camera");
                        try {
                            Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
                            String fileUrl = MediaStore.Images.Media.insertImage(getContentResolver(), bm, "Camera Still Image", "Camera Pic Sample App Took");

                            if (fileUrl == null) {
                                Log.d("Still", "Image Insert failed");
                                return;
                            } else {
                                // Force the media scanner to go. Not required,
                                // but good for testing.
                                Uri picUri = Uri.parse(fileUrl);
                                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, picUri));
                            }
                        } catch (Exception e) {
                            Log.e("Still", "Error writing file", e);
                        }

                    }

                });
            }

        });

        Button capture = (Button) findViewById(R.id.capture);
        capture.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                cameraView.capture(new Camera.PictureCallback() {

                    public void onPictureTaken(byte[] data, Camera camera) {
                        Log.v("Still", "Image data received from camera");
                        FileOutputStream fos;
                        try {
                            // Fully qualified path name. In this case, we
                            // use the Files subdir
                            String pathForAppFiles = getFilesDir().getAbsolutePath();
                            pathForAppFiles = pathForAppFiles + "/" + STILL_IMAGE_FILE;
                            Log.d("Still image filename:", pathForAppFiles);

                            fos = openFileOutput(STILL_IMAGE_FILE, MODE_WORLD_READABLE);
                            fos.write(data);
                            fos.close();

                        } catch (Exception e) {
                            Log.e("Still", "Error writing file", e);
                        }
                    }
                });
            }
        });

        Button paper = (Button) findViewById(R.id.wallpaper);
        paper.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                cameraView.capture(new Camera.PictureCallback() {

                    public void onPictureTaken(byte[] data, Camera camera) {
                        Log.v("Still", "Image data received from camera");
                        ByteArrayInputStream bais = new ByteArrayInputStream(data);
                        try {
                            int height = getWallpaperDesiredMinimumHeight();
                            int width = getWallpaperDesiredMinimumWidth();
                            Toast.makeText(getApplicationContext(), "Wallpaper size = " + width + "x" + height, Toast.LENGTH_LONG).show();
                            Log.v("Still", "Wallpaper size=" + width + "x" + height);
                            setWallpaper(bais);
                        } catch (Exception e) {
                            Log.e("Still", "Setting wallpaper failed.", e);
                        }
                    }
                });
            }
        });

    }

    private class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
        private SurfaceHolder mHolder;
        private Camera camera = null;

        public CameraSurfaceView(Context context) {
            super(context);
            // Install a SurfaceHolder.Callback so we get notified when the
            // underlying surface is created and destroyed
            mHolder = getHolder();
            mHolder.addCallback(this);
            mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Camera.Parameters params = camera.getParameters();
            params.setPreviewSize(width, height);
            // params.setPreviewFormat(format);
            camera.setParameters(params);
            camera.startPreview();
        }

        public void surfaceCreated(SurfaceHolder holder) {
            camera = Camera.open();
            try {
                camera.setPreviewDisplay(mHolder);
            } catch (Exception e) {
                Log.e("Camera", "Failed to set camera preview display", e);
            }
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            camera.stopPreview();
            camera = null;
        }

        public boolean capture(Camera.PictureCallback jpegHandler) {
            if (camera != null) {
                camera.takePicture(null, null, jpegHandler);
                return true;
            } else {
                return false;
            }
        }

    }

}

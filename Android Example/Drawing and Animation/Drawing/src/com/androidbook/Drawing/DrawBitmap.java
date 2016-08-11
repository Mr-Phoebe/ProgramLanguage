package com.androidbook.Drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;

public class DrawBitmap extends Drawing {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new ViewWithBitmap(this));
	}

	 private static class ViewWithBitmap extends View {
	        
	        public ViewWithBitmap(Context context) {
	            super(context);
	        }
	        
	        @Override protected void onDraw(Canvas canvas) {
	            canvas.drawColor(Color.BLUE);
	            
	            Bitmap jayPic = BitmapFactory.decodeResource(getResources(), R.drawable.bluejay);
	            
	            // Draw the big middle jay
	            Bitmap jayPicMedium= Bitmap.createScaledBitmap(jayPic, 200, 300, false);           
	            canvas.drawBitmap(jayPicMedium, 60, 75, null);
	            
	            // Create the thumbnail jay
	            Bitmap jayPicSmall= Bitmap.createScaledBitmap(jayPic, 50, 75, false);     
	         
	            Matrix maxTopLeft = new Matrix();
	            maxTopLeft.preRotate(30);

	            Matrix maxBottomLeft = new Matrix();
	            maxBottomLeft.preRotate(-30);
	            
	            Matrix maxTopRight = new Matrix();
	            maxTopRight.preRotate(-30);			// tilt 30 degrees left
	            maxTopRight.preScale(-1, 1);		// mirror image
	            
	            Matrix maxBottomRight = new Matrix();
	            maxBottomRight.preRotate(30);		// tilt 30 degrees right
	            maxBottomRight.preScale(-1, 1);		// mirror image

	            Bitmap jayPicTopLeft = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxTopLeft, false);
	            Bitmap jayPicBottomLeft = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxBottomLeft, false);

	            Bitmap jayPicTopRight = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxTopRight, false);
	            Bitmap jayPicBottomRight = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxBottomRight, false);
		           
	            // Free up some memory by dumping bitmaps we don't need anymore
	            jayPicSmall.recycle();
	            jayPic.recycle();
	            
	            canvas.drawBitmap(jayPicTopLeft, 30, 30, null);
	            canvas.drawBitmap(jayPicBottomLeft, 30, 325, null);
	            canvas.drawBitmap(jayPicTopRight, 225, 30, null);
	            canvas.drawBitmap(jayPicBottomRight, 225, 325, null);
	            
	            
	        }
	    }

}

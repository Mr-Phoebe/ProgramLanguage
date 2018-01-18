package com.androidbook.Drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class DrawCustomFont extends Drawing {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new ViewWithChessBoardFont(this));
	}

	 private static class ViewWithChessBoardFont extends View {
	        private Paint    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	        private Typeface mType;
	        private float textSize = 32;
	        private float xStart = 7;
	        private float yStart = 75;
	        
	        public ViewWithChessBoardFont(Context context) {
	            super(context);
	            mPaint.setTextSize(textSize);
	        }
	        
	        @Override protected void onDraw(Canvas canvas) {
	            canvas.drawColor(Color.WHITE);
	            
	            // This chess font is Copywritten, but freely available. I have emailed the author. 
	            // We may want to remove this activity from the final CD (LED/SAC)  
	            mType = Typeface.createFromAsset(getContext().getAssets(),"fonts/chess1.ttf");
	            mPaint.setTypeface(mType);
	            mPaint.setColor(Color.BLACK);
	            
	            // Draw the chess board
	            canvas.drawText("5111111116", xStart, yStart, mPaint);
	            canvas.drawText("3RMBWKVNT2", xStart, (yStart+(textSize*1)), mPaint); 
	            canvas.drawText("3OPOPOPOP2", xStart, (yStart+(textSize*2)), mPaint); 
	            canvas.drawText("3 / / / /2", xStart, (yStart+(textSize*3)), mPaint); 
	            canvas.drawText("3/ / / / 2", xStart, (yStart+(textSize*4)), mPaint); 
	            canvas.drawText("3 / / / /2", xStart, (yStart+(textSize*5)), mPaint); 
	            canvas.drawText("3/ / / / 2", xStart, (yStart+(textSize*6)), mPaint); 
	            canvas.drawText("3popopopo2", xStart, (yStart+(textSize*7)), mPaint); 
	            canvas.drawText("3tnvqlbmr2", xStart, (yStart+(textSize*8)), mPaint); 
	            canvas.drawText("7444444448", xStart, (yStart+(textSize*9)), mPaint); 
	        }
	    }
}

package com.androidbook.Drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;

public class DrawGradient extends Drawing {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new ViewWithGradient(this));
	}

	private static class ViewWithGradient extends View {

		public ViewWithGradient(Context context) {
			super(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {

			canvas.drawColor(Color.WHITE);

			Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
			
			LinearGradient linGrad = new LinearGradient(0, 0, 25, 25,
					Color.RED, Color.BLACK, Shader.TileMode.MIRROR);
			circlePaint.setShader(linGrad);
			canvas.drawCircle(100, 100, 100, circlePaint);
			
			RadialGradient radGrad = new RadialGradient(250,
					175, 50, Color.GREEN, Color.BLACK,
					Shader.TileMode.MIRROR);
			circlePaint.setShader(radGrad);
			canvas.drawCircle(250, 175, 50, circlePaint);
			
			SweepGradient sweepGrad = new SweepGradient(canvas.getWidth()-175,
					canvas.getHeight()-175, new int[] {
                            Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA }, null);
			circlePaint.setShader(sweepGrad);
			canvas.drawCircle(canvas.getWidth()-175,
					canvas.getHeight()-175, 100, circlePaint);

		}
	}

}

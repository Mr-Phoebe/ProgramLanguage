package com.androidbook.ShapeShifter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShapeViewer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.shapes);

		// Handle Line Button
		final Button lineButton = (Button) findViewById(R.id.ButtonLine);
		lineButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Create a line from a rectangle
				ShapeDrawable d = new ShapeDrawable(new RectShape());
				d.setIntrinsicHeight(2);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.MAGENTA);
				setShapeByDrawable(d);
			}
		});

		// Handle Oval Button
		final Button ovalButton = (Button) findViewById(R.id.ButtonOval);
		ovalButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//setShapeByResourceId(R.drawable.red_oval);
			//  Or Draw an oval programatically.
				ShapeDrawable d = new ShapeDrawable(new OvalShape());
				d.setIntrinsicHeight(40);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.RED);
				setShapeByDrawable(d);
			}
		});

		// Handle Rectangle Button
		final Button rectButton = (Button) findViewById(R.id.ButtonRect);
		rectButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setShapeByResourceId(R.drawable.green_rect);
			}
		});

		// Handle Round Rectangle Button
		final Button roundRectButton = (Button) findViewById(R.id.ButtonRoundRect);
		roundRectButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
			
				ShapeDrawable d = new ShapeDrawable(new RoundRectShape(
						new float[] { 5, 5, 5, 5, 5, 5, 5, 5 }, null, null));
				d.setIntrinsicHeight(50);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.CYAN);
				setShapeByDrawable(d);
			}
		});

		// Handle Round Rectangle 2Button
		final Button roundRectButton2 = (Button) findViewById(R.id.ButtonRoundRect2);
		roundRectButton2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Create a rounded rect with an inner rect
				
	            float[] outerRadii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };
	            RectF   insetRectangle = new RectF(8, 8, 8, 8);
	            float[] innerRadii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };

				ShapeDrawable d = new ShapeDrawable(new RoundRectShape(outerRadii,insetRectangle , innerRadii));
				d.setIntrinsicHeight(50);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.WHITE);
				setShapeByDrawable(d);
			}
		});

		// Handle Path Button
		final Button pathButton = (Button) findViewById(R.id.ButtonPath);
		pathButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Let's draw a star
				Path p = new Path(); // pretty star, filled
				p.moveTo(50, 0);
				p.lineTo(25,100);
				p.lineTo(100,50);
				p.lineTo(0,50);
				p.lineTo(75,100);
				p.lineTo(50,0);    
				
				ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
				d.setIntrinsicHeight(100);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.YELLOW);
				setShapeByDrawable(d);
			}
		});

		// Handle Path Button
		final Button path2Button = (Button) findViewById(R.id.ButtonPath2);
		path2Button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Let's draw a star
				Path p = new Path();
				p.setFillType(Path.FillType.EVEN_ODD); // another fill type
				p.moveTo(50, 0);
				p.lineTo(25,100);
				p.lineTo(100,50);
				p.lineTo(0,50);
				p.lineTo(75,100);
				p.lineTo(50,0);    
				
				ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
				d.setIntrinsicHeight(100);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.YELLOW);
				setShapeByDrawable(d);
			}
		});
		
		// Handle Path Button
		final Button path3Button = (Button) findViewById(R.id.ButtonPath3);
		path3Button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Let's draw a star
				Path p = new Path();
				p.moveTo(50, 0);
				p.lineTo(25,100);
				p.lineTo(100,50);
				p.lineTo(0,50);
				p.lineTo(75,100);
				p.lineTo(50,0);    
				
				ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
				d.setIntrinsicHeight(100);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.YELLOW);
				d.getPaint().setStyle(Paint.Style.STROKE); // Line drawing
				
				setShapeByDrawable(d);
			}
		});


		
		// Handle Arc Button
		final Button arcButton = (Button) findViewById(R.id.ButtonArc);
		arcButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Create a arc, pacman style
				ShapeDrawable d = new ShapeDrawable(new ArcShape(0, 345));
				d.setIntrinsicHeight(100);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.MAGENTA);
				setShapeByDrawable(d);
			}
		});
	}

	private void setShapeByResourceId(int resourceId) {
		// We will animate the imageview
		ImageView reusableImageView = (ImageView) findViewById(R.id.ImageViewForShape);
		reusableImageView.setImageResource(resourceId);
	}

	private void setShapeByDrawable(Drawable drawable) {
		// We will animate the imageview
		ImageView reusableImageView = (ImageView) findViewById(R.id.ImageViewForShape);
		reusableImageView.setImageDrawable(drawable);
	}

}

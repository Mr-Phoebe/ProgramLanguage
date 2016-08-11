package com.androidbook.views;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class Pickers extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.pickers);
		
		final TextView text =(TextView)findViewById(R.id.text_datetime);
		final DatePicker date = (DatePicker)findViewById(R.id.DatePicker01);
		final TimePicker time = (TimePicker)findViewById(R.id.TimePicker01);
		
		time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){

			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				
				Date dt = new Date(date.getYear(), date.getMonth(), date.getDayOfMonth(), hourOfDay, minute	);
				text.setText(dt.toString());
			}
			
		});
		
		
		date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(),  new DatePicker.OnDateChangedListener() {

			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				
				Date dt = new Date(year-1900, monthOfYear, dayOfMonth, time.getCurrentHour(), time.getCurrentMinute());
				text.setText(dt.toString());
			}
			
		});
	}

}

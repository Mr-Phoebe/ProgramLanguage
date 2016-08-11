package com.androidbook.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Buttons extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.buttons);
		

		
		final Button basic_button = (Button) findViewById(R.id.basic_button);
		basic_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Toast.makeText(Buttons.this, "Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

		final ImageButton image_button = (ImageButton) findViewById(R.id.image_button);
		image_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Toast.makeText(Buttons.this, "Image button clicked", Toast.LENGTH_SHORT).show();
            }
        });
		
		
		final ToggleButton toggle_button = (ToggleButton) findViewById(R.id.toggle_button);
		toggle_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				TextView tv = (TextView) findViewById(R.id.text_feature);
				tv.setText(toggle_button.isChecked() ? "This feature is on" : "This feature is off");
			}
		});
		
		final Button submit_button = (Button) findViewById(R.id.submit_demo);
		submit_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v ){
				ToggleButton tb = (ToggleButton) findViewById(R.id.toggle_button);
				Toast.makeText(Buttons.this, tb.isChecked() ? "on": "off", Toast.LENGTH_LONG).show();
				Buttons.this.finish();
			}
		});
		
		final CheckBox check_button = (CheckBox) findViewById(R.id.checkbox);
		check_button.setOnClickListener(new View.OnClickListener() {
			public void onClick (View v) {
				TextView tv = (TextView)findViewById(R.id.checkbox);
				tv.setText(check_button.isChecked() ? "This option is checked": "This option is not checked");
			}
		});
		
		final RadioGroup group = (RadioGroup)findViewById(R.id.RadioGroup01);
		group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			public void onCheckedChanged(RadioGroup group, int checkedId) {
						TextView tv = (TextView) findViewById(R.id.TextView01);
						if (checkedId != -1) {
							RadioButton rb = (RadioButton) findViewById(checkedId);

							if (rb != null) {
								tv.setText("You chose: " + rb.getText());
							}
						} else {
							tv.setText("Choose 1");
						}
			}
		});
		
		final Button clear_choice = (Button) findViewById(R.id.Button01);
		clear_choice.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				RadioGroup group = (RadioGroup) findViewById(R.id.RadioGroup01);
				if (group != null) {
					group.clearCheck();
				}
			}
		}
		
		);

	}
}

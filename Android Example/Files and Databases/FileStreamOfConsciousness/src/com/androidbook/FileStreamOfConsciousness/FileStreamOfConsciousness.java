package com.androidbook.FileStreamOfConsciousness;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileStreamOfConsciousness extends Activity {

	public static final String LOG_FILENAME = "Chat_Log.txt";
	private Handler mHandler = new Handler();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);

		// Handle Send Button
		final Button sendButton = (Button) findViewById(R.id.ButtonSend);
		sendButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

			logChatMessage();

			final EditText chatText = (EditText) findViewById(R.id.EditTextChat);
			chatText.setText(null);
		
			}
		});

		// Handle Go to Log button
		final Button gotoLog = (Button) findViewById(R.id.ButtonSeeLog);
		gotoLog.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Go to other activity that displays file contents
				Intent intent = new Intent(FileStreamOfConsciousness.this,
						ViewLog.class);
				startActivity(intent);
			}
		});
	}

	
	
	private void logChatMessage() {
		
		new Thread(){
			public void run(){
				
				final EditText chatText = (EditText) findViewById(R.id.EditTextChat);
				String strChat = chatText.getText().toString();

				if (strChat.length() > 0) {
					
					strChat = strChat+"\n\n";

					try {
						// Open the file
						FileOutputStream fIO = openFileOutput(LOG_FILENAME, MODE_APPEND);
						// Write our chat string
						fIO.write(strChat.getBytes());
						// Close
						fIO.close();
						
						// Inform the UI thread we're good to go
						mHandler.post(new Runnable() {
							public void run() {
								Toast.makeText(FileStreamOfConsciousness.this,
										"Logged Chat Message",
										Toast.LENGTH_SHORT).show();
							}
						});
						
					} catch (Exception e) {
						// Append failed. Handle error
					}
				}
			}
		}.start();
	}
}
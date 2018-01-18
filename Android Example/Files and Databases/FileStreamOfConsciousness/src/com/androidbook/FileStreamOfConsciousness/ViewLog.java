package com.androidbook.FileStreamOfConsciousness;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewLog extends Activity {

	public static final String LOG_FILENAME = "Chat_Log.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.showfile);

		final TextView log = (TextView) findViewById(R.id.TextViewCurrentLogFile);
				
		// Read the file, dump it into the TextView
		
        try {
        	InputStream iFile = (InputStream) openFileInput(LOG_FILENAME);
        	log.setText(inputStreamToString(iFile));
		} catch (Exception e) {
			log.setText("Couldn't read log file.");
		}	
		
		// Handle Send Button
		final Button clearLog = (Button) findViewById(R.id.ButtonClearLog);
		clearLog.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// If the file exists, Delete the file
				if (java.util.Arrays.binarySearch(fileList(), LOG_FILENAME) != (-1)) {
					deleteFile(LOG_FILENAME);
				}
				
				// Update the screen
				final TextView log = (TextView) findViewById(R.id.TextViewCurrentLogFile);
	        	log.setText(null);
			}
		});

		// Handle Go to Chat button
		final Button goChat = (Button) findViewById(R.id.ButtonChat);
		goChat.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Go to other activity that allows chat
	        	Intent intent = new Intent(ViewLog.this, FileStreamOfConsciousness.class);
	   			startActivity(intent);

			}
		});
	}

	// Converts an input stream to a string so we can stick it in the TextView
	// Typically, this sort of possibly lengthy operation would be wrapped in a thread, 
	// and perhaps the UI would show a progress indicator as the file loaded into memory
	// but for this example, we keep it super simple for readability, since our chat log is tiny
	// To see an example of using another thread to offload this sort of operation, 
	// see the FileStreamOfConsciousness.java file, specifically the logChatMessage() method
	public String inputStreamToString(InputStream is) throws IOException {
		StringBuffer sBuffer = new StringBuffer();
		DataInputStream dataIO = new DataInputStream(is);
		String strLine = null;

		while ((strLine = dataIO.readLine()) != null) {
			sBuffer.append(strLine + "\n");
		}

		dataIO.close();
		is.close();

		return sBuffer.toString();

	}
}

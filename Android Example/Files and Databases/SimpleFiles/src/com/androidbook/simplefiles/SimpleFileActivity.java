package com.androidbook.simplefiles;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SimpleFileActivity extends Activity {
	private static final String DEBUG_TAG = "SimpleFileActivity Log";
	private static final String SOME_FILE_CONTENTS = "Sea turtles can be found all over the world, and yet all sea turtle species are on the endangered species listing. The loggerhead turtle is among these.";
	private static final String MORE_FILE_CONTENTS = "In the Pacific, loggerhead turtles are born on the beaches of Japan. The baby turtles hatch from their shells at night, in hopes of avoiding being spotted by a predator and being eaten. They make their way toward to ocean, navigating by light. In the past, this the brighest light at night was the sea itself, but manmade lights can now disrupt and confuse these little turtles. Only a portion of the babies make it down the sand and into the ocean.";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// The guts of this example, working with files in various ways
		runFileAccessExample();
	}

	public void runFileAccessExample() {
		Log.i(DEBUG_TAG, "Begin File Example");
		String file1 = "file1.xxx";

		// if the file exists, delete it
		if (Arrays.binarySearch(fileList(), file1) >= 0) {
			// Delete the old database file
			deleteFile(file1);
		}

		// write some text to a file, creating the file if necessary
		FileOutputStream fos;
		try {
			fos = openFileOutput(file1, MODE_PRIVATE);
			fos.write(SOME_FILE_CONTENTS.getBytes());
			fos.close();
			Log.i(DEBUG_TAG, "Wrote to File: " + file1);
		} catch (Exception e) {
			Log.i(DEBUG_TAG, "openFileOutput (new file) threw exception: "
					+ e.getMessage());
		}

		// Read back our whole file and print it as a single line string
		readAppFileAndLog(file1);
		// Read it again, only this time, 70 characters at a time
		readAppFileAndLogAsString(file1);

		// append some stuff to the file
		try {
			fos = openFileOutput(file1, MODE_APPEND);
			fos.write(MORE_FILE_CONTENTS.getBytes());
			fos.close();
			Log.i(DEBUG_TAG, "Appended File: " + file1);
		} catch (Exception e) {
			Log.i(DEBUG_TAG, "openFileOutput (append) threw exception: "
					+ e.getMessage());
		}

		// Read back our file again so we can see the appended text
		readAppFileAndLog(file1);
		
		Log.i(DEBUG_TAG, "INSPECTING APPLICATION FILE DIRECTORY at Context.getFilesDir()");
		File pathForAppFiles = getFilesDir();
		logFileDetails(pathForAppFiles);
		
		Log.i(DEBUG_TAG, "Listing Files in " + pathForAppFiles.getAbsolutePath());
		String[] fileList = pathForAppFiles.list();
		for(int i=0; i< fileList.length; i++)
		{
			Log.i(DEBUG_TAG, "Filename " + i+": " + fileList[i] );
		}

		Log.i(DEBUG_TAG, "INSPECTING APPLICATION FILE DIRECTORY at Context.getCacheDir()");
		File pathCacheDir = getCacheDir();
		logFileDetails(pathCacheDir);		

		String strCacheFileName = "myCacheFile.cache";
		File newCacheFile = new File(pathCacheDir, strCacheFileName);
		try {
			Log.i(DEBUG_TAG, "Creating a new file in the Cache Dir: " + strCacheFileName);
			newCacheFile.createNewFile();
			logFileDetails(newCacheFile);
			
			// Write to the file
			FileOutputStream foCache = new FileOutputStream(newCacheFile.getAbsolutePath());
			foCache.write(SOME_FILE_CONTENTS.getBytes());
			foCache.close();
			
			// Read what we wrote to the file back
			Log.i(DEBUG_TAG, "CACHED FILE CONTENTS:");
			readAnyFileAndLog(newCacheFile.getAbsolutePath());
			
		} catch (Exception e) {
			Log.i(DEBUG_TAG, "createNewFile threw exception: "
					+ e.getMessage());
		}
		
		Log.i(DEBUG_TAG, "Listing Files in " + pathCacheDir.getAbsolutePath());
		String[] fileListCache = pathCacheDir.list();
		for(int i=0; i< fileListCache.length; i++)
		{
			Log.i(DEBUG_TAG, "Filename " + i+": " + fileListCache[i] );
		}
		
		Log.i(DEBUG_TAG, "Deleting file in the Cache Dir: " + strCacheFileName);
		newCacheFile.delete();
		
		Log.i(DEBUG_TAG, "Listing Files in " + pathCacheDir.getAbsolutePath());
		String[] fileListCacheRefeshed = pathCacheDir.list();
		for(int i=0; i< fileListCacheRefeshed.length; i++)
		{
			Log.i(DEBUG_TAG, "Filename " + i+": " + fileListCacheRefeshed[i] );
		}
		
		
		// Back to the Context functions...
		Log.i(DEBUG_TAG, "Trying to delete the file we created: " + file1);
		if (deleteFile(file1)) {
			Log.i(DEBUG_TAG, "Deleted file: " + file1 + " successfully.");
		}

		Log.i(DEBUG_TAG, "End File Example");
	}
	
	// Log some file details
	public void logFileDetails(File file)
	{
		if(file.isDirectory())
		{
			Log.i(DEBUG_TAG, file.getAbsolutePath() + " is a DIRECTORY");			
		}
		if(file.isFile())
		{
			Log.i(DEBUG_TAG, file.getAbsolutePath() + " is a FILE");			
		}
		if(file.isHidden())
		{
			Log.i(DEBUG_TAG, file.getAbsolutePath() + " is HIDDEN");			
		}

		if(file.exists())
		{
			Log.i(DEBUG_TAG, file.getAbsolutePath() + " EXISTS");			
		}
		if(file.canRead())
		{
			Log.i(DEBUG_TAG, file.getAbsolutePath() + " is READABLE");			
		}
		if(file.canWrite())
		{
			Log.i(DEBUG_TAG, file.getAbsolutePath() + " is WRITEABLE");			
		}	
	}

	// Logs a file with newlines every 70 characters ( prints better in the logcat screen)
	// Typically, this kind of file operation might be wrapped in a thread 
	// but for this example, we keep it super simple for readability
	// For a threading example, see the FileStreamOfConsciousness sample application
	// 
	// This method only works for the application directory
	public void readAppFileAndLog(String filename) {

		FileInputStream fis;
		try {
			fis = openFileInput(filename);
			StringBuffer sBuffer = new StringBuffer();
			int chunkSize = 70;
			byte[] bf = new byte[chunkSize];


			// read 50 bytes at a time
			while ((fis.read(bf, 0, chunkSize)) != -1) {
				String str = new String(bf);
				sBuffer.append(str + "\n");			
				if(fis.available() < 50)
				{
				Arrays.fill(bf, 0, chunkSize, (byte) ' '); // zero out our buffer so the next line only contains the remainder bytes
				}
			}
			fis.close();

			Log.i(DEBUG_TAG, "File Contents:\n" + sBuffer.toString());
			Log.i(DEBUG_TAG, "\nEOF");
		} catch (Exception e) {
			Log.i(DEBUG_TAG, "openFileInput threw exception: "+ e.getMessage());
		}

	}

	
	// Logs a file with newlines every 70 characters (prints better in the logcat screen)
	// Typically, this kind of file operation might be wrapped in a thread
	public void readAnyFileAndLog(String filename) {

		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			StringBuffer sBuffer = new StringBuffer();
			int chunkSize = 70;
			byte[] bf = new byte[chunkSize];


			// read 50 bytes at a time
			while ((fis.read(bf, 0, chunkSize)) != -1) {
				String str = new String(bf);
				sBuffer.append(str + "\n");			
				if(fis.available() < 50)
				{
				Arrays.fill(bf, 0, chunkSize, (byte) ' '); // zero out our buffer so the next line only contains the remainder bytes
				}
			}


			fis.close();

			Log.i(DEBUG_TAG, "File Contents:\n" + sBuffer.toString());
			Log.i(DEBUG_TAG, "\nEOF");
		} catch (Exception e) {
			Log.i(DEBUG_TAG, "openFileInput threw exception: "+ e.getMessage());
		}
	}
	
	// Logs a file as one long string
	// Typically, this kind of file operation might be wrapped in a thread 
	public void readAppFileAndLogAsString(String filename) {

		FileInputStream fis;
		try {
			fis = openFileInput(filename);
			StringBuffer sBuffer = new StringBuffer();
			DataInputStream dataIO = new DataInputStream(fis);
			String strLine = null;

			// read a line at a time 
			while ((strLine = dataIO.readLine()) != null) {
				sBuffer.append(strLine + "\n");
			}

			dataIO.close();
			fis.close();

			Log.i(DEBUG_TAG, "File Contents:\n" + sBuffer.toString());
			Log.i(DEBUG_TAG, "\nEOF");
		} catch (Exception e) {
			Log.i(DEBUG_TAG, "openFileInput threw exception: "+ e.getMessage());
		}
	}
}
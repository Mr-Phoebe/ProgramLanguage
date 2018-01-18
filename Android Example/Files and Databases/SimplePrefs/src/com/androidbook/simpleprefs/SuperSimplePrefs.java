package com.androidbook.simpleprefs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public abstract class SuperSimplePrefs extends Activity {

	public static final String PREFERENCE_FILENAME = "AppPrefs";
	public static final String PREFERENCE_STRING_NAME = "StringPrefActivity";	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
				
		setContentView(R.layout.main);
        
        // Spit out the current preferences
        SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0); 
        SharedPreferences settingsActivity = getPreferences(MODE_PRIVATE); 

        // Show the activity name  
        final TextView activityName = (TextView)findViewById(R.id.Title);
        activityName.setText(this.getLocalClassName());
        
        // Show the shared preferences 
        final TextView prefs = (TextView)findViewById(R.id.CurrentPrefs);
        prefs.setText(settings.getAll().toString());
        
        // Set the private activity preferences 
        final TextView prefsAct = (TextView)findViewById(R.id.CurrentActivityPrefs);
        prefsAct.setText(settingsActivity.getAll().toString());
        
        // Move to other activity
        final Button goButton = (Button) findViewById(R.id.ButtonGo);         
        goButton.setOnClickListener(new View.OnClickListener() {             
        	public void onClick(View v) {                 
        		
        		// Go to the Main screen
        	Intent intent = new Intent(SuperSimplePrefs.this, GetTargetClass());
   			startActivity(intent);
        		}         
        	});
        
        
        // HANDLE ACTIVITY PREFERENCE BUTTONS
        
        // Handle add/update activity preference button clicks
        final Button prefAddActButton = (Button) findViewById(R.id.ButtonAddActivityPref);         
        prefAddActButton.setOnClickListener(new View.OnClickListener() {             
        	public void onClick(View v) {                 
  
     
        		final EditText prefName = (EditText)findViewById(R.id.EditTextPrefName);
        		final EditText prefValue = (EditText)findViewById(R.id.EditTextPrefValue);
        		final TextView prefs = (TextView)findViewById(R.id.CurrentActivityPrefs);
        		
        		// Get the application settings and open the editor
                SharedPreferences settings = getPreferences(0);
                SharedPreferences.Editor prefEditor = settings.edit();
                
                String strPrefName = prefName.getText().toString();
                String strPrefValue = prefValue.getText().toString();
                               
                // Add the preference and commit the changes
                prefEditor.putString(strPrefName, strPrefValue);
                prefEditor.commit();
                
                // Update the screen with all settings
        		prefs.setText(settings.getAll().toString()); 

        		}         
        	});
        
     // Handle clearing a single activity preference by name clicks
        final Button clearActPrefByNameButton = (Button) findViewById(R.id.ButtonClearActPrefByName);         
        clearActPrefByNameButton.setOnClickListener(new View.OnClickListener() {             
        	public void onClick(View v) {                 
  
        		final EditText prefName = (EditText)findViewById(R.id.EditTextPrefName);
        		final TextView prefs = (TextView)findViewById(R.id.CurrentActivityPrefs);
        		
        		// Get the application settings and open the editor
                SharedPreferences settings = getPreferences(0);
                SharedPreferences.Editor prefEditor = settings.edit();
                
                String strPrefName = prefName.getText().toString();
                
                // Remove the preference if it exists 
                if(settings.contains(strPrefName))
                {
                	// Remove the existing preference by the same name
                	prefEditor.remove(strPrefName);
                }
                
                // Commit our changes and update the display
                prefEditor.commit();
                
        		prefs.setText(settings.getAll().toString()); 

        		}         
        	});

        // Handle clearing preference button clicks
        final Button clearButton = (Button) findViewById(R.id.ButtonClearAct);         
        clearButton.setOnClickListener(new View.OnClickListener() {             
        	public void onClick(View v) {                 
  
        		final TextView prefs = (TextView)findViewById(R.id.CurrentActivityPrefs);
        		
        		// Get the application settings and open the editor
                SharedPreferences settings = getPreferences(0);
                SharedPreferences.Editor prefEditor = settings.edit();
                                
                // Clear all the preferences
                prefEditor.clear();
                prefEditor.commit();
                
                // Update the screen
        		prefs.setText(settings.getAll().toString()); 

        		// Also tell the user specifically what we did
        		Toast.makeText(SuperSimplePrefs.this, "Activity Preferences Cleared", Toast.LENGTH_SHORT).show();
        		}         
        	});
        
        // HANDLE SHARED PREFS BUTTONS
        // Handle add/update preference button clicks
        final Button prefButton = (Button) findViewById(R.id.ButtonAddSharedPref);         
        prefButton.setOnClickListener(new View.OnClickListener() {             
        	public void onClick(View v) {                 
  
     
        		final EditText prefName = (EditText)findViewById(R.id.EditTextPrefName);
        		final EditText prefValue = (EditText)findViewById(R.id.EditTextPrefValue);
        		final TextView prefs = (TextView)findViewById(R.id.CurrentPrefs);
        		
        		// Get the application settings and open the editor
                SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0);
                SharedPreferences.Editor prefEditor = settings.edit();
                
                String strPrefName = prefName.getText().toString();
                String strPrefValue = prefValue.getText().toString();
                               
                // Add the preference and commit the changes
                prefEditor.putString(strPrefName, strPrefValue);
                prefEditor.commit();
                
                // Update the screen with all settings
        		prefs.setText(settings.getAll().toString()); 

        		}         
        	});
        
     // Handle clearing a single preference by name clicks
        final Button clearPrefByNameButton = (Button) findViewById(R.id.ButtonClearSharedPrefByName);         
        clearPrefByNameButton.setOnClickListener(new View.OnClickListener() {             
        	public void onClick(View v) {                 
  
        		final EditText prefName = (EditText)findViewById(R.id.EditTextPrefName);
        		final TextView prefs = (TextView)findViewById(R.id.CurrentPrefs);
        		
        		// Get the application settings and open the editor
                SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0);
                SharedPreferences.Editor prefEditor = settings.edit();
                
                String strPrefName = prefName.getText().toString();
                
                // Remove the preference if it exists 
                if(settings.contains(strPrefName))
                {
                	// Remove the existing preference by the same name
                	prefEditor.remove(strPrefName);
                }
                
                // Commit our changes and update the display
                prefEditor.commit();
                
        		prefs.setText(settings.getAll().toString()); 

        		}         
        	});

        
        
        // Handle clearing preference button clicks
        final Button clearSharedButton = (Button) findViewById(R.id.ButtonClearShared);         
        clearSharedButton.setOnClickListener(new View.OnClickListener() {             
        	public void onClick(View v) {                 
  
        		final TextView prefs = (TextView)findViewById(R.id.CurrentPrefs);
        		
        		// Get the application settings and open the editor
                SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0);
                SharedPreferences.Editor prefEditor = settings.edit();
                                
                // Clear all the preferences
                prefEditor.clear();
                prefEditor.commit();
                
                // Update the screen
        		prefs.setText(settings.getAll().toString()); 

        		// Also tell the user specifically what we did
        		Toast.makeText(SuperSimplePrefs.this, "Shared Preferences Cleared", Toast.LENGTH_SHORT).show();
        		}         
        	});
        
        // Register to be notified whenever preferences change
        settings.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {             
        	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {   
        		// Tell the user what changed
        		Toast.makeText(SuperSimplePrefs.this, "Preference Changed: "+key, Toast.LENGTH_SHORT).show();
        		}         
        	});
		
		
	}
	
	abstract Class<?> GetTargetClass();
	

}

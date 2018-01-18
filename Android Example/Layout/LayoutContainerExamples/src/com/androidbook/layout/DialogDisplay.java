package com.androidbook.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogDisplay extends
    Activity {

    @Override
    protected void onCreate(
        Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super
            .onCreate(savedInstanceState);
        
        setContentView(R.layout.dialog);
        
        Button b = (Button)findViewById(R.id.do_dialog_btn);
        
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(
                View v) {
                
                new AlertDialog.Builder(DialogDisplay.this)
                .setMessage("Please press agree to continue...")
             .setPositiveButton("Agree", null)
 
                .show();
            }
                
        });
    }

}

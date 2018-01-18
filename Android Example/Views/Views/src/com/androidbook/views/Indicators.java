package com.androidbook.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class Indicators extends Activity {
	private ProgressBar mProgress;
	private ProgressBar mProgress2;
	private ProgressBar mProgress3;
	private int mProgressStatus = 0;
	private int mProgress2Status = 0;
	private int mProgress3Status = 0;
	
	private Activity me = this;

	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.indicators);
		//setProgressBarIndeterminateVisibility(true);
		//setProgressBarVisibility(true);
		//setProgress(10000);
		
	    final Chronometer timer = (Chronometer)findViewById(R.id.Chronometer01);
	    long base =  timer.getBase();
	    Log.d(ViewsMenu.debugTag, "base = "+ base);
	    timer.setBase(0);
	    
	    //final DigitalClock clock = (DigitalClock)findViewById(R.id.DigitalClock01);

		mProgress = (ProgressBar) findViewById(R.id.progress_bar);

		// Start lengthy operation in a background thread
		new Thread(new Runnable() {
			public void run() {
				while (mProgressStatus < 100) {
					try {
						synchronized (this) {
							wait(50);
						}
					} catch (Exception e) {
						Log.e(ViewsMenu.debugTag, "wait failed", e);
					}
					mProgressStatus++;

					// Update the progress bar
					mHandler.post(new Runnable() {
						public void run() {
							mProgress.setProgress(mProgressStatus);
						}
					});
				}
			}
		}).start();
		

		mProgress2 = (ProgressBar) findViewById(R.id.progress_bar2);

		// Start lengthy operation in a background thread
		new Thread(new Runnable() {
			public void run() {
				timer.start();
				while (mProgress2Status < 100) {
					try {
						synchronized (this) {
							wait(100);
						}
					} catch (Exception e) {
						Log.e(ViewsMenu.debugTag, "wait failed", e);
					}
					mProgress2Status++;

					// Update the progress bar
					mHandler.post(new Runnable() {
						public void run() {
							mProgress2.setProgress(mProgress2Status/4);
							mProgress2.setSecondaryProgress(mProgress2Status);
							me.setProgress(mProgress2Status*100);
						}
					});
									
				}
				mHandler.post(new Runnable(){
					public void run() {
						ProgressBar prog_stop = (ProgressBar)findViewById(R.id.progress_bar3);
						prog_stop.setVisibility(ProgressBar.GONE);			
					}
				});
				timer.stop();
			}
		}).start();
		
		mProgress3 = (ProgressBar) findViewById(R.id.progress_bar3);
		
		// Start lengthy operation in a background thread
		new Thread(new Runnable() {
			public void run() {
				while (mProgress3Status < 100) {
					try {
						synchronized (this) {
							wait(100);
						}
					} catch (Exception e) {
						Log.e(ViewsMenu.debugTag, "wait failed", e);
					}
					mProgress3Status++;

					// Update the progress bar
					mHandler.post(new Runnable() {
						public void run() {
							mProgress3.setProgress(mProgress3Status/4);
							mProgress3.setSecondaryProgress(mProgress3Status);
						}
					});
				}
			}
		}).start();
		
	    SeekBar seek = (SeekBar) findViewById(R.id.seekbar1);
	    seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromTouch) {
				
				Log.d(ViewsMenu.debugTag, "progress = " + progress + " fromTouch = " + fromTouch);
				((TextView)findViewById(R.id.seek_text))
					.setText("Value: "+progress);

				seekBar.setSecondaryProgress((progress+seekBar.getMax())/2);
				
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	    RatingBar rate = (RatingBar) findViewById(R.id.ratebar1);
	    rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromTouch) {
				Log.d(ViewsMenu.debugTag, "rating = " + rating + " fromTouch = " + fromTouch);
				((TextView)findViewById(R.id.rating_text)).setText("Rating: "+ rating);
			}
	    });
	    
	   
	    registerForContextMenu(timer);
	    
	    
	    
		
	}
	


    @Override
public boolean onContextItemSelected(MenuItem item) {
     super.onContextItemSelected(item);
     
     Chronometer timer = (Chronometer)findViewById(R.id.Chronometer01);
     switch (item.getItemId()){
         case R.id.stop_timer:
             timer.stop();
             break;
         case R.id.start_timer:
             timer.start();
             break;
         case R.id.reset_timer:
             timer.setBase(SystemClock.elapsedRealtime());
             break;
     }
     return true;
}



    @Override
    public void onCreateContextMenu(
        ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        
        if (v.getId() == R.id.Chronometer01)
        {
            getMenuInflater().inflate(R.menu.timer_context, menu);
            menu.setHeaderIcon(android.R.drawable.ic_media_play)
                .setHeaderTitle("Timer controls");
        }
    }

}

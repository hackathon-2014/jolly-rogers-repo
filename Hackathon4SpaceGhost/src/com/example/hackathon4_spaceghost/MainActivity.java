package com.example.hackathon4_spaceghost;


import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button StartButton = (Button) findViewById(R.id.Startbutton);
		StartButton.setOnClickListener(startButtonListener);
		Button ExitButton = (Button) findViewById(R.id.Exitbutton);
		ExitButton.setOnClickListener(exitButtonListener);
		Button HighSButton = (Button) findViewById(R.id.HighSbutton);
		HighSButton.setOnClickListener(highSButtonListener);
	}
	
	OnClickListener startButtonListener = new OnClickListener()
	{
					@Override
					public void onClick(View v) {
						
						Intent intent = new Intent(MainActivity.this, Game.class);
				        startActivity(intent);
						
					}

			};
	OnClickListener exitButtonListener = new OnClickListener()
	{
		@Override
		public void onClick(View v) {
								
				System.exit(0);;
								
		}

	};
	
	OnClickListener highSButtonListener = new OnClickListener()
	{
		@Override
		public void onClick(View v) {
								
				//Intent intent = new Intent(MainActivity.this, HighScore.class);
				//startActivity(intent);
								
		}

	};
							
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

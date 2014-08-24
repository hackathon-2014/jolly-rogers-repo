package com.example.hackathon4_spaceghost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class SplashScreen extends Activity {

	private static int SPLASH_TIME_OUT = 3000;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		
		new Handler().postDelayed(new Runnable(){
			public void run(){
				Intent i = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(i);
				finish();			
			}
		}, SPLASH_TIME_OUT);
			}
		
		
						}
					
package com.example.hackathon4_spaceghost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashScreen extends Activity {

	
	protected boolean _active=true;
	protected int _splashTime=3000;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		Thread splashThread = new Thread(){
			@Override
			public void run(){
				try{
					int waited = 0;
					while(_active && (waited <_splashTime)){
						sleep(100);
						if(_active){
							waited += 100;
						}
					}
				}catch (Exception e){
				} finally{
					startActivity(new Intent(SplashScreen.this, MainActivity.class));
					finish();
				}
			};
		};
		splashThread.start();
	}

	
	}

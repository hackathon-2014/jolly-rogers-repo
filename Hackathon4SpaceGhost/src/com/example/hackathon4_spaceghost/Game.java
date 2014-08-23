package com.example.hackathon4_spaceghost;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Game extends Fragment 
{
	private Button btnShoot = new Button(getActivity());
	private Button btnUp = new Button(getActivity());
	private Button btnDwn = new Button(getActivity());
	private ImageView spaceGhost = new ImageView(getActivity());
	private ImageView lazer = new ImageView(getActivity());
	
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
	    // TODO Auto-generated method stub
	    super.onViewCreated(view, savedInstanceState);

	    //Set a FrameLayout to add buttons
	    FrameLayout FrameLayout = new FrameLayout(getActivity());
	    // Set the layout full width, full height
	    LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	    FrameLayout.setLayoutParams(params);
	    //FrameLayout.setOrientation(FrameLayout.HORIZONTAL); //or VERTICAL

	    spaceGhost.setLayoutParams(params);
	    spaceGhost.setX(50);
	    spaceGhost.setY(50);
	    spaceGhost.setImageResource(R.drawable.space_ghost_flying);
	    	    
	    //Button btnShoot = new Button(getActivity());
	    btnShoot.setLayoutParams(params);
	    btnShoot.setWidth(10);
	    btnShoot.setHeight(10);
	    btnShoot.setX(50);
	    btnShoot.setY(100);
	    btnShoot.setOnClickListener(shoot);
	    
	    btnUp.setLayoutParams(params);	    
	    btnUp.setX(100);
	    btnUp.setY(100);
	    btnUp.setOnClickListener(moveUp);
	    
	    btnDwn.setLayoutParams(params);
	    btnDwn.setX(110);
	    btnDwn.setY(110);
	    btnDwn.setOnClickListener(moveDown);   

	    ViewGroup viewGroup = (ViewGroup) view;

	    FrameLayout.addView(spaceGhost);
	    FrameLayout.addView(btnShoot);
	    FrameLayout.addView(btnUp);

	    viewGroup.addView(FrameLayout);
	    
	    theGame();
	}
	
	private OnClickListener shoot = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	lazer.setImageResource(R.drawable.ic_launcher);
	    	lazer.setX(spaceGhost.getX());
	    	lazer.setY(spaceGhost.getY());
	    }
	};
	
	private OnClickListener moveUp = new OnClickListener()
	{
		public void onClick(View v)
		{
			spaceGhost.setY(spaceGhost.getY() + 1);
		}
	};

	
	private OnClickListener moveDown = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	spaceGhost.setY(spaceGhost.getY() - 1);
	    }
	};
	
	private void check_collision(int enemy_count, ImageView emenies)
	{
		float playerX = spaceGhost.getX();
		float playerY = spaceGhost.getY();
				
		float q1X = playerX + (playerX / 2);
		float q1Y = playerY + (playerY / 2);
		
		float hitW = (playerX * (80/100)) / 2;
		float hitH = (playerY * (80/100)) / 2;
////////////////////////////////////////////////////////
		float bulletX = lazer.getX();
		float bulletY = lazer.getY();
			
	}
	
	
	private void theGame()
	{
		int enemy_count = 0;
		int enemy_cap = 3;
		boolean game_over = false;
		int spawn_time = 1000;
		int delay = 1001;
		
		ImageView[] enemies = new ImageView[enemy_cap];
				
		for(int x = 0; x < enemy_cap; x++)
		{
			enemies[x].setVisibility(0);
			enemies[x].setImageResource(R.drawable.ic_launcher);
			enemies[x].setMaxHeight(10);
			enemies[x].setMaxWidth(10);
		}
		
		while(!game_over)
		{
			if(delay <= spawn_time || delay == 3000)
			{
				if(enemy_count < enemy_cap)
				{
					enemies[enemy_count].setVisibility(1);
					enemies[enemy_count].setX(800);
					enemies[enemy_count].setY(800);
				}
			}
			else
			{
				delay++;
			}
			
			for(int x = 0; x <= enemy_count; x++)
			{
				enemies[x].setX(enemies[x].getX() - 5);
				enemies[x].setY(enemies[x].getY() - 5);
				//check_collision(enemy_count, enemies);
			}
			
			for(int x = 0; x <= enemy_count; x++)
			{
				enemies[x].setX(enemies[x].getX() + 5);
				enemies[x].setY(enemies[x].getY() + 5);
				//check_collision(enemy_count, enemies);
			}
			
				
		}//end game loop
	}//end game method
}

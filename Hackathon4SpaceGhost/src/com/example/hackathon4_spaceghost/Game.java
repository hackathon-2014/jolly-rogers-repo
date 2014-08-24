package com.example.hackathon4_spaceghost;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class Game extends Fragment 
{
	private Button btnShoot = new Button(getActivity());
	private Button btnUp = new Button(getActivity());
	private Button btnDwn = new Button(getActivity());
	private ImageView spaceGhost = new ImageView(getActivity());
	private ImageView lazer = new ImageView(getActivity());
	private TextView score = new TextView(getActivity());
	
	private int enemy_cap = 3;

	private ImageView[] enemies = new ImageView[enemy_cap];
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
	    // TODO Auto-generated method stub
	    super.onCreateView(inflater, container, savedInstanceState);
	    View view =
	    		inflater.inflate(R.layout.game_screen, container, false);
	    
	    //Set a FrameLayout to add buttons
	    RelativeLayout layout = new RelativeLayout(getActivity());
	    // Set the layout full width, full height
	    LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	    layout.setLayoutParams(params);
	    //FrameLayout.setOrientation(FrameLayout.HORIZONTAL); //or VERTICAL

	    spaceGhost.setLayoutParams(params);
	    spaceGhost.setX(50);
	    spaceGhost.setY(50);
	    spaceGhost.setImageResource(R.drawable.space_ghost_flying);
	    	    
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
	    
	    lazer.setLayoutParams(params);
	    lazer.setImageResource(R.drawable.ic_launcher);
	    lazer.setVisibility(1);
	    
	    score.setLayoutParams(params);
	    score.setX(800);
	    score.setY(100);
	    
	    for(int x = 0; x < enemy_cap; x++)
	    {
	    	enemies[x].setLayoutParams(params);
	    }

	    

	    layout.addView(spaceGhost);
	    layout.addView(btnShoot);
	    layout.addView(btnUp);
	    layout.addView(lazer);
	    layout.addView(score);
	    
	    for(int x = 0; x < enemy_cap; x++)
	    {
	    	layout.addView(enemies[x]);
	    }

	    container.addView(layout);
	    
	    
	    theGame();
	    
	    return view;
	}
	
	private OnClickListener shoot = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	lazer.setVisibility(0);
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
	
	private boolean check_collision(int enemy_count, ImageView[] enemies)
	{
		boolean gameOver = false;
		
		
		float playerX = spaceGhost.getX();
		float playerY = spaceGhost.getY();
				
		float pqX = playerX + (playerX / 2);
		float pqY = playerY + (playerY / 2);
		
		float phitW = (spaceGhost.getWidth() * (80/100)) / 2;
		float phitH = (spaceGhost.getHeight() * (80/100)) / 2;
////////////////////////////////////////////////////////
		float bulletX = lazer.getX();
		float bulletY = lazer.getY();
		
		float bqX = bulletX + (bulletX / 2);
		float bqY = bulletY + (bulletY / 2);
		
		float bhitW = (lazer.getWidth() * (80/100)) /2;	
		float bhitH = (lazer.getHeight() * (80/100)) / 2;
		
		/////////////////////////////////////////////////////////
		
		for(int x = 0; x < enemy_count; x++)
		{
			float enemyX = enemies[x].getX();
			float enemyY = enemies[x].getY();
			
			float eqW = enemyX + (enemyX / 2);
			float eqY = enemyY + (enemyY / 2);
			
			float ehitW = (enemies[x].getWidth() * (80/100)) / 2;
			float ehitH = (enemies[x].getHeight() * (80/100)) / 2;
			
			//detects if an enemy collides with a player or lazer
			for(float b = eqW - ehitW; b < eqW + ehitH; b++)
			{
				for(float a = eqY - ehitH; a < eqY + ehitH; a++)
				{
					if(a > pqY - phitH && a < pqY + phitH && b > pqX - phitW && b < pqX + phitW)
					{
						gameOver = true;
					}
					else if(a > bqY - bhitH && a < bqY + bhitH && b > bqX - bhitW && b < bqX + bhitW)
					{
						gameOver = true;
					}
				}
			}	
		}
		
		return gameOver;
	}
	
	
	private void theGame()
	{
		int enemy_count = 0;
		boolean game_over = false;
		int spawn_time = 1000;
		int delay = 1001;
		
		
				
		for(int x = 0; x < enemy_cap; x++)
		{
			enemies[x].setVisibility(1);
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
					enemies[enemy_count].setVisibility(0);
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
				if(enemies[x].getVisibility() == 0)
				{
					for(int z = 0; z < 5; z++)
					{
						enemies[x].setX(enemies[x].getX() - 1);
						enemies[x].setY(enemies[x].getY() - 1);
						if(enemies[x].getX() != -1)
						{
							check_collision(enemy_count, enemies);
						}
						else
						{
							enemies[x].setVisibility(1);
						}
					}
				}
			}
			
			for(int x = 0; x <= enemy_count; x++)
			{
				if(enemies[x].getVisibility() == 0)
				{
					for(int z = 0; z < 5; z++)
					{
						enemies[x].setX(enemies[x].getX() + 1);
						enemies[x].setY(enemies[x].getY() + 1);
						if(enemies[x].getX() != -1)
						{
							check_collision(enemy_count, enemies);
						}
						else
						{
							enemies[x].setVisibility(1);
						}
					}
				}
			}
			
			if(lazer.getVisibility() == 0)
			{
				lazer.setX(lazer.getX() + 1);
				
				if(lazer.getX() > 1950)
				{
					lazer.setVisibility(1);
				}				
			}
				
		}//end game loop
	}//end game method
}

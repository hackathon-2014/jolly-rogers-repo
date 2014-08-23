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
	private ImageView spaceGhost = new ImageView(getActivity());
	
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
	    //... and other views
	    
	    
	    

	    ViewGroup viewGroup = (ViewGroup) view;

	    FrameLayout.addView(spaceGhost);
	    FrameLayout.addView(btnShoot);
	    FrameLayout.addView(btnUp);

	    viewGroup.addView(FrameLayout);
	}
	
	private OnClickListener shoot = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	      
	    }
	};
	
	private OnClickListener moveUp = new OnClickListener()
	{
		public void onClick(View v)
		{
			spaceGhost.setY(spaceGhost.getY() + 1);
		}
	};
}

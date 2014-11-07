package com.example.dddice;

import java.util.Random;

//import com.example.dddice.FragmentTab2.DiceAnimation;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.DiceApp.dddice.R;

public class FragmentTab3 extends Fragment {
	ImageButton button;
	ImageButton soundtoggle;
	Thread t;
	static ImageView image;
	
	
	

	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState)
	  {
		  
		final View view = inflater.inflate(R.layout.tab, container, false);
		
		image = (ImageView) view.findViewById(R.id.imageView1);
		
		button = (ImageButton) view.findViewById(R.id.roll_button);
		
		image.setBackgroundResource(R.drawable.d8_animated);
		
		final MediaPlayer mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.rollsound);

		soundtoggle = (ImageButton) view.findViewById(R.id.sound_indicator);
		
		if (MainActivity.sound==true){
			  soundtoggle.setImageResource(R.drawable.soundon);
		  } else{
			  soundtoggle.setImageResource(R.drawable.soundoff);
		  }
		
		button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0)
            {
            	
            	image.setBackgroundResource(R.drawable.d8_animated);
            	final AnimationDrawable rolling = (AnimationDrawable) image.getBackground();
            	rolling.start();
            	
            	if(MainActivity.sound==true){
            		mp.start();
            	}
            	
            	view.postDelayed(new Runnable() {
            	    @Override
            	    public void run() {
            	    	finalRoll(1,8);
            	    }
            	}, 500);//this number should match up to duration of animation
            	
        		
        		
            }
        });
		
		
		soundtoggle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0)
            {
            	if (MainActivity.sound==true){
      			  soundtoggle.setImageResource(R.drawable.soundoff);
      			  MainActivity.sound=false;
      		  } else{
      			  soundtoggle.setImageResource(R.drawable.soundon);
      			  MainActivity.sound=true;
      		  }
            		            	
        		
        		
            }
        });
		
		
		return view;
	  }
	  
	  
	  public static void finalRoll(int min, int max) 
	  {

		int outcome = randInt(min,max);
      	
      	if(outcome==1)
      	{
      		image.setBackgroundResource(R.drawable.d8_1);
      	} else if(outcome==2) {
      		image.setBackgroundResource(R.drawable.d8_2);
      	}else if(outcome==3) {
      		image.setBackgroundResource(R.drawable.d8_3);
      	}else if(outcome==4) {
      		image.setBackgroundResource(R.drawable.d8_4);
      	}else if(outcome==5) {
      		image.setBackgroundResource(R.drawable.d8_5);
      	}else if(outcome==6) {
      		image.setBackgroundResource(R.drawable.d8_6);
      	}else if(outcome==7) {
      		image.setBackgroundResource(R.drawable.d8_7);
      	}else if(outcome==8) {
      		image.setBackgroundResource(R.drawable.d8_8);
      	}
      	
		    
	  }
	  
	  
	  public static int randInt(int min, int max) 
	  {

		    // Usually this should be a field rather than a method variable so
		    // that it is not re-seeded every call.
		    Random rand = new Random();

		    // nextInt is normally exclusive of the top value,
		    // so add 1 to make it inclusive
		    int randomNum = rand.nextInt((max - min) + 1) + min;

		    return randomNum;
	  }
	}
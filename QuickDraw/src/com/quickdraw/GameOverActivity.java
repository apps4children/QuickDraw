package com.quickdraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.quickdraw.R;

public class GameOverActivity extends Activity{
	ImageView playAgain,exit;
	Animation animAlpha;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.gameover);
		playAgain = (ImageView)findViewById(R.id.playAgain);
		exit = (ImageView)findViewById(R.id.exit);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		
		playAgain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playAgain.startAnimation(animAlpha);
				Intent i = new Intent(GameOverActivity.this, GeometryShapesActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				exit.startAnimation(animAlpha);
				//GeometryShapesActivity.geometryShapesActivity.finish();
				finish();
				System.exit(0);
			}
		});
	}

}

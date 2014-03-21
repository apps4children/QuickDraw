package com.quickdraw;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.quickdraw.R;

public class GeometryShapesActivity extends Activity {
	
	//static GeometryShapesActivity geometryShapesActivity;
	ImageView play,rule,exit;
	Animation animAlpha;
    final CharSequence[] levels = {"पहला स्तर","दूसरा स्तर"};
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_geometry_shapes);
        
        //geometryShapesActivity = this;
        
		play = (ImageView)findViewById(R.id.play);
		rule = (ImageView)findViewById(R.id.rule);
		exit = (ImageView)findViewById(R.id.exit);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		
		play.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint({ "InlinedApi", "NewApi" })
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				play.startAnimation(animAlpha);
//				Intent i = new Intent(GeometryShapesActivity.this, Badminton.class);
//				startActivity(i);

				AlertDialog.Builder builder = new AlertDialog.Builder(GeometryShapesActivity.this);
				builder.setTitle("खेल के स्तर का चयन करें");
				builder.setItems(levels, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						if(which == 0){
							Intent i = new Intent(getApplicationContext(), Badminton.class);
							startActivity(i);
							finish();
						}
						else{
							Intent i = new Intent(getApplicationContext(), Level2.class);
							startActivity(i);
							finish();
						}
					}
				});
				
				AlertDialog alert = builder.create();
				builder.show();
			}
		});
		
		rule.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rule.startAnimation(animAlpha);
				Intent i = new Intent(GeometryShapesActivity.this, Instructions.class);
				startActivity(i);

			}
		});
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				exit.startAnimation(animAlpha);
				finish();
				System.exit(0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.geometry_shapes, menu);
		return true;
	}

}

package com.quickdraw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.quickdraw.R;

public class Boat extends Activity {

List<Integer> numbers = new ArrayList<Integer>();
MediaPlayer mediaPlayer;
	Animation animAlpha;
    Button back,next;
	int[] boatShapes= {R.drawable.boat_left,R.drawable.boat_right,R.drawable.boat_mid,R.drawable.boatup_left,R.drawable.boatup_right,R.drawable.flag,
			           R.drawable.chimney,R.drawable.circle};
	
	String[] boatNames= {"boatLeft","boatRight","boatMid","boatUpLeft","boatUpRight","flag","chimney","circle"};
	String name[]={"boatLeft","boatRight","boatMid","boatUpLeft","boatUpRight","flag"};
	
	public ImageView boatLeft,boatRight,boatMid,boatUpLeft,boatUpRight,flag,bottom1,bottom2,bottom3,bottom4,bottom5,bottom6,bottom7,bottom8,source,target,temp;
	                           
	String src,tar;
    MyDragEventListener myDragEventListener = new MyDragEventListener();

    
    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.boat);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		for(int i=0;i<8;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		boatLeft=(ImageView) findViewById(R.id.boatLeft);
		//tri.setImageResource(boatShapes[numbers.get(0).intValue()]);
		boatLeft.setContentDescription("1");
		boatLeft.setTag("boatLeft");
		boatLeft.setOnTouchListener(new MyTouchListener());
		boatLeft.setOnDragListener(myDragEventListener);
		
		boatRight=(ImageView) findViewById(R.id.boatRight);
		boatRight.setContentDescription("2");
		//tri2.setImageResource(boatShapes[numbers.get(1).intValue()]);
		boatRight.setTag("boatRight");
		boatRight.setOnTouchListener(new MyTouchListener());
		boatRight.setOnDragListener(myDragEventListener);
		
		boatMid=(ImageView) findViewById(R.id.boatMid);
		boatMid.setContentDescription("3");
		//tri2.setImageResource(boatShapes[numbers.get(1).intValue()]);
		boatMid.setTag("boatMid");
		boatMid.setOnTouchListener(new MyTouchListener());
		boatMid.setOnDragListener(myDragEventListener);
		
		boatUpLeft=(ImageView) findViewById(R.id.boatupLeft);
		boatUpLeft.setContentDescription("4");
		//tri2.setImageResource(boatShapes[numbers.get(1).intValue()]);
		boatUpLeft.setTag("boatUpLeft");
		boatUpLeft.setOnTouchListener(new MyTouchListener());
		boatUpLeft.setOnDragListener(myDragEventListener);
		
		boatUpRight=(ImageView) findViewById(R.id.boatupRight);
		boatUpRight.setContentDescription("5");
		//tri2.setImageResource(boatShapes[numbers.get(1).intValue()]);
		boatUpRight.setTag("boatUpRight");
		boatUpRight.setOnTouchListener(new MyTouchListener());
		boatUpRight.setOnDragListener(myDragEventListener);
		
		flag=(ImageView) findViewById(R.id.flag);
		flag.setContentDescription("6");
		//tri2.setImageResource(boatShapes[numbers.get(1).intValue()]);
		flag.setTag("flag");
		flag.setOnTouchListener(new MyTouchListener());
		flag.setOnDragListener(myDragEventListener);
						
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(boatShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(boatNames[(Integer)numbers.get(0).intValue()]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(boatShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(boatNames[(Integer)numbers.get(1).intValue()]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(boatShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(boatNames[(Integer)numbers.get(2).intValue()]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(boatShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(boatNames[(Integer)numbers.get(3).intValue()]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(boatShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(boatNames[(Integer)numbers.get(4).intValue()]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(boatShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(boatNames[(Integer)numbers.get(5).intValue()]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		
		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(boatShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(boatNames[(Integer)numbers.get(6).intValue()]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);
		
		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(boatShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(boatNames[(Integer)numbers.get(7).intValue()]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);

		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Boat.this, Butterfly.class);
				startActivity(i);
				overridePendingTransition(R.anim.bottom_in,R.anim.top_out);
				finish();
			}
		});
		
		next = (Button)findViewById(R.id.next);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				next.startAnimation(animAlpha);
				Intent i = new Intent(Boat.this, Train.class);
				startActivity(i);
				overridePendingTransition(R.anim.right_in,R.anim.left_out);
				finish();
			}
		});
}
    private final class MyTouchListener implements OnTouchListener 
	{
	    @SuppressLint("NewApi")
		public boolean onTouch(View view, MotionEvent motionEvent) 
	    {
	    	if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) 
	    	{
				source=(ImageView)view;
				src=source.getTag().toString();
				
				ClipData clipData = ClipData.newPlainText("","");
	            View.DragShadowBuilder dsb = new View.DragShadowBuilder(view);
	            view.startDrag(clipData, dsb, view, 0);
	            return true;
	        } 
	    	else 
	        {
	            return false;
	        }
	    }
	 }
	@SuppressLint("NewApi")
	private static class MyDragShadowBuilder extends View.DragShadowBuilder 
	{
	    private static Drawable shadow;
	    @SuppressLint("NewApi")
		public MyDragShadowBuilder(View v) 
	    {
	      super(v);
	      shadow = new ColorDrawable(Color.LTGRAY);
	    }
	    @SuppressLint("NewApi")
		@Override
	    public void onProvideShadowMetrics (Point size, Point touch)
	    {
	      int width = getView().getWidth();
	      int height = getView().getHeight();
	      shadow.setBounds(0, 0, width, height);
	      size.set(width, height);
	      touch.set(width / 2, height / 2);
	    }
	    @Override
	    public void onDrawShadow(Canvas canvas) 
	    {
	      shadow.draw(canvas);
	    }
	}
	@SuppressLint("NewApi")
	protected class MyDragEventListener implements View.OnDragListener 
	 {
	   @SuppressLint("NewApi")
	   public boolean onDrag(View v, DragEvent event) 
	   {
	   target=(ImageView)v;
	   temp=target;
	   tar=target.getTag().toString();
	   final int action = event.getAction();
	   View dragView = (View) event.getLocalState();
	   switch(action) 
	   {
	   case DragEvent.ACTION_DRAG_STARTED:
        return true;
	   case DragEvent.ACTION_DRAG_ENTERED:
	    return true;
	   case DragEvent.ACTION_DRAG_LOCATION:
	    return true;
	   case DragEvent.ACTION_DRAG_EXITED:
	    return true;
	   case DragEvent.ACTION_DROP:
		    
/*	        System.out.println("Source Tag="+source.getTag().toString());
	        System.out.println("Target Tag="+target.getTag().toString());
	        ((ImageView)target).setImageResource(trainShapes[Integer.parseInt(source.getTag().toString())]);
	        ((ImageView)source).setImageResource(trainShapes[Integer.parseInt(temp.getTag().toString())]);
	        
	        ((ImageView)target).setTag(src);
	        ((ImageView)source).setTag(tar);*/
		   
		  /* if(target.getTag().equals(source.getTag())&&(target.getContentDescription().equals("1")||target.getContentDescription().equals("2")||target.getContentDescription().equals("3")||target.getContentDescription().equals("4")||target.getContentDescription().equals("5")||
				   target.getContentDescription().equals("6")))
		   {
			   
                int index=Arrays.asList(boatNames).indexOf(source.getTag());

		        ((ImageView)target).setImageResource(boatShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        ((ImageView)target).setOnTouchListener(null);
		        ((ImageView)source).setTag("0");
		   }*/
		  if(target.getContentDescription().equals("1")||target.getContentDescription().equals("2")||target.getContentDescription().equals("3")||target.getContentDescription().equals("4")||target.getContentDescription().equals("5")||
				   target.getContentDescription().equals("6")){
			  int index=Arrays.asList(boatNames).indexOf(source.getTag());

              if(boatLeft.getTag().toString().equals(source.getTag().toString()))
              {
            	  boatLeft.setImageResource(boatShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        boatLeft.setOnTouchListener(null);
		        boatLeft.setTag("1");
		        ((ImageView)source).setTag("0");
              }
              else if(boatRight.getTag().toString().equals(source.getTag().toString()))
              {
            	  boatRight.setImageResource(boatShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        boatRight.setOnTouchListener(null);
		        boatRight.setTag("1");
		        ((ImageView)source).setTag("0");
              }
              
              else if(boatMid.getTag().toString().equals(source.getTag().toString()))
              {
            	  boatMid.setImageResource(boatShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        boatMid.setOnTouchListener(null);
		        boatMid.setTag("1");
		        ((ImageView)source).setTag("0");
              }
              else if(boatUpLeft.getTag().toString().equals(source.getTag().toString()))
              {
            	  boatUpLeft.setImageResource(boatShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        boatUpLeft.setOnTouchListener(null);
		        boatUpLeft.setTag("1");
		        ((ImageView)source).setTag("0");
              }
              else if(boatUpRight.getTag().toString().equals(source.getTag().toString()))
              {
            	  boatUpRight.setImageResource(boatShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        boatUpRight.setOnTouchListener(null);
		        boatUpRight.setTag("1");
		        ((ImageView)source).setTag("0");
              }
              else if(flag.getTag().toString().equals(source.getTag().toString()))
              {
            	  flag.setImageResource(boatShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        flag.setOnTouchListener(null);
		        flag.setTag("1");
		        ((ImageView)source).setTag("0");
              }

		  }
	        //System.out.println("Name===="+name[Integer.parseInt(top2.getTag().toString())]);
	       
	       result();
	       //System.out.println("First Image Name:="+name[Integer.parseInt(tri.getTag().toString())]);
	        return true;
	   case DragEvent.ACTION_DRAG_ENDED:
	        return true;
	   default:
	        return false;
	        }
	      }
	 }

	private void result() {
		// TODO Auto-generated method stub
		if(boatMid.getTag().equals("1")
		   &&boatRight.getTag().equals("1")
		   &&boatLeft.getTag().equals("1")
		   &&boatUpLeft.getTag().equals("1")
		   &&boatUpRight.getTag().equals("1")
		   &&flag.getTag().equals("1"))
		{
//			mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.excellent);
//			mediaPlayer.start();
			new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   
                    Intent i=new Intent(Boat.this,Train.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_in,R.anim.left_out);
                    finish();
                }
            }, 500);
	}
	    }

		
}

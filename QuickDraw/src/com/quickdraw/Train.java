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

public class Train extends Activity {

    List<Integer> numbers = new ArrayList<Integer>();
    MediaPlayer mediaPlayer;
	Animation animAlpha;
    Button back,next;
	int[] trainShapes= {R.drawable.train_body,R.drawable.chimney,R.drawable.train_body,R.drawable.small_rod,R.drawable.train_window,R.drawable.net,
			                R.drawable.stem,R.drawable.tri};
	String[] trainNames= {"frontBox","chimney","trainBody","smallRod","trainWindow","net","stem","tri"};
	String name[]={"frontBox","chimney","trainBody","smallRod","trainWindow"};
	
	public ImageView frontBox,chimney,trainBody,smallRod,trainWindow,bottom1,bottom2,bottom3,bottom4,bottom5,bottom6,
	                           bottom7,bottom8,source,target,temp;
	String src,tar;
    MyDragEventListener myDragEventListener = new MyDragEventListener();

    
    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.train);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		
		for(int i=0;i<8;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		frontBox=(ImageView) findViewById(R.id.trainFront);
		//tri.setImageResource(trainShapes[numbers.get(0).intValue()]);
		frontBox.setContentDescription("1");
		frontBox.setTag("frontBox");
		frontBox.setOnTouchListener(new MyTouchListener());
		frontBox.setOnDragListener(myDragEventListener);
		
		chimney=(ImageView) findViewById(R.id.chimney);
		chimney.setContentDescription("2");
		//tri2.setImageResource(trainShapes[numbers.get(1).intValue()]);
		chimney.setTag("chimney");
		chimney.setOnTouchListener(new MyTouchListener());
		chimney.setOnDragListener(myDragEventListener);
		
/*		trainDoor=(ImageView) findViewById(R.id.mainDoor);
		trainDoor.setContentDescription("3");
		//tri2.setImageResource(trainShapes[numbers.get(1).intValue()]);
		trainDoor.setTag("trainDoor");
		trainDoor.setOnTouchListener(new MyTouchListener());
		trainDoor.setOnDragListener(myDragEventListener);*/
		
		trainBody=(ImageView) findViewById(R.id.firstBlock);
		trainBody.setContentDescription("3");
		//tri2.setImageResource(trainShapes[numbers.get(1).intValue()]);
		trainBody.setTag("trainBody");
		trainBody.setOnTouchListener(new MyTouchListener());
		trainBody.setOnDragListener(myDragEventListener);
		
		smallRod=(ImageView) findViewById(R.id.connecter1);
		smallRod.setContentDescription("4");
		//tri2.setImageResource(trainShapes[numbers.get(1).intValue()]);
		smallRod.setTag("smallRod");
		smallRod.setOnTouchListener(new MyTouchListener());
		smallRod.setOnDragListener(myDragEventListener);
		
		trainWindow=(ImageView) findViewById(R.id.trainWindow);
		trainWindow.setContentDescription("5");
		//tri2.setImageResource(trainShapes[numbers.get(1).intValue()]);
		trainWindow.setTag("trainWindow");
		trainWindow.setOnTouchListener(new MyTouchListener());
		trainWindow.setOnDragListener(myDragEventListener);
						
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(trainShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(trainNames[(Integer)numbers.get(0).intValue()]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(trainShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(trainNames[(Integer)numbers.get(1).intValue()]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(trainShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(trainNames[(Integer)numbers.get(2).intValue()]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(trainShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(trainNames[(Integer)numbers.get(3).intValue()]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(trainShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(trainNames[(Integer)numbers.get(4).intValue()]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(trainShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(trainNames[(Integer)numbers.get(5).intValue()]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		
		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(trainShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(trainNames[(Integer)numbers.get(6).intValue()]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);
		
		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(trainShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(trainNames[(Integer)numbers.get(7).intValue()]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);
		
		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Train.this, Boat.class);
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
				Intent i = new Intent(Train.this, Truck.class);
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
		   
		   if(target.getContentDescription().equals("1")||target.getContentDescription().equals("2")||target.getContentDescription().equals("3")||target.getContentDescription().equals("4")||target.getContentDescription().equals("5"))
		   {
			   
                int index=Arrays.asList(trainNames).indexOf(source.getTag());

                if(frontBox.getTag().toString().equals(source.getTag().toString()))
                {
                	frontBox.setImageResource(trainShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        frontBox.setOnTouchListener(null);
		        frontBox.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(chimney.getTag().toString().equals(source.getTag().toString()))
                {
                	chimney.setImageResource(trainShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        chimney.setOnTouchListener(null);
		        chimney.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                
                else if(trainBody.getTag().toString().equals(source.getTag().toString()))
                {
                	trainBody.setImageResource(trainShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        trainBody.setOnTouchListener(null);
		        trainBody.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(smallRod.getTag().toString().equals(source.getTag().toString()))
                {
                	smallRod.setImageResource(trainShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        smallRod.setOnTouchListener(null);
		        smallRod.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(trainWindow.getTag().toString().equals(source.getTag().toString()))
                {
                	trainWindow.setImageResource(trainShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        trainWindow.setOnTouchListener(null);
		        trainWindow.setTag("1");
		        ((ImageView)source).setTag("0");
                }
		   }
		   
		   result();
	        return true;
	   case DragEvent.ACTION_DRAG_ENDED:
	        return true;
	   default:
	        return false;
	        }
	      }
	    }
	
	public void result()
	{
		if(frontBox.getTag().equals("1") &&chimney.getTag().equals("1") &&trainBody.getTag().equals("1") &&smallRod.getTag().equals("1")
		   &&trainWindow.getTag().equals("1"))
		{
//			mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.excellent);
//			mediaPlayer.start();
			new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   
                    Intent i=new Intent(Train.this,Truck.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_in,R.anim.left_out);
                    finish();
                }
            }, 500);
		}
	}
		
}

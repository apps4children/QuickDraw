package com.quickdraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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

public class Hut extends Activity{
	
//	MediaPlayer mediaPlayer;
	List<Integer> numbers = new ArrayList<Integer>();
    Animation animAlpha;
    Button back, next;
	int[] hutShapes= {R.drawable.hut_top,R.drawable.window1,R.drawable.window1,
			             R.drawable.left_side,R.drawable.stem,R.drawable.footer1,R.drawable.circle};

	String hutNames[]={"hut_top","window1","window2","left_side","stem","footer","circle"};
	String name[]={"hut_top","window1","window2"};

	public ImageView hutTop,window1,window2,bottom1,bottom2,bottom7,
	                 bottom3,bottom4,bottom5,bottom6,source,target,temp;
	String src,tar;
    MyDragEventListener myDragEventListener = new MyDragEventListener();
    Intent intent;

	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.hut);
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		for(int i=0;i<7;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Hut.this, Play.class);
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
				intent = new Intent(Hut.this, Rocket.class);
				startActivity(intent);
				overridePendingTransition(R.anim.right_in,R.anim.left_out);
				finish();
			}
		});
		
		hutTop=(ImageView) findViewById(R.id.hut_top);
		hutTop.setId(1);
	//	top.setImageResource(hutShapes[numbers.get(0).intValue()]);
		hutTop.setTag("hut_top");
		hutTop.setOnTouchListener(new MyTouchListener());
		hutTop.setOnDragListener(myDragEventListener);
		
		window1=(ImageView) findViewById(R.id.window1);
		window1.setId(2);
	//	centerTop.setImageResource(hutShapes[numbers.get(1).intValue()]);
		window1.setTag("window1");
		window1.setOnTouchListener(new MyTouchListener());
		window1.setOnDragListener(myDragEventListener);
		
		window2=(ImageView) findViewById(R.id.window2);
		window2.setId(3);
	//	centerBelow.setImageResource(hutShapes[numbers.get(2).intValue()]);
		window2.setTag("window2");
		window2.setOnTouchListener(new MyTouchListener());
		window2.setOnDragListener(myDragEventListener);
				
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(hutShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(hutNames[(Integer)numbers.get(0)]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(hutShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(hutNames[(Integer)numbers.get(1)]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(hutShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(hutNames[(Integer)numbers.get(2)]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(hutShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(hutNames[(Integer)numbers.get(3)]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(hutShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(hutNames[(Integer)numbers.get(4)]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);
		
		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(hutShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(hutNames[(Integer)numbers.get(5)]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);

		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(hutShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(hutNames[(Integer)numbers.get(6)]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);

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
	//
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
		   
		   if(target.getId()==1||target.getId()==2||target.getId()==3)
		   {

			   int index=Arrays.asList(hutNames).indexOf(source.getTag());

               if(hutTop.getTag().toString().equals(source.getTag().toString()))
               {
            	   hutTop.setImageResource(hutShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        hutTop.setOnTouchListener(null);
		        hutTop.setTag("1");
		        ((ImageView)source).setTag("0");
               }
               else if(window1.getTag().toString().equals(source.getTag().toString()))
               {
            	   window1.setImageResource(hutShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        window1.setOnTouchListener(null);
		        window1.setTag("1");
		        ((ImageView)source).setTag("0");
               }
               
               else if(window2.getTag().toString().equals(source.getTag().toString()))
               {
            	   window2.setImageResource(hutShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        window2.setOnTouchListener(null);
		        window2.setTag("1");
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
		if(hutTop.getTag().equals("1")&&window1.getTag().equals("1")&&window2.getTag().equals("1"))
		{
//					mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.good);
//					mediaPlayer.start();
					new Handler().postDelayed(new Runnable() {
	                      @Override
	                      public void run() {
                           
	                          Intent i=new Intent(Hut.this,Rocket.class);
	                          //startAnimation(animAlpha);
	                          startActivity(i);
	                          overridePendingTransition(R.anim.right_in,R.anim.left_out);
	                          finish();
	                      }
	                  },500);
		}
	}
	

	   }


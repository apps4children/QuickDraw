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

public class Plane extends  Activity 
{
	List<Integer> numbers = new ArrayList<Integer>();
	MediaPlayer mediaPlayer;
	Button back,next;
	int[] planeShapes = {R.drawable.wing_top,R.drawable.wing_bottom,R.drawable.tail,R.drawable.window,R.drawable.truck_chimney,R.drawable.window1,R.drawable.tri,
			             R.drawable.tyre,R.drawable.handle,R.drawable.chimney,R.drawable.truck_tyre};
	
	String planeNames[] = {"wing_top","wing_bottom","tail","tyre","handle","chimney","truck_chimney","window1","tri","window",
			              "truck_tyre"};
	String namesPlane[] = {"wing_top","wing_bottom","tail"};
	
	ImageView wingTop,wingBottom,tail,bottom1,bottom2,bottom3,bottom4,bottom5,bottom6,bottom7,
	                 bottom8,bottom9,bottom10,bottom11,source,target,temp;
	String src,tar;
	Animation animAlpha;
	MyDragEventListener myDragEventListener = new MyDragEventListener();
	Intent intent;
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_plane);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		
		back = (Button)findViewById(R.id.back);
		next = (Button)findViewById(R.id.next);
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				intent = new Intent(Plane.this,Bus.class);
				startActivity(intent);
				overridePendingTransition(R.anim.bottom_in,R.anim.top_out);
				finish();
			}
		});
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				next.startAnimation(animAlpha);
				intent = new Intent(Plane.this,Butterfly.class);
				startActivity(intent);
				overridePendingTransition(R.anim.right_in,R.anim.left_out);
				finish();
			}
		});
		
		for(int i=0;i<11;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		wingTop = (ImageView)findViewById(R.id.wingTop);
		wingTop.setTag("wing_top");
		wingTop.setContentDescription("1");
		wingTop.setOnTouchListener(new MyTouchListener());
		wingTop.setOnDragListener(myDragEventListener);

/*		window1 = (ImageView)findViewById(R.id.win1);
		window1.setTag("window1");
		window1.setContentDescription("2");
		window1.setOnTouchListener(new MyTouchListener());
		window1.setOnDragListener(myDragEventListener);

		window2 = (ImageView)findViewById(R.id.win2);
		window2.setTag("window2");
		window2.setContentDescription("3");
		window2.setOnTouchListener(new MyTouchListener());
		window2.setOnDragListener(myDragEventListener);

		window3 = (ImageView)findViewById(R.id.win3);
		window3.setTag("window3");
		window3.setContentDescription("4");
		window3.setOnTouchListener(new MyTouchListener());
		window3.setOnDragListener(myDragEventListener);

		window4 = (ImageView)findViewById(R.id.win4);
		window4.setTag("window4");
		window4.setContentDescription("5");
		window4.setOnTouchListener(new MyTouchListener());
		window4.setOnDragListener(myDragEventListener);*/

		tail = (ImageView)findViewById(R.id.tail);
		tail.setTag("tail");
		tail.setContentDescription("2");
		tail.setOnTouchListener(new MyTouchListener());
		tail.setOnDragListener(myDragEventListener);

		wingBottom = (ImageView)findViewById(R.id.wingBottom);
		wingBottom.setTag("wing_bottom");
		wingBottom.setContentDescription("3");
		wingBottom.setOnTouchListener(new MyTouchListener());
		wingBottom.setOnDragListener(myDragEventListener);

		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(planeShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(planeNames[(Integer)numbers.get(0)]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);

		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(planeShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(planeNames[(Integer)numbers.get(1)]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);

		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(planeShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(planeNames[(Integer)numbers.get(2)]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);

		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(planeShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(planeNames[(Integer)numbers.get(3)]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(planeShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(planeNames[(Integer)numbers.get(4)]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(planeShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(planeNames[(Integer)numbers.get(5)]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);

		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(planeShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(planeNames[(Integer)numbers.get(6)]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);

		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(planeShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(planeNames[(Integer)numbers.get(7)]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);

		bottom9=(ImageView) findViewById(R.id.img9);
		bottom9.setImageResource(planeShapes[(Integer)numbers.get(8).intValue()]);
		bottom9.setTag(planeNames[(Integer)numbers.get(8)]);
		bottom9.setOnTouchListener(new MyTouchListener());
		bottom9.setOnDragListener(myDragEventListener);

		bottom10=(ImageView) findViewById(R.id.img10);
		bottom10.setImageResource(planeShapes[(Integer)numbers.get(9).intValue()]);
		bottom10.setTag(planeNames[(Integer)numbers.get(9)]);
		bottom10.setOnTouchListener(new MyTouchListener());
		bottom10.setOnDragListener(myDragEventListener);

		bottom11=(ImageView) findViewById(R.id.img11);
		bottom11.setImageResource(planeShapes[(Integer)numbers.get(10).intValue()]);
		bottom11.setTag(planeNames[(Integer)numbers.get(10)]);
		bottom11.setOnTouchListener(new MyTouchListener());
		bottom11.setOnDragListener(myDragEventListener);

	}
		
		final class MyTouchListener implements OnTouchListener 
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
			public MyDragShadowBuilder(View v) 
		    {
		      super(v);
		      shadow = new ColorDrawable(Color.LTGRAY);
		    }
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
			   
			   if(target.getContentDescription().equals("1")||target.getContentDescription().equals("2")||target.getContentDescription().equals("3"))
			   {

	                int index=Arrays.asList(planeNames).indexOf(source.getTag());

	                if(wingTop.getTag().toString().equals(source.getTag().toString()))
	                {
	                	wingTop.setImageResource(planeShapes[index]);
			        ((ImageView)source).setImageResource(R.drawable.transparent1);
			        
			        //((ImageView)target).setTag(src);
			        wingTop.setOnTouchListener(null);
			        wingTop.setTag("1");
			        ((ImageView)source).setTag("0");
	                }
	                else if(tail.getTag().toString().equals(source.getTag().toString()))
	                {
	                	tail.setImageResource(planeShapes[index]);
			        ((ImageView)source).setImageResource(R.drawable.transparent1);
			        
			        //((ImageView)target).setTag(src);
			        tail.setOnTouchListener(null);
			        tail.setTag("1");
			        ((ImageView)source).setTag("0");
	                }
	                
	                else if(wingBottom.getTag().toString().equals(source.getTag().toString()))
	                {
	                	wingBottom.setImageResource(planeShapes[index]);
			        ((ImageView)source).setImageResource(R.drawable.transparent1);
			        
			        //((ImageView)target).setTag(src);
			        wingBottom.setOnTouchListener(null);
			        wingBottom.setTag("1");
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
			if(wingTop.getTag().equals("1")
			   &&tail.getTag().equals("1")
			   &&wingBottom.getTag().equals("1"))
			   {
//				mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.verygood);
//			    mediaPlayer.start();			
				new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       
                        Intent i=new Intent(Plane.this,Butterfly.class);
                        //startAnimation(animAlpha);
                        startActivity(i);
                        overridePendingTransition(R.anim.right_in,R.anim.left_out);
                        finish();
                    }
                }, 500);
			   }
		}
	}



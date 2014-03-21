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

public class Badminton extends Activity {

List<Integer> numbers = new ArrayList<Integer>();
	
//    MediaPlayer mediaPlayer;
    Button back,next;
	int[] badmintonShapes= {R.drawable.net,R.drawable.handle,R.drawable.tri2,R.drawable.net,R.drawable.handle,
			                R.drawable.circle,R.drawable.left_side,R.drawable.window1,R.drawable.truck_window,R.drawable.truck_chimney};
	String[] badmintonNames= {"net","handle","triLower","net2","handle2","circle","left_side","window","truckWindow","chimney"};
	String name[]={"net","handle","net2","handle2"};
	
	public ImageView net,handle,net2,handle2,bottom1,bottom2,bottom3,bottom4,bottom5,bottom6,bottom7,bottom8,bottom9,bottom10,source,target,temp;
	String src,tar;
	Animation animAlpha;
    MyDragEventListener myDragEventListener = new MyDragEventListener();

    
    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.badminton);
				
		animAlpha= AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
		for(int i=0;i<10;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		net=(ImageView) findViewById(R.id.net);
		//tri.setImageResource(badmintonShapes[numbers.get(0).intValue()]);
		net.setId(1);
		net.setTag("net");
		net.setOnTouchListener(new MyTouchListener());
		net.setOnDragListener(myDragEventListener);
		
		handle=(ImageView) findViewById(R.id.handle);
		handle.setId(2);
		//tri2.setImageResource(badmintonShapes[numbers.get(1).intValue()]);
		handle.setTag("handle");
		handle.setOnTouchListener(new MyTouchListener());
		handle.setOnDragListener(myDragEventListener);
		
		net2=(ImageView) findViewById(R.id.net2);
		//tri.setImageResource(badmintonShapes[numbers.get(0).intValue()]);
		net2.setId(3);
		net2.setTag("net2");
		net2.setOnTouchListener(new MyTouchListener());
		net2.setOnDragListener(myDragEventListener);
		
		handle2=(ImageView) findViewById(R.id.handle2);
		//tri.setImageResource(badmintonShapes[numbers.get(0).intValue()]);
		handle2.setId(4);
		handle2.setTag("handle2");
		handle2.setOnTouchListener(new MyTouchListener());
		handle2.setOnDragListener(myDragEventListener);
		
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(badmintonShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(badmintonNames[(Integer)numbers.get(0).intValue()]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(badmintonShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(badmintonNames[(Integer)numbers.get(1).intValue()]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(badmintonShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(badmintonNames[(Integer)numbers.get(2).intValue()]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(badmintonShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(badmintonNames[(Integer)numbers.get(3).intValue()]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(badmintonShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(badmintonNames[(Integer)numbers.get(4).intValue()]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(badmintonShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(badmintonNames[(Integer)numbers.get(5).intValue()]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		
		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(badmintonShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(badmintonNames[(Integer)numbers.get(6).intValue()]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);
		
		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(badmintonShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(badmintonNames[(Integer)numbers.get(7).intValue()]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);
		
		bottom9=(ImageView) findViewById(R.id.img9);
		bottom9.setImageResource(badmintonShapes[(Integer)numbers.get(8).intValue()]);
		bottom9.setTag(badmintonNames[(Integer)numbers.get(8).intValue()]);
		bottom9.setOnTouchListener(new MyTouchListener());
		bottom9.setOnDragListener(myDragEventListener);

		bottom10=(ImageView) findViewById(R.id.img10);
		bottom10.setImageResource(badmintonShapes[(Integer)numbers.get(9).intValue()]);
		bottom10.setTag(badmintonNames[(Integer)numbers.get(9).intValue()]);
		bottom10.setOnTouchListener(new MyTouchListener());
		bottom10.setOnDragListener(myDragEventListener);

		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Badminton.this, GeometryShapesActivity.class);
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
				Intent i = new Intent(Badminton.this, Play.class);
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
	        ((ImageView)target).setImageResource(badmintonShapes[Integer.parseInt(source.getTag().toString())]);
	        ((ImageView)source).setImageResource(badmintonShapes[Integer.parseInt(temp.getTag().toString())]);
	        
	        ((ImageView)target).setTag(src);
	        ((ImageView)source).setTag(tar);*/
		   
		   if(target.getId()==1||target.getId()==2||target.getId()==3||target.getId()==4)
		   {
			   
               /* int index=Arrays.asList(badmintonNames).indexOf(source.getTag());

		        ((ImageView)target).setImageResource(badmintonShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        ((ImageView)target).setOnTouchListener(null);
		        ((ImageView)source).setTag("0");*/
			   
			   int index=Arrays.asList(badmintonNames).indexOf(source.getTag());

               if(net.getTag().toString().equals(source.getTag().toString()))
               {
		        net.setImageResource(badmintonShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent_net);
		        
		        //((ImageView)target).setTag(src);
		        net.setOnTouchListener(null);
		        net.setTag("1");
		        ((ImageView)source).setTag("0");
               }
               else if(net2.getTag().toString().equals(source.getTag().toString()))
               {
		        net2.setImageResource(badmintonShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent_net);
		        
		        //((ImageView)target).setTag(src);
		        net2.setOnTouchListener(null);
		        net2.setTag("1");
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
	
	public void result()
	{
		if(net.getTag().equals("1")&&net2.getTag().equals("1"))
		{
		  // intent = new Intent(MakeDrawingActivity.this, Home.class);
		   //startActivity(intent); 
					//mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.good);
					//mediaPlayer.start();
					new Handler().postDelayed(new Runnable() {
	                      @Override
	                      public void run() {
                             
	                          Intent i=new Intent(Badminton.this,Play.class);
	                          //startAnimation(animAlpha);
	                          startActivity(i);
	                          overridePendingTransition(R.anim.right_in,R.anim.left_out);
	                          finish();
	                      }
	                  }, 500);
		}
		
	}
		
}

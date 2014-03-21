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

public class Truck extends Activity {

List<Integer> numbers = new ArrayList<Integer>();
MediaPlayer mediaPlayer;
	Animation animAlpha;
    Button back,next;
	int[] truckShapes= {R.drawable.front_box_truck,R.drawable.truck_chimney,R.drawable.truck_upperhandle,R.drawable.truck_tyre,R.drawable.truck_tyreback,
			            R.drawable.truck_tyreback,R.drawable.inner_window,R.drawable.inner_window};
	String[] truckNames= {"light","truckChimney","handle","frontTyre","backTyre1","backTyre2","truckLeftWindow","truckRightWindow"};
	String name[]={"light","truckChimney","handle","frontTyre","backTyre1","backTyre2","truckLeftWindow","truckRightWindow"};
	
	public ImageView light,truckChimney,handle,frontTyre,backTyre1,backTyre2,truckLeftWindow,truckRightWindow,bottom1,bottom2,bottom3,bottom4,
	                           bottom5,bottom6,bottom7,bottom8,source,target,temp;
	String src,tar;
    MyDragEventListener myDragEventListener = new MyDragEventListener();

    
    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.truck);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		
		for(int i=0;i<8;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		light=(ImageView) findViewById(R.id.front);
		//tri.setImageResource(truckShapes[numbers.get(0).intValue()]);
		light.setContentDescription("1");
		light.setTag("light");
		light.setOnTouchListener(new MyTouchListener());
		light.setOnDragListener(myDragEventListener);
		
		truckChimney=(ImageView) findViewById(R.id.truckChimney);
		truckChimney.setContentDescription("2");
		//tri2.setImageResource(truckShapes[numbers.get(1).intValue()]);
		truckChimney.setTag("truckChimney");
		truckChimney.setOnTouchListener(new MyTouchListener());
		truckChimney.setOnDragListener(myDragEventListener);
		
		handle=(ImageView) findViewById(R.id.topTruck);
		handle.setContentDescription("3");
		//tri2.setImageResource(truckShapes[numbers.get(1).intValue()]);
		handle.setTag("handle");
		handle.setOnTouchListener(new MyTouchListener());
		handle.setOnDragListener(myDragEventListener);
		
		frontTyre=(ImageView) findViewById(R.id.truckTyreFront);
		frontTyre.setContentDescription("4");
		//tri2.setImageResource(truckShapes[numbers.get(1).intValue()]);
		frontTyre.setTag("frontTyre");
		frontTyre.setOnTouchListener(new MyTouchListener());
		frontTyre.setOnDragListener(myDragEventListener);
		
		backTyre1=(ImageView) findViewById(R.id.truckTyreBack1);
		backTyre1.setContentDescription("5");
		//tri2.setImageResource(truckShapes[numbers.get(1).intValue()]);
		backTyre1.setTag("backTyre1");
		backTyre1.setOnTouchListener(new MyTouchListener());
		backTyre1.setOnDragListener(myDragEventListener);
		
		backTyre2=(ImageView) findViewById(R.id.truckTyreBack2);
		backTyre2.setContentDescription("6");
		//tri2.setImageResource(truckShapes[numbers.get(1).intValue()]);
		backTyre2.setTag("backTyre2");
		backTyre2.setOnTouchListener(new MyTouchListener());
		backTyre2.setOnDragListener(myDragEventListener);
						
		truckLeftWindow=(ImageView) findViewById(R.id.truckLeftWindow);
		truckLeftWindow.setContentDescription("7");
		//tri2.setImageResource(truckShapes[numbers.get(1).intValue()]);
		truckLeftWindow.setTag("truckLeftWindow");
		truckLeftWindow.setOnTouchListener(new MyTouchListener());
		truckLeftWindow.setOnDragListener(myDragEventListener);
						
		truckRightWindow=(ImageView) findViewById(R.id.truckRightWindow);
		truckRightWindow.setContentDescription("8");
		//tri2.setImageResource(truckShapes[numbers.get(1).intValue()]);
		truckRightWindow.setTag("truckRightWindow");
		truckRightWindow.setOnTouchListener(new MyTouchListener());
		truckRightWindow.setOnDragListener(myDragEventListener);
						
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(truckShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(truckNames[(Integer)numbers.get(0).intValue()]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(truckShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(truckNames[(Integer)numbers.get(1).intValue()]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(truckShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(truckNames[(Integer)numbers.get(2).intValue()]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(truckShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(truckNames[(Integer)numbers.get(3).intValue()]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(truckShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(truckNames[(Integer)numbers.get(4).intValue()]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(truckShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(truckNames[(Integer)numbers.get(5).intValue()]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		
		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(truckShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(truckNames[(Integer)numbers.get(6).intValue()]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);
		
		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(truckShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(truckNames[(Integer)numbers.get(7).intValue()]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);
		
		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Truck.this, Train.class);
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
				Intent i = new Intent(Truck.this, GameOverActivity.class);
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
	        ((ImageView)target).setImageResource(truckShapes[Integer.parseInt(source.getTag().toString())]);
	        ((ImageView)source).setImageResource(truckShapes[Integer.parseInt(temp.getTag().toString())]);
	        
	        ((ImageView)target).setTag(src);
	        ((ImageView)source).setTag(tar);*/
		   
		   if(target.getContentDescription().equals("1")||target.getContentDescription().equals("2")||target.getContentDescription().equals("3")||target.getContentDescription().equals("4")||target.getContentDescription().equals("5")||
				   target.getContentDescription().equals("6")||target.getContentDescription().equals("7")||target.getContentDescription().equals("8"))
		   {
			   
                int index=Arrays.asList(truckNames).indexOf(source.getTag());

                if(light.getTag().toString().equals(source.getTag().toString()))
                {
                	light.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        light.setOnTouchListener(null);
		        light.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(truckChimney.getTag().toString().equals(source.getTag().toString()))
                {
                	truckChimney.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        truckChimney.setOnTouchListener(null);
		        truckChimney.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                
                else if(handle.getTag().toString().equals(source.getTag().toString()))
                {
                	handle.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        handle.setOnTouchListener(null);
		        handle.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(frontTyre.getTag().toString().equals(source.getTag().toString()))
                {
                	frontTyre.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        frontTyre.setOnTouchListener(null);
		        frontTyre.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(backTyre1.getTag().toString().equals(source.getTag().toString()))
                {
                	backTyre1.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        backTyre1.setOnTouchListener(null);
		        backTyre1.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(backTyre2.getTag().toString().equals(source.getTag().toString()))
                {
                	backTyre2.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        backTyre2.setOnTouchListener(null);
		        backTyre2.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(truckLeftWindow.getTag().toString().equals(source.getTag().toString()))
                {
                	truckLeftWindow.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        truckLeftWindow.setOnTouchListener(null);
		        truckLeftWindow.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(truckRightWindow.getTag().toString().equals(source.getTag().toString()))
                {
                	truckRightWindow.setImageResource(truckShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        truckRightWindow.setOnTouchListener(null);
		        truckRightWindow.setTag("1");
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
		if(handle.getTag().equals("1")&&frontTyre.getTag().equals("1")&&backTyre1.getTag().equals("1")&&backTyre2.getTag().equals("1")
		   &&truckLeftWindow.getTag().equals("1")&&truckRightWindow.getTag().equals("1")&&truckChimney.getTag().equals("1")&&light.getTag().equals("1"))
		{
//			mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.excellent);
//			mediaPlayer.start();
			new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   
                    Intent i=new Intent(Truck.this,GameOverActivity.class);
                    //startAnimation(animAlpha);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_in,R.anim.left_out);
                    finish();
                }
            }, 500);
		}
	}
		
}

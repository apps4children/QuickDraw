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

public class Butterfly extends Activity {

List<Integer> numbers = new ArrayList<Integer>();
MediaPlayer mediaPlayer;
	Animation animAlpha;
    Button back,next;
	int[] butterflyShapes= {R.drawable.butter_head,R.drawable.wingup_left,R.drawable.wingup_right,R.drawable.wingdown_left,R.drawable.wingdown_right,
			                R.drawable.boat_right,R.drawable.truck_chimney,R.drawable.chimney};
	
	String[] butterflyNames= {"head","wingUpLeft","wingUpRight","wingDownLeft","wingDownRight","boatRight","truckChimney","chimney"};
	String name[]={"head","wingUpLeft","wingUpRight","wingDownLeft","wingDownRight"};
	
	public ImageView head,wingUpLeft,wingUpRight,wingDownLeft,wingDownRight,bottom1,bottom2,bottom3,bottom4,bottom5,bottom6,
	                           bottom7,bottom8,source,target,temp;
	String src,tar;
    MyDragEventListener myDragEventListener = new MyDragEventListener();

    
    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.butterfly);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		
		for(int i=0;i<8;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		head=(ImageView) findViewById(R.id.butterHead);
		//tri.setImageResource(butterflyShapes[numbers.get(0).intValue()]);
		head.setContentDescription("1");
		head.setTag("head");
		head.setOnTouchListener(new MyTouchListener());
		head.setOnDragListener(myDragEventListener);
		
		wingUpLeft=(ImageView) findViewById(R.id.wingUpLeft);
		wingUpLeft.setContentDescription("2");
		//tri2.setImageResource(butterflyShapes[numbers.get(1).intValue()]);
		wingUpLeft.setTag("wingUpLeft");
		wingUpLeft.setOnTouchListener(new MyTouchListener());
		wingUpLeft.setOnDragListener(myDragEventListener);
		
		wingUpRight=(ImageView) findViewById(R.id.wingUpRight);
		wingUpRight.setContentDescription("3");
		//tri2.setImageResource(butterflyShapes[numbers.get(1).intValue()]);
		wingUpRight.setTag("wingUpRight");
		wingUpLeft.setOnTouchListener(new MyTouchListener());
		wingUpRight.setOnDragListener(myDragEventListener);
		
		wingDownRight=(ImageView) findViewById(R.id.wingDownRight);
		wingDownRight.setContentDescription("4");
		//tri2.setImageResource(butterflyShapes[numbers.get(1).intValue()]);
		wingDownRight.setTag("wingDownRight");
		wingDownRight.setOnTouchListener(new MyTouchListener());
		wingDownRight.setOnDragListener(myDragEventListener);
		
		wingDownLeft=(ImageView) findViewById(R.id.wingDownLeft);
		wingDownLeft.setContentDescription("5");
		//tri2.setImageResource(butterflyShapes[numbers.get(1).intValue()]);
		wingDownLeft.setTag("wingDownLeft");
		wingDownLeft.setOnTouchListener(new MyTouchListener());
		wingDownLeft.setOnDragListener(myDragEventListener);
		
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(butterflyShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(butterflyNames[(Integer)numbers.get(0).intValue()]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(butterflyShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(butterflyNames[(Integer)numbers.get(1).intValue()]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(butterflyShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(butterflyNames[(Integer)numbers.get(2).intValue()]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(butterflyShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(butterflyNames[(Integer)numbers.get(3).intValue()]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(butterflyShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(butterflyNames[(Integer)numbers.get(4).intValue()]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(butterflyShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(butterflyNames[(Integer)numbers.get(5).intValue()]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		
		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(butterflyShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(butterflyNames[(Integer)numbers.get(6).intValue()]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);
		
		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(butterflyShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(butterflyNames[(Integer)numbers.get(7).intValue()]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);
		
		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Butterfly.this, Plane.class);
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
				Intent i = new Intent(Butterfly.this, Boat.class);
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
		    		   
		   if(target.getContentDescription().equals("1")||target.getContentDescription().equals("2")||target.getContentDescription().equals("3")||
				   target.getContentDescription().equals("4")||target.getContentDescription().equals("5"))
				    {
			   
                int index=Arrays.asList(butterflyNames).indexOf(source.getTag());

                if(head.getTag().toString().equals(source.getTag().toString()))
                {
                	head.setImageResource(butterflyShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        head.setOnTouchListener(null);
		        head.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(wingUpLeft.getTag().toString().equals(source.getTag().toString()))
                {
                	wingUpLeft.setImageResource(butterflyShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        wingUpLeft.setOnTouchListener(null);
		        wingUpLeft.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                
                else if(wingUpRight.getTag().toString().equals(source.getTag().toString()))
                {
                	wingUpRight.setImageResource(butterflyShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        wingUpRight.setOnTouchListener(null);
		        wingUpRight.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(wingDownLeft.getTag().toString().equals(source.getTag().toString()))
                {
                	wingDownLeft.setImageResource(butterflyShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        wingDownLeft.setOnTouchListener(null);
		        wingDownLeft.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(wingDownRight.getTag().toString().equals(source.getTag().toString()))
                {
                	wingDownRight.setImageResource(butterflyShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        wingDownRight.setOnTouchListener(null);
		        wingDownRight.setTag("1");
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
		if(head.getTag().equals("1")
	       &&wingUpLeft.getTag().equals("1")
		   &&wingDownLeft.getTag().equals("1")
		   &&wingUpRight.getTag().equals("1")
		   &&wingDownRight.getTag().equals("1"))
		{
//			mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.excellent);
//			mediaPlayer.start();
			new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   
                    Intent i=new Intent(Butterfly.this,Boat.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_in,R.anim.left_out);
                    finish();
                }
            }, 500);
		}
	}
		
}

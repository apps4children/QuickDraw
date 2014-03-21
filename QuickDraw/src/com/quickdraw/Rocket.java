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
import android.opengl.Visibility;
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
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.quickdraw.R;
public class Rocket extends  Activity 
{
List<Integer> numbers = new ArrayList<Integer>();
	MediaPlayer mediaPlayer;
    RelativeLayout mid;
    Button back, next;
	int[] rocketShapes= {R.drawable.rocket_top,R.drawable.circle,R.drawable.circle,
			             R.drawable.left_side,R.drawable.right_side,R.drawable.footer1,R.drawable.footer1};

	String rocketNames[]={"rocket_top","circle_top","circle","left_side","right_side","footer","footer1"};
	String name[]={"rocket_top","circle_top","circle","rocket_mid","left_side","right_side","footer","footer1"};

	public ImageView top,centerTop,centerBelow,rocketLeft,rocketRight,footerLeft,footerRight,bottom1,bottom2,
	                 bottom3,bottom4,bottom5,bottom6,bottom7,bottom8,source,target,temp;
	String src,tar;
    MyDragEventListener myDragEventListener = new MyDragEventListener();
    Intent intent;
    Animation animAlpha;
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.rocket);
		
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		//intent=new Intent(this,GameOver.class);
	    //System.out.println("First Image Id="+tree[3]);
		
		//random number
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
				intent = new Intent(Rocket.this, Hut.class);
				startActivity(intent);
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
				intent = new Intent(Rocket.this, Bus.class);
				startActivity(intent);
				overridePendingTransition(R.anim.right_in,R.anim.left_out);
				finish();
			}
		});
		
		mid = (RelativeLayout)findViewById(R.id.mid);
		
		top=(ImageView) findViewById(R.id.top);
		top.setId(1);
	//	top.setImageResource(rocketShapes[numbers.get(0).intValue()]);
		top.setTag("rocket_top");
		top.setOnTouchListener(new MyTouchListener());
		top.setOnDragListener(myDragEventListener);
		
		centerTop=(ImageView) findViewById(R.id.centerTop);
		centerTop.setId(2);
	//	centerTop.setImageResource(rocketShapes[numbers.get(1).intValue()]);
		centerTop.setTag("circle_top");
		centerTop.setOnTouchListener(new MyTouchListener());
		centerTop.setOnDragListener(myDragEventListener);
		
		centerBelow=(ImageView) findViewById(R.id.centerBelow);
		centerBelow.setId(3);
	//	centerBelow.setImageResource(rocketShapes[numbers.get(2).intValue()]);
		centerBelow.setTag("circle");
		centerBelow.setOnTouchListener(new MyTouchListener());
		centerBelow.setOnDragListener(myDragEventListener);
		
		rocketLeft=(ImageView) findViewById(R.id.rocketLeft);
		rocketLeft.setId(4);
	//	rocketLeft.setImageResource(rocketShapes[numbers.get(3).intValue()]);
		rocketLeft.setTag("left_side");
		rocketLeft.setOnTouchListener(new MyTouchListener());
		rocketLeft.setOnDragListener(myDragEventListener);
				
		rocketRight=(ImageView) findViewById(R.id.rocketRight);
		rocketRight.setId(5);
	//	rocketRight.setImageResource(rocketShapes[numbers.get(3).intValue()]);
		rocketRight.setTag("right_side");
		rocketRight.setOnTouchListener(new MyTouchListener());
		rocketRight.setOnDragListener(myDragEventListener);
		
		footerLeft=(ImageView) findViewById(R.id.footerLeft);
		footerLeft.setId(6);
	//	footerLeft.setImageResource(rocketShapes[numbers.get(3).intValue()]);
		footerLeft.setTag("footer");
		footerLeft.setOnTouchListener(new MyTouchListener());
		footerLeft.setOnDragListener(myDragEventListener);
		
		footerRight=(ImageView) findViewById(R.id.footerRight);
		footerRight.setId(7);
	//	footerRight.setImageResource(rocketShapes[numbers.get(4).intValue()]);
		footerRight.setTag("footer1");
		footerRight.setOnTouchListener(new MyTouchListener());
		footerRight.setOnDragListener(myDragEventListener);
		
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(rocketShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(rocketNames[(Integer)numbers.get(0)]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(rocketShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(rocketNames[(Integer)numbers.get(1)]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(rocketShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(rocketNames[(Integer)numbers.get(2)]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(rocketShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(rocketNames[(Integer)numbers.get(3)]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(rocketShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(rocketNames[(Integer)numbers.get(4)]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);
		
		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(rocketShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(rocketNames[(Integer)numbers.get(5)]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		
		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(rocketShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(rocketNames[(Integer)numbers.get(6)]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);
		
/*		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(rocketShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(rocketNames[(Integer)numbers.get(7)]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);*/
		
	}
	
	//Draging item
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
		    
/*	        System.out.println("Source Tag="+source.getTag().toString());
	        System.out.println("Target Tag="+target.getTag().toString());
	        ((ImageView)target).setImageResource(rocketShapes[Integer.parseInt(source.getTag().toString())]);
	        ((ImageView)source).setImageResource(rocketShapes[Integer.parseInt(temp.getTag().toString())]);
	        
	        ((ImageView)target).setTag(src);
	        ((ImageView)source).setTag(tar);*/
 

		   if(target.getId()==1||target.getId()==2||target.getId()==3||target.getId()==4||target.getId()==5||target.getId()==6||target.getId()==7)
		   {

                int index=Arrays.asList(rocketNames).indexOf(source.getTag());

                if(top.getTag().toString().equals(source.getTag().toString()))
                {
                	top.setImageResource(rocketShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        top.setOnTouchListener(null);
		        top.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(centerTop.getTag().toString().equals(source.getTag().toString()))
                {
                	centerTop.setImageResource(rocketShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        centerTop.setOnTouchListener(null);
		        centerTop.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                
                else if(centerBelow.getTag().toString().equals(source.getTag().toString()))
                {
                	centerBelow.setImageResource(rocketShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        centerBelow.setOnTouchListener(null);
		        centerBelow.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(rocketLeft.getTag().toString().equals(source.getTag().toString()))
                {
                	rocketLeft.setImageResource(rocketShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        rocketLeft.setOnTouchListener(null);
		        rocketLeft.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(rocketRight.getTag().toString().equals(source.getTag().toString()))
                {
                	rocketRight.setImageResource(rocketShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        rocketRight.setOnTouchListener(null);
		        rocketRight.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(footerLeft.getTag().toString().equals(source.getTag().toString()))
                {
                	footerLeft.setImageResource(rocketShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        footerLeft.setOnTouchListener(null);
		        footerLeft.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(footerRight.getTag().toString().equals(source.getTag().toString()))
                {
                	footerRight.setImageResource(rocketShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        footerRight.setOnTouchListener(null);
		        footerRight.setTag("1");
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
		if(top.getTag().equals("1")
		   &&centerTop.getTag().equals("1")
		   &&centerBelow.getTag().equals("1")
		   &&rocketLeft.getTag().equals("1")
		   &&rocketRight.getTag().equals("1")
		   &&footerLeft.getTag().equals("1")
		   &&footerRight.getTag().equals("1"))
		   {
//			mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.verygood);
//			mediaPlayer.start();
			new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   
                    Intent i=new Intent(Rocket.this,Bus.class);
                    //startAnimation(animAlpha);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_in,R.anim.left_out);
                    finish();
                }
            }, 500);
		   }
		
	}

}

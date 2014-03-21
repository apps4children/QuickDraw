package com.quickdraw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.media.AudioManager;
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
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.quickdraw.R;

public class Play extends Activity {

List<Integer> numbers = new ArrayList<Integer>();

 //   MediaPlayer mediaPlayer;
    Animation animAlpha;
    Button back,next;
	int[] treeShapes= {R.drawable.tri2,R.drawable.tri2,R.drawable.tri2,
			             R.drawable.chimney,R.drawable.left_side,R.drawable.circle};
	String[] treeNames= {"tri","triMid","triLower","chimney","hexagon","circle"};
	String name[]={"tri","triMid","triLower"};
	
	public ImageView tri,tri2,tri3,bottom1,bottom2,bottom3,bottom4,bottom5,bottom6,source,target,temp;
	String src,tar;
    MyDragEventListener myDragEventListener = new MyDragEventListener();

    
    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.play);
				
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		for(int i=0;i<6;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		tri=(ImageView) findViewById(R.id.tri);
		//tri.setImageResource(treeShapes[numbers.get(0).intValue()]);
		tri.setId(1);
		tri.setTag("tri");
		tri.setOnTouchListener(new MyTouchListener());
		tri.setOnDragListener(myDragEventListener);
		
		tri2=(ImageView) findViewById(R.id.tri2);
		tri2.setId(2);
		//tri2.setImageResource(treeShapes[numbers.get(1).intValue()]);
		tri2.setTag("triMid");
		tri2.setOnTouchListener(new MyTouchListener());
		tri2.setOnDragListener(myDragEventListener);
		
		tri3=(ImageView) findViewById(R.id.tri3);
		tri3.setId(3);
		//tri3.setImageResource(treeShapes[numbers.get(2).intValue()]);
		tri3.setTag("triLower");
		tri3.setOnTouchListener(new MyTouchListener());
		tri3.setOnDragListener(myDragEventListener);
		
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(treeShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(treeNames[(Integer)numbers.get(0).intValue()]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(treeShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(treeNames[(Integer)numbers.get(1).intValue()]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(treeShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(treeNames[(Integer)numbers.get(2).intValue()]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(treeShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(treeNames[(Integer)numbers.get(3).intValue()]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(treeShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(treeNames[(Integer)numbers.get(4).intValue()]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(treeShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(treeNames[(Integer)numbers.get(5).intValue()]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		
		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Play.this, Badminton.class);
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
				Intent i = new Intent(Play.this, Hut.class);
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
	        ((ImageView)target).setImageResource(treeShapes[Integer.parseInt(source.getTag().toString())]);
	        ((ImageView)source).setImageResource(treeShapes[Integer.parseInt(temp.getTag().toString())]);
	        
	        ((ImageView)target).setTag(src);
	        ((ImageView)source).setTag(tar);*/
		   
		   if(target.getId()==1||target.getId()==2||target.getId()==3)
		   {
			   
                int index=Arrays.asList(treeNames).indexOf(source.getTag());

                if(tri.getTag().toString().equals(source.getTag().toString()))
                {
		        tri.setImageResource(treeShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        tri.setOnTouchListener(null);
		        tri.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                else if(tri2.getTag().toString().equals(source.getTag().toString()))
                {
		        tri2.setImageResource(treeShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        tri2.setOnTouchListener(null);
		        tri2.setTag("1");
		        ((ImageView)source).setTag("0");
                }
                
                else if(tri3.getTag().toString().equals(source.getTag().toString()))
                {
		        tri3.setImageResource(treeShapes[index]);
		        ((ImageView)source).setImageResource(R.drawable.transparent1);
		        
		        //((ImageView)target).setTag(src);
		        tri3.setOnTouchListener(null);
		        tri3.setTag("1");
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
		if(tri.getTag().equals("1")&&tri2.getTag().equals("1")&&tri3.getTag().equals("1"))
		{
//					mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.good);
//					mediaPlayer.start();
			new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   
                    Intent i=new Intent(Play.this,Hut.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.right_in,R.anim.left_out);
                    finish();
                }
            }, 500);

		}
	}
		
}

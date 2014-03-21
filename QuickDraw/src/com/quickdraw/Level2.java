package com.quickdraw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
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

public class Level2 extends Activity {

List<Integer> numbers = new ArrayList<Integer>();
    Animation animAlpha;
    Button back,next;
	int[] treeShapes= {R.drawable.tri2,R.drawable.stem,R.drawable.boat_mid,R.drawable.tri2,R.drawable.left_side,
			             R.drawable.net,R.drawable.circle,R.drawable.right_side};

	public ImageView quickDraw1,quickDraw2,quickDraw3,quickDraw4,quickDraw5,quickDraw6,quickDraw7,quickDraw8,quickDraw9,quickDraw10,quickDraw11,
	                 quickDraw12,quickDraw13,quickDraw14,quickDraw15,quickDraw16,quickDraw17,quickDraw18,quickDraw19,quickDraw20,
	                   bottom1,bottom2,bottom3,bottom4,bottom5,bottom6,bottom7,bottom8,source,target,temp;
	String src,tar;
	int transparent=R.drawable.transparent1;
    MyDragEventListener myDragEventListener = new MyDragEventListener();

    
    @SuppressLint({ "NewApi"})
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.level2);
				
		animAlpha=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
		for(int i=0;i<8;i++) 
		{
		 numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		quickDraw1=(ImageView) findViewById(R.id.levelImg1);
		//quickDraw1.setImageResource(treeShapes[numbers.get(0).intValue()]);
		quickDraw1.setId(1);
		quickDraw1.setTag(transparent);
		quickDraw1.setOnTouchListener(new MyTouchListener());
		quickDraw1.setOnDragListener(myDragEventListener);
		
		quickDraw2=(ImageView) findViewById(R.id.levelImg2);
		//quickDraw2.setImageResource(treeShapes[numbers.get(1).intValue()]);
		quickDraw2.setId(2);
		quickDraw2.setTag(transparent);
		quickDraw2.setOnTouchListener(new MyTouchListener());
		quickDraw2.setOnDragListener(myDragEventListener);
				
		quickDraw3=(ImageView) findViewById(R.id.levelImg3);
		//quickDraw3.setImageResource(treeShapes[numbers.get(2).intValue()]);
		quickDraw3.setId(3);
		quickDraw3.setTag(transparent);
		quickDraw3.setOnTouchListener(new MyTouchListener());
		quickDraw3.setOnDragListener(myDragEventListener);
				
		quickDraw4=(ImageView) findViewById(R.id.levelImg4);
		//quickDraw4.setImageResource(treeShapes[numbers.get(3).intValue()]);
		quickDraw4.setId(4);
		quickDraw4.setTag(transparent);
		quickDraw4.setOnTouchListener(new MyTouchListener());
		quickDraw4.setOnDragListener(myDragEventListener);
				
		quickDraw5=(ImageView) findViewById(R.id.levelImg5);
		//quickDraw5.setImageResource(treeShapes[numbers.get(4).intValue()]);
	    quickDraw5.setId(5);
		quickDraw5.setTag(transparent);
		quickDraw5.setOnTouchListener(new MyTouchListener());
		quickDraw5.setOnDragListener(myDragEventListener);
		
		quickDraw6=(ImageView) findViewById(R.id.levelImg6);
		//quickDraw6.setImageResource(treeShapes[numbers.get(5).intValue()]);
		quickDraw6.setId(6);
		quickDraw6.setTag(transparent);
		quickDraw6.setOnTouchListener(new MyTouchListener());
		quickDraw6.setOnDragListener(myDragEventListener);
		
		quickDraw7=(ImageView) findViewById(R.id.levelImg7);
		//quickDraw7.setImageResource(treeShapes[numbers.get(6).intValue()]);
		quickDraw7.setId(7);
		quickDraw7.setTag(transparent);
		quickDraw7.setOnTouchListener(new MyTouchListener());
		quickDraw7.setOnDragListener(myDragEventListener);
		
		quickDraw8=(ImageView) findViewById(R.id.levelImg8);
		//quickDraw8.setImageResource(treeShapes[numbers.get(7).intValue()]);
		quickDraw8.setId(8);
		quickDraw8.setTag(transparent);
		quickDraw8.setOnTouchListener(new MyTouchListener());
		quickDraw8.setOnDragListener(myDragEventListener);
		
		quickDraw9=(ImageView) findViewById(R.id.levelImg9);
		//quickDraw9.setImageResource(treeShapes[numbers.get(8).intValue()]);
		quickDraw9.setId(9);
	    quickDraw9.setTag(transparent);
		quickDraw9.setOnTouchListener(new MyTouchListener());
		quickDraw9.setOnDragListener(myDragEventListener);
		
		quickDraw10=(ImageView) findViewById(R.id.levelImg10);
		//quickDraw10.setImageResource(treeShapes[numbers.get(9).intValue()]);
		quickDraw10.setId(10);
		quickDraw10.setTag(transparent);
		quickDraw10.setOnTouchListener(new MyTouchListener());
		quickDraw10.setOnDragListener(myDragEventListener);
		
		quickDraw11=(ImageView) findViewById(R.id.levelImg11);
		//quickDraw11.setImageResource(treeShapes[numbers.get(10).intValue()]);
		quickDraw11.setId(11);
		quickDraw11.setTag(transparent);
		quickDraw11.setOnTouchListener(new MyTouchListener());
		quickDraw11.setOnDragListener(myDragEventListener);
				
		quickDraw12=(ImageView) findViewById(R.id.levelImg12);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw12.setId(12);
		quickDraw12.setTag(transparent);
		quickDraw12.setOnTouchListener(new MyTouchListener());
		quickDraw12.setOnDragListener(myDragEventListener);
		
		quickDraw13=(ImageView) findViewById(R.id.levelImg13);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw13.setId(13);
		quickDraw13.setTag(transparent);
		quickDraw13.setOnTouchListener(new MyTouchListener());
		quickDraw13.setOnDragListener(myDragEventListener);
		
		quickDraw14=(ImageView) findViewById(R.id.levelImg14);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw14.setId(14);
		quickDraw14.setTag(transparent);
		quickDraw14.setOnTouchListener(new MyTouchListener());
		quickDraw14.setOnDragListener(myDragEventListener);
		
		quickDraw15=(ImageView) findViewById(R.id.levelImg15);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw15.setId(15);
		quickDraw15.setTag(transparent);
		quickDraw15.setOnTouchListener(new MyTouchListener());
		quickDraw15.setOnDragListener(myDragEventListener);
		
		quickDraw16=(ImageView) findViewById(R.id.levelImg16);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw16.setId(16);
		quickDraw16.setTag(transparent);
		quickDraw16.setOnTouchListener(new MyTouchListener());
		quickDraw16.setOnDragListener(myDragEventListener);
		
		quickDraw17=(ImageView) findViewById(R.id.levelImg17);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw17.setId(17);
		quickDraw17.setTag(transparent);
		quickDraw17.setOnTouchListener(new MyTouchListener());
		quickDraw17.setOnDragListener(myDragEventListener);
		
		quickDraw18=(ImageView) findViewById(R.id.levelImg18);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw18.setId(18);
		quickDraw18.setTag(transparent);
		quickDraw18.setOnTouchListener(new MyTouchListener());
		quickDraw18.setOnDragListener(myDragEventListener);
		
		quickDraw19=(ImageView) findViewById(R.id.levelImg19);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw19.setId(19);
		quickDraw19.setTag(transparent);
		quickDraw19.setOnTouchListener(new MyTouchListener());
		quickDraw19.setOnDragListener(myDragEventListener);
		
		quickDraw20=(ImageView) findViewById(R.id.levelImg20);
		//quickDraw12.setImageResource(treeShapes[numbers.get(11).intValue()]);
		quickDraw20.setId(20);
		quickDraw20.setTag(transparent);
		quickDraw20.setOnTouchListener(new MyTouchListener());
		quickDraw20.setOnDragListener(myDragEventListener);
		
		bottom1=(ImageView) findViewById(R.id.img1);
		bottom1.setImageResource(treeShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setTag(treeShapes[(Integer)numbers.get(0).intValue()]);
		bottom1.setOnTouchListener(new MyTouchListener());
		bottom1.setOnDragListener(myDragEventListener);
		bottom1.setId(00);
		
		bottom2=(ImageView) findViewById(R.id.img2);
		bottom2.setImageResource(treeShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setTag(treeShapes[(Integer)numbers.get(1).intValue()]);
		bottom2.setOnTouchListener(new MyTouchListener());
		bottom2.setOnDragListener(myDragEventListener);
		bottom2.setId(01);
		
		bottom3=(ImageView) findViewById(R.id.img3);
		bottom3.setImageResource(treeShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setTag(treeShapes[(Integer)numbers.get(2).intValue()]);
		bottom3.setOnTouchListener(new MyTouchListener());
		bottom3.setOnDragListener(myDragEventListener);
		bottom3.setId(02);
		
		bottom4=(ImageView) findViewById(R.id.img4);
		bottom4.setImageResource(treeShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setTag(treeShapes[(Integer)numbers.get(3).intValue()]);
		bottom4.setOnTouchListener(new MyTouchListener());
		bottom4.setOnDragListener(myDragEventListener);
		bottom4.setId(03);

		bottom5=(ImageView) findViewById(R.id.img5);
		bottom5.setImageResource(treeShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setTag(treeShapes[(Integer)numbers.get(4).intValue()]);
		bottom5.setOnTouchListener(new MyTouchListener());
		bottom5.setOnDragListener(myDragEventListener);
		bottom5.setId(04);

		bottom6=(ImageView) findViewById(R.id.img6);
		bottom6.setImageResource(treeShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setTag(treeShapes[(Integer)numbers.get(5).intValue()]);
		bottom6.setOnTouchListener(new MyTouchListener());
		bottom6.setOnDragListener(myDragEventListener);
		bottom6.setId(05);
		
		bottom7=(ImageView) findViewById(R.id.img7);
		bottom7.setImageResource(treeShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setTag(treeShapes[(Integer)numbers.get(6).intValue()]);
		bottom7.setOnTouchListener(new MyTouchListener());
		bottom7.setOnDragListener(myDragEventListener);
		bottom7.setId(06);
		
		bottom8=(ImageView) findViewById(R.id.img8);
		bottom8.setImageResource(treeShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setTag(treeShapes[(Integer)numbers.get(7).intValue()]);
		bottom8.setOnTouchListener(new MyTouchListener());
		bottom8.setOnDragListener(myDragEventListener);
		bottom8.setId(07);
		
		back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				back.startAnimation(animAlpha);
				Intent i = new Intent(Level2.this, GeometryShapesActivity.class);
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
				Intent i = new Intent(Level2.this, GameOverActivity.class);
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

		   if(target.getId()==1||target.getId()==2||target.getId()==3||target.getId()==4||target.getId()==5||target.getId()==6||target.getId()==7
				   ||target.getId()==8||target.getId()==9||target.getId()==10||target.getId()==11||target.getId()==12||target.getId()==13||target.getId()==14
				   ||target.getId()==15||target.getId()==16||target.getId()==17||target.getId()==18||target.getId()==19||target.getId()==20)
		      {
			   tar=target.getTag().toString();
			   int s,t;
			   s=Integer.parseInt(src);
			   t=Integer.parseInt(tar);
			   ((ImageView)target).setImageResource(s);
			   ((ImageView)target).setTag(src);
			   
			   
			   ((ImageView)source).setImageResource(t);
			   ((ImageView)source).setTag(tar);
			   
			   //
//			   tar=target.getTag().toString();
			   
//			   System.out.println("Target:====="+((ImageView)target).getTag().toString());
//			   System.out.println("Source:====="+((ImageView)source).getTag().toString());
//			   
//			   System.out.println("Tar:====="+tar);
//			   System.out.println("Src:====="+src);
//
		      }
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
//		if(tri.getTag().toString().equalsIgnoreCase("tri")
//		   &&tri2.getTag().toString().equalsIgnoreCase("triMid")
//		   &&tri3.getTag().toString().equalsIgnoreCase("triLower"))
		{
		  // intent = new Intent(MakeDrawingActivity.this, Home.class);
		   //startActivity(intent); 
		}
	}
		
}

package com.example.androidphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class FreeFallActivity extends AppCompatActivity
{
    double mass,height,gravity,accelaration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent gi = getIntent();
        mass=gi.getDoubleExtra("mass",0); //will be used in the table to calculate energy
        height=gi.getDoubleExtra("height",0);
        int planet=gi.getIntExtra("planet",0);
        if(planet>=0) gravity=Languages.gravity[planet];
        else gravity=10;
        double meter=(double)Resources.getSystem().getDisplayMetrics().heightPixels/(height*1.3);
        accelaration=gravity*meter/100;
        Log.w("TAG","a="+accelaration+" meter="+meter+" g="+gravity+" h="+height);

        super.onCreate(savedInstanceState);
        setContentView(new DrawingView(this,accelaration,height*meter));
    }

    public void move(View view)
    {

    }

    @Override
    protected void onPause()
    {
        super.onPause();

        finish();
    }
}

class DrawingView extends SurfaceView
{

    private SurfaceHolder surfaceHolder;
    private Paint paint = new Paint();
    double x,y,vx,vy,h;
    double accelaration;
    Canvas canvas;

    public DrawingView(Context context, double accelaration, double h)
    {
        super(context);
        surfaceHolder = getHolder();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        x=y=0;
        vx=vy=10;
        this.accelaration=accelaration;
        this.h=h;

/*
        Timer t=new Timer();
        t.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                draw();
            }
        }, 100, 100);*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if (surfaceHolder.getSurface().isValid())
            {
                x=getWidth()/2-25;
                y=30;
                vy=0;

                Timer t=new Timer();
                t.scheduleAtFixedRate(new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        if(y>=h+30)
                        {
                            y=h+30;
                            t.cancel();
                            Log.w("TAG","y="+y);
                        }

                        canvas = surfaceHolder.lockCanvas();
                        canvas.drawColor(Color.YELLOW);
                        paint.setColor(Color.RED);
                        canvas.drawCircle((int)x, (int)y, 30, paint);
                        paint.setColor(Color.BLUE);
                        canvas.drawRect(new Rect(0,(int)h+61,Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels),paint);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        //x+=vx;
                        y+=vy;

                        vy+=accelaration;

                        if(y>=Resources.getSystem().getDisplayMetrics().heightPixels ||y<=0) t.cancel();
                    }
                }, 5, 5);
            }
        }
        return false;
    }
/*
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.BLUE);
        canvas.drawCircle((int)x, (int)y, 100, paint);
    }
    */
}
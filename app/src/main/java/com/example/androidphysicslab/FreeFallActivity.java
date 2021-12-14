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
import android.os.Bundle;
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
        mass=gi.getIntExtra("mass",0); //will be used in the table to calculate energy
        height=gi.getIntExtra("height",0);
        int planet=gi.getIntExtra("planet",0);
        if(planet>=0) gravity=Languages.gravity[planet];
        else gravity=10;
        double meter=Resources.getSystem().getDisplayMetrics().heightPixels/(height+1);
        accelaration=gravity*meter/100;

        super.onCreate(savedInstanceState);
        setContentView(new DrawingView(this,accelaration));
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
    int x,y,vx,vy;
    double accelaration;
    Canvas canvas;

    public DrawingView(Context context, double accelaration)
    {
        super(context);
        surfaceHolder = getHolder();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        x=y=0;
        vx=vy=10;
        this.accelaration=accelaration;

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
                        canvas = surfaceHolder.lockCanvas();
                        canvas.drawColor(Color.YELLOW);
                        canvas.drawCircle(x, y, 50, paint);
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

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.BLUE);
        canvas.drawCircle(x, y, 100, paint);
    }
}
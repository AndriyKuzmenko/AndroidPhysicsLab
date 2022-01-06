package com.example.androidphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FreeFallPlots extends AppCompatActivity
{
    double[] hList,vList;
    DataPoint[] vPlot,hPlot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_fall_plots);

        GraphView graph=(GraphView)findViewById(R.id.heightPlot);

        Intent gi=getIntent();
        hList=gi.getDoubleArrayExtra("hList");
        vList=gi.getDoubleArrayExtra("vList");
        vPlot=new DataPoint[vList.length];
        hPlot=new DataPoint[vList.length];

        for(int i=0;i<vList.length;i++)
        {
            vPlot[i]=new DataPoint((double)i/100,vList[i]);
        }

        for(int i=0;i<vList.length;i++)
        {
            hPlot[i]=new DataPoint((double)i/100,hList[i]);
        }

        try
        {
            LineGraphSeries<DataPoint> vSeries = new LineGraphSeries< >(vPlot);
            graph.addSeries(vSeries);

            LineGraphSeries<DataPoint> hSeries = new LineGraphSeries< >(hPlot);
            graph.addSeries(hSeries);
        }
        catch (IllegalArgumentException e)
        {

        }
    }
}

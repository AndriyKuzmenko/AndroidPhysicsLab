package com.example.androidphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FreeFallPlots extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_fall_plots);

        GraphView graph=(GraphView)findViewById(R.id.heightPlot);

        try
        {
            LineGraphSeries<DataPoint> series = new LineGraphSeries< >(new DataPoint[]
                    {
                            new DataPoint(-5, 25-2),
                            new DataPoint(-4.75, 22.5625-2),
                            new DataPoint(-4.5, 20.25-2),
                            new DataPoint(-4.25, 18.0625-2),
                            new DataPoint(-4, 16-2),
                            new DataPoint(-3.75, 14.0625-2),
                            new DataPoint(-3.5, 12.25-2),
                            new DataPoint(-3.25, 10.5625-2),
                            new DataPoint(-3, 9-2),
                            new DataPoint(-2.75, 7.5625-2),
                            new DataPoint(-2.5, 6.25-2),
                            new DataPoint(-2.25, 5.0625-2),
                            new DataPoint(-2, 4-2),
                            new DataPoint(-1.75, 3.0625-2),
                            new DataPoint(-1.5, 2.25-2),
                            new DataPoint(-1.25, 1.5625-2),
                            new DataPoint(-1, 1-2),
                            new DataPoint(-0.75, 0.5625-2),
                            new DataPoint(-0.5, 0.25-2),
                            new DataPoint(-0.25, 0.0625-2),
                            new DataPoint(0, 0-2),
                            new DataPoint(0.25, 0.0625-2),
                            new DataPoint(0.5, 0.25-2),
                            new DataPoint(0.75, 0.5625-2),
                            new DataPoint(1, 1-2),
                            new DataPoint(1.25, 1.5625-2),
                            new DataPoint(1.5, 2.25-2),
                            new DataPoint(1.75, 3.0625-2),
                            new DataPoint(2, 4-2),
                            new DataPoint(2.25, 5.0625-2),
                            new DataPoint(2.5, 6.25-2),
                            new DataPoint(2.75, 7.5625-2),
                            new DataPoint(3, 9-2),
                            new DataPoint(3.25, 10.5625-2),
                            new DataPoint(3.5, 12.25-2),
                            new DataPoint(3.75, 14.0625-2),
                            new DataPoint(4, 16-2),
                            new DataPoint(4.25, 18.0625-2),
                            new DataPoint(4.5, 20.25-2),
                            new DataPoint(4.75, 22.5625-2),
                            new DataPoint(5, 25-2),
                    });
            graph.addSeries(series);
        }
        catch (IllegalArgumentException e)
        {

        }
    }
}

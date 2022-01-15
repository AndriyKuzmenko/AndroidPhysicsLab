package com.example.androidphysicslab;

import java.util.ArrayList;

public class FreeFallObject extends Experiment
{
    private double[] hList;
    private double[] vList;

    public FreeFallObject(double[] hList, double[] vList)
    {
        this.hList=hList;
        this.vList=vList;
    }

    public void setHList(double[] hList)
    {
        this.hList=hList;
    }

    public void setVList(double[] vList)
    {
        this.vList=vList;
    }

    public double[] getHList()
    {
        return hList;
    }

    public double[] getVList()
    {
        return vList;
    }
}

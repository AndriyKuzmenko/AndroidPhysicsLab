package com.example.androidphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FreeFallResults extends AppCompatActivity
{
    ListView results;
    double[] hList,vList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_fall_results);

        results=(ListView)findViewById(R.id.results);

        Intent gi=getIntent();
        hList=gi.getDoubleArrayExtra("hList");
        vList=gi.getDoubleArrayExtra("vList");

        Log.w("Tag",String.valueOf(hList==null)+" l="+hList.length);

        String[] list=new String[hList.length+1];
        list[0]="t(sec)    h(m)    v(m/sec)";

        for(int i=1; i<hList.length+1; i++)
        {
            String t=" ";
            String time=String.valueOf((double)(i-1)/100);
            int dot=time.indexOf('.');
            if(time.length()>dot+3)
            {
                time=time.substring(0,dot+3);
            }
            else
            {
                while(time.length()<=dot+3)
                {
                    time+=" ";
                }
                if(i%10==0)time+=" ";
            }
            t+=time+"      ";

            String h=String.valueOf(hList[i-1]);
            dot=h.indexOf('.');
            if(h.length()>dot+3)
            {
                h=h.substring(0,dot+3);
            }
            else
            {
                while(h.length()<=dot+3)
                {
                    h+=" ";
                }
            }
            t+=h+"      ";

            String v=String.valueOf(vList[i-1]);
            dot=v.indexOf('.');
            if(v.length()>dot+3)
            {
                v=v.substring(0,dot+3);
            }
            else
            {
                while(h.length()<=dot+3)
                {
                    v+=" ";
                }
            }

            t+=v;

            list[i]=t;
        }

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        results.setAdapter(adp);
    }
}

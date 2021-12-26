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

        String[] list=new String[hList.length];

        for(int i=0; i<hList.length; i++)
        {
            list[i]="h="+hList[i]+"  v="+vList[i];
        }

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        results.setAdapter(adp);
    }
}

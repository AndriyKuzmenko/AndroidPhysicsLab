package com.example.androidphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FreeFallData extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_fall_data);
    }

    public void start(View view)
    {
        Intent si=new Intent(this, FreeFallActivity.class);
        startActivity(si);
    }
}

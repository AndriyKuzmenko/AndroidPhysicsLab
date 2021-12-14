package com.example.androidphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity
{
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        logIn=(Button)findViewById(R.id.logIn);
    }

    public void freeFall(View view)
    {
        Intent si=new Intent(this, FreeFallData.class);
        startActivity(si);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }
}

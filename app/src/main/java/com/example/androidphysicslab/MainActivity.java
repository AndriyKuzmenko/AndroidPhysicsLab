package com.example.androidphysicslab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
{
    Button logIn;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=(EditText)findViewById(R.id.phone);
        logIn=(Button)findViewById(R.id.logIn);

        Languages.toEnglish();
        changeLanguage();
    }

    public void logIn(View view)
    {
        String phoneNumber=phone.getText().toString();

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(FBRef.mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new MyCallback())          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();

        if(id==R.id.English)
        {
            Languages.toEnglish();
        }
        else if(id==R.id.Hebrew)
        {
            Languages.toHebrew();
        }

        changeLanguage();

        return true;
    }

    public void changeLanguage()
    {
        logIn.setText(Languages.logIn);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        finish();
    }

    public void nextActivity()
    {
        Intent si=new Intent(this, MenuActivity.class);
        startActivity(si);
    }
}
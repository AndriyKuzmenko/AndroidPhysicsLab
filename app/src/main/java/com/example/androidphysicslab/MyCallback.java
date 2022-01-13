package com.example.androidphysicslab;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class MyCallback extends PhoneAuthProvider.OnVerificationStateChangedCallbacks
{

    @Override
    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential)
    {
        Log.d("TAG", "Registration successful");
    }

    @Override
    public void onVerificationFailed(@NonNull FirebaseException e)
    {
        Log.d("TAG", "Registration failed");
    }
}
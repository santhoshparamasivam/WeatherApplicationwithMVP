package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherapplication.utils.SessionKeys;
import com.example.weatherapplication.utils.SessionManager;

public class ProfileActivity extends AppCompatActivity {

    TextView userEmail,userName;

    SessionManager sessionManager;

    ImageView ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        ImageView=findViewById(R.id.ImageView);
        sessionManager=new SessionManager(this);
        String FirstName=sessionManager.getStringKey(SessionKeys.FIRST_NAME);
        String Email=sessionManager.getStringKey(SessionKeys.EMAIL);
        String pic=sessionManager.getStringKey(SessionKeys.PHOTO);
        if (Email!=null&& !(Email.isEmpty())){
           userEmail.setText(Email);
        }

        if (FirstName!=null&& !(FirstName.isEmpty())){
            userName.setText(FirstName);
        }
        if (pic!=null&& !(pic.isEmpty())){
            Glide.with(this)
                    .load(pic)
                    .into(ImageView);
        }



    }
}
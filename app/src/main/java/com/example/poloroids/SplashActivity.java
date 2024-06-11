package com.example.poloroids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashActivity extends AppCompatActivity {

    private static int activity_splash=4000;

    Animation topAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnim=AnimationUtils.loadAnimation(this,R.anim.top_animation);

        image=findViewById(R.id.imageView4);
        image.setAnimation(topAnim);
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        },activity_splash);
    }
}
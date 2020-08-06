package com.example.baiexe3;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ImageView mLoadingBg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }

    private void setEvent() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation ImageRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.loading_animation);
                mLoadingBg.startAnimation(ImageRotateAnimation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }, 3000);
            }
        });


    }

    private void setControl() {
        mLoadingBg = findViewById(R.id.winpay_loading_bg);
        btn = findViewById(R.id.btn);
    }
}


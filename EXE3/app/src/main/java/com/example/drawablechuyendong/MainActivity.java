package com.example.drawablechuyendong;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    ImageView images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = (ImageView)findViewById(R.id.imgWF);
        images.setBackgroundResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable)images.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animationDrawable.start();
    }
}

package com.example.smartchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class BeginActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    FrameLayout frameLayout;


    ImageView imLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        imLogo = findViewById(R.id.logo);
        AnimationFade();
    }

    private void AnimationFade() {

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(imLogo, View.ALPHA, 0f);
        anim2.setDuration(3400);
        anim2.start();


        //Delay
        Runnable Delay = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(BeginActivity.this, MainActivity.class));
                finish();

            }
        };

        Handler pd = new Handler();
        pd.postDelayed(Delay, 3000);
    }
}

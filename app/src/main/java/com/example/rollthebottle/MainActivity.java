package com.example.rollthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
    private int fromDegree;
    private boolean spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.imageView);
    }

    public void spin(View view) {

        if (!spn){
            int toDegree = random.nextInt(1800);

            // set the pivot to the centre of the image
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;

            // pass parameters in RoatateAnimation function
            Animation rot = new RotateAnimation(fromDegree, toDegree, pivotX, pivotY);

            rot.setDuration(2500);

            rot.setFillAfter(true);
            rot.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spn = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spn = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            // change last direction
            fromDegree = toDegree;

            // start animation
            bottle.startAnimation(rot);
        }

    }
}
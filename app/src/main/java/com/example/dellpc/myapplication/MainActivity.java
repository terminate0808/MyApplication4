package com.example.dellpc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;


    RotateAnimation rotateAnimation ,rotateAnimationStart,rotateAnimationEnd;
    boolean imageHolding = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotateAnimation=new RotateAnimation(0, 1000,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(4500);
        rotateAnimation.setInterpolator(new LinearInterpolator()) ;
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                                                     public void onAnimationStart(Animation animation) {
                                                         if (imageHolding) {
                                                             imageView.startAnimation(rotateAnimation);
                                                         }else{
                                                             imageView.startAnimation(rotateAnimationEnd);
                                                         }
                                                     }

                                                     public void onAnimationEnd(Animation animation) {

                                                     }

                                                     public void onAnimationRepeat(Animation animation) {

                                                     }
                });

        rotateAnimationEnd=new RotateAnimation(0, 1000,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimationEnd.setDuration(4500);
        rotateAnimationEnd.setInterpolator(new LinearInterpolator()) ;
        rotateAnimationEnd.setAnimationListener(new Animation.AnimationListener() {
                                                     public void onAnimationStart(Animation animation) {
                                                            if (imageHolding) {
                                                                imageView.startAnimation(rotateAnimation);
                                                                }else{
                                                            imageView.startAnimation(rotateAnimationEnd);
                                                            }
                                                     }

                                                        public void onAnimationEnd(Animation animation) {

                                                        }

                                                        public void onAnimationRepeat(Animation animation) {

                                                        }
                });

        rotateAnimationStart=new RotateAnimation(0, 1000,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimationStart.setDuration(4500);
        rotateAnimationStart.setInterpolator(new LinearInterpolator()) ;
        rotateAnimationStart.setAnimationListener(new Animation.AnimationListener() {
                                                        public void onAnimationStart(Animation animation) {

                                                        }

                                                        public void onAnimationEnd(Animation animation) {
                                                            if (imageHolding){
                                                            imageView.startAnimation(rotateAnimation);
                                                            }else{
                                                            imageView.startAnimation(rotateAnimationEnd);
                                                            }
                                                        }

                                                        public void onAnimationRepeat(Animation animation) {

                                                         }
                });


        imageView=(ImageView)findViewById(R.id.imageView);

                imageView.setOnTouchListener(new View.OnTouchListener(){
                public boolean onTouch(View v,MotionEvent event){
                switch(event.getAction()){
                 case MotionEvent.ACTION_DOWN:
                     imageHolding=true;
                     imageView.startAnimation(rotateAnimationStart);
                     break;
                 case MotionEvent.ACTION_UP:
                     imageHolding=false;

                     break;
                     }
                        return true;

                }
                }
                );
        }
}
package com.example.dell.myapplication.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.dell.myapplication.R;

public class Main3Activity extends AppCompatActivity {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();

    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
 /*       AnimationDrawable animationDrawable = (AnimationDrawable) mIv.getBackground();
        animationDrawable.start();*/
        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        mIv.setAnimation(animation);
        int i = mIv.getWidth() / 2;
        int i1 = mIv.getHeight() / 2;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1,0.5f,1,0.5f, Animation.RELATIVE_TO_PARENT,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setInterpolator(new AnticipateInterpolator());
        scaleAnimation.setFillAfter(true);
        mIv.setAnimation(scaleAnimation);
  /*      if (animationDrawable.isRunning()){
            Log.e("==", "完成: " );
        }else {
            animationDrawable.start();
        }*/
    }
}

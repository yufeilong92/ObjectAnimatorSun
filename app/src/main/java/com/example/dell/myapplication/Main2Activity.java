package com.example.dell.myapplication;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = Main2Activity.class.getSimpleName();
    private Button mBtnNation;
    private Resources resources;
    private ProgressBar mProgressbar;
    private WebView mWebview;
    private ImageView mIv;
    private FrameLayout mFla;
    private View mView;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Resources resources = getResources();

    }
    private void startAnimation(){
        int color = resources.getColor(R.color.blue_sky);
        int color1 = resources.getColor(R.color.sunset_sky);
        int color2 = resources.getColor(R.color.night_sky);
        int top = mIv.getTop();
        int height = mFla.getHeight();
        ObjectAnimator animator =  ObjectAnimator.ofFloat(mIv,"y",top,height)
                .setDuration(3000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator backgroundColor = ObjectAnimator.ofInt(mFla, "backgroundColor", color, color1).setDuration(3000);
        backgroundColor.setEvaluator(new ArgbEvaluator());
        ObjectAnimator backgroundColor1 = ObjectAnimator.ofInt(mFla, "backgroundColor", color, color2).setDuration(3000);
        backgroundColor1.setEvaluator(new ArgbEvaluator());
//        backgroundColor.start();
//        animator.start();
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIv, "scaleY",  1f, 0).setDuration(3000);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIv, "scaleX",1f ,0).setDuration(3000);
      scaleX.setInterpolator(new DecelerateInterpolator());
        scaleY.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator)
                .with(backgroundColor)
                .with(scaleY)
                .with(scaleX)
                .before(backgroundColor1);
        animatorSet.start();

    }
    private void startAnimation1(){
        int color = resources.getColor(R.color.blue_sky);
        int color1 = resources.getColor(R.color.sunset_sky);
        int color2 = resources.getColor(R.color.night_sky);
        int top = mIv.getTop();
        int height = mFla.getHeight();
        ObjectAnimator animator =  ObjectAnimator.ofFloat(mIv,"y",height,top)
                .setDuration(3000);



        animator.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator backgroundColor = ObjectAnimator.ofInt(mFla, "backgroundColor", color, color1).setDuration(3000);
        backgroundColor.setEvaluator(new ArgbEvaluator());
        ObjectAnimator backgroundColor1 = ObjectAnimator.ofInt(mFla, "backgroundColor", color, color2).setDuration(3000);
        backgroundColor1.setEvaluator(new ArgbEvaluator());
//        backgroundColor.start();
//        animator.start();
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIv, "scaleY", 0, 1f).setDuration(3000);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIv, "scaleX", 0, 1f).setDuration(3000);
        scaleX.setInterpolator(new DecelerateInterpolator());
        scaleY.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator)
                .with(backgroundColor)
                .with(scaleY)
                .with(scaleX)
                .before(backgroundColor1);
        animatorSet.start();

    }
    private void initData() {
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        mWebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    mProgressbar.setVisibility(View.GONE);
                } else {
                    mProgressbar.setVisibility(View.VISIBLE);

                    mProgressbar.setProgress(newProgress);
                }

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setSubtitle(title);
            }
        });
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebview.loadUrl("http://www.baidu.com");
    }

    private void initView() {
        mBtnNation = (Button) findViewById(R.id.btn_nation);
        resources = getResources();
        mBtnNation.setOnClickListener(this);
        mProgressbar = (ProgressBar) findViewById(R.id.progressbar);
        mProgressbar.setOnClickListener(this);
        mWebview = (WebView) findViewById(R.id.webview);
        mWebview.setOnClickListener(this);
        mProgressbar.setMax(100);
        mBtnNation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_CANCEL:
                        Log.e(TAG, "ACTION_CANCEL: ");
                        break;
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "ACTION_DOWN: ");

                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "ACTION_UP: ");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
        mFla = (FrameLayout) findViewById(R.id.fla);
        mFla.setOnClickListener(this);
        mView = findViewById(R.id.view);
        mView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_nation:
//                sendNotaification();
                startAnimation1();
                break;
            case  R.id.iv:
                startAnimation();
               break;
        }
    }

    private void sendNotaification() {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("下载中。。。。")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                .setAutoCancel(true)
                .setContentTitle("游戏下载///")
                .setContentText("西游降魔。。。");
        manager.notify(0, builder.build());
        initData();
    }
}

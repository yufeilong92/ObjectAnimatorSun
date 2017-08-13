package com.example.dell.myapplication.text;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.myapplication.R;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private Button mButton2;
    private Button mButton3;
    private NavigationView mNaview;
    private ImageView mIV;
    private ImageView mIVs;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        initData();
    }

    private void initData() {

        mNaview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_one:
                        Toast.makeText(Main4Activity.this, "ic_one", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_two:
                        Toast.makeText(Main4Activity.this, "ic_two", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_three:
                        Toast.makeText(Main4Activity.this, "ic_three", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_four:
                        Toast.makeText(Main4Activity.this, "ic_four", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.iv_head:
                        Toast.makeText(Main4Activity.this, "iv_head", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


    }


    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);

        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mNaview = (NavigationView) findViewById(R.id.naview);
        mNaview.setOnClickListener(this);
        View view = mNaview.getHeaderView(0);
        mIV = (ImageView) view.findViewById(R.id.iv_head);
        mIVs = (ImageView) view.findViewById(R.id.iv_heads);
        mIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main4Activity.this, "sssss", Toast.LENGTH_SHORT).show();
            }
        });
        mIVs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main4Activity.this, "33333", Toast.LENGTH_SHORT).show();
            }
        });

        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mDrawer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Snackbar.make(v, "你点击了", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.button2:
            mDrawer.openDrawer(Gravity.START);
                break;
            case R.id.button3:

                break;

        }
    }
}

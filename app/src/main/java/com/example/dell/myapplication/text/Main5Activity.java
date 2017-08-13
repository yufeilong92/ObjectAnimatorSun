package com.example.dell.myapplication.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;

import com.example.dell.myapplication.R;

public class Main5Activity extends AppCompatActivity {
   private String Name="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }
  private class  tablyouts extends TabLayout{
      public tablyouts(Context context) {
          super(context);
      }

      public tablyouts(Context context, AttributeSet attrs) {
          super(context, attrs);
      }

      public tablyouts(Context context, AttributeSet attrs, int defStyleAttr) {
          super(context, attrs, defStyleAttr);
      }

      @Override
      public void setTabTextColors(@Nullable ColorStateList textColor) {
          super.setTabTextColors(textColor);
      }

  }
}

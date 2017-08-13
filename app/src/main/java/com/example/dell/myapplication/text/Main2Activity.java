package com.example.dell.myapplication.text;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.myapplication.R;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRlv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        SelecContent content = new SelecContent(new JamedContent());
        List<String> listfragment = content.getListfragment();
        for (String s : listfragment) {
            Log.e("===", "initView: "+s );
        }

        List<String> title = content.getTitle();
        for (String s : title) {
            Log.e("==", "initView: ==="+s );
        }
    }
}

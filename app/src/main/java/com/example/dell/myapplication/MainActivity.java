package com.example.dell.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private String request;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    String obj = (String) msg.obj;
                    mTv.setText(obj);
                    break;
                case  0:
                    Toast.makeText(MainActivity.this,""+(String) msg.obj,Toast.LENGTH_SHORT).show();
                   break;
                default:
                    break;
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new Thread(new Runnable() {

            @Override
            public void run() {
                request = Request("http://www.baidu.com");
            }
        }).start();


        handler.obtainMessage(0,"ssssss")
                .sendToTarget();
    }

    private String Request(String str) {
        try {
            URL url = new URL(str);
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(6000);
                connection.setReadTimeout(6000);
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader reader1 = new InputStreamReader(inputStream);
                    BufferedReader reader = new BufferedReader(reader1);
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    reader1.close();
                    reader.close();
                    Message message = new Message();
                    message.what = 1;
                    message.obj = response.toString();
                    handler.sendMessage(message);

                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }
}

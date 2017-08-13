package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;

    private static boolean BOne = false;
    private static boolean BTwo = false;
    private static boolean BThree = false;
    private static boolean BFour = false;
    private static boolean BFive = false;
    private static boolean BSixe = false;
    private static boolean BServince = false;
    private static boolean BEight = false;
    private static boolean BNine = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        initView();

        int a = 7;
        for (int i = 0; i < a; i++) {
            String index = Stutas.getNameWithIndex(i);
            Log.e("===", "onCreate: " + index);
        }
        Stutas one = Stutas.valueOf("One");
        Log.e("===", "onCreate:" + one);
        String name = one.getName();
        int id = one.getId();
        Log.e("===", "onCreate:" + one + name + id);
    }

    private void initView() {
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton6 = (Button) findViewById(R.id.button6);
        mButton7 = (Button) findViewById(R.id.button7);
        mButton8 = (Button) findViewById(R.id.button8);
        mButton9 = (Button) findViewById(R.id.button9);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                if (BOne)
                    Toast.makeText(Main7Activity.this, "button1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                if (BTwo)
                    Toast.makeText(Main7Activity.this, "button2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                if (BThree)
                    Toast.makeText(Main7Activity.this, "button3", Toast.LENGTH_SHORT).show();

                break;
            case R.id.button4:
                if (BFour)
                    Toast.makeText(Main7Activity.this, "button4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                 Stutas.SelectStutas(Stutas.One);

                break;
            case R.id.button6:
                Stutas.SelectStutas(Stutas.TWO);
                break;
            case R.id.button7:
                Stutas.SelectStutas(Stutas.Three);
                break;
            case R.id.button8:
                Stutas.SelectStutas(Stutas.Four);
                break;
            case R.id.button9:

                break;
        }
    }

    enum Stutas {
        One("未审核", 1), TWO("机构已受理", 2), Three("机构未受理", 3), Four("媒体受理", 4),
        Five("媒体不受理", 5), Six("结束", 6);

        Stutas(String str, int i) {
            this.name = str;
            this.id = i;
        }

        public static String getNameWithIndex(int id) {

            Stutas[] values = Stutas.values();
            for (Stutas value : values) {
                if (value.getId() == id) {
                    return value.getName();
                }
            }
            return null;
        }

        public static void SelectStutas(Stutas stutas) {
            switch (stutas) {
                case One:
                    BOne=true;
                    BTwo=true;
                    BThree=false;
                    BFour=false;
                    break;
                case TWO:
                    BOne=false;
                    BTwo=false;
                    BThree=true;
                    BFour=true;
                    break;
                case Three:
                    BOne=true;
                    BTwo=false;
                    BThree=false;
                    BFour=true;
                    break;
                case Four:
                    BOne=true;
                    BTwo=false;
                    BThree=true;
                    BFour=false;
                    break;
                case Five:
                    break;
                case Six:
                    break;
                default:
                    break;
            }
        }

        String name;
        int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}

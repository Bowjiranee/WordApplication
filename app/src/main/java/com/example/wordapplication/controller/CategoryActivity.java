package com.example.wordapplication.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wordapplication.R;
import com.example.wordapplication.model.Word;

public class CategoryActivity extends AppCompatActivity {

    private TextView title1;
    private TextView title2;
    private TextView title3;
    private TextView title4;
    private TextView title5;

    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview5;

    private Word currentWord;
    String[] groups = {"FRUIT","SHAPE","COLOR","ANIMAL","BODY"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Button backBTN = (Button)findViewById(R.id.backBtn);

        title1 = (TextView)findViewById(R.id.textView1);
        title2 = (TextView)findViewById(R.id.textView2);
        title3 = (TextView)findViewById(R.id.textView3);
        title4 = (TextView)findViewById(R.id.textView4);
        title5 = (TextView)findViewById(R.id.textView5);

        imageview1 = (ImageView) findViewById(R.id.imageView1);
        imageview2 = (ImageView) findViewById(R.id.imageView2);
        imageview3 = (ImageView) findViewById(R.id.imageView3);
        imageview4 = (ImageView) findViewById(R.id.imageView4);
        imageview5 = (ImageView) findViewById(R.id.imageView5);

            title1.setText(groups[0]);
            title2.setText(groups[1]);
            title3.setText(groups[2]);
            title4.setText(groups[3]);
            title5.setText(groups[4]);


        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

//        imageview1.setOnClickListener(this);
//        imageview2.setOnClickListener(this);
//        imageview3.setOnClickListener(this);
//        imageview4.setOnClickListener(this);
//        imageview5.setOnClickListener(this);

    }

//    @Override
//    public void onClick(View v) {
//        if(R.id.imageView1 == v.getId()){
////
////            Intent intent = new Intent(CategoryActivity.this, Main2Activity.class);
////
////            startActivity(intent);
//
//        }else if(R.id.imageView2 == v.getId()){
//
////            Intent intent2 = new Intent(CategoryActivity.this,Main2Activity.class);
////
////            startActivity(intent2);
//        }
//    }
}

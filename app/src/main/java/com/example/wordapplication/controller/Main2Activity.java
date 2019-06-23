package com.example.wordapplication.controller;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wordapplication.R;
import com.example.wordapplication.model.Word;
import com.example.wordapplication.db.WordDbHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private TextView titleGroup;
    private TextView nameWord;
//    private TextView nameTest;

    private Button nextBtn;
    private ImageView mImageView;

    private List<Word> mWordList;

    private int wordCounter;
    private int wordCountTotal;
    private Word currentWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titleGroup = (TextView)findViewById(R.id.title_text_view);
        nameWord = (TextView)findViewById(R.id.name_text_view);
//        nameTest = (TextView)findViewById(R.id.name_test_view);
        nextBtn = (Button)findViewById(R.id.next_button);
        mImageView = (ImageView) findViewById(R.id.word_image_view);

        WordDbHelper dbHelper = new WordDbHelper(this);
        mWordList = dbHelper.getAllWords();
        wordCountTotal = mWordList.size();
        Collections.shuffle(mWordList);

        showNextQuestion();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextQuestion();
            }
        });
    }

    public void showNextQuestion(){

        if(wordCounter<wordCountTotal){
            currentWord = mWordList.get(wordCounter);
            wordCounter++;

            String str = currentWord.getImage();
            int num = str.lastIndexOf(".png");
            String strImage = str.substring(0,num);

            titleGroup.setText(currentWord.getGroup());

                if (currentWord.getGroup().equals("COLOR")){
                    nameWord.setText( currentWord.getNameWord() );
/*                        mImageView.setImageResource( getResources().getIdentifier
                                ( strImage , "drawable", getPackageName()));*/
                    try {
                        InputStream is = getAssets().open("colors/"+currentWord.getImage());
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            Log.e("wtf", line);
                        }
                        Drawable d = Drawable.createFromStream(is, null);
                        mImageView.setImageDrawable(d);
                        br.close();
                    }
                    catch(IOException e) {
                        return;
                    }

                }else if(currentWord.getGroup().equals("FRUIT")){
                    nameWord.setText(currentWord.getNameWord());

                    try {
                        InputStream is = getAssets().open("fruits/"+currentWord.getImage());
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            Log.e("wtf", line);
                        }
                        Drawable d = Drawable.createFromStream(is, null);
                        mImageView.setImageDrawable(d);
                        br.close();
                    }
                    catch(IOException e) {
                        return;
                    }
                }else if(currentWord.getGroup().equals("ANIMAL")){
                    nameWord.setText( currentWord.getNameWord() );

                    try {
                        InputStream is = getAssets().open("animals/"+currentWord.getImage());
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            Log.e("wtf", line);
                        }
                        Drawable d = Drawable.createFromStream(is, null);
                        mImageView.setImageDrawable(d);
                        br.close();
                    }
                    catch(IOException e) {
                        return;
                    }
                }else if(currentWord.getGroup().equals("BODY")){
                    nameWord.setText( currentWord.getNameWord() );

                    try {
                        InputStream is = getAssets().open("bodies/"+currentWord.getImage());
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            Log.e("wtf", line);
                        }
                        Drawable d = Drawable.createFromStream(is, null);
                        mImageView.setImageDrawable(d);
                        br.close();
                    }
                    catch(IOException e) {
                        return;
                    }
                }else if(currentWord.getGroup().equals("SHAPE")){
                    nameWord.setText( currentWord.getNameWord() );

                    try {
                        InputStream is = getAssets().open("shapes/"+currentWord.getImage());
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            Log.e("wtf", line);
                        }
                        Drawable d = Drawable.createFromStream(is, null);
                        mImageView.setImageDrawable(d);
                        br.close();
                    }
                    catch(IOException e) {
                        return;
                    }
                }
        }else{
            finish();
        }
    }
}


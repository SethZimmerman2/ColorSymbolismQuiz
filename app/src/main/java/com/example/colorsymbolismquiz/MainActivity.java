package com.example.colorsymbolismquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSharedPrefs();
        initRadioGroupQ1();
        initRadioGroupQ2();
        initAnswerButton();
        initNameChange();

    }

    private void initSharedPrefs(){
        SharedPreferences sharedPref = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
        String choice1 = sharedPref.getString("Q1", "friends");
        String choice2 = sharedPref.getString("Q2", "intro");


        RadioButton radioFriends = findViewById(R.id.radioFriends);
        RadioButton radioWalks = findViewById(R.id.radioWalks);
        RadioButton radioHome = findViewById(R.id.radioHome);
        RadioButton radioIntroverted = findViewById(R.id.radioIntroverted);
        RadioButton radioExtroverted = findViewById(R.id.radioExtroverted);
        RadioButton radioIntroExtro = findViewById(R.id.radioIntroExtro);

        if(choice1.equals("friends")){
            radioFriends.setChecked(true);
        }
        else if(choice1.equals("walks")){
            radioWalks.setChecked(true);
        }
        else{
            radioHome.setChecked(true);
        }

        if(choice2.equals("intro")){
            radioIntroverted.setChecked(true);
        }
        else if(choice2.equals("extro")){
            radioExtroverted.setChecked(true);
        }
        else{
            radioIntroExtro.setChecked(true);
        }


    }

    private void initRadioGroupQ1(){
        RadioGroup rg1 = findViewById(R.id.radioQ1);
        RadioButton rbFriends = findViewById(R.id.radioFriends);
        RadioButton rbWalks = findViewById(R.id.radioWalks);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbFriends.isChecked()){
                    SharedPreferences sp = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Q1", "friends");
                    editor.apply();
                }
                else if(rbWalks.isChecked()){
                    SharedPreferences sp = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Q1", "walks");
                    editor.apply();
                }
                else{
                    SharedPreferences sp = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Q1", "home");
                    editor.apply();
                }
            }
        });
    }

    private void initRadioGroupQ2(){
        RadioGroup rg2 = findViewById(R.id.radioQ2);
        RadioButton rbIntro = findViewById(R.id.radioIntroverted);
        RadioButton rbExtro = findViewById(R.id.radioExtroverted);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbIntro.isChecked()){
                    SharedPreferences sp = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Q2", "intro");
                    editor.apply();
                }
                else if(rbExtro.isChecked()){
                    SharedPreferences sp = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Q2", "extro");
                    editor.apply();
                }
                else{
                    SharedPreferences sp = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Q2", "introExtro");
                    editor.apply();
                }
            }
        });
    }

    private void initNameChange(){
        EditText editName = findViewById(R.id.editName);
        SharedPreferences sharedPref = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String name = editName.toString();
        editor.putString("getname", name);
        editor.apply();

    }

    private void initAnswerButton(){
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerDisplay.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}
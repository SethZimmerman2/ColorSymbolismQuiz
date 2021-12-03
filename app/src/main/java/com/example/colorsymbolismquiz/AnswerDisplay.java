package com.example.colorsymbolismquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerDisplay extends AppCompatActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_display);

        initRetakeButton();
    }

    public void onResume(){
        super.onResume();
        layout = findViewById(R.id.layout);

        SharedPreferences sharedPref = getSharedPreferences("ColorQuizPreferences", Context.MODE_PRIVATE);
        String choice1 = sharedPref.getString("Q1", "friends");
        String choice2 = sharedPref.getString("Q2", "intro");

        SharedPreferences sharedPrefName = getSharedPreferences("NamePreferences", Context.MODE_PRIVATE);

        String name = sharedPrefName.getString("getname", "Name");

        TextView textNameIs = findViewById(R.id.textNameIs);
        TextView textAnswer = findViewById(R.id.textAnswer);
        TextView textAnswerHeader = findViewById(R.id.textAnswerHeader);

        textNameIs.setText(name+"'s color is...");


        if(choice1.equals("friends") && choice2.equals("intro")){
            //white

            layout.setBackgroundColor(0xFFFFFFFF);
            textAnswer.setText("White!\n White represents purity, good, and simplicity. " +
                    "While you are not very outgoing yourself, " +
                    "you always respect and stick by what your friends like to do. In any arguments," +
                    "you are never the subject of ridicule and are always the first to suggest a compromise.");
        }
        else if(choice1.equals("friends") && choice2.equals("extro")){
            //orange
            layout.setBackgroundColor(0xFFFF6600);
            textAnswer.setText("Orange!\n Orange represents confidence, friendliness, and courage. " +
                    "You are typically the head of your friend group, always putting them first" +
                    "and helping them in times of need. You may not be the smartest nor the most serious by" +
                    "any means, but people look up to you and you should be proud of that.");
        }
        else if(choice1.equals("friends") && choice2.equals("introExtro")){
            //red
            layout.setBackgroundColor(0xFFFF0000);
            textAnswer.setText("Red!\n Red represents energy, strength and passion. You like your friends almost too" +
                    "much to the point where you threaten anyone and anything else that stands between you" +
                    "and them. Deep down, you don't mean harm and while your strength is admirable, people" +
                    "outside of your friend group may be intimidated; this probably doesn't bother you though.");
        }
        else if(choice1.equals("walks") && choice2.equals("extro")){
            //cyan
            layout.setBackgroundColor(0xFF00FFFF);
            textAnswer.setText("Cyan!\n Cyan represents healing, protection, and self-efficiency. " +
                    "Even if you aren't always available or willing to be with friends, their health is almost always on your mind." +
                    "You are always the first one to suggest precautionary measures and ward off violence. The first" +
                    "relaxation spot you always suggest is outside in the wilderness.");
        }
        else if(choice1.equals("walks") && choice2.equals("introExtro")){
            //yellow
            layout.setBackgroundColor(0xFFFFFF00);

            textAnswer.setText("Yellow!\n Yellow represents positivity, intelligence, and happiness. " +
                    "You are always the brightest one in the arm, often being the one who brings the group" +
                    "back together after a period of negativity. You are smart enough to understand your priorities" +
                    "and only slack off with friends when possible.");
        }
        else if(choice1.equals("walks") && choice2.equals("intro")){
            //green
            layout.setBackgroundColor(0xFF00FF00);
            textAnswer.setText("Green!\n Green represents fertility, nature,  and safety. " +
                    "Not a fan of chatter and interaction, you prefer to venture out for yourself and enjoy the periods" +
                    "of peace and quiet while you can. You don't plead harm on anyone, but you are mostly there for Mother" +
                    "Earth and are likely an outdoors person, seeing the value in staying active.");
        }
        else if(choice1.equals("home") && choice2.equals("intro")){
            //black
            layout.setBackgroundColor(0xFF000000);
            textAnswer.setTextColor(0xFFFFFFFF);
            textAnswerHeader.setTextColor(0xFFFFFFFF);
            textNameIs.setTextColor(0xFFFFFFFF);
            textAnswer.setText("Black!\n Black represents mystery, security, and formality. " +
                    "No one sees you enough to truly know who you are, as you have your own way of doing things. " +
                    "You don't follow anyone's rules but your own and often prohobit interaction with other people." +
                    "Unknown, yet formal, you ensure know one obtains any unwarranted knowledge of you.");
        }
        else if(choice1.equals("home") && choice2.equals("extro")){
            //purple
            layout.setBackgroundColor(0xFFFF00FF);
            textAnswer.setText("Purple!\n Purple represents wisdom, royalty, and luxury. You often stay inside, but that is often" +
                    "because you have no need to venture out. You always ensure you do everything in style and class," +
                    "often avoid casual norms or stereotypes. Having the wisdom and dignity to make it work, " +
                    "you also have the tendency to improve the style and class of others as well.");
        }
        else{
            //blue
            layout.setBackgroundColor(0xFF0000FF);
            textAnswer.setText("Blue!\n Blue represents stability, loyalty, and tranquility. You mostly keep to yourself," +
                    "but you value the trust in others just as they do in you. During times of crisis, you" +
                    "are always the one that maintains their cool and sets a calmer vibe for the group. You " +
                    "prefer solitude but are flexible and go with your friends flow when they ask.");
        }
    }

    public void initRetakeButton(){
        Button buttonRetake = findViewById(R.id.buttonRetake);
        buttonRetake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnswerDisplay.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
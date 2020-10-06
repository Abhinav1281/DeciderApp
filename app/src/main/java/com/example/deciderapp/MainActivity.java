package com.example.deciderapp;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int choice=0,choice1=0,choice2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void decisionTaker(View v)
    {
        ImageView img=findViewById(R.id.topImage);
        choice++;
        EditText ch1=findViewById(R.id.choice1);
        EditText ch2=findViewById(R.id.choice2);
        TextView txt=findViewById(R.id.result);
        String s1=ch1.getText().toString();
        String s2=ch2.getText().toString();
        Random rnd=new Random();
        int ch=rnd.nextInt(2);

        if(ch==1)
        {
            txt.setText(ch1.getText());
            choice1++;
            img.setImageResource(R.drawable.heads);
        }
        else {
            txt.setText(ch2.getText());
            choice2++;
            img.setImageResource(R.drawable.tails);
        }
        TextView chc=findViewById(R.id.choiceCount);
        chc.setText("NO. OF CHOICES MADE:"+choice);



        Toast.makeText(getApplicationContext(),"CHOICE 1--"+choice1+"  CHOICE 2--"+choice2,Toast.LENGTH_SHORT).show();


    }
    public void buttonRst(View v)
    {
        AlertDialog.Builder resetAlert=new AlertDialog.Builder(MainActivity.this);
        resetAlert.setCancelable(false);
        resetAlert.setTitle("RESET ALERT");
        resetAlert.setMessage("DO YOU WANT TO RESET?");
        resetAlert.setPositiveButton("RESET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reset();
            }
        });
        resetAlert.setNegativeButton("DON'T RESET ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        resetAlert.show();
    }

    public void reset()
    {
        choice2=0;choice=0;choice1=0;
        TextView chc=findViewById(R.id.choiceCount);
        chc.setText("NO. OF CHOICES MADE:"+choice);

        TextView txt=findViewById(R.id.result);
        txt.setText("VALUE RESET");
        ImageView img=findViewById(R.id.topImage);
        img.setImageResource(R.drawable.topimage);
        Toast.makeText(getApplicationContext(),"CHOICE 1--"+choice1+"CHOICE 2--"+choice2,Toast.LENGTH_SHORT).show();

    }

}
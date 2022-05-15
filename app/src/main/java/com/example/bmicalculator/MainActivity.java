package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;
    TextView mcurrentheight;
    TextView mcurrentage , mcurrentweight;
    ImageView mIncrementage , mincrementweight, mdecrementage,mdecrementweight;
    SeekBar mseekbarforheight;
    RelativeLayout mmale, mfemale;


    int weight=55;
    int age=22;
    int currentprogress;
    String mintprogress = "170";
    String typeofUser = "0";
    String weight2 ="55";
    String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        mcalculatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentweight = findViewById(R.id.currentweight);
        mcurrentheight = findViewById(R.id.currentHeight);
        mIncrementage = findViewById(R.id.incrementage);
        mdecrementage = findViewById(R.id.decrementage);
        mincrementweight = findViewById(R.id.incrementweight);
        mdecrementweight = findViewById(R.id.decrementweight);
        mseekbarforheight = findViewById(R.id.seekBarforHieght);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);


        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofUser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofUser="Female";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(typeofUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Height", Toast.LENGTH_SHORT).show();
                }
                else if(age ==0 || age <0){
                    Toast.makeText(getApplicationContext(), "Incorrect Age", Toast.LENGTH_SHORT).show();
                }
                else if(weight ==0 || weight <0){
                    Toast.makeText(getApplicationContext(), "Incorrect Weight", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,bmiactivity.class);
                    intent.putExtra("gender",typeofUser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }
            }
        });

        mIncrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age+1;
                age2 = String.valueOf(age);
                mcurrentage.setText(age2);
            }
        });



        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight+1;
                weight2 = String.valueOf(weight);
                mcurrentweight.setText(weight2);
            }
        });



        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight-1;
                weight2 = String.valueOf(weight);
                mcurrentweight.setText(weight2);
            }
        });


        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age-1;
                age2 = String.valueOf(age);
                mcurrentage.setText(age2);
            }
        });




    }
}
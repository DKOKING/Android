package com.example.tomagachi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    private final int nuetral = 0;
    private final int happy = 1;
    private final int mad = 2;
    private final int hun = 3;
    private final int nuetral2 = 4;
    private final int happy2 = 5;
    private final int mad2 = 6;
    private final int hun2 = 7;
    private int images[] = {R.drawable.tomaneutral, R.drawable.tomahappy, R.drawable.tomamad, R.drawable.tomahungry, R.drawable.tomaneutrallvl2, R.drawable.tomahappylvl2, R.drawable.tomamadlvl2, R.drawable.tomahungrylvl2};
    private TextView time;
    private CountDownTimer timer;
    private CountDownTimer timer2;
    private ProgressBar progBar;
    private ProgressBar hunBar;
    private int myInteger;
    private int myInt2;
    private ImageView pet;
    private TextView level;
    private int num = 1;
    private int num2 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progBar = findViewById(R.id.progBar);
        hunBar = findViewById(R.id.hunger);
        pet = findViewById(R.id.pet);
        level = findViewById(R.id.level);


        level.setText(String.format("%d", num));
        progBar.setMax(10);
        hunBar.setMax(100);
        hunBar.setProgress(100);

        timer = new CountDownTimer(100000, 1000) {

            public void onTick(long millisUntilFinished) {
                hunBar.setProgress(hunBar.getProgress() - 1);
            }

            public void onFinish() {
                timer.start();
            }
        };
        timer.start();


    }

    public void rubPet(View view) {
            if(hunBar.getProgress() > 50) {
                pet.setImageResource(images[happy]);
                progBar.setProgress(progBar.getProgress() + 1);
                if (progBar.getProgress() == progBar.getMax()) {
                    level.setText(String.format("%d", num++));
                    progBar.setMax(progBar.getMax() + 10);
                    progBar.setProgress(0);
                }
            }
            else if(hunBar.getProgress() < 50){
                pet.setImageResource(images[hun]);
                progBar.setProgress(progBar.getProgress() + 1);
                if (progBar.getProgress() == progBar.getMax()) {
                    level.setText(String.format("%d", num++));
                    progBar.setMax(progBar.getMax() + 10);
                    progBar.setProgress(0);
                }
            }
            else if(num >=10 && hunBar.getProgress() > 50){
                pet.setImageResource(images[happy2]);
                progBar.setProgress(progBar.getProgress() + 1);
                if (progBar.getProgress() == progBar.getMax()) {
                    level.setText(String.format("%d", num++));
                    progBar.setMax(progBar.getMax() + 10);
                    progBar.setProgress(0);
                }
            }
            else if(num >=10 && hunBar.getProgress() < 50){
                pet.setImageResource(images[hun2]);
                progBar.setProgress(progBar.getProgress() + 1);
                if (progBar.getProgress() == progBar.getMax()) {
                    level.setText(String.format("%d", num++));
                    progBar.setMax(progBar.getMax() + 10);
                    progBar.setProgress(0);
                }
            }

    }





    public void meat(View view) {
        hunBar.setProgress(hunBar.getProgress() + 30);
    }

    public void cheese(View view) {
        hunBar.setProgress(hunBar.getProgress() + 20);
    }

    public void bread(View view) {
        hunBar.setProgress(hunBar.getProgress() + 10);
    }
}



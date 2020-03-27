package com.example.Exercicios_ProgDispMov;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Aula3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInsanceState){
        super.onCreate(savedInsanceState);
        setContentView(R.layout.exercicios3);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5e9c00")));

    }
    public void aula31Click(View view){

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        setTitle("Poupanca");
        getSupportActionBar().setIcon(R.drawable.poupanca_icon);

        setContentView(R.layout.aula31);

    }
    public void aula32Click(View view){


        getSupportActionBar().hide();
        setContentView(R.layout.aula32);

    }
    public void aula33Click(View view){
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        setTitle("Quiz de trânsito");
        getSupportActionBar().setIcon(R.drawable.quiz_transito_icon);
        setContentView(R.layout.aula33);

    }
    public void aula34Click(View view){

    }
}

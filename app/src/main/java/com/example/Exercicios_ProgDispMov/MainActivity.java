package com.example.Exercicios_ProgDispMov;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
// TODO: 26/03/2020 Falta adicionar os exercicios da aula 1 e 2

// TODO: 26/03/2020 Aula 3:

// TODO: 26/03/2020 Ex3: Falta add o ex 3
// TODO: 26/03/2020 Ex4: Falta fazer a internacionalização

// TODO: 26/03/2020 Falta fazer os exercicios da aula 4 até o dia 01/04/2020

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5e9c00")));
        //getActionBar().setHomeButtonEnabled(true); //issaqui da pau
        //getActionBar().setDisplayHomeAsUpEnabled(true); //issaqui da pau
    }
    public void aula3click(View view) {
        startActivity(new Intent(this,Aula3Activity.class));
    }
    public void aula4click(View view) {
        startActivity(new Intent(this,Aula4Activity.class));
    }
}

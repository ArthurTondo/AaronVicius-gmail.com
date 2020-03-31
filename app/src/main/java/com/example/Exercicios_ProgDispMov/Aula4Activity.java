package com.example.Exercicios_ProgDispMov;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Aula4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);
        setContentView(R.layout.aula4);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5e9c00")));
    }

    public void onClickWeb(View argO) {
        Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100008146508196");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    public void onClickCall(View argO) {
        Uri uri = Uri.parse("tel: 40028922");
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //
            //
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(it);
    }
}

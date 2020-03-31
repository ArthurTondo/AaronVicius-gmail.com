package com.example.Exercicios_ProgDispMov;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Aula4Activity extends AppCompatActivity {
    public final int SELECIONAR_CONTATOS = 1, TIRAR_FOTO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aula4);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5e9c00")));
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA}, 1);
        Button botaoContatos = (Button) findViewById(R.id.botaoContatos);
        TextView tvInfo = findViewById(R.id.textInfoContato);
        tvInfo.setText(String.format("Contato:\nNome:  | ID: \nTelefone:"));
        botaoContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.android.contacts/contacts");
                Intent intent = new Intent(Intent.ACTION_PICK, uri);
                startActivityForResult(intent, SELECIONAR_CONTATOS);
            }
        });
        Button botaoPic = (Button) findViewById(R.id.botaoPic);
        botaoPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, TIRAR_FOTO);
            }
        });
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
    public void onClickMaps1(View argO){
        Uri urigeo = Uri.parse("geo:0,0?q=Sete+de+Setembro,Curitiba");
        Intent it = new Intent(Intent.ACTION_VIEW, urigeo);
        it.setPackage("com.google.android.apps.maps");
        startActivity(it);
    }
    public void onClickMaps2(View argO){
        Uri urigeo = Uri.parse("geo:-25.443195,-49.280977");
        Intent it = new Intent(Intent.ACTION_VIEW, urigeo);
        it.setPackage("com.google.android.apps.maps");
        startActivity(it);
    }
    public void onClickMaps3(View argO){
        String Partida="-25.443195,-49.280977";
        String Destino="-25.442207,-49.278403";
        String Url = "https://www.google.com/maps/dir/"+Partida+"/"+Destino+"/hl=pt";
        //https://www.google.com/maps/dir/-25.443195,-49.280977/-25.442207,-49.278403/hl=pt
        Intent it = new Intent(Intent.ACTION_VIEW);
        it.setData(Uri.parse(Url));
        startActivity(it);
    }

    protected void onActivityResult(int codigo, int resultado, Intent intent) {
        super.onActivityResult(codigo, resultado, intent);

        if (codigo == SELECIONAR_CONTATOS && resultado == RESULT_OK) {
            Uri uri = intent.getData();

            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToNext();
            int nameCol = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int idCol = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone._ID);
            String nome = cursor.getString(nameCol);
            String id = cursor.getString(idCol);
            cursor.close();

            Cursor telefones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
            telefones.moveToNext();
            String numTelefone = telefones.getString(telefones.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
            telefones.close();

            TextView tvInfo = (TextView) findViewById(R.id.textInfoContato);
            tvInfo.setText(String.format("Contato:\nNome: %s | ID: %s\nTelefone: %s", nome, id, numTelefone));
        }
        else if (codigo == SELECIONAR_CONTATOS && resultado == RESULT_CANCELED){
            TextView tvInfo = (TextView) findViewById(R.id.textInfoContato);
            tvInfo.setText(null);
        }
        else if (codigo == TIRAR_FOTO && resultado == RESULT_OK) {
            Bundle extras = intent.getExtras();
            Bitmap imagemBmp = (Bitmap) extras.get("data");
            ImageView imagePic = (ImageView) findViewById(R.id.imagemPicIt);
            imagePic.setImageBitmap(imagemBmp);
        }
        else if (codigo == TIRAR_FOTO && resultado == RESULT_CANCELED){
            ImageView imagePic = (ImageView) findViewById(R.id.imagemPicIt);
            imagePic.setImageBitmap(null);
        }
    }

}

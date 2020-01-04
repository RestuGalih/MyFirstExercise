package com.example.hmjpolines;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class profil extends AppCompatActivity {

    private TextView namaProfile, namaDeskripsi;
    ImageView photoProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profil);


        namaProfile = findViewById(R.id.Nama);
        namaDeskripsi = findViewById(R.id.Desc);
        photoProfile = findViewById(R.id.img_item_photo);


        String namaProfil = getIntent().getStringExtra("namaProfile");
        String namaDesc = getIntent().getStringExtra("namaDesc");
        int photo = getIntent().getIntExtra("photoProfile", 0);

        namaProfile.setText(namaProfil);
        namaDeskripsi.setText(namaDesc);
        photoProfile.setImageDrawable(getResources().getDrawable(photo));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(namaProfil);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(profil.this, MainActivity.class));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivityForResult(intent,0);
        return true;
    }
}

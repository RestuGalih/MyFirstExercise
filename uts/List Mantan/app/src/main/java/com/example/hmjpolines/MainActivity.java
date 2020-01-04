package com.example.hmjpolines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Hmj> hmjs;
    ArrayList<String> Nama,Desc;
    ArrayList<Integer> Photo;
    RecyclerView ListMANTAN;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ListMANTAN = findViewById(R.id.rv_hmj);

        hmjs =new ArrayList<>();
        Nama = new ArrayList<>();
        Photo = new ArrayList<>();
        Nama.add("Anya Geraldine");
        Nama.add("Feby Putri");
        Nama.add("Vanesha Prescilla");
        Nama.add("Aura Kasih");
        Nama.add("Chelsea Islan");

        Desc = new ArrayList<>();
        Desc.add("Anya yang memiliki nama asli Nur Amalina Hayati (lahir di Jakarta, 15 Desember 1995" +
                " umur 23 tahun) merupakan seorang selebriti sosial media Instagram." +
                " Anya mulai dikenal karena video vlog liburan bersama mantan kekasihnya Okky Raditya" +
                " dan membelikan mobil yang dia upload di akun youtube nya. Anya dulu pernah menjadi model berkebangsaan Indonesia" +
                ". Ia menjadi juara 1 kontes modelling Gading Model Search (GMS) pada tahun 2016");
        Desc.add("Feby lahir di kota Makassar pada tanggal 5 Februari 2000. Hobbi bernyanyi Feby yang sudah lama dilakoni," +
                " namun ia baru mengembangkannya saat duduk di kelas 3 SMP dengan membuat video dirinya bernyanyi.");
        Desc.add("Vanesha Prescilla (lahir di Jakarta, 25 Oktober 1999; umur 20 tahun) adalah seorang aktris, model, penyanyi" +
                " dan bintang iklan berkebangsaan Indonesia. Ia merupakan adik dari aktris Sissy Priscillia dan DJ Jevin Julian.");
        Desc.add("Aura kasih lahir di Bandung, 26 Februari 1987; umur 32 tahun) dikenal secara profesional sebagai Aura Kasih merupakan seorang" +
                " penyanyi berkebangsaan Indonesia.Aura Kasih mengawali karier sebagai finalis Miss Indonesia 2007 mewakili provinsi Lampung." +
                " Album perdananya ialah Malaikat Penggoda yang dirilis pada tahun 2008 dengan lagu utamanya yang berjudul Mari Bercinta." +
                " Lagu ini dikenal dengan single dance-hall.");
        Desc.add("Chelsea Elizabeth Islan (lahir 2 Juni 1995) adalah seorang aktris Indonesia. Dia mendapatkan pengakuan publik dalam sitkom" +
                " NET TV Tetangga Masa Gitu. Dia memulai debut filmnya di film drama Refrain (2013), kemudian melanjutkan karir aktingnya di" +
                " beberapa film seperti Street Society (2014), Merry Riana: Mimpi Sejuta Dolar (2014), Di Balik 98 (2015), dan Guru Bangsa: " +
                "Tjokroaminoto (2015). Pada 2017, ia diangkat sebagai duta Parade ASEAN, bersama dengan aktor Indonesia Nicholas Saputra");

        Photo.add(R.drawable.anya_geraldine);
        Photo.add(R.drawable.feby_putri);
        Photo.add(R.drawable.vanesha_prescilla);
        Photo.add(R.drawable.aura_kasih);
        Photo.add(R.drawable.chelsea_islan);

        layoutManager = new LinearLayoutManager(this);

        ListMANTAN.setHasFixedSize(true);
        ListMANTAN.setLayoutManager(layoutManager);


        for (int i = 0; i < Nama.size();i++) {
            Hmj currentItem = new Hmj();
//                    Toast.makeText(MainActivity.this, "" + Nama.get(i), Toast.LENGTH_LONG).show();
            try {
                currentItem.setName(Nama.get(i));
                currentItem.setDescription(Desc.get(i));
                currentItem.setPhoto(Photo.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }

            hmjs.add(currentItem);
        }
        adapter = new CardHmjAdapter(hmjs, MainActivity.this);

        ListMANTAN.setAdapter(adapter);



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profil,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== R.id.menu_profil){
            Intent intent = new Intent(MainActivity.this,profil.class);
            intent.putExtra("namaProfile", "Alvian Rizky Syachputra");
            intent.putExtra("namaDesc", "3.34.17.0.07");
            intent.putExtra("photoProfile", R.drawable.alvianprofil);
            startActivity(intent);
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}

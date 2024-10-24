package com.joylasropurba.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi Variabel Pendukung
    private TextView Hasil;
    private TextView Masukan;
    private  TextView Eksekusi;

    //Deklarasi dan Inisialisasi SharedPreferences
    private SharedPreferences preferences;

    //Digunakan Untuk Konfigurasi SharedPreferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Masukan = (EditText) findViewById(R.id.input);
        Hasil = (TextView) findViewById(R.id.output);
        Eksekusi = (TextView) findViewById(R.id.save);

        //Membuat File Baru Beserta Modifiernya
        preferences = getSharedPreferences("Belajar_SharedPreferences", Context.MODE_PRIVATE);
        Eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                Toast.makeText(getApplicationContext(),"Data Tersimpan",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getData(){
        //Mendapatkan Input dari User
        String getKonten = Masukan.getText().toString();

        //Digunakan Untuk Pengaturan Konfigurasi SharedPreferences
        editor = preferences.edit();

        //Memasukkan Data Pada Editor SharedPreferences dengan key (data_saya)
        editor.putString("data_saya",getKonten);

        //Menjalankan Operasi
        editor.apply();

        //Menampilkan Output
        Hasil.setText("Output data : "+preferences.getString("data_saya",null));
    }
}
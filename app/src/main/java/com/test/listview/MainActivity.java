package com.test.listview;

import android.content.Intent;
import android.icu.util.ValueIterator;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.test.listview.adapter.CustomlistAdapter;
import com.test.listview.function.MyFunction;

import java.io.IOException;

public class MainActivity extends MyFunction {
    String nama_buah[]={"alpukat","apel","ceri","durian","jambu air","manggis","strawberry"};
    int gambar_buah[]={R.drawable.alpukat, R.drawable.apel, R.drawable.ceri,
            R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry,};
    int suara_buah[]={R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian,
            R.raw.jambuair, R.raw.manggis, R.raw.strawberry};
    int detail_buah[] = {R.string.alpukat, R.string.apel,
            R.string.ceri, R.string.durian, R.string.jambuair,
            R.string.manggis, R.string.strawberi,};

    ListView listbuah;
    int posisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listbuah= findViewById(R.id.listbuah);

        CustomlistAdapter adapter= new CustomlistAdapter
                (context, nama_buah, gambar_buah,detail_buah);
        listbuah.setAdapter(adapter);
        listbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posisi=position;
                Intent kirimdata =new Intent(context,DetailList.class);
                kirimdata.putExtra("nb",nama_buah[position]);
                kirimdata.putExtra("gb",gambar_buah[position]);
                kirimdata.putExtra("sb",suara_buah[position]);
                kirimdata.putExtra("db",detail_buah[position]);
                startActivity(kirimdata);
                suaraBuah(position);
            }
        });
    }
    public void suaraBuah(int posisimp){
        MediaPlayer mp= new MediaPlayer();
//                media player untuk memainkan type suara
        Uri lokasi =Uri.parse("android.resource://"+getPackageName()+"/"+suara_buah[posisimp]);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
//                    try adalah mencoba dulu semua cara dibawah dengan mp.setdata-mp.prepare-mp.start
            mp.setDataSource(context,lokasi);
//            customcontext adalah dari myfunction
            mp.prepare();
            mp.start();
//                    semua cara ini tidak bisa maka catch menanganinya dan menampilkan pesan
        } catch (IOException e){
            e.printStackTrace();
//                    untuk menampilkan informasi di bug yang ketika dia errors
        }
    }
}

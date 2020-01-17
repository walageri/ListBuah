package com.test.listview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.listview.R;

public class CustomlistAdapter extends BaseAdapter {
    Context c;
    String[] namabuah;
    int[] gambarbuah,detailbuah;
    public CustomlistAdapter
            (Context context, String[] nama_buah, int[] gambar_buah, int[] detail_buah) {
    c=context;
    namabuah=nama_buah;
    gambarbuah=gambar_buah;
    detailbuah=detail_buah;
    }

    @Override
    public int getCount() {
        return gambarbuah.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.cutomlist,null);
        ImageView imgmkn=v.findViewById(R.id.imbuah);
        TextView txtmkn=v.findViewById(R.id.txbuah);

        imgmkn.setImageResource(gambarbuah[position]);
        txtmkn.setText(namabuah[position]);
        return v;
    }
}

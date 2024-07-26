package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomAdapter extends BaseAdapter {
    Context context;
    String item[];
    int img[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] item, int[] img) {
        this.context = applicationContext;
        this.item = item;
        this.img = img;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return item.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_reviewlistview, null);
        TextView iteml = (TextView) view.findViewById(R.id.textView);
        ImageView imgl = (ImageView) view.findViewById(R.id.icon);
        iteml.setText(item[i]);
        imgl.setImageResource(img[i]);
        return view;
    }
}


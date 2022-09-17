package com.example.trabalho2;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends BaseAdapter {

    private  Context context;
    List<String> listDialogs = new ArrayList<>();

    public AdapterList(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return listDialogs.size();
    }

    @Override
    public Object getItem(int position) {
        return listDialogs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list, parent, false);
        TextView textView = (TextView) view.findViewById(R.id.text);

        String list = listDialogs.get(position);
        textView.setText(list);

        return view;
    }

    public void add(String item){
        listDialogs.add(item);
        notifyDataSetChanged();
    }
    public void remove(String i){
        listDialogs.remove(i);
        notifyDataSetChanged();
    }
}

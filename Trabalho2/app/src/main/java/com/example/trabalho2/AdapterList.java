package com.example.trabalho2;

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
    //private List<String> listDialogs;
    List<String> listDialogs = new ArrayList<String>();

    public AdapterList(Context context, List<String> listDialogs) {
        this.context = context;
        this.listDialogs = listDialogs;
    }

    public AdapterList() {

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

        ListDialog listDialog = new ListDialog();
        textView.setText(listDialog.item);

        return view;
    }

    public void adicionar(String item){
        listDialogs.add(item);
        notifyDataSetChanged();
    }
}

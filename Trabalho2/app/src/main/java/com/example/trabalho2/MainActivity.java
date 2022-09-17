package com.example.trabalho2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListDialog.OnInteractionListener, AbsListView.MultiChoiceModeListener {

    public AdapterList adapterList;
    public ListDialog listDialog;
    private List<String> selecionados = new ArrayList<>();
    private ListView listView;

    private String item ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listDialog = new ListDialog();

        listView = (ListView) findViewById(R.id.lista_item);
        adapterList = new AdapterList(this);
        listView.setAdapter(adapterList);

        listView.setMultiChoiceModeListener(this);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

    }

    public void insert(String item){
        adapterList.add(item);
    }

    @Override //menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override// ao clicar no icone de adicionar uma caixa de dialog é aberta
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add){
            listDialog.show(getSupportFragmentManager(), "listDialog");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInteraction(String texto) {
        insert(texto);
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actions, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_delete){
            for (String s: selecionados){
                adapterList.remove(s);
            }
            actionMode.finish();
            return true;
        }//aqui colocar a parte do editar -- faltou a parte da edição
        else if (menuItem.getItemId() == R.id.action_edit){
            listDialog.show(getSupportFragmentManager(), "");
        }

        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        int count = listView.getChildCount();

        for (int i=0; i<count; i++){
            View view = listView.getChildAt(i);
            view.setBackgroundColor(Color.TRANSPARENT);
        }
        selecionados.clear();
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
        String s = (String) adapterList.getItem(i);
        View view = listView.getChildAt(i);

        if (b){
            view.setBackgroundColor(Color.TRANSPARENT);
            selecionados.add(s);
        }else{
            view.setBackgroundColor(Color.TRANSPARENT);
            selecionados.remove(s);
        }
    }
}
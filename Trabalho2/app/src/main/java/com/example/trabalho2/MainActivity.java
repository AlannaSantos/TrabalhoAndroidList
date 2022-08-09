package com.example.trabalho2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.lista_item);
        List<AdapterList> list = ;
        listView.setAdapter(new AdapterList(this, Collections.singletonList(list)));

    }

    @Override //menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // opção para escolher qual icone vai ser mostrado
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add){
            ListDialog listDialog = new ListDialog();
            listDialog.show(getSupportFragmentManager(), "listDialog");
        }
        return super.onOptionsItemSelected(item);
    }
}
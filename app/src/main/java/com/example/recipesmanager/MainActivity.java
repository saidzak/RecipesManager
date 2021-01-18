package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter adapter;
    DB_Sqlite mydata = new DB_Sqlite(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Demande d'acces au stockage pour le traitement des images des recettes.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        List<Recette> allReceips = mydata.getAllReceips();
        ListView listv = (ListView) findViewById(R.id.list);
        showList(allReceips, listv);

        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recette clickedrecette = (Recette) parent.getItemAtPosition(position);
                Intent todetails = new Intent(MainActivity.this, Details.class);
                todetails.putExtra("selectedid", clickedrecette.getId());
                startActivity(todetails);
                finish();
            }
        });
    }


    private void showList(List items, ListView listv) {
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);
        listv.setAdapter(adapter);
    }


    public void btn_add(View view) {
        Intent myintent = new Intent(MainActivity.this, add.class);
        startActivity(myintent);
        finish();
    }
}
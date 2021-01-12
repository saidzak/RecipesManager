package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> titres;
    ListView listv;
    ArrayList<Recette> list;
    ArrayAdapter adapter;
    MesRecettes MR = new MesRecettes();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listv = (ListView) findViewById(R.id.list);

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, MR.gettitres());
        listv.setAdapter(adapter);

        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = listv.getItemAtPosition(position).toString();
                Intent myintent = new Intent(MainActivity.this,Details.class);
                myintent.putExtra("titre",s);
                startActivity(myintent);
                finish();

            }
        });


    }
}
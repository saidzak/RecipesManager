package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    ArrayList<String> titres;
    ListView listv;
    ArrayList<Recette> list;
    ArrayAdapter adapter;
    ArrayList<String> testlist = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listv = (ListView) findViewById(R.id.list);

        testlist.add("Test 1");
        testlist.add("Test 2");
        testlist.add("Test 3");

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, testlist);
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

    public void btn_add(View view) {
        Intent myintent = new Intent(MainActivity.this,add.class);
        startActivity(myintent);
        finish();

    }
}
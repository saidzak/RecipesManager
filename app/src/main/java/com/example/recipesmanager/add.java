package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class add extends AppCompatActivity {

    DB_Sqlite db = new DB_Sqlite(this);

    EditText titre;
    Spinner type;
    EditText nbpersonnes;
    EditText ingredient;
    Spinner niveau;
    EditText instruction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

//Liste des types
        Spinner mySpinner = (Spinner) findViewById(R.id.etype);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(add.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.types));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

//        Liste des niveaux
        Spinner mySpinner1 = (Spinner) findViewById(R.id.eniveau);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(add.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.niveaux));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);

//        ---------------------- Initialisation -------------
        titre = findViewById(R.id.etitre);
        type = findViewById(R.id.etype);
        nbpersonnes = findViewById(R.id.enbpersonnes);
        ingredient = findViewById(R.id.eingredients);
        niveau = findViewById(R.id.eniveau);
        instruction = findViewById(R.id.einstruction);
    }

    public void tbn_ajouter(View view) {
        db.insertData(titre.toString(),type.toString(), Integer.parseInt(nbpersonnes.toString()),ingredient.toString(),niveau.toString(),instruction.toString());

    }
}
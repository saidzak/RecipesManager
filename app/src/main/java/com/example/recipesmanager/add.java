package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class add extends AppCompatActivity {

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
        Recette recette = null;


        try {
            String ti = titre.getText().toString();
            String ty = type.getSelectedItem().toString();
            int nb = Integer.parseInt(nbpersonnes.getText().toString());
            String ing = ingredient.getText().toString();
            String ni = niveau.getSelectedItem().toString();
            String ins = instruction.getText().toString();

            recette = new Recette(ti, ty, nb, ni, ing, ins);

        } catch (Exception e) {
            Toast.makeText(add.this, "ERREUR", Toast.LENGTH_SHORT).show();
        }

        DB_Sqlite mydb = new DB_Sqlite(add.this);
        boolean res = mydb.AddOne(recette);
        if (res==true) Toast.makeText(add.this, "ENREGISTRÉ", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(add.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
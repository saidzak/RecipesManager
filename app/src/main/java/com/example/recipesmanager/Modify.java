package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Modify extends AppCompatActivity {

    EditText titre;
    Spinner type;
    EditText nbpersonnes;
    EditText ingredient;
    Spinner niveau;
    EditText instruction;
    Recette recette;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);


        //Liste des types
        Spinner mySpinner = (Spinner) findViewById(R.id.etype);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Modify.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.types));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

//        Liste des niveaux
        Spinner mySpinner1 = (Spinner) findViewById(R.id.eniveau);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Modify.this,
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

//        --------------------------------INTENT------------------------
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        DB_Sqlite db = new DB_Sqlite(this);
        recette = db.getRecetteById(id);
//      ------------------------------------ Valeurs -------------------
        titre.setText(recette.getTitre());
        type.setSelection(getIndex(type, recette.getType()));
        nbpersonnes.setText(String.valueOf(recette.getNbpersonnes()));
        ingredient.setText(recette.getIngredients());
        niveau.setSelection(getIndex(niveau, recette.getNiveau()));
        instruction.setText(recette.getInstruction());
    }

    //    ---------------- Trouver l'indice de valuer du spinner-------------
    public int getIndex(Spinner spinner, String myString) {
        int index = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(myString)) {
                index = i;
            }
        }
        return index;
    }
//--------------------------------------------------------

    public void tbn_enregistrer(View view) {

        DB_Sqlite mydb = new DB_Sqlite(Modify.this);
        Recette modifiedrecette = null;

        try {
            String ti = titre.getText().toString();
            String ty = type.getSelectedItem().toString();
            int nb = Integer.parseInt(nbpersonnes.getText().toString());
            String ing = ingredient.getText().toString();
            String ni = niveau.getSelectedItem().toString();
            String ins = instruction.getText().toString();

            modifiedrecette = new Recette(ti, ty, nb, ni, ing, ins);


        } catch (Exception e) {
            Toast.makeText(Modify.this, "ERREUR", Toast.LENGTH_SHORT).show();
        }

        boolean res = mydb.modifyOne(modifiedrecette);

        if (res == true) Toast.makeText(Modify.this, modifiedrecette.getTitre()+ " Modifié Avec Succès", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Modify.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}